package com.github.pocketkid2.vehicles;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.pocketkid2.vehicles.commands.CraftBaseCommand;
import com.github.pocketkid2.vehicles.commands.VehicleBaseCommand;

public class VehiclesPlugin extends JavaPlugin {

	private boolean debug;

	// Density config fields
	private File densitiesFile;
	private FileConfiguration densitiesConfig;

	// Managers
	private VehicleManager vm;

	@Override
	public void onEnable() {

		// Create config.yml if it doesn't exist, and load it
		saveDefaultConfig();

		debug = getConfig().getBoolean("debug", false);

		// Create densities.yml if it doesn't exist, and load it
		createDensitiesConfig();

		// Register command executors
		getCommand("vehicle").setExecutor(new VehicleBaseCommand(this));
		getCommand("craft").setExecutor(new CraftBaseCommand(this));

		// Set up the manager
		vm = new VehicleManager(this);

		// Tell the console we've finished enabling the plugin
		log("Enabled!");
	}

	@Override
	public void onDisable() {
		log("Disabled!");
	}

	// Send a debug message to the console, if debug messages are enabled in the
	// config
	public void debug(String message) {
		if (debug) {
			getLogger().info("[Debug] " + message);
		}
	}

	// Log an informational message to the console
	public void log(String message) {
		getLogger().info(message);
	}

	// Log a warning message to the console
	public void warn(String message) {
		getLogger().warning(message);
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
