package com.couchpoker.repository;

import com.couchpoker.domain.entities.GameBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameBoardRepository extends JpaRepository<GameBoard, Long>{
}
