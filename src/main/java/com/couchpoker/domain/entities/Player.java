package com.couchpoker.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Player {
    private @Id
    @GeneratedValue Long id;
    private String name;
    private String connectionString;
    @OneToOne
    private PlayerState playerState;
    @ManyToOne
    private GameBoard gameBoard;
}
