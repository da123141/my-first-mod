// W pakiecie me.hackerini.mixin
@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(at = @At("HEAD"), method = "tick")
    private void onTick(CallbackInfo info) {
        KillAura.onTick();
    }
}