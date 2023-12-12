package ru.mgroup.carbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mgroup.carbuilder.model.Body;

public interface BodyRepository extends JpaRepository<Body, Long> {
}
