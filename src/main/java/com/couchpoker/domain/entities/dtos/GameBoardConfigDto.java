package com.couchpoker.domain.entities.dtos;

import lombok.Data;

@Data
public class GameBoardConfigDto {
    public String ConnectionId;
    public int MaxPlayers;
    public int MinPlayers;
    public int StartChips;
}
