package ru.mgroup.carbuilder.dto.car;

import lombok.*;
import ru.mgroup.carbuilder.dto.WheelDto;
import ru.mgroup.carbuilder.model.Body;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {

    private Long id;

    private WheelDto wheelDto;

    private Integer wheelsAmount;

    private Body body;

}
