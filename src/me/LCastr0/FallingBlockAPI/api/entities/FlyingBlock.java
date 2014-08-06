package me.LCastr0.FallingBlockAPI.api.entities;

import net.minecraft.server.v1_7_R3.EntityFallingBlock;
import net.minecraft.server.v1_7_R3.World;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class FlyingBlock extends EntityFallingBlock{
	
	public FlyingBlock(World world){
		super(world);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	 public void h() {
		Location top = new Location(this.getBukkitEntity().getWorld(), this.locX, this.locY+1, this.locZ);
	    if(this.getBukkitEntity().getLocation().add(0, 1, 0).getBlock().getType()!=Material.AIR&&(!top.getBlock().isLiquid())){
	    	FallingBlock fb = (FallingBlock) this.getBukkitEntity();
	    	this.getBukkitEntity().getLocation().getBlock().setType(fb.getMaterial());
	    	this.getBukkitEntity().getLocation().getBlock().setData(fb.getBlockData());
	    	fb.remove();
	    	this.world.removeEntity(this); 
	     }
	 }
	 
	 public void spawn(Location location) {
		 setPositionRotation(location.getX(), location.getY(), location.getZ(), 0, 0);
	     world.addEntity(this, CreatureSpawnEvent.SpawnReason.CUSTOM);
	 }

}
