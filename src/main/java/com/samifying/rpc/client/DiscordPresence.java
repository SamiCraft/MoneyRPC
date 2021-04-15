package com.samifying.rpc.client;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class DiscordPresence {

    public static final String APPLICATION_ID = "770681237622095913";
    public static final String SERVER_ADDRESS = "play.samifying.com";

    private final long startedAt;

    public DiscordPresence() throws IOException {
        this.startedAt = System.currentTimeMillis();
        ReadyEvent event = new ReadyEvent();
        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(event).build();
        DiscordRPC.discordInitialize(APPLICATION_ID, handlers, true);
        DiscordRPC.discordRunCallbacks();
    }

    public void update() throws IOException {
        String id = ModData.getInstance().getDiscordId();
        URL url = new URL("http://vps.samifying.com:4567/v1/balance?id=" + id);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        DiscordRichPresence rich = new DiscordRichPresence.Builder(SERVER_ADDRESS)
                .setDetails("Money: $" + in.readLine())
                .setStartTimestamps(startedAt)
                .setBigImage("default", "discord.gg/samifying")
                .build();
        DiscordRPC.discordUpdatePresence(rich);
    }

    public void stop() throws IOException {
        DiscordRPC.discordShutdown();
    }
}
