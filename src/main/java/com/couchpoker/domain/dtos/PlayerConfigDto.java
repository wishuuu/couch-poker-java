package com.couchpoker.domain.dtos;

import lombok.Data;

@Data
public class PlayerConfigDto {
    public String identifier;
    public String name;
    public String connectionString;
}
