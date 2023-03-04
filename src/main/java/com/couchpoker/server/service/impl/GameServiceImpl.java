package com.couchpoker.server.service.impl;

import com.couchpoker.domain.dtos.GameBoardConfigDto;
import com.couchpoker.domain.dtos.GameBoardDto;
import com.couchpoker.domain.entities.GameBoard;
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
}
