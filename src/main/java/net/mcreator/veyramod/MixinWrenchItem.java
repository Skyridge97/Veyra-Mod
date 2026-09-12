package net.mcreator.veyramod.mixin;

import net.mcreator.veyramod.blockentity.MacawPowerNodeBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "com.mrcrayfish.furniture.refurbished.item.WrenchItem")
public class MixinWrenchItem {

    @Inject(method = "useOn", at = @At("HEAD"), cancellable = true)
    private void handleMacawNodeConnection(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        if (level.getBlockEntity(pos) instanceof MacawPowerNodeBlockEntity) {
            // Bypass de la restriction réseau CFM
        }
    }
}