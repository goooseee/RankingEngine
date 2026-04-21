package com.example.RankingEngine.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.RankingEngine.Entity.UserPreference;
import com.example.RankingEngine.Repository.UserPreferenceRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class UserPreferenceService {
	
	private final UserPreferenceRepository repository;
	
	public List<UserPreference> getAll(){
		return repository.findAll();
	}
	
	public void addPreference(UserPreference userPreference) {
		repository.save( userPreference );
	}
	
	public void saveAll(List<UserPreference> userPreference) {
		repository.saveAll( userPreference );
	}
	
	public Optional<UserPreference> getById(Long id) {
		return repository.findById( id );
	}
	public List<UserPreference> getByUserId(Long userId) {
		//log.atTrace().log( "Getting userpreference for user with Id = {}", userId);
		return repository.findByUserId( userId );
	}
}
