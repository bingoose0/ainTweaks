package net.aindrigo.ainTweaks.main;

import net.aindrigo.ainTweaks.commands.AinCommand;
import net.aindrigo.ainTweaks.commands.GetFoodItem;
import net.aindrigo.ainTweaks.commands.GetItem;
import net.aindrigo.ainTweaks.events.AinListener;
import net.aindrigo.ainTweaks.itemVariants.Butter;
import net.aindrigo.ainTweaks.itemVariants.ButteredBread;
import net.aindrigo.ainTweaks.itemVariants.MashedPotatos;
import net.aindrigo.ainTweaks.recipe.Recipes;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.logging.Logger;

public class MainPlugin extends JavaPlugin {
    public static JavaPlugin plugin;
    public Logger logger;
    public static ButteredBread bread = new ButteredBread();
    public static CommandMap commandMap;
    public static Butter butter = new Butter();
    public static MashedPotatos mashedPotatos = new MashedPotatos();

    @Override
    public void onEnable() {
        super.onEnable();
        plugin = this;
        logger = getLogger();
        logger.info("Enabled");
        commandMap = getMap();
        initCommands();
        this.getServer().getPluginManager().registerEvents(new AinListener(), this);
        Recipes.breadRecipe();
        Recipes.butterRecipe();
        Recipes.potatoRecipe();
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
    private void initCommands(){
        // Command initializing
        GetFoodItem getFoodItem = new GetFoodItem();
        GetItem getItem = new GetItem();


        // Registering
        AinCommand.registerCommands("ainTweaks");
    }
}
