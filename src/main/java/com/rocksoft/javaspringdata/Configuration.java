package com.rocksoft.javaspringdata;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import com.rocksoft.javaspringdata.domain.EsrbRating;
import com.rocksoft.javaspringdata.domain.System;
import com.rocksoft.javaspringdata.domain.Title;
import com.rocksoft.javaspringdata.repository.EsrbRatingRepository;
import com.rocksoft.javaspringdata.repository.SystemRepository;
import com.rocksoft.javaspringdata.repository.TitleRepository;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	ApplicationRunner loadTestData(EsrbRatingRepository esrbRatingRepository, SystemRepository systemRepository, TitleRepository titleRepository) {
		return (ApplicationArguments args) -> {
			EsrbRating rating = esrbRatingRepository.save(new EsrbRating("E", "Everyone"));
			System system = systemRepository.save(new System("Atari 2600"));
			Title title1 = new Title(system, rating, "California Games");
			Title title2 = new Title(system, rating, "Pitfall!");
			Title title3 = new Title(system, rating, "Tank Commander");
			titleRepository.save(title1);
			titleRepository.save(title2);
			titleRepository.save(title3);
		};
	}
}
