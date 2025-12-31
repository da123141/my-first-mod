package me.hackerini.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

public class Killaura {
    public void onTick(MinecraftClient mc) {
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