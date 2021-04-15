package com.samifying.rpc.client;

import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class ReadyEvent implements ReadyCallback {

    @Override
    public void apply(DiscordUser user) {
        System.out.println("[RPC] Successfully loaded");
    }
}
