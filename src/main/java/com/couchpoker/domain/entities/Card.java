package com.couchpoker.domain.entities;

import com.couchpoker.domain.entities.enums.CardSuit;
import com.couchpoker.domain.entities.enums.CardValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Card {
    private final CardSuit Suit;
    private final CardValue Value;
}

