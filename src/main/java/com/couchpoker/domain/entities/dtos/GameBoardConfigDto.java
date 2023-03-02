package com.couchpoker.domain.entities.dtos;

import lombok.Data;

@Data
public class GameBoardConfigDto {
    public String connectionId;
    public int maxPlayers;
    public int minPlayers;
    public int startChips;
}
