package me.LCastr0.FallingBlockAPI.api;

import java.util.HashMap;
import java.util.Map;

import me.LCastr0.FallingBlockAPI.api.entities.FlyingBlock;
import me.LCastr0.FallingBlockAPI.api.entities.FlyingUpBat;
import net.minecraft.server.v1_7_R3.WorldServer;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R3.util.CraftMagicNumbers;

public class FlyingBlockController {
	
	private FlyingBlock flyingBlock;
	private FlyingUpBat cb;
	private WorldServer ws;
	private Location loc;
	private static Map<FlyingBlock, FlyingBlockController> controlers = new HashMap<FlyingBlock, FlyingBlockController>();
	
	public FlyingBlockController(FlyingBlock customFallingBlock){
		set(customFallingBlock);
	}
	
	public void create(){
		controlers.put(flyingBlock, this);
	}
	
	private void set(FlyingBlock customFallingBlock){
		this.flyingBlock = customFallingBlock;
		this.ws = ((CraftWorld) this.flyingBlock.getBukkitEntity().getWorld()).getHandle();
		this.loc = this.flyingBlock.getBukkitEntity().getLocation();
		this.cb = CreateFlyingBlock.getClass(customFallingBlock).getBat();
	}
	
	public void setMaterial(Material material){
		FlyingBlock cfb = new FlyingBlock(ws);
		cfb.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
		cfb.setPassengerOf(cb);
		cfb.id = CraftMagicNumbers.getBlock(material);
		cfb.data = flyingBlock.data;
		cfb.dropItem = flyingBlock.dropItem;
		ws.removeEntity(flyingBlock);
		ws.addEntity(cfb);
		this.flyingBlock = cfb;
	}
	
	public void setData(byte data){
		FlyingBlock cfb = new FlyingBlock(ws);
		cfb.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
		cfb.setPassengerOf(cb);
		cfb.id = flyingBlock.id;
		cfb.data = data;
		cfb.dropItem = flyingBlock.dropItem;
		ws.removeEntity(flyingBlock);
		ws.addEntity(cfb);
		this.flyingBlock = cfb;
	}
	
	public void setDropItem(boolean dropItem){
		FlyingBlock cfb = new FlyingBlock(ws);
		cfb.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
		cfb.setPassengerOf(cb);
		cfb.id = flyingBlock.id;
		cfb.data = flyingBlock.data;
		cfb.dropItem = dropItem;
		ws.removeEntity(flyingBlock);
		ws.addEntity(cfb);
		this.flyingBlock = cfb;
	}
	
	public void setLocation(Location location){
		FlyingBlock cfb = new FlyingBlock(ws);
		FlyingUpBat bat = new FlyingUpBat(ws);
		cfb.setLocation(location.getX(), location.getY(), location.getZ(), 0, 0);
		bat.setLocation(location.getX(), location.getY()-.5, location.getZ(), 0, 0);
		cfb.setPassengerOf(bat);
		cfb.id = flyingBlock.id;
		cfb.data = flyingBlock.data;
		cfb.dropItem = flyingBlock.dropItem;
		ws.removeEntity(flyingBlock);
		ws.removeEntity(cb);
		ws.addEntity(cfb);
		ws.addEntity(bat);
		this.flyingBlock = cfb;
		this.cb = bat;
	}
	
	public void destroy(){
		this.ws.removeEntity(cb);
		this.ws.removeEntity(flyingBlock);
	}
	
	public static FlyingBlockController getControler(FlyingBlock cfb){
		return controlers.get(cfb);
	}

}
