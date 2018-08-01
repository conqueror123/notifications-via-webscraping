package com.example.root.imageview;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import static com.example.root.imageview.con.body;

/**
 * Created by root on 30/6/18.
 */

class webB {
    public static void scrape(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = Jsoup.connect("http://192.168.43.38/balk.html").get();
                    //here you can change it to the website html page that you want
                    con.title = doc.title();
                    con.body = doc.body().text();
                    decide(con.title,con.body);
                } catch (IOException e) {

                }

            }
        }).start();
    }

    private static void decide(String title, String body) {
        if (title.equals(con.getNotificationTitle())){
            con.setIsNotification_enabled(false);
        }
        else {
            con.setNotificationTitle(title);
            con.setNotificationBody(body);
            con.setIsNotification_enabled(true);
        }
    }
}
