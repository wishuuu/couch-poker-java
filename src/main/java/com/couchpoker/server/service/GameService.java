package com.couchpoker.server.service;

import com.couchpoker.domain.dtos.GameBoardDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface GameService {
    @PostMapping("/initialize")
    GameBoardDto initializeGameBoard();
}
