package com.rocksoft.javaspringdata.domain;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullTitle", types = { Title.class })
public interface FullTitleProjection {
	String getTitle();
	System getSystem();
	EsrbRating getRating();
}
