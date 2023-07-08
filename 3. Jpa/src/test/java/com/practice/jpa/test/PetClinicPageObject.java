package com.practice.jpa.test;

import org.openqa.selenium.WebDriver;

public abstract class PetClinicPageObject {

    protected final WebDriver driver;

    public PetClinicPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void visit() {
        throw new RuntimeException("This page does not have a visit link");
    }

    /**
     * 도우미 메서드
     */
    protected void visit(String url) {
        driver.get("http://localhost:8080" + url);
        isReady();
    }

    public abstract void isReady();
}
