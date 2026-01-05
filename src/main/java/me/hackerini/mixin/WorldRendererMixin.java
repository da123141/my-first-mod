package me.hackerini.mixin;

import me.hackerini.modules.Esp;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.RenderLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.joml.Matrix4f;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {
    
    @Inject(at = @At("RETURN"), method = "render")
    private void onRender(RenderTickCounter tickCounter, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightmapTextureManager lightmapTextureManager, Matrix4f matrix4f, Matrix4f matrix4f2, CallbackInfo info) {
        // Wywołujemy nasze ESP na samym końcu renderowania świata
        // MatrixStack matrices = new MatrixStack(); // W nowszych wersjach trzeba uważać na stos macierzy
        Esp.onRender(new MatrixStack());
    }
}