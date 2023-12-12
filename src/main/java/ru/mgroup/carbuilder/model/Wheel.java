package ru.mgroup.carbuilder.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "wheels")
public class Wheel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock")
    private Integer stock;

    @JoinColumn (name = "wheels_size_id")
    @ManyToOne (fetch = FetchType.EAGER)
    @ToString.Exclude
    private WheelsSize wheelSize;
}
