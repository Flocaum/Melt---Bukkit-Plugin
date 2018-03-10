package me.flocaum.derreter;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getConsoleSender().sendMessage("§a[Melt] Started successfully! Author: Flocaum");
		getCommand("melt").setExecutor(this);
	}

	public void derreter(Player player) {
		try {
			for (ItemStack item : player.getInventory().getContents()) {
				if (item != null && item.getType().equals(Material.IRON_ORE)) {
					item.setType(Material.IRON_INGOT);
				}
				if (item != null && item.getType().equals(Material.GOLD_ORE)) {
					item.setType(Material.GOLD_INGOT);
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("melt")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				derreter(player);
				player.sendMessage("§aYou used the command to melt.");
				return true;
			} else {
				sender.sendMessage("§cPlayer Command!");
				return true;
			}
		}
		return false;
	}

}
