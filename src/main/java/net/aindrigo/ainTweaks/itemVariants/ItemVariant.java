package net.aindrigo.ainTweaks.itemVariants;

import net.aindrigo.ainTweaks.main.MainPlugin;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemVariant {
    public String name;
    public Material origin;
    public boolean enchantedEffect;
    public static ArrayList<ItemVariant> variants = new ArrayList<ItemVariant>();
    public static List<String> ids = new ArrayList<String>();
    public String itemId;
    public ItemVariant(String name, boolean enchantedEffect, Material origin, String itemId){
        this.origin = origin;
        this.name = name;
        this.enchantedEffect = enchantedEffect;
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
    public static ItemVariant getItemFromId(String id){
        for(ItemVariant i:variants){
            if(i.itemId.equals(id)){
                return i;
            }
        }
        return null;
    }



}
