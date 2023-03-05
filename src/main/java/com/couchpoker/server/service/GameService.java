package com.couchpoker.server.service;

import com.couchpoker.domain.dtos.GameBoardConfigDto;
import com.couchpoker.domain.dtos.GameBoardDto;
import com.couchpoker.domain.dtos.PlayerConfigDto;
import com.couchpoker.domain.dtos.PlayerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public interface GameService {
    @PostMapping("/create-gameboard")
    ResponseEntity<GameBoardDto> createGameBoard(@RequestBody GameBoardConfigDto config);

    @PostMapping("/join-game")
    ResponseEntity<PlayerDto> joinGameBoardAsPlayer(@RequestBody PlayerConfigDto config);

    @GetMapping("/gameboard/{joinCode}")
    ResponseEntity<GameBoardDto> getGameBoard(@PathVariable String joinCode);

    @PostMapping("/gameboard/{joinCode}/begin-round")
    HttpStatus beginRound(@PathVariable String joinCode);

    @PostMapping("/gameboard/{joinCode}/deal-turn")
    HttpStatus dealTurn(@PathVariable String joinCode);
}
