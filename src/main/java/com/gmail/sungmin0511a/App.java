package com.gmail.sungmin0511a;

import java.util.Iterator;
import java.util.LinkedList;
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
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Connector connector = Connector.getInstance();

        WebElement document = connector.connect("https://www.kbid.co.kr/login/common_login.htm");

        WebElement fLogin = document.findElement(By.cssSelector("form[name=\"FLogin\"]"));
        WebElement idBox = fLogin.findElement(By.cssSelector("input#MemID"));
        WebElement pwBox = fLogin.findElement(By.cssSelector("input#MemPW"));
        WebElement loginBtn = fLogin.findElement(By.cssSelector("input[name=\"images\"]"));
        WebElement fomList;
        List<WebElement> elements;
        List<PostingDocument> postingList = new LinkedList<>();
        idBox.sendKeys("pipe3");
        pwBox.sendKeys("t0206");
        loginBtn.submit();
        Logger.sleep(1000);

        // 필터에 맞는 URL로 접속
        URLMaker urlMaker = new URLMaker();
        urlMaker.setLstWork("전문소방시설공사");
        urlMaker.setLstArea("경기");
        urlMaker.setLstSArea("관내");

        for (int i = 1; i < 2; i++) {
            urlMaker.setCurSelPage(i);
            document = connector.connect(urlMaker.getUrl());

            fomList = document.findElement(By.cssSelector("form[name=\"fomList\"]"));
            elements = fomList.findElements(By.cssSelector(".list-item"));

            // 리스트에 있는 목록 가져오기
            for (WebElement element : elements) {
                PostingDocument item = new PostingDocument();
                WebElement ln_num = element.findElement(By.cssSelector(".ln-num"));
                WebElement ln_subject = element.findElement(By.cssSelector(".ln-subject"));
                WebElement ln_catal = element.findElement(By.cssSelector(".ln-catal"));
                WebElement ln_chk = element.findElement(By.cssSelector(".ln-chk"));
                WebElement hyperLink = ln_subject.findElement(By.cssSelector("a#BidName"));
                List<WebElement> btn_sr = ln_chk.findElements(By.cssSelector(".btn-sr"));

                item.setNum(ln_num.getText());
                item.setSubject(hyperLink.getText());
                item.setCatal(ln_catal.getText());
                item.setHyperLink(hyperLink.getAttribute("href"));
                for (WebElement webElement : btn_sr) {
                    if (webElement.getText().equals("투찰")) {
                        item.setProposition(true);
                        postingList.add(item);
                    }
                    if (webElement.getText().equals("읽음")) {
                        item.setRead(true);
                    }
                }
            }
        }

        PostingDocument firstDocument = postingList.get(0);
        document = connector.connect(firstDocument.getHyperLink());
        WebElement tbl_bid_view = document.findElement(By.cssSelector(".tbl_bid_view"));
        List<WebElement> th_bid_view = tbl_bid_view.findElements(By.cssSelector("th"));
        List<WebElement> td_bid_view = tbl_bid_view.findElements(By.cssSelector("td"));
        Iterator<WebElement> th_bid_view_iter = th_bid_view.iterator();
        Iterator<WebElement> td_bid_view_iter = td_bid_view.iterator();
        while (th_bid_view_iter.hasNext()) {
            WebElement th = th_bid_view_iter.next();
            WebElement td = td_bid_view_iter.next();
            String th_text = th.getText();
            String td_text = td.getText();
        }
        
        Logger.sleep(5000);

        connector.close();
    }
}
