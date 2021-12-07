package net.aindrigo.ainTweaks.commands;

import net.aindrigo.ainTweaks.itemVariants.ItemVariant;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GetItem extends AinCommand{

    public GetItem(){
        super("getcustomitem");

    }

    @Override
    public void onExecute(CommandSender sender, String[] args, boolean hasArgs, boolean isPlayer) {
        if(!hasArgs){
            sender.sendMessage(ChatColor.RED + "You must pass an argument! /getitem <item> <number>");
            return;
        }
        if(!isPlayer){
            sender.sendMessage(ChatColor.RED + "You aren't a player!");
            return;
        }

        String itemId = args[0];
        int numberOfItems = Integer.parseInt(args[1]);
        ItemVariant variant = ItemVariant.getItemFromId(itemId);
        Player player = (Player) sender;
        if(variant == null){
            sender.sendMessage(ChatColor.RED + "That isn't a valid item!");
        }
        ItemStack stack = variant.generateItem(numberOfItems);
        player.getInventory().addItem(stack);
        sender.sendMessage(ChatColor.GREEN + "Gave " + player.getDisplayName() + " " + String.valueOf(numberOfItems) + " " + variant.name);

    }
}
