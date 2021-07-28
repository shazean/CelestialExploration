package mod.shim.celestialexploration.blocks;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.registry.RegistryTileEntity;
import mod.shim.celestialexploration.tileentity.AssemblyStationTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class AssemblyStationBlock extends Block {
	   private static final ITextComponent CONTAINER_TITLE = new TranslationTextComponent("container." + Main.MODID + ".assembly_station");

	   public AssemblyStationBlock(AbstractBlock.Properties properties) {
	      super(properties);
	   }

	@Override
	public boolean hasTileEntity(BlockState state) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		// TODO Auto-generated method stub
		return RegistryTileEntity.ASSEMBLY_STATION_TILE_ENTITY_TYPE.get().create();
	}



@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos,
			PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		// TODO Auto-generated method stub
		if (!worldIn.isClientSide) {
			TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof AssemblyStationTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (AssemblyStationTileEntity) tileentity, pos);
			}
		}
		return super.use(state, worldIn, pos, player, handIn, hit);
	}

//	   public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
//	      if (p_225533_2_.isClientSide) {
//	         return ActionResultType.SUCCESS;
//	      } else {
//	         p_225533_4_.openMenu(p_225533_1_.getMenuProvider(p_225533_2_, p_225533_3_));
//	         p_225533_4_.awardStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
//	         return ActionResultType.CONSUME;
//	      }
//	   }
//
//	   public INamedContainerProvider getMenuProvider(BlockState p_220052_1_, World p_220052_2_, BlockPos p_220052_3_) {
//	      return new SimpleNamedContainerProvider((p_220270_2_, p_220270_3_, p_220270_4_) -> {
//	         return new WorkbenchContainer(p_220270_2_, p_220270_3_, IWorldPosCallable.create(p_220052_2_, p_220052_3_));
//	      }, CONTAINER_TITLE);
//	   }
	}