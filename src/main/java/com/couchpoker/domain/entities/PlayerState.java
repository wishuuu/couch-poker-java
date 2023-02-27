package com.couchpoker.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public final class PlayerState {
    private boolean IsFolded;
    private boolean IsAllIn;
    private int ChipsOnBet;
    private int ChipsOnHand;
    private List<Card> Cards = new ArrayList<Card>();
}
