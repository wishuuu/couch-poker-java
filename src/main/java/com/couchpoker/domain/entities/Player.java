package com.couchpoker.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Player {
    private @Id
    @GeneratedValue Long id;
    private String name;
    private String connectionId;
    @OneToOne
    private PlayerState playerState;
    @ManyToOne
    private GameBoard gameBoard;
}
