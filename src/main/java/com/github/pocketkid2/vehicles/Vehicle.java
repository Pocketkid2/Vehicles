package com.github.pocketkid2.vehicles;

import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Vehicle {

	private double density;

	private List<Block> blocks;

	private Player pilot;

	public Vehicle(Player p, List<Block> b) {
		pilot = p;
		blocks = b;
	}

}
