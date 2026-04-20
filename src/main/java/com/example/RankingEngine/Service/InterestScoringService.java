package com.example.RankingEngine.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.RankingEngine.DTO.MovieDTO;
import com.example.RankingEngine.DTO.ScoringWeightsProperties;
import com.example.RankingEngine.DTO.UserPreferenceDTO;
import com.example.RankingEngine.DTO.UserRecommendationProfile;
import com.example.RankingEngine.DTO.UserWatchedHistory;
import com.example.RankingEngine.DTO.Enum.CountStatus;
import com.example.RankingEngine.DTO.Enum.Reaction;
import com.example.RankingEngine.DTO.Enum.RecentyType;
import com.example.RankingEngine.DTO.Enum.Type;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
@RequiredArgsConstructor
public class InterestScoringService {
	
	private final ScoringWeightsProperties properties;

	public List<UserPreferenceDTO> calculateInterest(UserRecommendationProfile profile,
			List<UserWatchedHistory> history) {
//		System.out.println( "Interest Scoring: " );
		System.out.println( profile.getGenreWeights() );
//		System.out.println( history.get( 0 ).toString());
		long startTime = System.currentTimeMillis();
		log.atDebug().log( "Start calc interest for user = {}", profile.getUserId() );
		Map<Type, UserPreferenceDTO> mapType = profile.getGenreWeights();
		if(mapType == null) {
			mapType = new HashMap<>();
		}
		int proceed = 0;
		
		for(UserWatchedHistory watchedHistory : history) {
			
			if(watchedHistory.getStatus()!=CountStatus.Count) {
			double weight = calculationContribution( watchedHistory );
			List<Type> types = watchedHistory.getMovie().getType();
			for(Type type : types) {
				
				UserPreferenceDTO userPreference = mapType.computeIfAbsent( type, 
						t -> create( type, profile.getUserId(), 0.0 ));
				
				updateUserPreference( userPreference, weight );
				
			}
			watchedHistory.setStatus( CountStatus.Count );
			proceed++;
			}
		}
		log.atDebug().log( "End calc interst proceed new movie {} total preference for user = {} in ms = {}",
				 proceed, mapType.size(), profile.getUserId(), System.currentTimeMillis()-startTime );
		return new ArrayList<>(mapType.values());
	}
	
	private UserPreferenceDTO create(Type type, long user, double weight) {
		return UserPreferenceDTO
					.builder()
					.type( type )
					.userId( user )
					.weight( weight )
					.lastUpdate( LocalDate.now() )
					.build();
	}
	
	private void updateUserPreference (UserPreferenceDTO preference, double weight) {
		preference.setWeight( preference.getWeight() + weight );
		preference.setLastUpdate( LocalDate.now() );
	}
	
	private double calculationContribution(UserWatchedHistory history) {
		double weight = getReact(history.getReact())+getDuration(history)+getDate(history.getWhenWatched());
		double finalWeight = weight*getTimesWatched(history.getTimesWatched());
		return finalWeight;
	}
	
	private double getReact(Reaction reaction) {
		return properties.reaction().getOrDefault( reaction, 0.0 );
	}
	
	private double getDate(LocalDate date) {
		LocalDate dateNow = LocalDate.now();
		return properties.recency().getOrDefault( getRecent( date, dateNow ), 0.0 );
	}
	
	private RecentyType getRecent(LocalDate date1,LocalDate date2) {
		long e = ChronoUnit.DAYS.between( date1, date2 );
		if(e<=7) {
			return RecentyType.week;
		}else if (e <= 30) {
			return RecentyType.month;
		}else
			return RecentyType.morethanmonths;
	}
	
	private double getDuration(UserWatchedHistory history) {
		MovieDTO movie = history.getMovie();
		double procent = 0.0;
		if(movie.getDurationOfMovieSeconds()>0) {
		procent = (double) history.getDurationSeconds()/movie.getDurationOfMovieSeconds();
		}
		if(procent<0.3) {
			return -0.1;
		}else if(procent<=0.5) {
			return 0.2;
		}else if(procent<=0.7) {
			return 0.5;
		}else 
			return 1.0;
	}
	
	private double getTimesWatched(int timesWatched) {
		return Math.log10( timesWatched + 1);
	}
	
	
}
