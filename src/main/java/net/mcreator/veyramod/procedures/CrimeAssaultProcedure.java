package net.mcreator.veyramod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.veyramod.network.VeyraModModVariables;

public class CrimeAssaultProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getCapability(VeyraModModVariables.PLAYER_VARIABLES).orElseGet(VeyraModModVariables.PlayerVariables::new).wantedLevel < 2) {
			{
				var _playerVars = entity.getCapability(VeyraModModVariables.PLAYER_VARIABLES).orElse(null);
				if (_playerVars != null) {
					_playerVars.wantedLevel = 2;
					_playerVars.markSyncDirty();
				}
			}
		} else if (entity.getCapability(VeyraModModVariables.PLAYER_VARIABLES).orElseGet(VeyraModModVariables.PlayerVariables::new).wantedLevel < 3) {
			{
				var _playerVars = entity.getCapability(VeyraModModVariables.PLAYER_VARIABLES).orElse(null);
				if (_playerVars != null) {
					_playerVars.wantedLevel = 3;
					_playerVars.markSyncDirty();
				}
			}
		}
	}
}