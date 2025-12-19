package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "farms")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FarmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity owner;

    @NotBlank
    @Column(length = 100)
    private String name;

    @NotNull
    @Column(name = "soil_ph")
    private Double soilPH;

    @NotNull
    @Column(name = "water_level")
    private Double waterLevel;

    @NotBlank
    private String season;
}
