package com.samifying.rpc.client;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class DiscordPresence implements ReadyCallback {

    public static final String APPLICATION_ID = "770681237622095913";
    public static final String SERVER_ADDRESS = "play.samifying.com";

    private final long startedAt;
    private String id;

    public DiscordPresence() throws IOException {
        this.startedAt = System.currentTimeMillis();
        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(this).build();
        DiscordRPC.discordInitialize(APPLICATION_ID, handlers, true);
        DiscordRPC.discordRunCallbacks();
    }

    public void update() throws IOException {
        if (id != null) {
            URL url = new URL("http://api.samifying.com:8010/v1/balance?id=" + id);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            DiscordRPC.discordUpdatePresence(new DiscordRichPresence.Builder(SERVER_ADDRESS)
                    .setDetails("Money: " + in.readLine())
                    .setStartTimestamps(startedAt)
                    .setBigImage("default", "discord.gg/samifying")
                    .build());
            in.close();
            return;
        }

        // This is run until we retrieve the user id
        DiscordRPC.discordUpdatePresence(new DiscordRichPresence.Builder("Loading data")
                .setBigImage("creeper", "Fabric Mod Loader")
                .setStartTimestamps(startedAt)
                .build());
    }

    public void stop() throws IOException {
        DiscordRPC.discordClearPresence();
        DiscordRPC.discordShutdown();
    }

    @Override
    public void apply(DiscordUser user) {
        System.out.println("Discord RPC Loaded");
        this.id = user.userId;
    }
}
