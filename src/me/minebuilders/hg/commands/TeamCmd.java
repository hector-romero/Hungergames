package me.minebuilders.hg.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.minebuilders.hg.Config;
import me.minebuilders.hg.Game;
import me.minebuilders.hg.HG;
import me.minebuilders.hg.PlayerData;
import me.minebuilders.hg.Team;
import me.minebuilders.hg.Util;

public class TeamCmd extends BaseCmd {

	public TeamCmd() {
		forcePlayer = true;
		cmdName = "team";
		forceInGame = true;
		argLength = 2;
		usage = "<&cinvite&b/&caccept&b>";
	}

	@Override
	public boolean run() {
		PlayerData pd = HG.plugin.players.get(player.getName());
		Game g = pd.getGame();

		if (args[1].equalsIgnoreCase("invite")) {

			if (args.length >= 3) {

				Player p = Bukkit.getPlayer(args[2]);

				if (p == null || !g.getPlayers().contains(p.getName())) {
					Util.msg(player, "&c" + args[2] + " No esta disponible!");
					return true;
				}

				if (pd.getTeam() != null) {

					Team t = pd.getTeam();

					if (!t.getLeader().equalsIgnoreCase(player.getName())) {
						Util.msg(player, "&cSolamente el lider puede invitar otros jugadores!");
						return true;
					}
					if (t.isOnTeam(p.getName())) {
						Util.msg(player, "&c" + args[2] + " &3ya esta en un equipo!");
						return true;
					}

					if ((t.getPlayers().size() + t.getPenders().size()) >= Config.maxTeam) {
						Util.msg(player, "&cYa has alcanzado el limite de invitaciones!");
						return true;
					}

					HG.plugin.players.get(p.getName()).setTeam(t);
					t.invite(p);
					Util.msg(player, "&c" + p.getName() + " &3Ha sido invitado!");
					return true;
				}

				if (HG.plugin.players.get(p.getName()).isOnTeam(p.getName())) {
					Util.msg(player, "&c" + args[2] + " &3ya esta en un equipo!");
					return true;
				}

				Team t = new Team(player.getName());
				HG.plugin.players.get(p.getName()).setTeam(t);
				pd.setTeam(t);
				t.invite(p);
				Util.msg(player, "&c" + p.getName() + " &3Ha sido invitado!");
				return true;
			} else {
				Util.msg(player, "&cUso: &3/hg &bteam invite <&cnombre&b>");
			}
		} else if (args[1].equalsIgnoreCase("accept")) {

			Team t = HG.plugin.players.get(player.getName()).getTeam();

			if (t == null) {
				Util.msg(player, "&cNo tienes invitaciones pendientes...");
				return true;
			}
			if (t.getPenders().contains(player.getName())) {

				t.acceptInvite(player);
				for (String s : t.getPlayers()) {
					Player p = Bukkit.getPlayer(s);

					if (p != null) {
						Util.scm(p, "&6*&b&m                                                                             &6*");
						Util.scm(p, ChatColor.WHITE + player.getName() + " &3Se ha unido a tu equipo!");
						Util.scm(p, "&6*&b&m                                                                             &6*");
					}
					return true;
				}

				return true;
			}
		} else {
			Util.scm(player, "&c" + args[1] + " no es una opcion valida!");
			Util.scm(player, "&cOpciones validas: &6invite&c, &6accept ");
		}
		return true;
	}
}