package jp.alcoinuser.playertag;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class PlayerTagCommandExecutor implements Listener, CommandExecutor {
    private final PlayerTag plugin;
    public PlayerTagCommandExecutor(PlayerTag ref){
        plugin = ref;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(command.getName().equalsIgnoreCase("pt")){
            if(args.length != 0){
                if(args[0].equalsIgnoreCase("set")){
                    String playernm = args[1];
                    String playernmhead = args[2];
                    commandSender.sendMessage("[PlayerTag]:SetTag User:"+ playernm + " "+ "Tag:"+playernmhead);
                    plugin.getConfig().set(playernm,playernmhead);
                    plugin.saveConfig();
                    plugin.reloadConfig();
                    return true;
                }else if(args[0].equalsIgnoreCase("reload")){
                    plugin.reloadConfig();
                    commandSender.sendMessage("config reloaded");
                    return true;
                }
            }
        }
        return false;
    }
}

