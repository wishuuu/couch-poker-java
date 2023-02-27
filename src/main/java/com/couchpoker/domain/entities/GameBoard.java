package com.couchpoker.domain.entities;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    public String Identifier ;
    public String ConnectionId ;
    public int MaxPlayers ;
    public int MinPlayers ;
    public List<Player> Players = new ArrayList<Player>();
    public List<Card> Cards = new ArrayList<Card>();
    public List<Card> CommunityCards = new ArrayList<Card>();
    public int ChipsOnBet ;
    public int StartChips ;
    public int CurrentPlayer ;
    public int StartingPlayer ;
}
