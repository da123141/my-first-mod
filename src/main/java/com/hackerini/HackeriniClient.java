package me.hackerini;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import me.hackerini.modules.Killaura;

public class HackeriniMod implements ModInitializer {
    public static final Killaura killaura = new Killaura();

    @Override
    public void onInitialize() {
        // Rejestrujemy tick, aby Killaura działała co klatkę
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                killaura.onTick(client);
            }
        });
    }
}