package me.hackerini.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

public class Killaura {
    
    public static void onTick(MinecraftClient mc) {
        // Zabezpieczenie: nie rób nic, jeśli gra się jeszcze ładuje
        if (mc.player == null || mc.world == null) return;

        // Szukamy graczy w świecie
        for (Entity entity : mc.world.getEntities()) {
            if (entity instanceof PlayerEntity target && target != mc.player) {
                // Jeśli gracz jest bliżej niż 4.5 bloku i żyje
                if (mc.player.distanceTo(target) < 4.5 && target.isAlive()) {
                    // Atakujemy!
                    mc.interactionManager.attackEntity(mc.player, target);
                    mc.player.swingHand(Hand.MAIN_HAND);
                    break; // Atakujemy jednego na tick, żeby nie wywaliło za spam
                }
            }
        }
    }
}