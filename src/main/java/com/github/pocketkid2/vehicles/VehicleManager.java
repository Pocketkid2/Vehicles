package com.github.pocketkid2.vehicles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Material;

public class VehicleManager {

	private VehiclesPlugin plugin;

	private List<Vehicle> vehicles;

	private List<Material> allowedBlocks;

	public VehicleManager(VehiclesPlugin vp) {
		plugin = vp;
		allowedBlocks = new ArrayList<Material>();
		for (String id : vp.getDensitiesConfig().getStringList("blocks")) {
			// plugin.getLogger().info("Reading config value: " + id);
			allowedBlocks.addAll(Arrays.stream(Material.values()).filter(s -> s.toString().contains(id)).collect(Collectors.toList()));
		}
		// allowedBlocks =
		// vp.getDensitiesConfig().getStringList("blocks").stream().map(Material.values).collect(Collectors.toList());
		plugin.getLogger().info("Vehicle manager loaded " + allowedBlocks.size() + " allowed block types");
	}

}
