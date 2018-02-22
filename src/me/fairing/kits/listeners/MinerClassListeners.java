package me.fairing.kits.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import com.google.common.collect.Iterables;

import me.fairing.kits.ClassesPlugin;

public class MinerClassListeners implements Listener {
	@SuppressWarnings("unused")
	private final ClassesPlugin plugin;

	public MinerClassListeners(ClassesPlugin plugin) {
		this.plugin = plugin;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void mineBlock(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if(event.getPlayer().getInventory().getItemInMainHand() != null && event.getPlayer().getInventory().getItemInMainHand().getType() == Material.DIAMOND_PICKAXE) {
			int status = 0;
			for (ItemStack item : player.getInventory().getArmorContents()) {
				if (item != null && item.getType().name().startsWith("IRON")) status += 1;
			}
			if (status == 4) {
				event.setCancelled(true);
				Block block = event.getBlock();
				if (block.getDrops(event.getPlayer().getInventory().getItemInMainHand()).size()>=1) {
					for (int x=0;x < block.getDrops(event.getPlayer().getInventory().getItemInMainHand()).size(); x++) {
					ItemStack drp = Iterables.get(block.getDrops(event.getPlayer().getInventory().getItemInMainHand()),x);
					if (drp.getType() == Material.IRON_ORE) {
						drp.setType(Material.IRON_INGOT);
					}
					if (drp.getType() == Material.GOLD_ORE) {
						drp.setType(Material.GOLD_INGOT);
					}
					block.setType(Material.AIR);
					player.getInventory().addItem(drp);
				}
				}
			}
		}

	}
}
