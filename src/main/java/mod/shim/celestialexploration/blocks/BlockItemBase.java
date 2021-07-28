package mod.shim.celestialexploration.blocks;

import mod.shim.celestialexploration.Main;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

 public class BlockItemBase extends BlockItem {

	public BlockItemBase(Block block) {
		super(block, new Item.Properties().tab(Main.CELESTIAL_TAB));
	
	}
	
}
