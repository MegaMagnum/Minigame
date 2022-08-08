package me.megamagnum.main;

import me.megamagnum.main.commands.commandJoin;
import me.megamagnum.main.commands.commandSetup;
import me.megamagnum.main.storage.Storage;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Build || Load config / storage
        Storage.setup();
        Storage.get().options().copyDefaults(true);
        Storage.save();
        getConfig().options().copyDefaults(true);
        saveConfig();

        // Commands
        getCommand("setup").setExecutor(new commandSetup());
        getCommand("join").setExecutor(new commandJoin());

        // Event handlers


    }

    @Override
    public void onDisable() {

    }
}
