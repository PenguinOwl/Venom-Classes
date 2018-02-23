package me.fairing.kits.listeners;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;

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
					for (ItemStack drp : block.getDrops(event.getPlayer().getInventory().getItemInMainHand())) {
						if (drp.getType() == Material.IRON_ORE) {
							drp.setType(Material.IRON_INGOT);
						}
						if (drp.getType() == Material.GOLD_ORE) {
							drp.setType(Material.GOLD_INGOT);
						}
						if (drp.getType() == Material.GOLD_INGOT || drp.getType() == Material.COAL || drp.getType() == Material.IRON_INGOT || drp.getType() == Material.DIAMOND || drp.getType() == Material.EMERALD) {
							int bonus = (int) (Math.random() * (event.getPlayer().getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) + 2)) - 1;
							if (bonus < 0) {
								bonus = 0;
							}
							drp.setAmount(1+bonus);
						}
						Dye ll = new Dye();
						ll.setColor(DyeColor.BLUE);
						if (drp.getType() == Material.REDSTONE || drp == ll.toItemStack(1)) {
							int bonus = (int) (Math.random() * (event.getPlayer().getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) + 2)) - 1;
							if (bonus < 0) {
								bonus = 0;
							}
							drp.setAmount(3+bonus);
						}
						block.setType(Material.AIR);
						player.getInventory().addItem(drp);
					}
				}
			}
		}

	}
}
