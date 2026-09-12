package net.mcreator.veyramod.registry;

import net.mcreator.veyramod.blockentity.MacawPowerNodeBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = 
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "veyra_mod");

    public static final RegistryObject<BlockEntityType<MacawPowerNodeBlockEntity>> MACAW_POWER_NODE =
        BLOCK_ENTITIES.register("macaw_power_node", () ->
            BlockEntityType.Builder.of(MacawPowerNodeBlockEntity::new).build(null)
        );
}