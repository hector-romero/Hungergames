package me.minebuilders.hg.commands;

import me.minebuilders.hg.Game;
import me.minebuilders.hg.HG;
import me.minebuilders.hg.Util;

public class JoinCmd extends BaseCmd {

	public JoinCmd() {
		forcePlayer = true;
		cmdName = "join";
		forceInGame = false;
		argLength = 2;
		usage = "<&carena&b>";
	}

	@Override
	public boolean run() {

		if (HG.plugin.players.containsKey(player.getName())) {
			Util.msg(player, "&cYa estas en un juego!");
		} else {
			Game g = HG.manager.getGame(args[1]);
			if (g != null && !g.getPlayers().contains(player.getName())) {
				g.join(player);
			} else {
				Util.msg(player, "&cEsa arena no existe!");
			}
		}
		return true;
	}
}