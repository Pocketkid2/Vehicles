package com.github.pocketkid2.vehicles.commands;

import java.util.List;

public abstract class SubCommand {

	private List<String> aliases;

	private int minArgs;

	private int maxArgs;

	// Inheritors of this class should call super with whatever values are
	// appropriate
	public SubCommand(List<String> a, int min, int max) {
		aliases = a;
		minArgs = min;
		maxArgs = max;
	}

	// This method is called by the base command to execute the command function
	public abstract void execute(List<String> args);
}
