package net.mcreator.veyramod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import com.tacz.guns.api.event.common.GunFireEvent;

@Mod.EventBusSubscriber
public class CrimeEventHandler {

    @SubscribeEvent
    public static void onGunFire(GunFireEvent event) {
        Entity shooter = event.getShooter();
        if (shooter instanceof Player player && !player.level().isClientSide()) {
            CrimeFireWeaponProcedure.execute(player);
        }
    }

    @SubscribeEvent
    public static void onEntityDamage(LivingDamageEvent event) {
        DamageSource source = event.getSource();
        Entity attacker = source.getEntity();
        Entity victim = event.getEntity();

        if (attacker instanceof Player player && !player.level().isClientSide()) {
            if (victim instanceof Player) {
                CrimeAssaultProcedure.execute(player);
            }
        }
    }

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        DamageSource source = event.getSource();
        Entity attacker = source.getEntity();
        Entity victim = event.getEntity();

        if (attacker instanceof Player player && !player.level().isClientSide()) {
            if (victim instanceof Player) {
                CrimeMurderProcedure.execute(player);
            }
        }
    }
}