package net.aindrigo.ainTweaks.customItems;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CustomItem {
    public String name;
    public Material origin;
    public boolean enchantedEffect;
    public static ArrayList<CustomItem> variants = new ArrayList<CustomItem>();
    public static List<String> ids = new ArrayList<String>();
    public String itemId;
    public ItemMeta meta;
    public CustomItem(String name, boolean enchantedEffect, Material origin, String itemId){
        this.origin = origin;
        this.name = name;
        this.enchantedEffect = enchantedEffect;
        this.itemId = itemId;
        variants.add(this);
        ids.add(this.itemId);

    }
    public ItemMeta getItemMeta(){
        meta.setDisplayName(this.name);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        return meta;
    }

    public void setItemMeta(ItemMeta itemMeta){
        this.meta = itemMeta;
    }
    public ItemStack generateItem(int numberofitems){
        ItemStack item = new ItemStack(this.origin, numberofitems);

        item.setItemMeta(getItemMeta());

        return item;
    }

    public boolean isItem(ItemStack item){
        if(item.getItemMeta().getDisplayName().equals(this.name)){
            return true;

        }else{
            return false;
        }
    }
    public static CustomItem getItemFromId(String id){
        for(CustomItem i:variants){
            if(i.itemId.equals(id)){
                return i;
            }
        }
        return null;
    }



}
