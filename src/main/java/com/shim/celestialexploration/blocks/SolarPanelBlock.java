//package com.shim.celestialexploration.blocks;
//
//import javax.annotation.Nullable;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.BlockGetter;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.EntityBlock;
//import net.minecraft.world.level.block.SoundType;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.entity.BlockEntityTicker;
//import net.minecraft.world.level.block.entity.BlockEntityType;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.StateDefinition;
//import net.minecraft.world.level.block.state.properties.BlockStateProperties;
//import net.minecraft.world.level.material.Material;
//import net.minecraft.world.phys.shapes.Shapes;
//import net.minecraft.world.phys.shapes.VoxelShape;
//
//public class SolarPanelBlock extends Block implements EntityBlock {
//	
//	public static final String MESSAGE_SOLAR = "message.solar_panel";
//	public static final String SCREEN_SOLAR = "screen.celestialexploration.solar_panel";
//	
//	private static final VoxelShape RENDER_SHAPE = Shapes.box(0.1,  0.1, 0.1, 0.9, 0.9, 0.9);
//	
//
//	public SolarPanelBlock() {
//		super(Properties.of(Material.METAL)
//				.sound(SoundType.METAL)
//				.strength(2.0f)
//				.lightLevel(state -> state.getValue(BlockStateProperties.POWERED) ? 5  : 0)
//						);
//	}
//	
//	@Override
//	public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos) {
//		return RENDER_SHAPE;
//	}
//
//	@Override
//	public BlockEntity newBlockEntity(BlockPos pos, BlockState blockState) {
//		return new SolarPanelBlockEntity(pos, blockState);
//	}
//	
//	@Nullable
//	@Override
//	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
//		if (level.isClientSide()) {
//			return null;
//		}
//		return (lvl, pos, blockState, t) -> {
//			if (t instanceof SolarPanelBlockEntity tile) {
//				tile.tickServer();
//			}
//		};
//	}
//	
//	
//	@Override
//	protected void createBlockStateDefinition(StateDefinition.Builder<Bllock, BlockState> builder) {
//		super.createBlockStateDefinition(builder);
//		builder.add(BlockStateProperties.POWERED);
//	}
//
//}
