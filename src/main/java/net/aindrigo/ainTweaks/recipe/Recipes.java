package net.aindrigo.ainTweaks.recipe;

import net.aindrigo.ainTweaks.main.MainPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class Recipes {

    public static void breadRecipe(){
        ItemStack butter = MainPlugin.butter.generateItem(1);
        ItemStack bread = new ItemStack(Material.BREAD, 1);
        NamespacedKey key = new NamespacedKey(MainPlugin.plugin, "bread");
        ShapedRecipe recipe = new ShapedRecipe(key,MainPlugin.bread.generateItem(1));
        recipe.shape("U", "B");
        recipe.setIngredient('U', new RecipeChoice.ExactChoice(MainPlugin.butter.generateItem(1)));
        recipe.setIngredient('B', Material.BREAD);
        Bukkit.addRecipe(recipe);
    }
}
