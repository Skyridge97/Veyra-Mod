package net.mcreator.veyramod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.veyramod.network.VeyraModModVariables;

public class CrimeAssaultProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getCapability(VeyraModModVariables.PLAYER_VARIABLES).orElseGet(VeyraModModVariables.PlayerVariables::new).wantedLevel < 2) {
			{
				entity.getCapability(VeyraModModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
					capability.wantedLevel = 2;
					capability.markSyncDirty();
				});
			}
		} else if (entity.getCapability(VeyraModModVariables.PLAYER_VARIABLES).orElseGet(VeyraModModVariables.PlayerVariables::new).wantedLevel < 3) {
			{
				entity.getCapability(VeyraModModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
					capability.wantedLevel = 3;
					capability.markSyncDirty();
				});
			}
		}
	}
}