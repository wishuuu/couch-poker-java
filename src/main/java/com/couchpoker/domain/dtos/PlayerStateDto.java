package com.couchpoker.domain.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PlayerStateDto {
    public int chipsOnHand;
    public List<CardDto> hand;
}
