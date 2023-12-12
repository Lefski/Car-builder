package ru.mgroup.carbuilder.dto.car;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewCarDto {

    @NotNull (message = "wheelId may not be null")
    @Positive (message = "wheelId may not be negative or zero")
    private Long wheelId;

    @NotNull (message = "wheelsAmount may not be null")
    @Positive (message = "wheelAmount may not be negative or zero")
    @Min(value = 2, message = "car needs at least 2 wheels to be created")
    private Integer wheelsAmount;

    @NotNull (message = "bodyId may not be null")
    @Positive (message = "bodyId may not be negative or zero")
    private Long bodyId;

    @NotBlank(message = "car name may not be null or blank")
    @Size(min = 1, max = 255)
    private String name;

    @Override
    public String toString() {
        return "NewCarDto{" +
                "wheelId=" + wheelId +
                ", wheelsAmount=" + wheelsAmount +
                ", bodyId=" + bodyId +
                ", name=" + name +
                '}';
    }
}
