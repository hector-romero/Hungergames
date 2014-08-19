package me.minebuilders.hg.tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.minebuilders.hg.Game;
import me.minebuilders.hg.HG;
import me.minebuilders.hg.Util;

public class FreeRoamTask implements Runnable {

	private Game game;
	private int id;

	public FreeRoamTask(Game g) {
		this.game = g;
		for (String s : g.getPlayers()) {
			Player p = Bukkit.getPlayer(s);
			if (p != null) {
				Util.scm(p,"&4[]---------[ &6&lEl juego ha comenzado! &4]---------[]");
				Util.scm(p," &e Tenes " + g.getRoamTime() + " segundos de gracia!");
				p.setHealth(20);
				p.setFoodLevel(20);
				g.unFreeze(p);
			}
		}
		this.id = Bukkit.getScheduler().scheduleSyncDelayedTask(HG.plugin, this, g.getRoamTime() * 20L);
	}

	@Override
	public void run() {
		game.msgAll("&c&lEl tiempo de gracia se acabo, PVP habilitado!");
		game.startGame();
	}

	public void stop() {
		Bukkit.getScheduler().cancelTask(id);
	}
}
