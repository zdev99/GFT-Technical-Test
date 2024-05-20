package com.zonydev.inditex.microserviceinditex.application.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zonydev.inditex.microserviceinditex.application.request.PriceRequest;
import com.zonydev.inditex.microserviceinditex.application.response.Brand;
import com.zonydev.inditex.microserviceinditex.application.response.Price;
import com.zonydev.inditex.microserviceinditex.domain.service.BrandService;
import com.zonydev.inditex.microserviceinditex.domain.service.PriceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/price")
@Validated
public class PriceController {

	@Autowired
	private PriceService priceService;

	@Autowired
	private BrandService brandService;

	public PriceController(PriceService priceService, BrandService brandService) {
		super();
		this.priceService = priceService;
		this.brandService = brandService;
	}

	@PostMapping
	public ResponseEntity<Price> calculatePrice(@Valid @RequestBody PriceRequest request) {
		Price calculatedPrice = null;
		Brand brand = brandService.findById(request.getBrandId());
		if (brand != null) {
			calculatedPrice = priceService.getPrice(request.getDate(), request.getProductId(), request.getBrandId());
			return ResponseEntity.ok(calculatedPrice);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
