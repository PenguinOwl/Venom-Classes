package me.fairing.kits.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.fairing.kits.ClassesPlugin;
import me.fairing.kits.utils.ItemStackBuilder;

public class DiamondKit {

	public static void giveDiamondKit(Player player) {
		ItemStack dsword = new ItemStackBuilder(Material.DIAMOND_SWORD).enchant(Enchantment.DAMAGE_ALL,
				ClassesPlugin.getInstance().getConfig().getInt("MAP_KIT_SHARPNESS_LEVEL"), true).build();
		ItemStack epearl = new ItemStackBuilder(Material.ENDER_PEARL).amount(16).build();
		ItemStack cookedbeef = new ItemStackBuilder(Material.COOKED_BEEF).amount(64).build();
		ItemStack healthp = new ItemStack(Material.POTION, 1, (short) 16421);
		ItemStack speedp = new ItemStack(Material.POTION, 1, (short) 8226);
		ItemStack dhelmet = new ItemStackBuilder(Material.DIAMOND_HELMET)
				.enchant(Enchantment.PROTECTION_ENVIRONMENTAL,
						ClassesPlugin.getInstance().getConfig().getInt("MAP_KIT_PROT_LEVEL"), true)
				.enchant(Enchantment.DURABILITY, ClassesPlugin.getInstance().getConfig().getInt("MAP_KIT_UNBREAKING_LEVEL"), true).build();
		ItemStack dchest = new ItemStackBuilder(Material.DIAMOND_CHESTPLATE)
				.enchant(Enchantment.PROTECTION_ENVIRONMENTAL,
						ClassesPlugin.getInstance().getConfig().getInt("MAP_KIT_PROT_LEVEL"), true)
				.enchant(Enchantment.DURABILITY, ClassesPlugin.getInstance().getConfig().getInt("MAP_KIT_UNBREAKING_LEVEL"), true).build();
		ItemStack dlegs = new ItemStackBuilder(Material.DIAMOND_LEGGINGS)
				.enchant(Enchantment.PROTECTION_ENVIRONMENTAL,
						ClassesPlugin.getInstance().getConfig().getInt("MAP_KIT_PROT_LEVEL"), true)
				.enchant(Enchantment.DURABILITY, ClassesPlugin.getInstance().getConfig().getInt("MAP_KIT_UNBREAKING_LEVEL"), true).build();
		ItemStack dboots = new ItemStackBuilder(Material.DIAMOND_BOOTS)
				.enchant(Enchantment.PROTECTION_ENVIRONMENTAL,
						ClassesPlugin.getInstance().getConfig().getInt("MAP_KIT_PROT_LEVEL"), true)
				.enchant(Enchantment.DURABILITY, ClassesPlugin.getInstance().getConfig().getInt("MAP_KIT_UNBREAKING_LEVEL"), true).build();

		player.getInventory().setHelmet(dhelmet);
		player.getInventory().setChestplate(dchest);
		player.getInventory().setLeggings(dlegs);
		player.getInventory().setBoots(dboots);
		
		player.getInventory().setItem(0, dsword);
		player.getInventory().setItem(1, epearl);
		player.getInventory().setItem(7, cookedbeef);
		player.getInventory().setItem(8, speedp);
		player.getInventory().setItem(35, speedp);
		player.getInventory().setItem(26, speedp);
		player.getInventory().setItem(17, speedp);
		for (int i = 0; i < 35; i++) {
			player.getInventory().addItem(healthp);
		}
	}

}
