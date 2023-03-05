package com.couchpoker.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GameBoard {
    private @Id String joinCode = String.format("%06d", new Random().nextInt(999999));
    private String connectionString; // TODO check how WebSocket works
    private int maxPlayers;
    private int minPlayers;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Player> players = new LinkedList<>();
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Card> deck = new LinkedList<>();
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Card> communityCards = new LinkedList<>();
    private int chipsOnBet;
    private int startChips;
    private int currentPlayer;
    private int startingPlayer;
}
