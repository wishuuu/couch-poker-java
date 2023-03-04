package com.couchpoker.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GameBoard {
    private @Id @GeneratedValue Long id;
    private String identifier = String.format("%06d", new Random().nextInt(999999));
    private String connectionString; // TODO check how WebSocket works
    private int maxPlayers;
    private int minPlayers;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Player> players = new ArrayList<>();
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Card> cards = new ArrayList<>();
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Card> communityCards = new ArrayList<>();
    private int chipsOnBet;
    private int startChips;
    private int currentPlayer;
    private int startingPlayer;
}
