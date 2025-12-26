package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "suggestions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String suggestedCrops;

    private String suggestedFertilizers;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    private Farm farm;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
