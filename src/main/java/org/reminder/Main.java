package org.reminder;



import org.reminder.environment.Environment;
import org.reminder.misc.RemindTray;
import org.reminder.misc.TrayNotification;


import javax.swing.*;

public class Main {
    public static void check(Environment env){
        TrayNotification tray = new TrayNotification();

        while(Thread.activeCount()>0){
            for(int i=0;i<env.manager.getNotifications().size();i++){
                if(env.manager.getNotifications().get(i).checkTime()){
                    String title=env.manager.getNotifications().get(i).getTitle();
                    String message=env.manager.getNotifications().get(i).getMessage();
                    tray.setNotificationText(message);
                    tray.setNotificationTitle(title);
                    tray.Display();

                }
            }
        }
    }
    public static void main(String[] args){

        JFrame frame = new JFrame();
        Environment env = new Environment(frame);
        env.Setup();
        RemindTray tray=new RemindTray("/images/icon.png",env);
        tray.showTray();


        check(env);
    }

}