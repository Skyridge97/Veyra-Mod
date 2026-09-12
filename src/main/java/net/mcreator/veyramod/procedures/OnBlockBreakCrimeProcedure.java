package net.mcreator.veyramod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.veyramod.network.VeyraModModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnBlockBreakCrimeProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getPlayer());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			entity.getCapability(VeyraModModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
				capability.wantedLevel = entity.getCapability(VeyraModModVariables.PLAYER_VARIABLES).orElseGet(VeyraModModVariables.PlayerVariables::new).wantedLevel + 2;
				capability.markSyncDirty();
			});
		}
	}
}