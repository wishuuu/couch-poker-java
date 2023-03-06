package com.couchpoker.server.service.impl;

import com.couchpoker.domain.dtos.GameBoardConfigDto;
import com.couchpoker.domain.dtos.GameBoardDto;
import com.couchpoker.domain.dtos.PlayerConfigDto;
import com.couchpoker.domain.dtos.PlayerDto;
import com.couchpoker.domain.entities.GameBoard;
import com.couchpoker.domain.entities.Player;
import com.couchpoker.game.GameLogic;
import com.couchpoker.repository.GameBoardRepository;
import com.couchpoker.server.service.GameService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@ComponentScan({"com.couchpoker.game", "com.couchpoker.repository"})
@RequiredArgsConstructor
@Transactional
public class GameServiceImpl implements GameService {
    @Resource
    private final GameBoardRepository gameBoardRepository;
    private final GameLogic gameLogic;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public ResponseEntity<GameBoardDto> createGameBoard(GameBoardConfigDto config) {
        GameBoard gameBoard = gameBoardRepository.save(mapper.map(config, GameBoard.class));
        log.info("Created GameBoard, join code:\t{}", gameBoard.getJoinCode());
        return ResponseEntity.ok(mapper.map(gameBoard, GameBoardDto.class));
    }

    @Override
    public ResponseEntity<PlayerDto> joinGameBoardAsPlayer(PlayerConfigDto config) {
        Player player = mapper.map(config, Player.class);
        GameBoard gameBoard = gameBoardRepository.getReferenceById(config.joinCode);
        gameBoard.getPlayers().add(player);
        gameBoardRepository.save(gameBoard);
        log.info("Player {} joined GameBoard, join code:\t{}", player.getName(), gameBoard.getJoinCode());
        return ResponseEntity.ok(mapper.map(player, PlayerDto.class));
    }

    @Override
    public ResponseEntity<GameBoardDto> getGameBoard(String joinCode) {
        return ResponseEntity.ok(mapper.map(gameBoardRepository.getReferenceById(joinCode), GameBoardDto.class));
    }

    @Override
    public HttpStatus beginRound(String joinCode) {
        GameBoard gameBoard = gameBoardRepository.getReferenceById(joinCode);
        gameLogic.newDeck(gameBoard);
        gameBoardRepository.save(gameBoard);
        gameLogic.startRound(gameBoard);
        gameBoardRepository.save(gameBoard);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus dealTurn(String joinCode) {
        GameBoard gameBoard = gameBoardRepository.getReferenceById(joinCode);
        gameLogic.dealTurn(gameBoard);
        gameBoardRepository.save(gameBoard);
        return HttpStatus.OK;
    }
}
