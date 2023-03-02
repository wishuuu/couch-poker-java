package com.couchpoker.game;

import com.couchpoker.domain.entities.GameBoard;
import com.couchpoker.domain.entities.Player;
import com.couchpoker.domain.entities.dtos.GameBoardConfigDto;
import com.couchpoker.domain.entities.dtos.PlayerDto;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@NoArgsConstructor
public class GameInitializer {
    private final ModelMapper mapper = new ModelMapper();
    public GameBoard InitializeGameBoard(GameBoardConfigDto gameBoardConfigDto) {
        return mapper.map(gameBoardConfigDto, GameBoard.class);
    }

    public Player CreatePlayer(PlayerDto playerDto) {
        return mapper.map(playerDto, Player.class);
    }
}
