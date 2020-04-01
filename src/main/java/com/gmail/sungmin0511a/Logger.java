
package com.gmail.sungmin0511a;

/**
 * Logger
 */
public class Logger {
    public static void log(String str) {
        System.out.println(str);
    }

    public static void log(Object obj) {
        System.out.println(obj.toString());
    }

    public static void sleep(int milliSeconds) {
        synchronized (Connector.getInstance()) {
            try {
                Thread.sleep(milliSeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}