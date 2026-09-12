package net.mcreator.veyramod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.veyramod.network.VeyraModModVariables;

public class WantedLevelTo1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			entity.getCapability(VeyraModModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
				capability.wantedLevel = 1;
				capability.markSyncDirty();
			});
		}
	}
}