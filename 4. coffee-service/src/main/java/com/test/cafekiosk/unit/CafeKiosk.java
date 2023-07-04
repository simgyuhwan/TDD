package com.test.cafekiosk.unit;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.test.cafekiosk.unit.beverage.Beverage;
import com.test.cafekiosk.unit.order.Order;

import lombok.Getter;

@Getter
public class CafeKiosk {
	private final List<Beverage> beverages = new ArrayList<>();
	private static final LocalTime SHOP_OPEN_TIME = LocalTime.of(10, 0);
	private static final LocalTime SHOP_CLOSE_TIME = LocalTime.of(22, 0);

	public void add(Beverage beverage, int count) {
		if (count <= 0) {
			throw new IllegalArgumentException("음료는 1잔 이상 주문하실 수 있습니다.");
		}

		for (int i = 0; i < count; i++) {
			beverages.add(beverage);
		}
	}

	public void add(Beverage beverage) {
		beverages.add(beverage);
	}

	public int calculateTotalPrice() {
		return beverages.stream().mapToInt(Beverage::getPrice).sum();
	}

	public void remove(Beverage beverage) {
		beverages.remove(beverage);
	}

	public void clear() {
		beverages.clear();
	}

	public Order createOrder() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		LocalTime currentTime = currentDateTime.toLocalTime();

		if (currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)) {
			throw new IllegalArgumentException("주문 시간이 아닙니다. 관리자에게 문의하세요.");
		}

		return new Order(currentDateTime, beverages);
	}

	public Order createOrder(LocalDateTime currentDateTime) {
		LocalTime currentTime = currentDateTime.toLocalTime();

		if (currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)) {
			throw new IllegalArgumentException("주문 시간이 아닙니다. 관리자에게 문의하세요.");
		}

		return new Order(currentDateTime, beverages);
	}
}
