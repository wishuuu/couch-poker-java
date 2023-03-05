package com.couchpoker.domain.entities;

import com.couchpoker.domain.enums.CardSuit;
import com.couchpoker.domain.enums.CardValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Card {
    private @Id @GeneratedValue Long id;
    private CardSuit suit;
    private CardValue value;
    @ManyToOne
    private GameBoard gameBoard;
}

