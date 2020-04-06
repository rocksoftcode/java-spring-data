package com.rocksoft.javaspringdata;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.rocksoft.javaspringdata.domain.Title;

import lombok.AllArgsConstructor;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class IntegrationTests {

	TestRestTemplate restTemplate;

	@Test
	void retrievesItemWithProjection() {
		ResponseEntity<Title> entity = restTemplate.getForEntity("/titles/3?projection={projection}", Title.class,
				new HashMap<String, String>() {{ put("projection", "fullTitle"); }});
		Title title = entity.getBody();
		assertThat(title).isNotNull();
		assertThat(title.getTitle()).isNotNull();
		assertThat(title.getRating()).isNotNull();
		assertThat(title.getRating().getCode()).isNotNull();
		assertThat(title.getSystem()).isNotNull();
		assertThat(title.getSystem().getName()).isNotNull();
	}
}
