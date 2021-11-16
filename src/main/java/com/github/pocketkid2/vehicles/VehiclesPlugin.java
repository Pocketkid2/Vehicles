package com.github.pocketkid2.vehicles;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.pocketkid2.vehicles.commands.CraftBaseCommand;
import com.github.pocketkid2.vehicles.commands.VehicleBaseCommand;

public class VehiclesPlugin extends JavaPlugin {

	// Density config fields
	private File densitiesFile;
	private FileConfiguration densitiesConfig;

	@Override
	public void onEnable() {

		// Create config.yml if it doesn't exist, and load it
		saveDefaultConfig();

		// Create densities.yml if it doesn't exist, and load it
		createDensitiesConfig();

		// Register command executors
		getCommand("vehicle").setExecutor(new VehicleBaseCommand(this));
		getCommand("craft").setExecutor(new CraftBaseCommand(this));

		// Tell the console we've finished enabling the plugin
		getLogger().info("Enabled!");
	}

	@Override
	public void onDisable() {
		getLogger().info("Disabled!");
	}

	//
	// This method simply returns the configuration class instance so that other
	// classes in this plugin can have access to it. This could potentially also be
	// used for an API.
	//
	public FileConfiguration getDensitiesConfig() {
		return densitiesConfig;
	}

	//
	// This method creates the density config file if it doesn't exist, and loads
	// the configuration into memory if it does
	//
	public void createDensitiesConfig() {

		// First create the path
		densitiesFile = new File(getDataFolder(), "densities.yml");

		// If the file hasn't been created yet, do so
		if (!densitiesFile.exists()) {

			// Make sure the folder exists (possibly redundant?) and write the file
			densitiesFile.getParentFile().mkdirs();
			saveResource("densities.yml", false);
		}

		// Create a new configuration class for YAML files
		densitiesConfig = new YamlConfiguration();

		// Read it, and if an error, print to console so we can debug
		try {
			densitiesConfig.load(densitiesFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
