package com.gmail.sungmin0511a;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * KBID Crawler
 * 
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Connector connector = Connector.getInstance();
        
        WebElement document = connector.connect("https://www.kbid.co.kr/login/common_login.htm");

        WebElement fLogin = document.findElement(By.cssSelector("form[name=\"FLogin\"]"));
        WebElement idBox = fLogin.findElement(By.cssSelector("input#MemID"));
        WebElement pwBox = fLogin.findElement(By.cssSelector("input#MemPW"));
        WebElement loginBtn = fLogin.findElement(By.cssSelector("input[name=\"images\"]"));
        idBox.sendKeys("pipe3");
        pwBox.sendKeys("t0206");
        loginBtn.submit();
        Logger.sleep(1000);
        
        
        document = connector.connect("https://www.kbid.co.kr/common/main_search_result.htm?CurSelPage=2&Tname=C&Kind_type=2&lstWork=&lstKind=");

        WebElement fomList = document.findElement(By.cssSelector("form[name=\"fomList\"]"));
        System.out.println(fomList.getText());

        List<WebElement> elements = document.findElements(By.cssSelector(".list-item"));
        String hyperLink_last = "";
        for (WebElement element : elements) {
            WebElement ln_num = element.findElement(By.cssSelector(".ln-num"));
            WebElement ln_catal = element.findElement(By.cssSelector(".ln-catal"));
            WebElement hyperLink = element.findElement(By.cssSelector(".ln-subject")).findElement(By.cssSelector("a#BidName"));
            Logger.log(ln_num.getText());
            Logger.log(ln_catal.getText());
            hyperLink_last = hyperLink.getAttribute("href");
            System.out.println(hyperLink_last);
        }

        connector.connect(hyperLink_last);
        
        Logger.sleep(5000);

        connector.close();
    }
}
