package net.aindrigo.ainTweaks.events;

import net.aindrigo.ainTweaks.customItems.ButteredBread;
import net.aindrigo.ainTweaks.customItems.CustomFood;
import net.aindrigo.ainTweaks.main.MainPlugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;


public class AinListener implements org.bukkit.event.Listener {
    ButteredBread bread = MainPlugin.bread;


    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event){
        ItemStack stack = event.getItem();
        Player player = event.getPlayer();
        CustomFood.processItem(player,stack);
    }
    @EventHandler
    public void onCraft(CraftItemEvent event){
        Recipe recipe = event.getRecipe();
        Inventory inventory = event.getInventory();
        if(MainPlugin.butter.isItem(recipe.getResult())){
            inventory.addItem(new ItemStack(Material.BUCKET, 1));
        }
    }

}
