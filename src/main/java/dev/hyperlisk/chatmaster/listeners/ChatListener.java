package dev.hyperlisk.chatmaster.listeners;

import dev.hyperlisk.chatmaster.ChatMaster;
import dev.hyperlisk.chatmaster.channel.Channel;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private ChatMaster plugin = ChatMaster.getInstance();

    @EventHandler
    public void onPlayerChatEvent(final AsyncPlayerChatEvent event) {
        event.setCancelled(true);

        if(!(event.getPlayer() instanceof Player)) {
            return;
        }
        Player player = event.getPlayer();

        Channel channel = plugin.getChannelManager().getChannel(player.getUniqueId());
        String format = channel.getFormat();

        if(player.hasPermission("chatmaster.supporter")) {
            player.setDisplayName(ChatMaster.getInstance().getConfig().get("chatmaster.supporter.colour") + player.getDisplayName());
        }

        format = format.replace("{NAME}", player.getDisplayName())
                .replace("{MESSAGE}", event.getMessage());

        for (Player p : Bukkit.getOnlinePlayers()) {
            if(p.hasPermission(channel.getPermission())) {
                p.sendMessage(format);
            }
        }
    }



}
