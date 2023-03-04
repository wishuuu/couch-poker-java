package com.couchpoker.server.service;

import com.couchpoker.domain.dtos.GameBoardConfigDto;
import com.couchpoker.domain.dtos.GameBoardDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface GameService {
    @PostMapping("/create-gameboard")
    GameBoardDto createGameBoard(@RequestBody GameBoardConfigDto config);
}
