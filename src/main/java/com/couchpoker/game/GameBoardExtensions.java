package com.couchpoker.game;

import com.couchpoker.domain.entities.Card;
import com.couchpoker.domain.entities.GameBoard;
import com.couchpoker.domain.entities.Player;
import com.couchpoker.domain.entities.enums.CardSuit;
import com.couchpoker.domain.entities.enums.CardValue;

import java.util.ArrayList;
import java.util.List;

public class GameBoardExtensions {
    public static void ShuffleCards(GameBoard gameBoard) {
        List<Card> cards = new ArrayList<Card>();
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 13; j++)
                cards.add(new Card(CardSuit.values()[i], CardValue.values()[j]));

        cards = cards.stream().sorted((c1, c2) -> (int) (Math.random() * 3 - 1)).toList();
        gameBoard.setCards(cards);
    }

    private static void CleanHands(GameBoard gameBoard) {
        for (Player player : gameBoard.getPlayers()) {
            player.getPlayerState().setCards(new ArrayList<Card>());
        }
    }

    public static void DealCards(GameBoard gameBoard) {
        for (int i = 0; i < 2; i++) {
            for (Player player : gameBoard.getPlayers()) {
                player.getPlayerState().getCards().add(gameBoard.getCards().stream().findFirst().orElseThrow());
                gameBoard.getCards().remove(gameBoard.getCards().stream().findFirst().orElseThrow());
            }
        }
    }

    public static void DealFlop(GameBoard gameBoard) {
        for (int i = 0; i < 3; i++) {
            gameBoard.getCommunityCards().add(gameBoard.getCards().stream().findFirst().orElseThrow());
            gameBoard.getCards().remove(gameBoard.getCards().stream().findFirst().orElseThrow());
        }
    }

    public static GameBoard DealTurn(GameBoard gameBoard) {
        gameBoard.getCommunityCards().add(gameBoard.getCards().stream().findFirst().orElseThrow());
        gameBoard.getCards().remove(gameBoard.getCards().stream().findFirst().orElseThrow());
        return gameBoard;
    }

    public static GameBoard BeginDeal(GameBoard gameBoard) {
        CleanHands(gameBoard);
        ShuffleCards(gameBoard);
        DealCards(gameBoard);
        DealFlop(gameBoard);
        return gameBoard;
    }
}
