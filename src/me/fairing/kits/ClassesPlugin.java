package me.fairing.kits;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import me.fairing.kits.classes.ClassListener;
import me.fairing.kits.commands.KitsCommand;
import me.fairing.kits.friendlyhandler.EmptyFriendlyHandler;
import me.fairing.kits.friendlyhandler.FriendlyHandler;
import me.fairing.kits.listeners.ArcherClassListeners;
import me.fairing.kits.listeners.BardClassListeners;
import me.fairing.kits.listeners.MinerClassListeners;

public class ClassesPlugin extends JavaPlugin {
	
	@Getter
	private static ClassesPlugin instance;
	
	@Getter
	private FriendlyHandler friendlyHandler;
	
	@Override
	public void onEnable() {
		ClassesPlugin.instance = this;
		this.saveConfig();
		this.reloadConfig();
		findFriendlyHandler();
		Bukkit.getPluginManager().registerEvents(new ClassListener(this), this);
		Bukkit.getPluginManager().registerEvents(new ArcherClassListeners(this), this);
		Bukkit.getPluginManager().registerEvents(new BardClassListeners(this), this);
		Bukkit.getPluginManager().registerEvents(new MinerClassListeners(this), this);
		this.getCommand("kits").setExecutor(new KitsCommand(this));
	}
	
	private void findFriendlyHandler() {
		Bukkit.getLogger().info("[Kits] Could not find any friendly handlers!");
		friendlyHandler = new EmptyFriendlyHandler();
	}

}
