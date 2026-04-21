package com.example.RankingEngine.Entity;

import java.util.List;

import com.example.RankingEngine.DTO.Enum.Type;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
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
@Table(name = "movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long movieId;
	@ElementCollection
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"))
	@Column(name = "genre")
	private List<Type> type;
	
	private long durationOfMovieSeconds;
	
	private double rating;
}
