package com.example.seollyongbackend.dto;


import com.example.seollyongbackend.entity.Town;
import lombok.Getter;

@Getter
public class TopCongestedTownsResponseDto {
    private Long townId;
    private String townName;

    private Integer congestionRank;

    public TopCongestedTownsResponseDto(Town town) {
        this.townId = town.getTownId();
        this.townName = town.getTownName();
        this.congestionRank = town.getCongestionRank();
    }
}
