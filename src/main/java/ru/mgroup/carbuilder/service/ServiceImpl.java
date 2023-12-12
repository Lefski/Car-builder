package ru.mgroup.carbuilder.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import ru.mgroup.carbuilder.dto.BodyDto;
import ru.mgroup.carbuilder.dto.WheelDto;
import ru.mgroup.carbuilder.dto.car.CarDto;
import ru.mgroup.carbuilder.dto.car.NewCarDto;
import ru.mgroup.carbuilder.exception.ConflictException;
import ru.mgroup.carbuilder.exception.NotFoundException;
import ru.mgroup.carbuilder.mapper.BodiesMapper;
import ru.mgroup.carbuilder.mapper.CarMapper;
import ru.mgroup.carbuilder.mapper.WheelsMapper;
import ru.mgroup.carbuilder.model.Body;
import ru.mgroup.carbuilder.model.Car;
import ru.mgroup.carbuilder.model.Wheel;
import ru.mgroup.carbuilder.repository.BodyRepository;
import ru.mgroup.carbuilder.repository.CarRepository;
import ru.mgroup.carbuilder.repository.WheelRepository;

import java.util.ArrayList;

@org.springframework.stereotype.Service
@Slf4j
@AllArgsConstructor
public class ServiceImpl implements Service {
    private final BodyRepository bodyRepository;
    private final WheelRepository wheelRepository;
    private final CarRepository carRepository;


    @Override
    public Page<BodyDto> getAllCarBody(PageRequest pageRequest) {
        Page<Body> bodyPage = bodyRepository.findAll(pageRequest);
        ArrayList<BodyDto> bodyDtoList = new ArrayList<>();
        for (Body body :
                bodyPage) {
            bodyDtoList.add(BodiesMapper.toBodyDto(body));
        }
        Page<BodyDto> bodyDtoPage = new PageImpl<>(bodyDtoList);
        log.info("Запрос на получение всех корпусов выполнен: {}", bodyDtoList);
        return bodyDtoPage;
    }

    @Override
    public Page<WheelDto> getAllCarWheels(PageRequest pageRequest) {
        Page<Wheel> wheelPage = wheelRepository.findAll(pageRequest);
        ArrayList<WheelDto> wheelDtoList = new ArrayList<>();
        for (Wheel wheel :
                wheelPage) {
            wheelDtoList.add(WheelsMapper.toWheelDto(wheel));
        }
        Page<WheelDto> wheelDtoPage = new PageImpl<>(wheelDtoList);
        log.info("Запрос на получение всех колес выполнен: {}", wheelDtoList);
        return wheelDtoPage;
    }

    @Override
    public CarDto createCar(NewCarDto newCarDto) {
        Wheel wheel = wheelRepository.findById(newCarDto.getWheelId()).orElseThrow(() ->
                new NotFoundException("There is no wheel with such id")
        );
        Integer wheelAmount = newCarDto.getWheelsAmount();
        if (wheel.getStock() < wheelAmount) {
            throw new ConflictException("There are not enough wheels in stock");
        }
        Body body = bodyRepository.findById(newCarDto.getBodyId()).orElseThrow(() ->
                new NotFoundException("There is no body with such id")
        );
        if (body.getStock() < 1) {
            throw new ConflictException("There are not enough bodies in stock");
        }
        wheel.setStock(wheel.getStock() - wheelAmount);
        wheelRepository.save(wheel);
        body.setStock(body.getStock() - 1);
        bodyRepository.save(body);
        Car car = Car.builder()
                .wheel(wheel)
                .body(body)
                .wheelsAmount(wheelAmount)
                .name(newCarDto.getName())
                .build();
        CarDto savedCar = CarMapper.toDto(carRepository.save(car));
        log.info("Запрос на создание машины выполнен: {}", savedCar);
        return savedCar;
    }

    @Override
    public CarDto getCarById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException("Машины с таким id не существует"));
        CarDto carDto = CarMapper.toDto(car);
        log.info("Запрос на поиск машины по id выполнен: {}", carDto);
        return carDto;
    }

    @Override
    public Page<CarDto> getCars(PageRequest pageRequest) {
        Page<Car> carPage = carRepository.findAll(pageRequest);
        ArrayList<CarDto> carDtoList = new ArrayList<>();
        for (Car car :
                carPage) {
            carDtoList.add(CarMapper.toDto(car));
        }
        Page<CarDto> carDtoPage = new PageImpl<>(carDtoList);
        log.info("Запрос на получение всех машин выполнен: {}", carDtoList);
        return carDtoPage;
    }
}
