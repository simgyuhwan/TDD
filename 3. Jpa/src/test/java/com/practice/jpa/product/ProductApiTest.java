package com.practice.jpa.product;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

class ProductApiTest extends ApiTest{

    @Test
    void 상품등록() {
        final AddProductRequest request = 상품등록요청_생성();

        // API 요청
        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/products")
                .then()
                .log().all().extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private AddProductRequest 상품등록요청_생성() {
        final int price = 1000;
        final String name = "상품명";
        return new AddProductRequest(name, price, DiscountPolicy.NONE);
    }

}
