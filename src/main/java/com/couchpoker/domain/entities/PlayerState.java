package com.couchpoker.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class PlayerState {
    private @Id @GeneratedValue Long id;
    private boolean isFolded;
    private boolean isAllIn;
    private int chipsOnBet;
    private int chipsOnHand;
    @OneToMany
    private List<Card> cards = new ArrayList<>();
}
