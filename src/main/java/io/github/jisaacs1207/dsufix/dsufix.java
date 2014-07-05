package io.github.jisaacs1207.dsufix;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public final class dsufix extends JavaPlugin implements Listener{
	@Override
	public void onEnable() {
		getLogger().info("5K DSU fix is enabled.");
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		getLogger().info("5K DSU fix is disabled.");
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onBlockBreak(BlockBreakEvent event) {
		if(event.getBlock().getTypeId()==3131){
			for(Player player : event.getBlock().getWorld().getPlayers()){
				double playerLoc = player.getEyeLocation().distance(event.getBlock().getLocation());
				if (playerLoc < 50){
					player.closeInventory();
				}
			}
		}
	}

}

