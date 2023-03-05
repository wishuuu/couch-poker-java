package com.couchpoker.game;

import com.couchpoker.domain.entities.Card;
import com.couchpoker.domain.entities.GameBoard;
import com.couchpoker.domain.entities.Player;
import com.couchpoker.domain.enums.CardSuit;
import com.couchpoker.domain.enums.CardValue;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Component
@NoArgsConstructor
public class GameLogic {
    private void shuffleDeck(GameBoard gameBoard) {
        List<Card> cards = gameBoard.getDeck();
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 13; j++) {
                Card card = new Card();
                card.setSuit(CardSuit.values()[i]);
                card.setValue(CardValue.values()[j]);
                cards.add(card);
            }
        Collections.shuffle(cards);
    }

    public void newDeck(GameBoard gameBoard) {
        log.info("Preparing new deck for GameBoard, join code:\t{}", gameBoard.getJoinCode());
        gameBoard.setDeck(new LinkedList<>());
        gameBoard.setCommunityCards(new LinkedList<>());
        for (Player player : gameBoard.getPlayers()) {
            player.getPlayerState().setHand(new LinkedList<>());
        }
        shuffleDeck(gameBoard);
    }

    private void dealHands(GameBoard gameBoard) {
        for (int i = 0; i < 2; i++) {
            for (Player player : gameBoard.getPlayers()) {
                Card card = gameBoard.getDeck().stream().findFirst().orElseThrow();
                player.getPlayerState().getHand().add(card);
                gameBoard.getDeck().remove(card);
            }
        }
    }

    private void dealFlop(GameBoard gameBoard) {
        for (int i = 0; i < 3; i++) {
            Card card = gameBoard.getDeck().stream().findFirst().orElseThrow();
            gameBoard.getCommunityCards().add(card);
            gameBoard.getDeck().remove(card);
        }
    }

    public void dealTurn(GameBoard gameBoard) {
        log.info("Dealing turn for GameBoard, join code:\t{}", gameBoard.getJoinCode());
        Card card = gameBoard.getDeck().stream().findFirst().orElseThrow();
        gameBoard.getCommunityCards().add(card);
        gameBoard.getDeck().remove(card);
    }

    public void startRound(GameBoard gameBoard) {
        log.info("Starting round for GameBoard, join code:\t{}", gameBoard.getJoinCode());
        dealHands(gameBoard);
        dealFlop(gameBoard);
    }
}
