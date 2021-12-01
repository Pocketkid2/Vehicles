package com.github.pocketkid2.vehicles;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Material;

import com.github.pocketkid2.vehicles.utils.Utils;

public class VehicleManager {

	private VehiclesPlugin plugin;

	private List<Vehicle> vehicles;

	private List<Material> allowedBlocks;

	public VehicleManager(VehiclesPlugin vp) {
		plugin = vp;
		allowedBlocks = vp.getDensitiesConfig().getStringList("blocks").stream().map(Utils::lookupType).collect(Collectors.toList());
		plugin.getLogger().info("Vehicle manager loaded " + allowedBlocks.size() + " allowed block types");
	}

}
