package jp.alcoinuser.playertag;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerTag extends JavaPlugin implements Listener {
    public void onEnable(){
        super.onEnable();
        getConfig().getString("NotExists","");
        getServer().getPluginManager().registerEvents(this,this);
        getCommand("pt").setExecutor(new PlayerTagCommandExecutor(this));
        this.saveDefaultConfig();
    }
    @Override
    public void onDisable(){
        super.onDisable();
    }
    @Override
    public void onLoad(){ super.onLoad(); }

    @EventHandler
    public void onPlayerLogin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        String playernm = player.getDisplayName();
        String playernmhead = getConfig().getString(playernm,"");

        playernmhead = ChatColor.translateAlternateColorCodes('&',playernmhead);
        player.setPlayerListName(playernmhead+" "+ ChatColor.WHITE + playernm);
    }
}
