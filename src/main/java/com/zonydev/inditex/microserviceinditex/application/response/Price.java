package com.zonydev.inditex.microserviceinditex.application.response;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;

@Entity
@Data
@Builder
@Jacksonized
@EqualsAndHashCode(callSuper = false)
public class Price {

	public Price() {
		this.priceId = null;
		this.brand = null;
		this.startDate = null;
		this.endDate = null;
		this.priceList = null;
		this.productId = null;
		this.priority = null;
		this.price = null;
		this.curr = null;
	}

	public Price(Long priceId, Brand brand, LocalDateTime startDate, LocalDateTime endDate, Integer priceList,
			Integer productId, Integer priority, Float price, String curr) {
		this.priceId = priceId;
		this.brand = brand;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long priceId;

	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)
	private Brand brand;

	@Column(nullable = false)
	private LocalDateTime startDate;

	@Column(nullable = false)
	private LocalDateTime endDate;

	@Column(nullable = false)
	private Integer priceList;

	@Column(nullable = false)
	private Integer productId;

	@Column(nullable = false)
	private Integer priority;

	@Column(nullable = false)
	private Float price;

	@Column(nullable = false)
	private String curr;

	public Long getPriceId() {
		return priceId;
	}

	public Brand getBrand() {
		return brand;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public Integer getPriceList() {
		return priceList;
	}

	public Integer getProductId() {
		return productId;
	}

	public Integer getPriority() {
		return priority;
	}

	public Float getPrice() {
		return price;
	}

	public String getCurr() {
		return curr;
	}

	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

}
