package xyz.akiradev.customendspawnpoint;

import org.bukkit.plugin.java.JavaPlugin;

public final class CustomEndSpawnPoint extends JavaPlugin {
    public static CustomEndSpawnPoint plugin;
    ConfigManager configManager;
    @Override
    public void onEnable() {
        plugin = this;
        configManager = new ConfigManager(this);
        getCommand("setendspawn").setExecutor(new CommandSetEndSpawn(configManager));
        getServer().getPluginManager().registerEvents(new PortalListener(configManager), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
