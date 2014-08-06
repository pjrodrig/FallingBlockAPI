package me.LCastr0.FallingBlockAPI.api;

import me.LCastr0.FallingBlockAPI.api.entities.StaticFallingBlock;
import me.LCastr0.FallingBlockAPI.api.entities.FlyingBlock;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;

public class Creation {
	
	private Creation instance;
	
	/**
	 * @author LCastr0
	 */
	public Creation(){
		super();
		instance = this;
	}
	
	/**
	 * Creates a common falling block in a specific Location
	 * 
	 * @param location The location that the falling block will be spawned
	 * @param material The material of the falling block
	 * @param data The data (Also known as damage) of the falling block
	 * @param canDropItem Defines if the block will drop an item when broken
	 * 
	 * @return Returns a FallingBlock Object
	 * 
	 */
	public FallingBlock createFallingBlock(Location location, Material material, byte data, boolean canDropItem){
		CreateFallingBlock cfb = new CreateFallingBlock(location, material, data, canDropItem);
		cfb.create();
		return cfb.getFallingBlock();
	}
	
	/**
	 * Creates a static falling block in a specific Location
	 * 
	 * @param location The location that the falling block will be spawned
	 * @param material The material of the falling block
	 * @param data The data (Also known as damage) of the falling block
	 * @param canDropItem Defines if the block will drop an item when broken
	 * 
	 * @return Returns a CustomFallingBlock Object
	 * 
	 */
	public StaticFallingBlock createStaticFallingBlock(Location location, Material material, byte data, boolean canDropItem){
		CreateStaticFallingBlock csfb = new CreateStaticFallingBlock(location, material, data, canDropItem);
		csfb.create();
		return csfb.getStaticFallingBlock();
	}
	
	/**
	 * Creates a flying block in a specific Location
	 * 
	 * @param location The location that the flying block will be spawned
	 * @param material The material of the flying block
	 * @param data The data (Also known as damage) of the flying block
	 * @param canDropItem Defines if the block will drop an item when broken
	 * 
	 * @return Returns a CustomFallingBlock Object
	 * 
	 */
	public FlyingBlock createFlyingBlock(Location location, Material material, byte data, boolean canDropItem){
		CreateFlyingBlock cfb = new CreateFlyingBlock(location, material, data, canDropItem);
		cfb.create();
		return cfb.getFlyingBlock();
	}
	
	/**
	 * Creates a falling block controler, to change specific parts of the FallingBlock
	 * 
	 * @param fallingBlock The FallingBlock Object to be controled
	 * 
	 * @return Returns a FallingBlockController Object
	 * 
	 */
	public FallingBlockController getFallingBlockController(FallingBlock fallingBlock){
		return new FallingBlockController(fallingBlock);
	}
	
	/**
	 * Creates a static falling block controler, to change specific parts of the CustomFallingBlock
	 * 
	 * @param customFallingBlock The CustomFallingBlock Object to be controled
	 * 
	 * @return Returns a CustomFallingBlockController Object
	 * 
	 */
	public StaticFallingBlockController getStaticFallingBlockController(StaticFallingBlock customFallingBlock){
		return new StaticFallingBlockController(customFallingBlock);
	}
	
	/**
	 * Creates a flying block controler, to change specific parts of the CustomFallingBlock
	 * 
	 * @param customFallingBlock The CustomFallingBlock Object to be controled
	 * 
	 * @return Returns a FlyingBlockController Object
	 * 
	 */
	public FlyingBlockController getFlyingBlockController(FlyingBlock customFallingBlock){
		return new FlyingBlockController(customFallingBlock);
	}
	
	public Creation getCreation(){
		return instance;
	}

}
