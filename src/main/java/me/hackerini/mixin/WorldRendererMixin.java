package me.hackerini.mixin;

import me.hackerini.modules.Esp;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.joml.Matrix4f;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {
    
    @Inject(at = @At("RETURN"), method = "render")
    private void onRender(
        RenderTickCounter tickCounter, 
        boolean renderBlockOutline, 
        Camera camera, 
        GameRenderer gameRenderer, 
        LightmapTextureManager lightmapTextureManager, 
        Matrix4f matrix4f, 
        Matrix4f matrix4f2, 
        CallbackInfo info
    ) {
        // Tworzymy MatrixStack i wywołujemy ESP
        MatrixStack matrices = new MatrixStack();
        Esp.onRender(matrices);
    }
}