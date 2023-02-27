package com.couchpoker.domain.entities;

import java.util.ArrayList;
import java.util.List;

public class PlayerState {
    public boolean IsFolded ;
    public boolean IsAllIn ;
    public int ChipsOnBet ;
    public int ChipsOnHand ;
    public List<Card> Cards = new ArrayList<Card>();
}
