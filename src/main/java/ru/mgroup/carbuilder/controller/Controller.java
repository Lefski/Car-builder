package ru.mgroup.carbuilder.controller;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mgroup.carbuilder.dto.BodyDto;
import ru.mgroup.carbuilder.dto.WheelDto;
import ru.mgroup.carbuilder.dto.car.CarDto;
import ru.mgroup.carbuilder.dto.car.NewCarDto;
import ru.mgroup.carbuilder.service.Service;

import java.util.List;

@RestController
@Validated
@Slf4j
@RequestMapping(path = "/")
@AllArgsConstructor
public class Controller {

    private final Service service;

    @GetMapping("wheels")
    ResponseEntity<List<WheelDto>> getAllCarWheels(
            @RequestParam(required = false, defaultValue = "0") @PositiveOrZero Integer page,
            @RequestParam(required = false, defaultValue = "10") @PositiveOrZero Integer size
    ) {
        log.info("Принят запрос на получение всех колес, page:{}, size{}", page, size);
        return ResponseEntity.ok(service.getAllCarWheels(PageRequest.of(page, size)).toList());


    }

    @GetMapping("body")
    ResponseEntity<List<BodyDto>> getAllCarBody(
            @RequestParam(required = false, defaultValue = "0") @PositiveOrZero Integer page,
            @RequestParam(required = false, defaultValue = "10") @PositiveOrZero Integer size
    ) {
        log.info("Принят запрос на получение всех корпусов, page:{}, size{}", page, size);
        return ResponseEntity.ok(service.getAllCarBody(PageRequest.of(page, size)).toList());
    }

    @GetMapping("cars")
    ResponseEntity<List<CarDto>> getCars(
            @RequestParam(required = false, defaultValue = "0") @PositiveOrZero Integer page,
            @RequestParam(required = false, defaultValue = "10") @PositiveOrZero Integer size
    ) {
        log.info("Принят запрос на получение всех машин, page:{}, size{}", page, size);
        return ResponseEntity.ok(service.getCars(PageRequest.of(page, size)).toList());
    }

    @GetMapping("cars/{carId}")
    ResponseEntity<CarDto> getCarById(
            @PathVariable @Positive Long carId
    ) {
        log.info("Принят запрос на получение машины по id:{}", carId);
        return ResponseEntity.ok(service.getCarById(carId));
    }

    @PostMapping("cars")
    ResponseEntity<CarDto> createCar(
            @RequestBody @Validated NewCarDto newCarDto
    ) {
        log.info("Принят запрос на создание машины, newCarDto:{}", newCarDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCar(newCarDto));
    }

}
