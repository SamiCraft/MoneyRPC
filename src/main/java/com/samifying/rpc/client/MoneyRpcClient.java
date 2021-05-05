package com.samifying.rpc.client;


import net.arikia.dev.drpc.DiscordRPC;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Environment(EnvType.CLIENT)
public class MoneyRpcClient implements ClientModInitializer {

    public Timer timer = new Timer(MoneyRpcClient.class.getSimpleName());

    @Override
    public void onInitializeClient() {
        try {
            DiscordPresence presence = new DiscordPresence();

            // Creating a callback thread
            new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    DiscordRPC.discordRunCallbacks();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ignored) {
                    }
                }
            }, "DiscordCallbacks").start();

            // Displaying presence
            presence.update();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    presence.stop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }, "DiscordCleanup"));
            timer.schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            try {
                                presence.update();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Date(),
                    5000L
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
