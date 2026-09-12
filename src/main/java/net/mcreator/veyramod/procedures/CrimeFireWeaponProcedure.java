package net.mcreator.veyramod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.veyramod.network.VeyraModModVariables;

public class CrimeFireWeaponProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getCapability(VeyraModModVariables.PLAYER_VARIABLES).orElseGet(VeyraModModVariables.PlayerVariables::new).wantedLevel < 1) {
			{
				entity.getCapability(VeyraModModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
					capability.wantedLevel = 1;
					capability.markSyncDirty();
				});
			}
		}
	}
}