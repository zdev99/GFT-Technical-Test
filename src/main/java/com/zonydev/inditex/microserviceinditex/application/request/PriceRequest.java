package com.zonydev.inditex.microserviceinditex.application.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PriceRequest {

	@NotBlank(message = "El campo 'date' no puede estar vacío")
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}", message = "El campo 'date' debe tener el formato yyyy-mm-dd hh:mm:ss")
	private String date;

	@NotBlank(message = "El campo 'productId' no puede estar vacío")
	private Integer productId;

	@NotBlank(message = "El campo 'brandId' no puede estar vacío")
	private Long brandId;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
}
