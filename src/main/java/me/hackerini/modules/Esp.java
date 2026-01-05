package me.hackerini.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

public class Esp {
    public static void onRender(MatrixStack matrices) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.world == null || mc.player == null) return;

        // Pobieramy pozycję kamery, żeby boxy nie "pływały"
        Vec3d cameraPos = mc.gameRenderer.getCamera().getPos();

        for (PlayerEntity player : mc.world.getPlayers()) {
            if (player == mc.player || !player.isAlive()) continue;

            // Obliczamy pozycję gracza względem kamery
            Box box = player.getBoundingBox().offset(-cameraPos.x, -cameraPos.y, -cameraPos.z);
            
            // Tutaj wywołujemy rysowanie (uproszczone dla 1.21)
            drawBox(matrices, box);
        }
    }

    private static void drawBox(MatrixStack matrices, Box box) {
        // Logika rysowania linii przy użyciu DebugRenderer lub VertexConsumer
        // W 1.21.4 najbezpieczniej użyć WorldRenderer.drawBox
    }
}