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
import java.awt.*;

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

    public static void potatoRecipe(){
        Material potatoes = Material.POTATO;
        Material stick = Material.STICK;
        NamespacedKey key = new NamespacedKey(MainPlugin.plugin, "mashedpotatos");
        ShapelessRecipe recipe = new ShapelessRecipe(key, MainPlugin.mashedPotatos.generateItem(1));
        recipe.addIngredient(potatoes);
        recipe.addIngredient(stick);
        Bukkit.addRecipe(recipe);
    }

    public static void candyAppleRecipe(){
        Material apple = Material.APPLE;
        Material sugar = Material.SUGAR;
        NamespacedKey key = new NamespacedKey(MainPlugin.plugin, "candyapple");
        ShapelessRecipe recipe = new ShapelessRecipe(key,MainPlugin.candyApple.generateItem(1));
        recipe.addIngredient(apple);
        recipe.addIngredient(sugar);
        Bukkit.addRecipe(recipe);
    }
}
