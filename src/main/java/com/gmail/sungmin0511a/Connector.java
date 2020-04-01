package com.gmail.sungmin0511a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Connector
 */
public class Connector {

    private static final Connector INSTANCE = new Connector();
    private WebDriver driver;
    private WebElement document;

    public static Connector getInstance() {
        return INSTANCE;
    }

    private Connector() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    }

    public WebElement connect(String URL) {
        driver.get(URL);
        document = driver.findElement(By.cssSelector("html"));
        return document;
    }

    

    /**
     * @return the document
     */
    public WebElement getDocument() {
        return document;
    }

    public void close() {
        driver.close();
    }


        // WebElement comments = driver.findElement(By.tagName("ytd-comments"));
    //     try {
    //         document = Jsoup.connect(URL).get();
    //         Elements elements = document.body().select(".list-item");
    //         for (Element element : elements) {
    //             Element ln_num = element.selectFirst(".ln-num");
    //             Element ln_catal = element.selectFirst(".ln-catal");
    //             System.out.println(ln_num.text());
    //             System.out.println(ln_catal.text());
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    
}