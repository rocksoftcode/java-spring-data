package com.rocksoft.javaspringdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rocksoft.javaspringdata.domain.Title;
import com.rocksoft.javaspringdata.domain.FullTitleProjection;

@RepositoryRestResource(excerptProjection = FullTitleProjection.class)
public interface TitleRepository extends CrudRepository<Title, Long> {
}
