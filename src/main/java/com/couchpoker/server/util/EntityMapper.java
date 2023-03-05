package com.couchpoker.server.util;

import com.couchpoker.domain.dtos.PlayerConfigDto;
import com.couchpoker.domain.entities.GameBoard;
import com.couchpoker.domain.entities.Player;
import com.couchpoker.domain.dtos.GameBoardConfigDto;
import com.couchpoker.domain.entities.PlayerState;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EntityMapper {
    private final ModelMapper mapper = new ModelMapper();

    public GameBoard generateGameBoard(GameBoardConfigDto gameBoardConfigDto) {
        return mapper.map(gameBoardConfigDto, GameBoard.class);
    }

    public Player generatePlayer(PlayerConfigDto playerDto) {
        Player player = mapper.map(playerDto, Player.class);
        player.setPlayerState(new PlayerState());
        return player;
    }
}
