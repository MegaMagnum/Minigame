package me.megamagnum.main;

import me.megamagnum.main.commands.commandJoin;
import me.megamagnum.main.commands.commandKill;
import me.megamagnum.main.commands.commandSetup;
import me.megamagnum.main.commands.commandTemp;
import me.megamagnum.main.events.HitEvent;
import me.megamagnum.main.events.RespawnEvent;
import me.megamagnum.main.events.DeathEvent;
import me.megamagnum.main.storage.Storage;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Build || Load config / storage
        Storage.setup();
        Storage.get().options().copyDefaults(true);
        Storage.get().getDefaults();
        Storage.save();
        getConfig().options().copyDefaults(true);
        saveConfig();


        // Commands
        getCommand("setup").setExecutor(new commandSetup());
        getCommand("join").setExecutor(new commandJoin());
        getCommand("temp").setExecutor(new commandTemp());
        getCommand("kill").setExecutor(new commandKill());

        // Event handlers
        getServer().getPluginManager().registerEvents(new RespawnEvent(), this);
        getServer().getPluginManager().registerEvents(new DeathEvent(), this);
        getServer().getPluginManager().registerEvents(new HitEvent(), this);

    }

    @Override
    public void onDisable() {

    }
}