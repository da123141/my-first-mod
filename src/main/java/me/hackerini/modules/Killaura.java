package me.hackerini.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

public class Killaura {
    // Robimy to 'static', żeby łatwiej było wywołać w Mixinie
    public static void onTick(MinecraftClient mc) {
        if (mc.player == null || mc.world == null) return;

        mc.world.getPlayers().forEach(target -> {
            if (target != mc.player && target.isAlive()) {
                if (mc.player.distanceTo(target) < 4.5) {
                    mc.interactionManager.attackEntity(mc.player, target);
                    mc.player.swingHand(Hand.MAIN_HAND);
                }
            }
        });
    }
}