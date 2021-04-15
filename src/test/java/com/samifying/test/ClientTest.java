package com.samifying.test;

import com.samifying.rpc.client.DiscordPresence;
import org.lwjgl.system.CallbackI;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ClientTest {
    public static void main(String[] args) throws IOException {
//        String clientID = "770681237622095913";
//        System.out.println("Application ID: " + clientID);
//
//        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
//            System.out.println("Handler");
//            System.out.println("Connected to discord rpc as " + user.username + ":" + user.discriminator);
//        }).build();
//        DiscordRPC.discordInitialize(clientID, handlers, true);
//        DiscordRPC.discordRegister(clientID, "");
//        DiscordRPC.discordRunCallbacks();
//        DiscordRichPresence rich = new DiscordRichPresence.Builder("play.samifying.com")
//                .setDetails("HideySMP | has 12500")
//                .setStartTimestamps(System.currentTimeMillis())
//                .setBigImage("default", "discord.gg/samifying").build();
//        DiscordRPC.discordUpdatePresence(rich);
//
//
//        System.out.println("To stop this program please type in: stop");
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Scanner scn = new Scanner(System.in);
//                while (true) {
//                    if (scn.nextLine().trim().equalsIgnoreCase("stop")) {
//                        DiscordRPC.discordShutdown();
//                        return;
//                    }
//                }
//            }
//        }, "RuntimeBroker");
//    }
//        DiscordPresence presence = new DiscordPresence("770681237622095913");
//        presence.update("Details");
//        System.out.println(presence.getUserId());
//        boolean running = true;
//        Scanner scn = new Scanner(System.in);
//        while (running) {
//            if (scn.nextLine().trim().equalsIgnoreCase("stop")) {
//                running = false;
//                presence.stop();
//            }
//        }


//        DiscordPresence presence = new DiscordPresence();
//        presence.update();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date().getTime());
            }
        }, new Date(), 10);
        boolean running = true;
        Scanner scn = new Scanner(System.in);
        while (running) {
            if (scn.nextLine().trim().equalsIgnoreCase("stop")) {
                running = false;
                //presence.stop();
            }
        }
    }
}

