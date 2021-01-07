package dev.hyperlisk.chatmaster.listeners;

import dev.hyperlisk.chatmaster.ChatMaster;
import dev.hyperlisk.chatmaster.channel.Channel;
import dev.hyperlisk.chatmaster.channel.ChannelManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    ChannelManager channelManager = ChatMaster.getInstance().getChannelManager();


    @EventHandler
    public void setDefaultChannel(final PlayerJoinEvent e) {
        if(!(e instanceof Player)) {
            return;
        }

        Player player = (Player) e;

        channelManager.setChannel(player.getUniqueId(), Channel.GLOBAL);

        
    }

}
