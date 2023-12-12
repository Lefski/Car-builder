package ru.mgroup.carbuilder.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ru.mgroup.carbuilder.dto.BodyDto;
import ru.mgroup.carbuilder.dto.WheelDto;
import ru.mgroup.carbuilder.dto.car.CarDto;
import ru.mgroup.carbuilder.dto.car.NewCarDto;

public interface Service {
    Page<BodyDto> getAllCarBody(PageRequest pageRequest);

    Page<WheelDto> getAllCarWheels(PageRequest pageRequest);

    CarDto createCar(NewCarDto newCarDto);

    CarDto getCarById(Long id);

    Page<CarDto> getCars(PageRequest pageRequest);


}
