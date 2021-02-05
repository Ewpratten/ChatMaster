package dev.hyperlisk.chatmaster.commands;

import dev.hyperlisk.chatmaster.ChatMaster;
import dev.hyperlisk.chatmaster.ReferenceStrings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetColour implements CommandExecutor {

    private ChatMaster instance = ChatMaster.getInstance();


    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            return false;
        }

        Player player = (Player) commandSender;
        if(instance.getConfig().get("chatmaster.supporters").equals(player.getUniqueId())) {



        } else {
            player.sendMessage(ReferenceStrings.logHeader + "Contact an admin to receive supporter status.");
        }

        return true;
    }

}
