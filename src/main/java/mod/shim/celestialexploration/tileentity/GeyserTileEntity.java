package mod.shim.celestialexploration.tileentity;

import java.util.Random;

import mod.shim.celestialexploration.registry.RegistryTileEntity;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IIntArray;

public class GeyserTileEntity extends TileEntity {

	public GeyserTileEntity(TileEntityType<?> p_i48289_1_) {
		super(p_i48289_1_);
		// TODO Auto-generated constructor stub
	}
	
	public GeyserTileEntity() {
		this(RegistryTileEntity.GEYSER_TILE_ENTITY_TYPE.get());
	}

	
	private int randomTimer;
	   
	public void setCounterTimer() {
	   Random random = new Random();
	   randomTimer = random.nextInt(50);
   }
	   
   public int getCounterTime() {
	   return randomTimer;
   }
	   
   public void tickCounter() {
	   randomTimer--;
		   
	   if (randomTimer <= 0) {
		   setCounterTimer();
	   }
		   
   }
   
   public final IIntArray dataAccess = new IIntArray() {
	   public int get(int p_221476_1_) {
		   return GeyserTileEntity.this.randomTimer;
	     
	   }

	   public void set(int p_221477_1_, int p_221477_2_) {
		   Random random = new Random();
		   GeyserTileEntity.this.randomTimer = random.nextInt(p_221477_2_);
			
	   }
	      

	   public int getCount() {
		   return 4;
	   }

	   };
	
}
