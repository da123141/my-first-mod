package me.hackerini;

import net.fabricmc.api.ClientModInitializer;

// Zmieniamy na ClientModInitializer, bo tak masz w fabric.mod.json
public class HackeriniMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Ta metoda wywoła się przy starcie Minecrafta
        System.out.println("Hackerini Client załadowany pomyślnie!");
    }
}