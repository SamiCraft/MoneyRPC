package com.samifying.rpc.client;

import java.io.*;
import java.util.Properties;

public class ModData {

    private static ModData instance = null;

    private final String discordId;

    private ModData(String discordId) {
        this.discordId = discordId;
    }

    public static ModData getInstance() throws IOException {
        if (instance == null) {
            //Reading configuration from file
            File config = new File("moneyrpc.properties");
            Properties prop = new Properties();
            if (!config.exists()) {
                try (OutputStream output = new FileOutputStream(config)) {
                    prop.setProperty("discord.id", "358236836113547265");
                    prop.store(output, "Change the discord id to your user id, the current one set is Pequla's ID");
                }
            }
            try (InputStream input = new FileInputStream(config)) {
                prop.load(input);
                instance = new ModData(prop.getProperty("discord.id"));
            }
        }
        return instance;
    }

    public String getDiscordId() {
        return discordId;
    }
}
