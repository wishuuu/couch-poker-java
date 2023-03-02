package com.couchpoker.domain.entities.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PlayerStateDto {
    public boolean isFolded;
    public boolean isAllIn;
    public int chipsOnBet;
    public int chipsOnHand;
    public List<CardDto> cards;
}
