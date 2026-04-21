package com.example.RankingEngine.DTO;

import java.util.List;

import com.example.RankingEngine.DTO.Enum.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieDTO {
	
	private Long movieId;
	
	private List<Type> type;
	
	private long durationOfMovieSeconds;
	
	private double rating;
	
}
