package me.LCastr0.FallingBlockAPI.api;

import java.util.HashMap;
import java.util.Map;

import me.LCastr0.FallingBlockAPI.api.entities.StaticBat;
import me.LCastr0.FallingBlockAPI.api.entities.StaticFallingBlock;
import net.minecraft.server.v1_7_R3.WorldServer;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R3.util.CraftMagicNumbers;

public class StaticFallingBlockController {
	
	private StaticFallingBlock customFallingBlock;
	private StaticBat cb;
	private WorldServer ws;
	private Location loc;
	private static Map<StaticFallingBlock, StaticFallingBlockController> controlers = new HashMap<StaticFallingBlock, StaticFallingBlockController>();
	
	public StaticFallingBlockController(StaticFallingBlock customFallingBlock){
		set(customFallingBlock);
	}
	
	public void create(){
		controlers.put(customFallingBlock, this);
	}
	
	private void set(StaticFallingBlock customFallingBlock){
		this.customFallingBlock = customFallingBlock;
		this.ws = ((CraftWorld) this.customFallingBlock.getBukkitEntity().getWorld()).getHandle();
		this.loc = this.customFallingBlock.getBukkitEntity().getLocation();
		this.cb = CreateStaticFallingBlock.getClass(customFallingBlock).getBat();
	}
	
	public void setMaterial(Material material){
		StaticFallingBlock cfb = new StaticFallingBlock(ws);
		cfb.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
		cfb.setPassengerOf(cb);
		cfb.id = CraftMagicNumbers.getBlock(material);
		cfb.data = customFallingBlock.data;
		cfb.dropItem = customFallingBlock.dropItem;
		ws.removeEntity(customFallingBlock);
		ws.addEntity(cfb);
		this.customFallingBlock = cfb;
	}
	
	public void setData(byte data){
		StaticFallingBlock cfb = new StaticFallingBlock(ws);
		cfb.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
		cfb.setPassengerOf(cb);
		cfb.id = customFallingBlock.id;
		cfb.data = data;
		cfb.dropItem = customFallingBlock.dropItem;
		ws.removeEntity(customFallingBlock);
		ws.addEntity(cfb);
		this.customFallingBlock = cfb;
	}
	
	public void setDropItem(boolean dropItem){
		StaticFallingBlock cfb = new StaticFallingBlock(ws);
		cfb.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
		cfb.setPassengerOf(cb);
		cfb.id = customFallingBlock.id;
		cfb.data = customFallingBlock.data;
		cfb.dropItem = dropItem;
		ws.removeEntity(customFallingBlock);
		ws.addEntity(cfb);
		this.customFallingBlock = cfb;
	}
	
	public void setLocation(Location location){
		StaticFallingBlock cfb = new StaticFallingBlock(ws);
		StaticBat bat = new StaticBat(ws);
		cfb.setLocation(location.getX(), location.getY(), location.getZ(), 0, 0);
		bat.setLocation(location.getX(), location.getY()-.5, location.getZ(), 0, 0);
		cfb.setPassengerOf(bat);
		cfb.id = customFallingBlock.id;
		cfb.data = customFallingBlock.data;
		cfb.dropItem = customFallingBlock.dropItem;
		ws.removeEntity(customFallingBlock);
		ws.removeEntity(cb);
		ws.addEntity(cfb);
		ws.addEntity(bat);
		this.customFallingBlock = cfb;
		this.cb = bat;
	}
	
	public void destroy(){
		this.ws.removeEntity(cb);
		this.ws.removeEntity(customFallingBlock);
	}
	
	public static StaticFallingBlockController getControler(StaticFallingBlock cfb){
		return controlers.get(cfb);
	}

}
