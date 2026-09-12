package net.mcreator.veyramod.mixin;

import net.mcreator.veyramod.blockentity.MacawPowerNodeBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;

@Pseudo
@Mixin(targets = "com.mcwlights.kawaee.blocks.LampBlock")
public abstract class MixinMacawLampBlock extends Block implements EntityBlock {

    public MixinMacawLampBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MacawPowerNodeBlockEntity(pos, state);
    }
}