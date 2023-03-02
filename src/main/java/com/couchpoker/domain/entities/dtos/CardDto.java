package com.couchpoker.domain.entities.dtos;

import com.couchpoker.domain.entities.enums.CardSuit;
import com.couchpoker.domain.entities.enums.CardValue;
import lombok.Data;

@Data
public class CardDto {
    public CardSuit suit;
    public CardValue value;
}
