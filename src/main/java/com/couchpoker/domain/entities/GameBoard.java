package com.couchpoker.domain.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public final class GameBoard {
    private final String Identifier;
    private final String ConnectionId; // TODO check how WebSocket works
    private final int MaxPlayers;
    private final int MinPlayers;
    private List<Player> Players = new ArrayList<Player>();
    private List<Card> Cards = new ArrayList<Card>();
    private List<Card> CommunityCards = new ArrayList<Card>();
    private int ChipsOnBet;
    private final int StartChips;
    private int CurrentPlayer;
    private int StartingPlayer;
}
