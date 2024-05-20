package com.zonydev.inditex.microserviceinditex.application.response;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Entity
@Data
@Builder
@Jacksonized
public class Brand {

	public Brand() {
		this.brandId = null;
		this.description = null;
	}

	public Brand(Long brandId, String description) {
		this.brandId = brandId;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long brandId;

	@Column(nullable = false)
	private String description;

	public Long getBrandId() {
		return brandId;
	}

	public String getDescription() {
		return description;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
