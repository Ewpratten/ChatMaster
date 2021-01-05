package dev.hyperlisk.chatmaster;

import dev.hyperlisk.chatmaster.channel.ChannelManager;
import dev.hyperlisk.chatmaster.database.DatabaseManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatMaster extends JavaPlugin {

    private static ChatMaster instance;
    private ChannelManager channelManager;
    private DatabaseManager databaseManager;
    FileConfiguration config = this.getConfig();

    public void onEnable() {

        this.channelManager = new ChannelManager();

    }

    public void onDisable() {

    }

    public ChannelManager getChannelManager() {
        return channelManager;
    }

    public static ChatMaster getInstance() {
        if(instance == null) {
            instance = new ChatMaster();
        }
        return instance;
    }


}
