package com.testproject;

import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class LoginFeatureTests {

    private ChromeDriver driver;

    @Before
    public void setUp() throws InvalidTokenException, AgentConnectException, ObsoleteVersionException, IOException {
        driver = new ChromeDriver(new ChromeOptions());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void shouldOpenPage() {
        driver.get("https://example.cypress.io/commands/actions");
        Assert.assertEquals("Cypress.io: Kitchen Sink", driver.getTitle());
    }
    @Test
    public void shouldTypeText() {
        driver.get("https://example.cypress.io/commands/actions");
        driver.findElement(By.cssSelector(".action-email")).sendKeys("test@test.com");
        Assert.assertEquals("test@test.com",
                driver.findElement(By.cssSelector(".action-email")).getAttribute("value"));
    }
}
