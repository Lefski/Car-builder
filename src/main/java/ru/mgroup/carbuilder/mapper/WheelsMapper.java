package ru.mgroup.carbuilder.mapper;

import ru.mgroup.carbuilder.dto.WheelDto;
import ru.mgroup.carbuilder.model.Wheel;

public class WheelsMapper {
    public static WheelDto toWheelDto(Wheel wheel) {
        return WheelDto.builder()
                .id(wheel.getId())
                .wheelsSize(wheel.getWheelSize())
                .build();
    }
}
