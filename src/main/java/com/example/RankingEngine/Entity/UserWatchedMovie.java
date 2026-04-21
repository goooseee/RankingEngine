package com.example.RankingEngine.Entity;

import java.time.LocalDate;

import com.example.RankingEngine.DTO.Enum.CountStatus;
import com.example.RankingEngine.DTO.Enum.Reaction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserWatchedMovie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long userId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "movie_id")
	private Movie movie;
	@Enumerated(EnumType.STRING)
	private Reaction react;
	@Column(name = "when_watched")
	private LocalDate whenWatched;
	@Column(name = "duration_seconds")
	private long durationSeconds;
	@Column(name = "times_watched")
	private int timesWatched;
	@Builder.Default
	@Enumerated(EnumType.STRING)
	private CountStatus status = CountStatus.NotCount;
	
}
