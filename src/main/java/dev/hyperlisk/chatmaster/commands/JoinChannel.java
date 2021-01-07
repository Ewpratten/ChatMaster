package dev.hyperlisk.chatmaster.commands;

import dev.hyperlisk.chatmaster.ChatMaster;
import dev.hyperlisk.chatmaster.channel.Channel;
import dev.hyperlisk.chatmaster.channel.ChannelManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinChannel implements CommandExecutor {

    ChannelManager channelManager = ChatMaster.getInstance().getChannelManager();

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            return false;
        }

        Player player = (Player) commandSender;
        String channelName = strings[0];

        if(player.hasPermission(channelManager.returnChannel(channelName).getPermission())) {
            channelManager.setChannel(player.getUniqueId(), channelManager.returnChannel(channelName));
        } else {
            player.sendMessage("[ChatMaster] To join a channel, you must specify either " +
                    "'dev' or 'staff' and have the correct perms to join that channel");

            return false;

        }
        return true;
    }
}
