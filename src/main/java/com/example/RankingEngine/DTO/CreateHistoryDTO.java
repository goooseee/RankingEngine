package com.example.RankingEngine.DTO;

import java.time.LocalDate;

import com.example.RankingEngine.DTO.Enum.Reaction;
import com.example.RankingEngine.Entity.Movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateHistoryDTO {
	
	private Long userId;
	private Long movieId;
	private Reaction react;
	private long durationSeconds;
	private int timesWatched;
	
}
