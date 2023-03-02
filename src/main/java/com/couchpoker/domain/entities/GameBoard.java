package com.couchpoker.domain.entities;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@RequiredArgsConstructor
public final class GameBoard {
    @Id
    @GeneratedValue
    private Long id;
    private String identifier = String.valueOf(new Random().nextInt()%1000000);
    private final String connectionId; // TODO check how WebSocket works
    private final int maxPlayers;
    private final int minPlayers;
    private List<Player> players = new ArrayList<Player>();
    private List<Card> cards = new ArrayList<Card>();
    private List<Card> communityCards = new ArrayList<Card>();
    private int chipsOnBet;
    private final int startChips;
    private int currentPlayer;
    private int startingPlayer;
}
