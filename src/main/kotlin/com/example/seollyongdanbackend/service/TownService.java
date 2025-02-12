package com.example.seollyongdanbackend.service;

import com.example.seollyongdanbackend.dto.*;
import com.example.seollyongdanbackend.entity.Town;
import com.example.seollyongdanbackend.repository.TownRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TownService {
    private final TownRepository townRepository;

    public TownService(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    public List<TownCrimeFrequencyResponseDto> getCrimeFrequencies() {
        List<Town> towns = townRepository.findAll();
        return towns.stream()
                .map(TownCrimeFrequencyResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TownSafetyResponseDto getSafetyInfo(Long townId) {
        Town town = townRepository.findById(townId)
                .orElseThrow(() -> new IllegalArgumentException("해당 자치구가 존재하지 않습니다. ID: " + townId));

        return new TownSafetyResponseDto(town);
    }

    // 안전 순위 상위 5개 자치구 조회
    public List<TownSafetyRankResponseDto> getTop5SafeTowns() {
        List<Town> towns = townRepository.findTop5ByOrderBySafetyRankAsc();
        return towns.stream()
                .map(TownSafetyRankResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TownPropertiesResponseDto getPropertiesInfo(Long townId) {
        Town town = townRepository.findById(townId)
                .orElseThrow(() -> new IllegalArgumentException("해당 자치구가 존재하지 않습니다. ID: " + townId));

        return new TownPropertiesResponseDto(town);
    }

    // 전체 자치구의 도로 혼잡도 조회
    public List<TownRoadCongestionResponseDto> getAllRoadCongestion() {
        List<Town> towns = townRepository.findAll();
        return towns.stream()
                .map(TownRoadCongestionResponseDto::new)
                .collect(Collectors.toList());
    }

    public TownTransportResponseDto getTransportInfo(Long townId) {
        Town town = townRepository.findByTownId(townId)
                .orElseThrow(() -> new IllegalArgumentException("해당 자치구가 존재하지 않습니다. ID: " + townId));

        return new TownTransportResponseDto(town);
    }

    // 혼잡도 순위 상위 5개 자치구 조회
    public List<TopCongestedTownsResponseDto> getTop5CongestedTowns() {
        List<Town> topTowns = townRepository.findTop5ByOrderByCongestionRankAsc();
        return topTowns.stream()
                .map(TopCongestedTownsResponseDto::new)
                .collect(Collectors.toList());
    }
}

