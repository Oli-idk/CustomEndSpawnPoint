package xyz.akiradev.customendspawnpoint;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetEndSpawn implements CommandExecutor {

    ConfigManager configManager;

    public CommandSetEndSpawn(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("customendspawnpoint.set")){
                if(args.length == 1) {
                    configManager.reload();
                    sender.sendMessage("Config reloaded");
                    return true;
                }
                configManager.get().set("spawn", player.getLocation());
                player.sendMessage("You have set the end spawn point");
                configManager.save();
                return true;
            }
        }else{
            sender.sendMessage("You must be a player to use this command");
        }
        
        return false;
    }
}
