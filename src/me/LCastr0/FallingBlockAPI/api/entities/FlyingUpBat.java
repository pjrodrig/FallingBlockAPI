package me.LCastr0.FallingBlockAPI.api.entities;

import me.LCastr0.FallingBlockAPI.FallingBlockAPI;
import net.minecraft.server.v1_7_R3.DamageSource;
import net.minecraft.server.v1_7_R3.EntityHuman;
import net.minecraft.server.v1_7_R3.World;

import net.minecraft.server.v1_7_R3.EntityBat;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class FlyingUpBat extends EntityBat {
	
	public FlyingUpBat(World world) {
		super(world);
	}
	
	FallingBlockAPI api = FallingBlockAPI.instance();
	
	@Override
	public boolean aD() {
		return false;
	}
	
	@Override
	protected String aT() {
		return "";
	}

	@Override
	protected String o(int i) {
		return "";
	}

	@Override
	protected String t() {
		return "";
	}

	@Override
	public int aU() {
		return 0;
	}

	@Override
	public boolean O() {
		return false;
	}
	
	@Override
	public boolean isSleeping() {
		return false;
	}

	@Override
	public void h() {
		setInvisible(true);
		final int task = Bukkit.getScheduler().scheduleSyncRepeatingTask(api, new Runnable(){
			public void run(){
				setLocation(locX, locY+0.1, locZ, 0, 0);
			}
		}, 1, 1);
		Bukkit.getScheduler().scheduleSyncDelayedTask(api, new Runnable(){public void run(){Bukkit.getScheduler().cancelTask(task);}}, 9);
		Location top = new Location(getBukkitEntity().getWorld(), locX, locY+1, locZ);
		if(getBukkitEntity().getLocation().add(0, 1, 0).getBlock().getType()!=Material.AIR&&(!top.getBlock().isLiquid())){
			world.removeEntity(this);
		}
	}

	@Override
	protected void bn() {
		
	}
	
	@Override
	public boolean bN() {
		return false;
	}
	
	@Override
	public void b_(EntityHuman entity) {
		
	}

	@Override
	public boolean damageEntity(DamageSource damagesource, float f) {
		return false;
	}

	@Override
	public void g(double x, double y, double z) {

	}
	
	@Override
	public boolean canSpawn() {
		return true;
	}

}
