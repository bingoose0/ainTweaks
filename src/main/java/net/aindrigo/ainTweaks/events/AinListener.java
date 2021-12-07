package net.aindrigo.ainTweaks.events;

import net.aindrigo.ainTweaks.itemVariants.ButteredBread;
import net.aindrigo.ainTweaks.itemVariants.ItemVariant;
import net.aindrigo.ainTweaks.main.MainPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;


public class AinListener implements org.bukkit.event.Listener {
    ButteredBread bread = MainPlugin.bread;


    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event){
        ItemStack stack = event.getItem();
        Player player = event.getPlayer();
        ItemVariant.processItem(player,stack);
        MainPlugin.plugin.getLogger().info("Hunger satisfied");
    }
}
