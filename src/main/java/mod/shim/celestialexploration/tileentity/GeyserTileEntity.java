package mod.shim.celestialexploration.tileentity;

import java.util.Random;

import mod.shim.celestialexploration.registry.RegistryTileEntity;
import net.minecraft.inventory.IClearable;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IIntArray;

public class GeyserTileEntity extends TileEntity implements ITickableTileEntity {

	private int randomTimer;
	Random random = new Random();

	
	public GeyserTileEntity(TileEntityType<?> p_i48289_1_) {
		super(p_i48289_1_);
//		setCounterTimer();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public GeyserTileEntity() {
		this(RegistryTileEntity.GEYSER_TILE_ENTITY_TYPE.get());
	}

	@Override
	public void tick() {
//		System.out.println("GeyserTileEntity tick");
		
		if (!this.level.isClientSide()) {
		
		   this.randomTimer--;
		   
		   if (this.randomTimer < 0) {
//			   this.randomTimer = this.random.nextInt(45) + 5;
			   this.randomTimer = 30;
		   }
		   

//		System.out.println("GeyserTileEntity randomTimer: " + randomTimer);
//		this.tickCounter();
		}

	}

	
	   
//	public void setCounterTimer() {
//	   this.randomTimer = this.random.nextInt(45) + 5;
//   }
	   
   public int getCounterTime() {
//	   System.out.println("GeyserTileEntity getCounterTime randomTimer: " + randomTimer);
	   return randomTimer;
	   
   }

}
