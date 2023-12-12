package ru.mgroup.carbuilder.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "bodies")
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock")
    private Integer stock;

    @JoinColumn (name = "type_id")
    @ManyToOne (fetch = FetchType.EAGER)
    @ToString.Exclude
    private BodiesType bodiesType;
}
