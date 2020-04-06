package com.rocksoft.javaspringdata.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Title {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@NonNull
	private System system;
	@OneToOne
	@NonNull
	private EsrbRating rating;
	@NonNull
	private String title;
}
