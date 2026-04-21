package com.example.RankingEngine.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ResponseDTO {
	
	private long userId;
	
	private List<Long> moviesId;

}
