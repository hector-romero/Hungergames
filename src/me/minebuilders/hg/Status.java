package me.minebuilders.hg;


import org.bukkit.ChatColor;

public enum Status {
	RUNNING(ChatColor.GREEN  + "" + ChatColor.BOLD +  "Jugando"), STOPPED(ChatColor.DARK_RED  + "" + ChatColor.BOLD +  "Detenido"),
	WAITING(ChatColor.AQUA  + "" + ChatColor.BOLD +  "Listo..."), BROKEN(ChatColor.DARK_RED  + "" + ChatColor.BOLD +  "ROTO"),
	ROLLBACK(ChatColor.RED  + "" + ChatColor.BOLD +  "Restaurando..."), NOTREADY(ChatColor.DARK_BLUE  + "" + ChatColor.BOLD +  "No Listo"),
	BEGINNING(ChatColor.GREEN  + "" + ChatColor.BOLD +  "Jugando"), COUNTDOWN(ChatColor.AQUA  + "" + ChatColor.BOLD +  "Comenzando...");

	private String name;

	Status(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
