package com.zonydev.inditex.microserviceinditex.application.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.zonydev.inditex.microserviceinditex.application.request.PriceRequest;
import com.zonydev.inditex.microserviceinditex.application.response.Brand;
import com.zonydev.inditex.microserviceinditex.application.response.Price;
import com.zonydev.inditex.microserviceinditex.domain.service.BrandService;
import com.zonydev.inditex.microserviceinditex.domain.service.PriceService;

public class PriceControllerTest {

	private PriceController priceController;
	private PriceService priceService;
	private BrandService brandService;

	@BeforeEach
	public void setUp() {
		priceService = mock(PriceService.class);
		brandService = mock(BrandService.class);
		priceController = new PriceController(priceService, brandService);
	}

	@Test
	public void testCalculatePrice1() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Request Test 1 correspondiente al PDF
		PriceRequest request = new PriceRequest();
		request.setDate("2020-06-14 10:00:00");
		request.setProductId(35455);
		request.setBrandId(1L);

		// Simulamos una respuesta válida del servicio de Brand
		Brand expectedBrand = new Brand(1L, "ZARA");
		when(brandService.findById(request.getBrandId())).thenReturn(expectedBrand);

		// Simulamos una respuesta válida del servicio de Price
		Price expectedPrice = new Price();
		expectedPrice.setPriceId(3L);
		expectedPrice.setBrand(expectedBrand);
		expectedPrice.setStartDate(LocalDateTime.parse("2020-06-15 00:00:00", formatter));
		expectedPrice.setEndDate(LocalDateTime.parse("2020-06-15 11:00:00", formatter));
		expectedPrice.setPriceList(1);
		expectedPrice.setProductId(35455);
		expectedPrice.setPriority(1);
		expectedPrice.setPrice(30.5f);
		expectedPrice.setCurr("EUR");

		when(priceService.getPrice(request.getDate(), request.getProductId(), request.getBrandId()))
				.thenReturn(expectedPrice);

		ResponseEntity<Price> response = priceController.calculatePrice(request);

		// Verificamos que la respuesta sea OK (200)
		assertEquals(HttpStatus.OK, response.getStatusCode());

		// Verificamos que el Price devuelto tenga el PriceId esperado
		assertEquals(expectedPrice.getPriceId(), response.getBody().getPriceId());
	}

	@Test
	public void testCalculatePrice2() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Request Test 2 correspondiente al PDF
		PriceRequest request = new PriceRequest();
		request.setDate("2020-06-14 16:00:00");
		request.setProductId(35455);
		request.setBrandId(1L);

		// Simulamos una respuesta válida del servicio de Brand
		Brand expectedBrand = new Brand(1L, "ZARA");
		when(brandService.findById(request.getBrandId())).thenReturn(expectedBrand);

		// Simulamos una respuesta válida del servicio de Price
		Price expectedPrice = new Price();
		expectedPrice.setPriceId(2L);
		expectedPrice.setBrand(expectedBrand);
		expectedPrice.setStartDate(LocalDateTime.parse("2020-06-14 15:00:00", formatter));
		expectedPrice.setEndDate(LocalDateTime.parse("2020-06-14 18:30:00", formatter));
		expectedPrice.setPriceList(2);
		expectedPrice.setProductId(35455);
		expectedPrice.setPriority(1);
		expectedPrice.setPrice(25.45f);
		expectedPrice.setCurr("EUR");

		when(priceService.getPrice(request.getDate(), request.getProductId(), request.getBrandId()))
				.thenReturn(expectedPrice);

		ResponseEntity<Price> response = priceController.calculatePrice(request);

		// Verificamos que la respuesta sea OK (200)
		assertEquals(HttpStatus.OK, response.getStatusCode());

		// Verificamos que el Price devuelto tenga el PriceId esperado
		assertEquals(expectedPrice.getPriceId(), response.getBody().getPriceId());
	}

	@Test
	public void testCalculatePrice3() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Request Test 3 correspondiente al PDF
		PriceRequest request = new PriceRequest();
		request.setDate("2020-06-14 21:00:00");
		request.setProductId(35455);
		request.setBrandId(1L);

		// Simulamos una respuesta válida del servicio de Brand
		Brand expectedBrand = new Brand(1L, "ZARA");
		when(brandService.findById(request.getBrandId())).thenReturn(expectedBrand);

		// Simulamos una respuesta válida del servicio de Price
		Price expectedPrice = new Price();
		expectedPrice.setPriceId(1L);
		expectedPrice.setBrand(expectedBrand);
		expectedPrice.setStartDate(LocalDateTime.parse("2020-06-14 00:00:00", formatter));
		expectedPrice.setEndDate(LocalDateTime.parse("2020-12-31 23:59:59", formatter));
		expectedPrice.setPriceList(1);
		expectedPrice.setProductId(35455);
		expectedPrice.setPriority(0);
		expectedPrice.setPrice(35.5f);
		expectedPrice.setCurr("EUR");

		when(priceService.getPrice(request.getDate(), request.getProductId(), request.getBrandId()))
				.thenReturn(expectedPrice);

		ResponseEntity<Price> response = priceController.calculatePrice(request);

		// Verificamos que la respuesta sea OK (200)
		assertEquals(HttpStatus.OK, response.getStatusCode());

		// Verificamos que el Price devuelto tenga el PriceId esperado
		assertEquals(expectedPrice.getPriceId(), response.getBody().getPriceId());
	}

	@Test
	public void testCalculatePrice4() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Request Test 4 correspondiente al PDF
		PriceRequest request = new PriceRequest();
		request.setDate("2020-06-15 10:00:00");
		request.setProductId(35455);
		request.setBrandId(1L);

		// Simulamos una respuesta válida del servicio de Brand
		Brand expectedBrand = new Brand(1L, "ZARA");
		when(brandService.findById(request.getBrandId())).thenReturn(expectedBrand);

		// Simulamos una respuesta válida del servicio de Price
		Price expectedPrice = new Price();
		expectedPrice.setPriceId(3L);
		expectedPrice.setBrand(expectedBrand);
		expectedPrice.setStartDate(LocalDateTime.parse("2020-06-15 00:00:00", formatter));
		expectedPrice.setEndDate(LocalDateTime.parse("2020-06-15 11:00:00", formatter));
		expectedPrice.setPriceList(1);
		expectedPrice.setProductId(35455);
		expectedPrice.setPriority(1);
		expectedPrice.setPrice(30.5f);
		expectedPrice.setCurr("EUR");

		when(priceService.getPrice(request.getDate(), request.getProductId(), request.getBrandId()))
				.thenReturn(expectedPrice);

		ResponseEntity<Price> response = priceController.calculatePrice(request);

		// Verificamos que la respuesta sea OK (200)
		assertEquals(HttpStatus.OK, response.getStatusCode());

		// Verificamos que el Price devuelto tenga el PriceId esperado
		assertEquals(expectedPrice.getPriceId(), response.getBody().getPriceId());
	}

	@Test
	public void testCalculatePrice5() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Request Test 5 correspondiente al PDF
		PriceRequest request = new PriceRequest();
		request.setDate("2020-06-15 10:00:00");
		request.setProductId(35455);
		request.setBrandId(1L);

		// Simulamos una respuesta válida del servicio de Brand
		Brand expectedBrand = new Brand(1L, "ZARA");
		when(brandService.findById(request.getBrandId())).thenReturn(expectedBrand);

		// Simulamos una respuesta válida del servicio de Price
		Price expectedPrice = new Price();
		expectedPrice.setPriceId(4L);
		expectedPrice.setBrand(expectedBrand);
		expectedPrice.setStartDate(LocalDateTime.parse("2020-06-15 16:00:00", formatter));
		expectedPrice.setEndDate(LocalDateTime.parse("2020-12-31 23:59:59", formatter));
		expectedPrice.setPriceList(1);
		expectedPrice.setProductId(35455);
		expectedPrice.setPriority(1);
		expectedPrice.setPrice(38.95f);
		expectedPrice.setCurr("EUR");

		when(priceService.getPrice(request.getDate(), request.getProductId(), request.getBrandId()))
				.thenReturn(expectedPrice);

		ResponseEntity<Price> response = priceController.calculatePrice(request);

		// Verificamos que la respuesta sea OK (200)
		assertEquals(HttpStatus.OK, response.getStatusCode());

		// Verificamos que el Price devuelto tenga el PriceId esperado
		assertEquals(expectedPrice.getPriceId(), response.getBody().getPriceId());
	}

}
