package com.zonydev.inditex.microserviceinditex.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zonydev.inditex.microserviceinditex.application.response.Brand;
import com.zonydev.inditex.microserviceinditex.domain.repository.BrandRepository;

@Service
public class BrandService {

	@Autowired
	private final BrandRepository brandRepository;

	public BrandService(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	public Brand findById(Long id) {
		/*
		 * Aquí tendríamos la lógica de negocio, pero al no existir y ser una simple
		 * consulta únicamente llamaremos al método con los parámetros ya validados por
		 * el controller
		 */
		return brandRepository.findById(id).orElse(null);
	}
}
