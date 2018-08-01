package com.example.root.imageview;

/**
 * Created by root on 30/6/18.
 */

public class con {
    private static boolean isNotification_enabled;
    public static String notificationTitle = "";
    private static String notificationBody = "";
    public static String body = "";
    public static String title = "";
    public static String empty_Notification = "empty";

    public static boolean isIsNotification_enabled() {
        return isNotification_enabled;
    }

    public static void setIsNotification_enabled(boolean isNotification_enabled) {
        con.isNotification_enabled = isNotification_enabled;
    }

    public static String getNotificationTitle() {
        return notificationTitle;
    }

    public static void setNotificationTitle(String notificationTitle) {
        con.notificationTitle = notificationTitle;
    }

    public static String getNotificationBody() {
        return notificationBody;
    }

    public static void setNotificationBody(String notificationBody) {
        con.notificationBody = notificationBody;
    }
}
