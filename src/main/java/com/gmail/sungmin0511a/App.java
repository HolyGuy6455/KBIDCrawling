package com.gmail.sungmin0511a;

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
        Connector connector = Connector.instance();
        connector.connect();
    }
}
