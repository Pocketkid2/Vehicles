package com.github.pocketkid2.vehicles;

import org.bukkit.plugin.java.JavaPlugin;

public class VehiclesPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info("Enabled!");
	}

	@Override
	public void onDisable() {
		getLogger().info("Disabled!");
	}
}
