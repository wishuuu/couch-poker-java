package com.couchpoker.domain.dtos;

import lombok.Data;

import java.util.List;

@Data
public class GameBoardDto {
    public String joinCode;
    public String connectionString;
    public List<PlayerDto> players;
    public List<CardDto> deck;
    public List<CardDto> communityCards;
}
