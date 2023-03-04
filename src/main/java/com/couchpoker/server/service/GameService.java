package com.couchpoker.server.service;

import com.couchpoker.domain.dtos.GameBoardConfigDto;
import com.couchpoker.domain.dtos.GameBoardDto;
import com.couchpoker.domain.dtos.PlayerConfigDto;
import com.couchpoker.domain.dtos.PlayerDto;
import org.springframework.web.bind.annotation.*;

@RestController
public interface GameService {
    @PostMapping("/create-gameboard")
    GameBoardDto createGameBoard(@RequestBody GameBoardConfigDto config);

    @PostMapping("/join-game")
    PlayerDto joinGameBoardAsPlayer(@RequestBody PlayerConfigDto config);

    @GetMapping("/gameboard/{identifier}")
    GameBoardDto getGameBoard(@PathVariable String identifier);
}
