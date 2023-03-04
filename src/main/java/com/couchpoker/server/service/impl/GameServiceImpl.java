package com.couchpoker.server.service.impl;

import com.couchpoker.domain.dtos.GameBoardConfigDto;
import com.couchpoker.domain.dtos.GameBoardDto;
import com.couchpoker.domain.dtos.PlayerConfigDto;
import com.couchpoker.domain.dtos.PlayerDto;
import com.couchpoker.domain.entities.GameBoard;
import com.couchpoker.domain.entities.Player;
import com.couchpoker.game.GameInitializer;
import com.couchpoker.repository.GameBoardRepository;
import com.couchpoker.server.service.GameService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@ComponentScan({"com.couchpoker.game", "com.couchpoker.repository"})
@RequiredArgsConstructor
@Transactional
public class GameServiceImpl implements GameService {
    @Resource
    private final GameBoardRepository gameBoardRepository;
    private final GameInitializer gameInitializer;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public GameBoardDto createGameBoard(GameBoardConfigDto config) {
        GameBoard gameBoard = gameBoardRepository.save(gameInitializer.generateGameBoard(config));
        return mapper.map(gameBoard, GameBoardDto.class);
    }

    @Override
    public PlayerDto joinGameBoardAsPlayer(PlayerConfigDto config) {
        Player player = gameInitializer.generatePlayer(config);
        GameBoard gameBoard = gameBoardRepository.findGameBoardByIdentifier(config.identifier);
        gameBoard.getPlayers().add(player);
        gameBoardRepository.save(gameBoard);
        return mapper.map(player, PlayerDto.class);
    }

    @Override
    public GameBoardDto getGameBoard(String identifier) {
        GameBoard gameBoard = gameBoardRepository.findGameBoardByIdentifier(identifier);
        return mapper.map(gameBoard, GameBoardDto.class);
    }
}
