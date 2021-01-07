package dev.hyperlisk.chatmaster.commands;

import dev.hyperlisk.chatmaster.ChatMaster;
import dev.hyperlisk.chatmaster.channel.ChannelManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LeaveChannel implements CommandExecutor {

    ChannelManager channelManager = ChatMaster.getInstance().getChannelManager();

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            return false;
        }

        Player player = (Player) commandSender;

        String channelName = strings[0];



        return true;

    }
}
