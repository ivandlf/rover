package com.rover.rover.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "obstacle")
public class Obstacle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "posx")
    private int x;
    @Column(name = "posy")
    private int y;
}
