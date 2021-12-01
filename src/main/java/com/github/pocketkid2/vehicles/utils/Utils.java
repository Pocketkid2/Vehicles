package com.github.pocketkid2.vehicles.utils;

import org.bukkit.Material;

public class Utils {

	public static Material lookupType(String name) {
		Material mat = Material.getMaterial(name, false);
		if (mat == null) {
			mat = Material.getMaterial(name, true);
		}
		return mat;
	}
}
