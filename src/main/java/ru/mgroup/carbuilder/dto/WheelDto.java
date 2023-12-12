package ru.mgroup.carbuilder.dto;

import lombok.*;
import ru.mgroup.carbuilder.model.WheelsSize;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WheelDto {

    private Long id;
    private WheelsSize wheelsSize;

    @Override
    public String toString() {
        return "WheelDto{" +
                "id=" + id +
                ", wheelsSize=" + wheelsSize +
                '}';
    }
}
