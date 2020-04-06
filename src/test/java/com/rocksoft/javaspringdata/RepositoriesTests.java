package com.rocksoft.javaspringdata;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.rocksoft.javaspringdata.domain.EsrbRating;
import com.rocksoft.javaspringdata.domain.System;
import com.rocksoft.javaspringdata.domain.Title;
import com.rocksoft.javaspringdata.repository.EsrbRatingRepository;
import com.rocksoft.javaspringdata.repository.SystemRepository;
import com.rocksoft.javaspringdata.repository.TitleRepository;

import lombok.AllArgsConstructor;

@DataJpaTest
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RepositoriesTests {

	private TestEntityManager entityManager;
	private EsrbRatingRepository esrbRatingRepository;
	private SystemRepository systemRepository;
	private TitleRepository titleRepository;

	@Test
	void esrbRatingPersistence() {
		EsrbRating rating = new EsrbRating("FOO", "Foobar");
		entityManager.persist(rating);
		entityManager.flush();
		Optional<EsrbRating> ratingFound = esrbRatingRepository.findById(rating.getId());
		assertThat(ratingFound.isPresent()).isTrue();
		assertThat(ratingFound.get()).isEqualTo(rating);
	}

	@Test
	void systemPersistence() {
		System system = new System("Foobar");
		entityManager.persist(system);
		entityManager.flush();
		Optional<System> systemFound = systemRepository.findById(system.getId());
		assertThat(systemFound.isPresent()).isTrue();
		assertThat(systemFound.get()).isEqualTo(system);
	}

	@Test
	void titlePersistenceAndRelationships() {
		EsrbRating rating = new EsrbRating("FOO", "Foobar");
		System system = new System("Foobar");
		entityManager.persist(rating);
		entityManager.persist(system);
		entityManager.flush();
		Title title = new Title(system, rating, "Foobar");
		entityManager.persist(title);
		entityManager.flush();
		Optional<Title> titleFound = titleRepository.findById(title.getId());
		assertThat(titleFound.isPresent()).isTrue();
		assertThat(titleFound.get()).isEqualTo(title);
	}
}
