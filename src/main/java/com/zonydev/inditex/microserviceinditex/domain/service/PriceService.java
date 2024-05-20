package com.zonydev.inditex.microserviceinditex.domain.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zonydev.inditex.microserviceinditex.application.response.Price;
import com.zonydev.inditex.microserviceinditex.domain.repository.PriceRepository;

@Service
public class PriceService {

	@Autowired
	private final PriceRepository priceRepository;

	public PriceService(PriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}

	public Price getPrice(String date, Integer productId, Long brandId) {
		/*
		 * Aquí tendríamos la lógica de negocio, pero al no existir y ser una simple
		 * consulta únicamente llamaremos al método con los parámetros ya validados por
		 * el controller
		 */
		Price price = null;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
			price = priceRepository.findByDateAndProductIdAndBrandId(dateTime, productId, brandId);
		} catch (Exception e) {
			System.err.println("Error al convertir el String a LocalDateTime: " + e.getMessage());
		}
		return price;
	}
}
