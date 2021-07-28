package mod.shim.celestialexploration.tileentity;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.inventory.container.AssemblyStationContainer;
import mod.shim.celestialexploration.registry.RegistryTileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class AssemblyStationTileEntity extends LockableLootTileEntity {

	public static int slots = 17;
	protected NonNullList<ItemStack> items = NonNullList.withSize(slots, ItemStack.EMPTY);
	static boolean isLit;

	
	public AssemblyStationTileEntity(TileEntityType<?> p_i48289_1_) {
		super(p_i48289_1_);
		// TODO Auto-generated constructor stub
	}
	
	public AssemblyStationTileEntity() {
		this(RegistryTileEntity.ASSEMBLY_STATION_TILE_ENTITY_TYPE.get());
	}

	
	@Override
	public int getContainerSize() {
		// TODO Auto-generated method stub
		return slots;
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		// TODO Auto-generated method stub
		return this.items;
	}
	
//	public ItemStack getItem() {
//		return this.items.get(0);
//	}

	@Override
	protected void setItems(NonNullList<ItemStack> itemsIn) {
		// TODO Auto-generated method stub
		this.items = itemsIn;
	}

	@Override
	protected ITextComponent getDefaultName() {
		// TODO Auto-generated method stub
		return new TranslationTextComponent("container." + Main.MODID + ".assembly_station");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		// TODO Auto-generated method stub
		return new AssemblyStationContainer(id, player, this);
	}
	
	public static void setLit(boolean lit) {
		isLit = lit;
	}


	//FIXME 6:24
//	@Override
//	public CompoundNBT save(CompoundNBT compound) {
//		super.save(compound);
//
//		if (!this.checkLootAndSave(compound)) {
//			ItemStackHelper.saveAllItems(compound, this.items);
//		}
//		
//		return compound;
//	}
//	
//	@Override
//	public void load(BlockState state, CompoundNBT nbt) {
//		super.load(state,  nbt);
//		this.items = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
//		if (!this.checkLootAndLoad(nbt)) {
//			ItemStackHelper.loadAllItems(nbt, this.items);
//		}
//		
//	}
	
	
}
