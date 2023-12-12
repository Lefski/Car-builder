package ru.mgroup.carbuilder.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "wheels_size")
public class WheelsSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "size_name")
    private String sizeName;

    @Override
    public String toString() {
        return "WheelsSize{" +
                "id=" + id +
                ", sizeName='" + sizeName + '\'' +
                '}';
    }
}
