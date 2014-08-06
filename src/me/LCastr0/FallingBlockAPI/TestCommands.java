package me.LCastr0.FallingBlockAPI;

import me.LCastr0.FallingBlockAPI.api.CreateFallingBlock;
import me.LCastr0.FallingBlockAPI.api.CreateFlyingBlock;
import me.LCastr0.FallingBlockAPI.api.CreateStaticFallingBlock;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommands implements CommandExecutor{
	
	public FallingBlockAPI plugin;
	
	public TestCommands(FallingBlockAPI plugin){
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
		
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(label.equalsIgnoreCase("fallingblock")){
				if(args.length==2){
					Material material = Material.getMaterial(Integer.valueOf(args[0]));
					byte b = (byte) ((int) Integer.valueOf(args[1]));
					CreateFallingBlock create = new CreateFallingBlock(player.getLocation(), material, b, false);
					create.create();
					return true;
				} else {
					player.sendMessage("§cYou need to specify a block-id and a data!");
					return false;
				}
			} else if(label.equalsIgnoreCase("flyingblock")){
				if(args.length==2){
					Material material = Material.getMaterial(Integer.valueOf(args[0]));
					byte b = (byte) ((int) Integer.valueOf(args[1]));
					CreateFlyingBlock create = new CreateFlyingBlock(player.getLocation(), material, b, false);
					create.create();
					return true;
				} else {
					player.sendMessage("§cYou need to specify a block-id and a data!");
					return false;
				}
			} else if(label.equalsIgnoreCase("staticblock")){
				if(args.length==2){
					Material material = Material.getMaterial(Integer.valueOf(args[0]));
					byte b = (byte) ((int) Integer.valueOf(args[1]));
					CreateStaticFallingBlock create = new CreateStaticFallingBlock(player.getLocation(), material, b, false);
					create.create();
					return true;
				} else {
					player.sendMessage("§cYou need to specify a block-id and a data!");
					return false;
				}
			}
		} else {
			sender.sendMessage("§cThis command is only avaliable for in-game players!");
			return true;
		}
		
		return false;
		
	}

}
