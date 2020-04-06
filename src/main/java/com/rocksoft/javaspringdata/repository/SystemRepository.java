package com.rocksoft.javaspringdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.rocksoft.javaspringdata.domain.System;

public interface SystemRepository extends CrudRepository<System, Long> {
}
