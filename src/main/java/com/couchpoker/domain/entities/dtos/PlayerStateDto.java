package com.couchpoker.domain.entities.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PlayerStateDto {
    public boolean IsFolded;
    public boolean IsAllIn;
    public int ChipsOnBet;
    public int ChipsOnHand;
    public List<CardDto> Cards;
}
