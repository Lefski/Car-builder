package ru.mgroup.carbuilder.dto;

import lombok.*;
import ru.mgroup.carbuilder.model.BodiesType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BodyDto {

    private Long id;
    private BodiesType bodiesType;
}
