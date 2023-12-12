package ru.mgroup.carbuilder.dto.car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import jakarta.validation.constraints.Size;

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
    private Long wheelsAmount;

    @NotNull (message = "bodyId may not be null")
    @Positive (message = "bodyId may not be negative or zero")
    private Long bodyId;

    @NotBlank(message = "car name may not be null or blank")
    @Size(min = 1, max = 255)
    private Long name;


}
