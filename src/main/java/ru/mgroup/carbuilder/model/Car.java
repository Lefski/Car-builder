package ru.mgroup.carbuilder.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JoinColumn (name = "wheels_id")
    @ManyToOne (fetch = FetchType.EAGER)
    @ToString.Exclude
    private Wheel wheel;

    @Column(name = "wheels_amount")
    private Integer wheelsAmount;

    @JoinColumn (name = "body_id")
    @ManyToOne (fetch = FetchType.EAGER)
    @ToString.Exclude
    private Body body;

}
