package me.minebuilders.hg;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class Team {

	private String leader;
	private List<String> players = new ArrayList<String>();
	private List<String> pending = new ArrayList<String>();
	
	public Team(String leader) {
		this.leader = leader;
		players.add(leader);
	}
	
	
	public void invite(Player p) {
		Util.scm(p, "&6*&b&m                                                                             &6*");
		Util.scm(p, "| &f" + leader + " &3Te ha invitado a su &fEquipo&3!");
		Util.scm(p, "| &3Escribe &f/hg team accept &3para unirte!");
		Util.scm(p, "&6*&b&m                                                                             &6*");
		pending.add(p.getName());
	}
	
	public void acceptInvite(Player p) {
		pending.remove(p.getName());
		players.add(p.getName());
		Util.msg(p, "&3Te has unido al equipo!");
	}
	
	public boolean isOnTeam(String p) {
		return (players.contains(p));
	}
	
	public boolean isPending(String p) {
		return (pending.contains(p));
	}
	
	public List<String> getPlayers() {
		return players;
	}
	
	public List<String> getPenders() {
		return pending;
	}
	
	public String getLeader() {
		return leader;
	}
}
