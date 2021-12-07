package net.aindrigo.ainTweaks.commands;

import net.aindrigo.ainTweaks.main.MainPlugin;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AinCommand extends BukkitCommand {
    public static ArrayList<AinCommand> commands = new ArrayList<AinCommand>();
    public AinCommand(String name){
        super(name);
        commands.add(this);
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

    public static void registerCommands(String prefix){
        CommandMap map = MainPlugin.commandMap;
        for(AinCommand command:commands){
            map.register(prefix,command);
        }
    }
}
