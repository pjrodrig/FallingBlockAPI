package me.LCastr0.FallingBlockAPI.api;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.util.Vector;

public class FallingBlockController {
	
	private FallingBlock fallingBlock;
	private Material material;
	private byte data;
	private Location actual;
	public Vector velocity = new Vector();
	private boolean dropItem;
	private static Map<FallingBlock, FallingBlockController> controlers = new HashMap<FallingBlock, FallingBlockController>();
	
	public FallingBlockController(FallingBlock fallingBlock){
		set(fallingBlock);
	}
	
	@SuppressWarnings({ "deprecation" })
	private void set(FallingBlock fallingBlock){
		this.fallingBlock = fallingBlock;
		this.material = fallingBlock.getMaterial();
		this.data = fallingBlock.getBlockData();
		this.actual = fallingBlock.getLocation();
		this.velocity = fallingBlock.getVelocity();
		this.dropItem = fallingBlock.getDropItem();
	}
	
	public void create(){
		controlers.put(fallingBlock, this);
	}
	
	@SuppressWarnings("deprecation")
	public void setLocation(Location newLocation){
		fallingBlock.remove();
		FallingBlock fallingBlock = newLocation.getWorld().spawnFallingBlock(newLocation, material.getId(), data);
		fallingBlock.setDropItem(dropItem);
		fallingBlock.setVelocity(velocity);
		set(fallingBlock);
	}
	
	@SuppressWarnings("deprecation")
	public void setMaterial(Material material){
		fallingBlock.remove();
		FallingBlock fallingBlock = actual.getWorld().spawnFallingBlock(actual, material.getId(), data);
		fallingBlock.setDropItem(dropItem);
		fallingBlock.setVelocity(velocity);
		set(fallingBlock);
	}
	
	@SuppressWarnings("deprecation")
	public void setData(byte data){
		fallingBlock.remove();
		FallingBlock fallingBlock = actual.getWorld().spawnFallingBlock(actual, material.getId(), data);
		fallingBlock.setDropItem(dropItem);
		fallingBlock.setVelocity(velocity);
		set(fallingBlock);
	}
	
	@SuppressWarnings("deprecation")
	public void setVelocity(Vector velocity){
		fallingBlock.remove();
		FallingBlock fallingBlock = actual.getWorld().spawnFallingBlock(actual, material.getId(), data);
		fallingBlock.setDropItem(dropItem);
		fallingBlock.setVelocity(velocity);
		set(fallingBlock);
	}
	
	@SuppressWarnings("deprecation")
	public void setDropItem(boolean dropItem){
		fallingBlock.remove();
		FallingBlock fallingBlock = actual.getWorld().spawnFallingBlock(actual, material.getId(), data);
		fallingBlock.setDropItem(dropItem);
		fallingBlock.setVelocity(velocity);
		set(fallingBlock);
	}
	
	public FallingBlock getBlock(){
		return fallingBlock;
	}
	
	public void destroy(){
		this.fallingBlock.remove();
	}
	
	public static FallingBlockController getControler(FallingBlock fallingBlock){
		return controlers.get(fallingBlock);
	}

}
