package me.LCastr0.FallingBlockAPI.api;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;

public class CreateFallingBlock {
	
	private Entity entityFallingBlock;
	private FallingBlock fallingBlock;
	private Location spawn;
	private Material material;
	private boolean dropItem;
	private byte data;
	private static Map<FallingBlock, CreateFallingBlock> instances = new HashMap<FallingBlock, CreateFallingBlock>();
	
	public CreateFallingBlock(Location spawn, Material material, byte data, boolean dropItem){
		this.spawn = spawn;
		this.material = material;
		this.dropItem = dropItem;
		this.data = data;
	}
	
	@SuppressWarnings("deprecation")
	public void create(){
		FallingBlock fallingBlock = this.spawn.getWorld().spawnFallingBlock(this.spawn, this.material.getId(), this.data);
		fallingBlock.setDropItem(dropItem);
		this.fallingBlock = fallingBlock;
		this.entityFallingBlock = (Entity) fallingBlock;
		instances.put(this.fallingBlock, this);
	}
	
	public Location getSpawn(){
		return this.spawn;
	}
	
	public Entity getEntity(){
		return this.entityFallingBlock;
	}
	
	public FallingBlock getFallingBlock(){
		return this.fallingBlock;
	}
	
	public static CreateFallingBlock getClass(FallingBlock fallingBlock){
		return instances.get(fallingBlock);
	}

}
