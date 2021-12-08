package net.aindrigo.ainTweaks.recipe;

import net.aindrigo.ainTweaks.main.MainPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

import javax.xml.stream.events.Namespace;

public class Recipes {

    public static void breadRecipe(){
        NamespacedKey key = new NamespacedKey(MainPlugin.plugin, "buttered_bread");
        ShapelessRecipe recipe = new ShapelessRecipe(key,MainPlugin.bread.generateItem(1));
        recipe.addIngredient(new RecipeChoice.ExactChoice(MainPlugin.butter.generateItem(1)));
        recipe.addIngredient(Material.BREAD);
        Bukkit.addRecipe(recipe);
    }

    public static void butterRecipe(){
        Material milk = Material.MILK_BUCKET;
        NamespacedKey key = new NamespacedKey(MainPlugin.plugin, "butter");
        ShapelessRecipe recipe = new ShapelessRecipe(key, MainPlugin.butter.generateItem(1));
        recipe.addIngredient(milk);
        Bukkit.addRecipe(recipe);
    }
}
