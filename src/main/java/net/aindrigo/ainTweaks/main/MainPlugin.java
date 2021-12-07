package net.aindrigo.ainTweaks.main;

import net.aindrigo.ainTweaks.commands.GetItem;
import net.aindrigo.ainTweaks.events.AinListener;
import net.aindrigo.ainTweaks.itemVariants.ButteredBread;
import net.aindrigo.ainTweaks.itemVariants.RatPoop;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.logging.Logger;

public class MainPlugin extends JavaPlugin {
    public static JavaPlugin plugin;
    public Logger logger;
    public static ButteredBread bread = new ButteredBread();
    public CommandMap commandMap;
    public static RatPoop ratPoop = new RatPoop();
    @Override
    public void onEnable() {
        super.onEnable();
        plugin = this;
        logger = getLogger();
        logger.info("Enabled");
        this.getServer().getPluginManager().registerEvents(new AinListener(), this);
        commandMap = getMap();

        commandMap.register("ainTweaks", new GetItem());
    }

    @Override
    public void onDisable() {
        super.onDisable();
        logger.info("Disabled");
        plugin = null;
    }

    private CommandMap getMap(){
        CommandMap map = null;
        try{
            final Field commandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

            commandMap.setAccessible(true);
            map = (CommandMap) commandMap.get(Bukkit.getServer());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
