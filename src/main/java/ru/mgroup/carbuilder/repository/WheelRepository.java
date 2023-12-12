package ru.mgroup.carbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mgroup.carbuilder.model.Wheel;

public interface WheelRepository extends JpaRepository<Wheel, Long> {
}
