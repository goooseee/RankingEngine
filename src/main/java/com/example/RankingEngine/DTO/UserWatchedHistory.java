package com.example.RankingEngine.DTO;

import java.time.LocalDate;
import java.util.List;

import com.example.RankingEngine.DTO.Enum.CountStatus;
import com.example.RankingEngine.DTO.Enum.Reaction;
import com.example.RankingEngine.DTO.Enum.Type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserWatchedHistory {
	private long userId;
	private MovieDTO movie;
	private Reaction react;
	private LocalDate whenWatched;
	private long durationSeconds;
	private int timesWatched;
	private CountStatus status;
}
