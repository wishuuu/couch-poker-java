package com.couchpoker.domain.entities;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@RequiredArgsConstructor
public final class Player {
    @Id
    @GeneratedValue
    private Long id;
    private final String name;
    private final String connectionId;
    private final PlayerState playerState;
}
