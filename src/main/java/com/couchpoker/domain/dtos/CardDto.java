package com.couchpoker.domain.dtos;

import com.couchpoker.domain.enums.CardSuit;
import com.couchpoker.domain.enums.CardValue;
import lombok.Data;

@Data
public class CardDto {
    public CardSuit suit;
    public CardValue value;
}
