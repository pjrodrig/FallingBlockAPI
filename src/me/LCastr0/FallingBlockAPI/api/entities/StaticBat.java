package me.LCastr0.FallingBlockAPI.api.entities;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import net.minecraft.server.v1_7_R3.DamageSource;
import net.minecraft.server.v1_7_R3.EntityBat;
import net.minecraft.server.v1_7_R3.EntityHuman;
import net.minecraft.server.v1_7_R3.PathfinderGoalSelector;
import net.minecraft.server.v1_7_R3.World;

import org.bukkit.Location;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class StaticBat extends EntityBat {
	
	public StaticBat(World world) {
		super(world);
		try {
			Method  clear = List.class.getDeclaredMethod("clear");
			Field b = PathfinderGoalSelector.class.getDeclaredField("b");
			b.setAccessible(true);
			Object bObj = b.get(this.goalSelector);
			clear.invoke(bObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
	};

	 @Override
	 public void h() {
		 setInvisible(true);
	     setLocation(locX, locY, locZ, yaw, pitch);
	     velocityChanged = false;
	 }
	 
	 public void spawn(Location location) {
		 setPositionRotation(location.getX(), location.getY(), location.getZ(), 0, 0);
	     world.addEntity(this, CreatureSpawnEvent.SpawnReason.CUSTOM);
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
