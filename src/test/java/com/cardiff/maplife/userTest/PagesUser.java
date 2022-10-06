package com.cardiff.maplife.userTest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PagesUser {
    private WebDriver webDriver;

    @Value("${local.server.port}")
    private int port;
    @Test
    public void testingPageContents() {
//      an alternative really good resource:   https://github.com/bonigarcia/webdrivermanager
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\c21086851\\OneDrive - Cardiff University\\Learning materials\\Devops\\CW\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=42227");
        options.addArguments("--headless");
        this.webDriver = new ChromeDriver(options);

//        WebDriverManager.firefoxdriver().setup();
//        webDriver = new FirefoxDriver();

        this.webDriver.get("http://localhost:" + Integer.toString(port) + "/authform?button=login-button");
        assertTrue(webDriver.findElement(By.id("login-a")).getText().contains("Login"));

        this.webDriver.findElement(By.name("username")).sendKeys("shuwen");
        this.webDriver.findElement(By.name("password")).sendKeys("123123123");
        this.webDriver.findElement(By.name("loginBtn")).click();
        this.webDriver.get("http://localhost:" + Integer.toString(port) + "/");
        assertTrue(webDriver.findElement(By.id("mapPageTitle")).getText().contains("MAP LIFE"));


        webDriver.quit();
    }
}

