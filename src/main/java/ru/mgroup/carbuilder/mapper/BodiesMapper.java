package ru.mgroup.carbuilder.mapper;

import ru.mgroup.carbuilder.dto.BodyDto;
import ru.mgroup.carbuilder.model.Body;

public class BodiesMapper {

    public static BodyDto toBodyDto(Body body) {
        return BodyDto.builder()
                .id(body.getId())
                .bodiesType(body.getBodiesType())
                .build();
    }
}
