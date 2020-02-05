package com.gmail.sungmin0511a;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Connector
 */
public class Connector {

    private static final Connector singleton_instance = new Connector();
    Document document;

    public static Connector instance() {
        return singleton_instance;
    }

    public void connect() {
        String URL = "https://www.kbid.co.kr/common/main_search_result.htm?Tname=I&Kind_type=1";
        try {
            document = Jsoup.connect(URL).get();
            Elements elements = document.body().select(".list-item");
            for (Element element : elements) {
                Element ln_num = element.selectFirst(".ln-num");
                Element ln_catal = element.selectFirst(".ln-catal");
                System.out.println(ln_num.text());
                System.out.println(ln_catal.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}