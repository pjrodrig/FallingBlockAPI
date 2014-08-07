package me.LCastr0.FallingBlockAPI;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.LCastr0.FallingBlockAPI.api.Creation;
import me.LCastr0.FallingBlockAPI.api.entities.StaticBat;
import me.LCastr0.FallingBlockAPI.api.entities.StaticFallingBlock;
import me.LCastr0.FallingBlockAPI.api.entities.FlyingBlock;
import me.LCastr0.FallingBlockAPI.api.entities.FlyingUpBat;
import net.minecraft.server.v1_7_R3.EntityFallingBlock;
import net.minecraft.server.v1_7_R3.EntityInsentient;
import net.minecraft.server.v1_7_R3.EntityTypes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class FallingBlockAPI extends JavaPlugin{
	
	private static Creation creation;
	private static FallingBlockAPI instance;
	
	public void onLoad(){
		instance = this;
		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&bFallingBlockAPI Loaded!"));
	}
	
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&aFallingBlockAPI Enabled!"));
		registerEntityFallingBlock("CustomFallingBlock", 21, StaticFallingBlock.class);
		registerEntityFallingBlock("FlyingBlock", 21, FlyingBlock.class);
		registerEntity("StaticBat", 65, StaticBat.class);
		registerEntity("FlyingUpBat", 65, FlyingUpBat.class);
	}

	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4FallingBlockAPI Disabled!"));
	}
	
	@SuppressWarnings("unchecked")
	public void registerEntity(String name, int id, Class<? extends EntityInsentient> class1) {
	    try {
	    	 List<Map<?, ?>> dataMaps = new ArrayList<Map<?, ?>>();
	            for (Field f : EntityTypes.class.getDeclaredFields()) {
	                if (f.getType().getSimpleName().equals(Map.class.getSimpleName())) {
	                    f.setAccessible(true);
	                    dataMaps.add((Map<?, ?>) f.get(null));
	                    }
	            }
	 
	            ((Map<Class<? extends EntityInsentient>, String>) dataMaps.get(1)).put(class1, name);
	            ((Map<Class<? extends EntityInsentient>, Integer>) dataMaps.get(3)).put(class1, id);	 
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@SuppressWarnings("unchecked")
	public void registerEntityFallingBlock(String name, int id, Class<? extends EntityFallingBlock> class1) {
		 try {
	    	 List<Map<?, ?>> dataMaps = new ArrayList<Map<?, ?>>();
	            for (Field f : EntityTypes.class.getDeclaredFields()) {
	                if (f.getType().getSimpleName().equals(Map.class.getSimpleName())) {
	                    f.setAccessible(true);
	                    dataMaps.add((Map<?, ?>) f.get(null));
	                    }
	            }
	 
	            ((Map<Class<? extends EntityFallingBlock>, String>) dataMaps.get(1)).put(class1, name);
	            ((Map<Class<? extends EntityFallingBlock>, Integer>) dataMaps.get(3)).put(class1, id);	 
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static Creation creation(){
		return creation;
	}

	public static FallingBlockAPI instance(){
		return instance;
	}
	
}
