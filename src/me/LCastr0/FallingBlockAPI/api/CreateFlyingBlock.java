package me.LCastr0.FallingBlockAPI.api;

import java.util.HashMap;
import java.util.Map;

import me.LCastr0.FallingBlockAPI.api.entities.FlyingBlock;
import me.LCastr0.FallingBlockAPI.api.entities.FlyingUpBat;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R3.util.CraftMagicNumbers;

public class CreateFlyingBlock {
	
	private FlyingBlock flyingBlock;
	private FlyingUpBat bat;
	private Location spawn;
	private Material material;
	private boolean dropItem;
	private byte data;
	private static Map<FlyingBlock, CreateFlyingBlock> instances = new HashMap<FlyingBlock, CreateFlyingBlock>();
	
	public CreateFlyingBlock(Location spawn, Material material, byte data, boolean dropItem){
		this.spawn = spawn;
		this.material = material;
		this.dropItem = dropItem;
		this.data = data;
	}
	
	public void create(){
		FlyingBlock cfb = new FlyingBlock(((CraftWorld) spawn.getWorld()).getHandle());
		FlyingUpBat cb = new FlyingUpBat(((CraftWorld) spawn.getWorld()).getHandle());
		cfb.setLocation(spawn.getX(), spawn.getY(), spawn.getZ(), 0, 0);
		cb.setLocation(getMiddle(spawn.getX()), spawn.getY(), getMiddle(spawn.getZ()), 0, 0);
		cfb.setPassengerOf(cb);
		cfb.id = CraftMagicNumbers.getBlock(material);
		cfb.data = data;
		cfb.dropItem = dropItem;
		((CraftWorld) spawn.getWorld()).getHandle().addEntity(cfb);
		((CraftWorld) spawn.getWorld()).getHandle().addEntity(cb);
		this.flyingBlock = cfb;
		this.bat = cb;
		instances.put(cfb, this);
	}
	
	public FlyingUpBat getBat(){
		return bat;
	}
	
	private double getMiddle(double d){
		int i = (int) Math.floor(d);
		return i+.5;
	}
	
	public Location getSpawn(){
		return this.spawn;
	}
	
	public FlyingBlock getFlyingBlock(){
		return flyingBlock;
	}
	
	public static CreateFlyingBlock getClass(FlyingBlock flyingBlock){
		return instances.get(flyingBlock);
	}

}
