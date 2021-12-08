package net.aindrigo.ainTweaks.itemVariants;

import net.aindrigo.ainTweaks.main.MainPlugin;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CustomFood {
    public String name;
    public Material origin;
    public boolean enchantedEffect;
    public int saturation;
    public static ArrayList<CustomFood> variants = new ArrayList<CustomFood>();
    public static List<String> ids = new ArrayList<String>();
    public String itemId;
    public CustomFood(String name, boolean enchantedEffect, Material origin, int saturation, String itemId){
        this.origin = origin;
        this.name = name;
        this.enchantedEffect = enchantedEffect;
        this.saturation = saturation * 2;
        this.itemId = itemId;
        variants.add(this);
        ids.add(this.itemId);
    }

    public ItemStack generateItem(int numberofitems){
        ItemStack item = new ItemStack(this.origin, numberofitems);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(this.name);
        if(this.enchantedEffect){
            item.addUnsafeEnchantment(Enchantment.MULTISHOT, 1);
        }
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);

        return item;
    }

    public boolean isItem(ItemStack item){
        if(item.getItemMeta().getDisplayName().equals(this.name)){
            return true;

        }else{
            return false;
        }
    }
    public static CustomFood getItemFromId(String id){
        for(CustomFood i:variants){
            if(i.itemId.equals(id)){
                return i;
            }
        }
        return null;
    }
    public static void processItem(Player player, ItemStack itemStack){
        for(CustomFood i:variants){
            if(i.isItem(itemStack)){
                int foodLevel = player.getFoodLevel();
                player.setFoodLevel(foodLevel + i.saturation);
                MainPlugin.plugin.getLogger().info("Item is correct");
            }
        }
    }


}
