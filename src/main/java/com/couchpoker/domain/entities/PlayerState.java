package com.couchpoker.domain.entities;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public final class PlayerState {
    @Id
    @GeneratedValue
    private Long id;
    private boolean isFolded;
    private boolean isAllIn;
    private int chipsOnBet;
    private int chipsOnHand;
    private List<Card> cards = new ArrayList<Card>();
}
