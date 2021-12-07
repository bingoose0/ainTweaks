package net.aindrigo.ainTweaks.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class AinCommand extends BukkitCommand {

    public AinCommand(String name){
        super(name);
    }

    public void onExecute(CommandSender sender, String[] args, boolean hasArgs, boolean isPlayer) {};
    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        boolean hasArgs = false;
        boolean isPlayer = false;
        if(args.length > 0) { hasArgs = true; }
        if(sender instanceof Player) { isPlayer = true; }

        onExecute(sender,args,hasArgs,isPlayer);
        return true;
    }
}
