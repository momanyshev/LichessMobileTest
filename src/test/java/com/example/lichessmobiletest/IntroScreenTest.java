package com.example.lichessmobiletest;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntroScreenTest {
    private AndroidDriver driver;
    private IntroScreen introScreen;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\Maksim.Manyshev\\Downloads\\lichess • Free Online Chess_8.0.0_Apkpure.apk");
        desiredCapabilities.setCapability("appium:platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Pixel 3a");
        desiredCapabilities.setCapability("appium:automationName", "uiAutomator2");
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        introScreen = new IntroScreen(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void lichessHeaderEnable(){
        assertTrue(introScreen.lichessHeaderEnabled(), "Заголовок приложения отсутствует");
    }
}