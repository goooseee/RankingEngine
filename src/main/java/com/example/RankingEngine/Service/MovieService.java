package com.example.RankingEngine.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.RankingEngine.Entity.Movie;
import com.example.RankingEngine.Repository.MovieRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class MovieService {
	
	private final MovieRepository movieRepository;
	
	public void addMovie(Movie movie) {
		movieRepository.save( movie );
	}
	
	public List<Movie> getAll(){
		return movieRepository.findAll();
	}
	
	public Optional<Movie> getById(Long id){
		return movieRepository.findById( id );
	}
	
}
