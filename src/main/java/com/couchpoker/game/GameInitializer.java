package com.couchpoker.game;

import com.couchpoker.domain.dtos.PlayerConfigDto;
import com.couchpoker.domain.entities.GameBoard;
import com.couchpoker.domain.entities.Player;
import com.couchpoker.domain.dtos.GameBoardConfigDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class GameInitializer {
    private final ModelMapper mapper = new ModelMapper();

    public GameBoard generateGameBoard(GameBoardConfigDto gameBoardConfigDto) {
        return mapper.map(gameBoardConfigDto, GameBoard.class);
    }

    public Player generatePlayer(PlayerConfigDto playerDto) {
        return mapper.map(playerDto, Player.class);
    }
}
