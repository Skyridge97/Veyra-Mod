package net.mcreator.veyramod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.veyramod.network.VeyraModModVariables;

public class AddWantedLevelProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			var _playerVars = entity.getCapability(VeyraModModVariables.PLAYER_VARIABLES).orElse(null);
			if (_playerVars != null) {
				_playerVars.wantedLevel = Mth.nextDouble(RandomSource.create(), 0, 6);
				_playerVars.markSyncDirty();
			}
		}
	}
}