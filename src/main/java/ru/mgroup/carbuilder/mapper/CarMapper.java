package ru.mgroup.carbuilder.mapper;

import ru.mgroup.carbuilder.dto.BodyDto;
import ru.mgroup.carbuilder.dto.WheelDto;
import ru.mgroup.carbuilder.dto.car.CarDto;
import ru.mgroup.carbuilder.model.Car;

public class CarMapper {

    public static CarDto toDto(Car car) {
        BodyDto bodyDto = BodiesMapper.toBodyDto(car.getBody());
        WheelDto wheelDto = WheelsMapper.toWheelDto(car.getWheel());

        return CarDto.builder()
                .id(car.getId())
                .body(bodyDto)
                .wheelDto(wheelDto)
                .wheelsAmount(car.getWheelsAmount())
                .build();
    }


}
