package com.zonydev.inditex.microserviceinditex.domain.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zonydev.inditex.microserviceinditex.application.response.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
	@Query("SELECT p FROM Price p WHERE p.startDate <= :date AND p.endDate >= :date AND p.productId = :productId AND p.brand.brandId = :brandId ORDER BY p.priority DESC LIMIT 1")
	Price findByDateAndProductIdAndBrandId(@Param("date") LocalDateTime dateTime, @Param("productId") Integer productId,
			@Param("brandId") Long brandId);
}
