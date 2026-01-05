package me.hackerini.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

public class KillAura {
    public static boolean enabled = true;
    private static final double RANGE = 4.0;

    public static void onTick() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (!enabled || client.player == null || client.world == null) return;

        for (Entity entity : client.world.getEntities()) {
            if (entity instanceof PlayerEntity && entity != client.player) {
                if (client.player.distanceTo(entity) <= RANGE) {
                    // Atakowanie
                    client.interactionManager.attackEntity(client.player, entity);
                    client.player.swingHand(Hand.MAIN_HAND);
                    break; 
                }
            }
        }
    }
}