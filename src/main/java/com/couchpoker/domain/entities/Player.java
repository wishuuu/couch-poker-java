package com.couchpoker.domain.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public final class Player {
    private final String Name;
    private final String ConnectionId;
    private final PlayerState PlayerState;
}
