package net.mcreator.veyramod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.veyramod.network.VeyraModModVariables;

public class CrimeMurderProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			var _playerVars = entity.getCapability(VeyraModModVariables.PLAYER_VARIABLES).orElse(null);
			if (_playerVars != null) {
				_playerVars.wantedLevel = 5;
				_playerVars.markSyncDirty();
			}
		}
	}
}