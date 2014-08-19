package me.minebuilders.hg.commands;

import me.minebuilders.hg.Config;
import me.minebuilders.hg.HG;
import me.minebuilders.hg.Util;

public class SaveCmd extends BaseCmd {

	public SaveCmd() {
		forcePlayer = true;
		cmdName = "save";
		argLength = 1;
		forceInRegion = false;
	}

	@Override
	public boolean run() {
		Util.msg(player, "&l&aSaving Arenas config!");
		HG.arenaconfig.saveCustomConfig();

		Util.msg(player, "&l&a- Successfully saved arenas config-");
		return true;
	}
}
