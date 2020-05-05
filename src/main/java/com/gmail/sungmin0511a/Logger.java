
package com.gmail.sungmin0511a;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Logger
 */
public class Logger {

    private static Logger instance;
    private JFrame frame;
    private JLabel label;
    static{
        instance = new Logger();
    }

    private Logger(){
        label = new JLabel();
        frame = new JFrame();
        frame.setSize(300, 200);
        frame.add(label);
        frame.setVisible(true);
    }

    public static void log(String str) {
        instance.label.setText(str);
        // System.out.println(str);
    }

    public static void log(Object obj) {
        instance.label.setText(obj.toString());
        // System.out.println(obj.toString());
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