package com.github.pocketkid2.vehicles;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class VehicleCommand implements CommandExecutor {

	private VehiclesPlugin plugin;

	public VehicleCommand(VehiclesPlugin p) {
		plugin = p;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
		return false;
	}

}
