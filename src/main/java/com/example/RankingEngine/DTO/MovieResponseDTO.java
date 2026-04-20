package com.example.RankingEngine.DTO;

import java.util.List;

import com.example.RankingEngine.DTO.Enum.Type;

public record MovieResponseDTO(Long id, String title, long durationOfMovieSeconds, double rating, double weight, List<Type> genres) {}

