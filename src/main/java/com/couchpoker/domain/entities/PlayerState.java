package com.couchpoker.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class PlayerState {
    private @Id @GeneratedValue Long id;
    private boolean isFolded;
    private boolean isAllIn;
    private int chipsOnBet;
    private int chipsOnHand;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Card> cards = new ArrayList<>();
}
