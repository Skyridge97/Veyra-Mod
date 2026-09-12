package net.mcreator.veyramod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.veyramod.network.VeyraModModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CmdSetWantedLevelProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		{
			var _playerVars = (commandParameterEntity(arguments, "target")).getCapability(VeyraModModVariables.PLAYER_VARIABLES).orElse(null);
			if (_playerVars != null) {
				_playerVars.wantedLevel = DoubleArgumentType.getDouble(arguments, "level");
				_playerVars.markSyncDirty();
			}
		}
	}

	private static Entity commandParameterEntity(CommandContext<CommandSourceStack> arguments, String parameter) {
		try {
			return EntityArgument.getEntity(arguments, parameter);
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
}