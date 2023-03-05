package com.couchpoker.domain.dtos;

import lombok.Data;

@Data
public class PlayerConfigDto {
    public String joinCode;
    public String name;
    public String connectionString;
}
