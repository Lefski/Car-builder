package ru.mgroup.carbuilder.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "bodies_type")
public class BodiesType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name")
    private String typeName;

    @Override
    public String toString() {
        return "BodiesType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
