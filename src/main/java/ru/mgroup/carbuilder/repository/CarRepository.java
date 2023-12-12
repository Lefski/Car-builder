package ru.mgroup.carbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mgroup.carbuilder.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
