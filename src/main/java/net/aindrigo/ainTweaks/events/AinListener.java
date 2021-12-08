package net.aindrigo.ainTweaks.events;

import net.aindrigo.ainTweaks.itemVariants.ButteredBread;
import net.aindrigo.ainTweaks.itemVariants.FoodVariant;
import net.aindrigo.ainTweaks.main.MainPlugin;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import javax.xml.stream.events.Namespace;
import java.awt.*;
import java.util.Random;


public class AinListener implements org.bukkit.event.Listener {
    ButteredBread bread = MainPlugin.bread;


    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event){
        ItemStack stack = event.getItem();
        Player player = event.getPlayer();
        FoodVariant.processItem(player,stack);
        MainPlugin.plugin.getLogger().info("Hunger satisfied");
    }

    @EventHandler
    public void onMobDeath(EntityDeathEvent event){
        EntityType entity = event.getEntityType();
        if(entity == EntityType.COW){
            ItemStack item = MainPlugin.butter.generateItem(3);
            World world = Bukkit.getWorld("world");
            world.dropItem(event.getEntity().getLocation(), item);
        }
    }
}
