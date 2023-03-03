package com.couchpoker.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Getter
@Setter
public class GameBoard {
    private @Id @GeneratedValue Long id;
    private String identifier = String.format("%06d", new Random().nextInt(999999));
    private String connectionId; // TODO check how WebSocket works
    private int maxPlayers;
    private int minPlayers;
    @OneToMany
    private List<Player> players = new ArrayList<>();
    @OneToMany
    private List<Card> cards = new ArrayList<>();
    @OneToMany
    private List<Card> communityCards = new ArrayList<>();
    private int chipsOnBet;
    private int startChips;
    private int currentPlayer;
    private int startingPlayer;
}
