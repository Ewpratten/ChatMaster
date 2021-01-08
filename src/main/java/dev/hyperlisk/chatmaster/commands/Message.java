package dev.hyperlisk.chatmaster.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Message implements CommandExecutor {


    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            return false;
        }

        Player sender = (Player) commandSender;
        String recieverName = strings[0];
        String message = "";

        if(Bukkit.getPlayerExact(recieverName) == null) {
            sender.sendMessage("Player: " + recieverName + " is not online.");
        } else {
            Player reciever = Bukkit.getPlayer(recieverName);
            for(int i = 1; i != strings.length; i++) {
                message += strings[i]+" ";
            }
            reciever.sendMessage(message);
        }



        return true;
    }
}
