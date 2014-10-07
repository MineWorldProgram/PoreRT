package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Monster;

public class PoreMonster extends PoreCreature implements Monster {

	//TODO: make constructor as specific as possible
	protected PoreMonster(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreMonster of(org.spongepowered.api.entity.Entity handle){
		return (PoreMonster)PoreCreature.of(handle);
	}

}
