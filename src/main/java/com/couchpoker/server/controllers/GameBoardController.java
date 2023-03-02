package com.couchpoker.server.controllers;

import com.couchpoker.domain.entities.GameBoard;
import com.couchpoker.domain.entities.dtos.GameBoardConfigDto;
import com.couchpoker.game.GameInitializer;
import com.couchpoker.infrastructure.GameBoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GameBoardController {
    private GameBoardRepository gameBoardRepository;
    private final GameInitializer gameInitializer;
    private final ModelMapper mapper = new ModelMapper();

    @PostMapping("/initialize")
    public GameBoard initialize(GameBoardConfigDto dto) {
        return gameBoardRepository.save(gameInitializer.InitializeGameBoard(dto));
    }
}
