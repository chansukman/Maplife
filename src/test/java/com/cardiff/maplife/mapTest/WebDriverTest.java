package com.cardiff.maplife.mapTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebDriverTest {
    private WebDriver webDriver;

    @Value("${local.server.port}")
    private int port;

    @Test
    public void testingContentsOnMap() throws InterruptedException {
        try{
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\c21106784\\OneDrive - Cardiff University\\Study\\Dissertation\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-debugging-port=42227");
            options.addArguments("--headless");
            this.webDriver = new ChromeDriver(options);
            this.webDriver.get("http://localhost:" + Integer.toString(port) + "/");
            Alert alt = webDriver.switchTo().alert();
            alt.accept();
            assertTrue(webDriver.findElement(By.className("filter-button")).getSize().height==50);
        }
        finally {
            webDriver.quit();
        }
    }
}
