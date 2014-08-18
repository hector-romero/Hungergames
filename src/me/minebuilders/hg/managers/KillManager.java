package me.minebuilders.hg.managers;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class KillManager {

	public String getDeathString(DamageCause dc, String name) {
		switch (dc) {
		case ENTITY_EXPLOSION: return (name + " Voló en pedazos!");
		case BLOCK_EXPLOSION: return (name + " Voló en pedazos!!");
		case CUSTOM: return (name + " Murio por causas desconocidas!");
		case FALL: return (name + " Se estrello contra el piso!");
		case FALLING_BLOCK: return (name + " Fue aplastado por un bloque!");
		case FIRE: return (name + " Se quemo vivo!");
		case FIRE_TICK: return (name + " Se quemo vivo!");
		case PROJECTILE: return (name + " Fue golpeado por un proyectil!");
		case LAVA: return (name + " Cayo en lava!");
		case MAGIC: return (name + " Fue magicamente destruido!");
		case SUICIDE: return (name + " No pudo soportar los hungergames!");
		default: return (name + " Fue asesinado por " + dc.toString().toLowerCase());
		}
	}

	public String getKillString(String name, Entity e) {
		switch (e.getType()) {
		case PLAYER: return ("&3" + name + " &b&lFue asesinado por &3" + ((Player)e).getName() + " &usando un(a) &3" + ((Player)e).getItemInHand().getType().name().toLowerCase() + "&b!");
		case ZOMBIE: return (name + " Fue deborado por un Zombie!");
		case SKELETON: return (name + " Le disparo un Esqueleto");
		case ARROW: return (name + " Le disparo un Esqueleto");
		case SPIDER: return (name + " Fue atrapado por una Araña!");
		default: return (name + " Repentinamente murio!");
		}
	}
}
