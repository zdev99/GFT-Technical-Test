package com.zonydev.inditex.microserviceinditex.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zonydev.inditex.microserviceinditex.application.response.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
	Optional<Brand> findById(Long id);
}
