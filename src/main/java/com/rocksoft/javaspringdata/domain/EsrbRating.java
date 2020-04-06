package com.rocksoft.javaspringdata.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class EsrbRating {
	@Id
	@GeneratedValue
	private Long id;
	@NonNull String code;
	@NonNull String name;
}
