package com.github.pocketkid2.vehicles;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

public class VehicleManager {

	private VehiclesPlugin plugin;

	private List<Vehicle> vehicles;

	private List<Material> allowedBlocks;

	public VehicleManager(VehiclesPlugin vp) {
		plugin = vp;

		// Create a new array and populate it with materials from the config file.
		// We will only allow exact names that match the Spigot API enum.
		allowedBlocks = new ArrayList<Material>();
		for (String id : vp.getDensitiesConfig().getStringList("blocks")) {
			plugin.debug("Reading config value: " + id);
			Material mat = Material.matchMaterial(id);
			if (mat != null) {
				if (mat.isBlock()) {
					allowedBlocks.add(mat);
					plugin.debug("Loaded material " + mat.toString());
				} else {
					plugin.warn("Material " + mat.toString() + " is not a block type!");
				}

			} else {
				plugin.warn("Couldn't load material " + id);
			}

		}
		plugin.log("Vehicle manager loaded " + allowedBlocks.size() + " allowed block types");
	}

}
