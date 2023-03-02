package com.couchpoker.game;

import com.couchpoker.domain.entities.Card;
import com.couchpoker.domain.entities.GameBoard;
import com.couchpoker.domain.entities.Player;
import com.couchpoker.domain.entities.enums.CardSuit;
import com.couchpoker.domain.entities.enums.CardValue;

import java.util.ArrayList;
import java.util.List;

public class GameBoardExtensions {
    public static void shuffleCards(GameBoard gameBoard) {
        List<Card> cards = new ArrayList<Card>();
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 13; j++)
                cards.add(new Card(CardSuit.values()[i], CardValue.values()[j]));

        cards = cards.stream().sorted((c1, c2) -> (int) (Math.random() * 3 - 1)).toList();
        gameBoard.setCards(cards);
    }

    private static void clearHands(GameBoard gameBoard) {
        for (Player player : gameBoard.getPlayers()) {
            player.getPlayerState().setCards(new ArrayList<Card>());
        }
    }

    public static void dealCards(GameBoard gameBoard) {
        for (int i = 0; i < 2; i++) {
            for (Player player : gameBoard.getPlayers()) {
                player.getPlayerState().getCards().add(gameBoard.getCards().stream().findFirst().orElseThrow());
                gameBoard.getCards().remove(gameBoard.getCards().stream().findFirst().orElseThrow());
            }
        }
    }

    public static void dealFlop(GameBoard gameBoard) {
        for (int i = 0; i < 3; i++) {
            gameBoard.getCommunityCards().add(gameBoard.getCards().stream().findFirst().orElseThrow());
            gameBoard.getCards().remove(gameBoard.getCards().stream().findFirst().orElseThrow());
        }
    }

    public static GameBoard dealTurn(GameBoard gameBoard) {
        gameBoard.getCommunityCards().add(gameBoard.getCards().stream().findFirst().orElseThrow());
        gameBoard.getCards().remove(gameBoard.getCards().stream().findFirst().orElseThrow());
        return gameBoard;
    }

    public static GameBoard beginDeal(GameBoard gameBoard) {
        clearHands(gameBoard);
        shuffleCards(gameBoard);
        dealCards(gameBoard);
        dealFlop(gameBoard);
        return gameBoard;
    }
}
