package net.mcreator.veyramod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.veyramod.network.VeyraModModVariables;

public class StarCondition4Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getCapability(VeyraModModVariables.PLAYER_VARIABLES).orElseGet(VeyraModModVariables.PlayerVariables::new).wantedLevel >= 4;
	}
}