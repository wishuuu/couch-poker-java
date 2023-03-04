package com.couchpoker.domain.dtos;

import lombok.Data;

import java.util.List;

@Data
public class GameBoardDto {
    public String identifier;
    public String connectionString;
    public List<PlayerDto> players;
    public List<CardDto> cards;
    public List<CardDto> communityCards;
}
