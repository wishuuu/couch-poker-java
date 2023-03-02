package com.couchpoker.domain.entities.dtos;

import lombok.Data;

import java.util.List;

@Data
public class GameBoardDto {
    public String identifier;
    public String connectionId;
    public List<PlayerDto> players;
    public List<CardDto> cards;
    public List<CardDto> communityCards;
}
