package com.couchpoker.domain.entities;

import com.couchpoker.domain.entities.enums.CardSuit;
import com.couchpoker.domain.entities.enums.CardValue;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@RequiredArgsConstructor
public final class Card {
    @Id
    @GeneratedValue
    private Long id;
    private final CardSuit suit;
    private final CardValue value;
}

