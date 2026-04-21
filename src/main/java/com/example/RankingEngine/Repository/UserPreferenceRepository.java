package com.example.RankingEngine.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RankingEngine.Entity.UserPreference;

public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long>{
	
	List<UserPreference> findByUserId(Long id);
	
}
