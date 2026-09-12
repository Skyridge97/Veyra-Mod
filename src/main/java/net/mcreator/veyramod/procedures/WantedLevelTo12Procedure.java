package net.mcreator.veyramod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.veyramod.network.VeyraModModVariables;

public class WantedLevelTo12Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			entity.getCapability(VeyraModModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
				capability.wantedLevel = Mth.nextInt(RandomSource.create(), 1, 2);
				capability.markSyncDirty();
			});
		}
	}
}