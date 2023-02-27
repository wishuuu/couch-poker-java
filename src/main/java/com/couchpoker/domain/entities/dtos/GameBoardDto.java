package com.couchpoker.domain.entities.dtos;

import lombok.Data;

import java.util.List;

@Data
public class GameBoardDto {
    public String Identifier;
    public String ConnectionId;
    public List<PlayerDto> Players;
    public List<CardDto> Cards;
    public List<CardDto> CommunityCards;
}
