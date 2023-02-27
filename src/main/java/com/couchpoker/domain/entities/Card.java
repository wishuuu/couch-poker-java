package com.couchpoker.domain.entities;

import com.couchpoker.domain.entities.enums.CardSuit;
import com.couchpoker.domain.entities.enums.CardValue;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class Card {
    @NonNull
    private CardSuit Suit;
    @NonNull
    private CardValue Value;
}

