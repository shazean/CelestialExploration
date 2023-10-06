//package com.shim.celestialexploration.blocks;
//
//import com.shim.celestialexploration.blocks.blockentities.SolarPanelBlockEntity;
//import com.shim.celestialexploration.inventory.containers.SolarPanelContainer;
//import net.minecraft.core.BlockPos;
//import net.minecraft.network.chat.Component;
//import net.minecraft.network.chat.TranslatableComponent;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.world.MenuProvider;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.AbstractContainerMenu;
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
//import net.minecraft.world.phys.BlockHitResult;
//import net.minecraft.world.phys.shapes.Shapes;
//import net.minecraft.world.phys.shapes.VoxelShape;
//import net.minecraftforge.network.NetworkHooks;
//
//import javax.annotation.Nullable;
//
//public class SolarPanelBlock extends Block implements EntityBlock {
//
//	public static final String MESSAGE_SOLAR = "message.solar_panel";
//	public static final String SCREEN_SOLAR_PANEL = "screen.celestialexploration.solar_panel";
//
//	private static final VoxelShape RENDER_SHAPE = Shapes.box(0.1,  0.1, 0.1, 0.9, 0.9, 0.9);
//
//
//	public SolarPanelBlock() {
//		super(Properties.of(Material.METAL)
//				.sound(SoundType.METAL)
//				.strength(2.0f)
//				.lightLevel(state -> state.getValue(BlockStateProperties.POWERED) ? 5  : 0)
//		);
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
//	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
//		super.createBlockStateDefinition(builder);
//		builder.add(BlockStateProperties.POWERED);
//	}
//
//	@Override
//	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace) {
//		System.out.println("SolarPanelBlock use()");
//		if (!level.isClientSide) {
//			System.out.println("SolarPanelScreen use() is not client side");
//
//			BlockEntity tileEntity = level.getBlockEntity(pos);
//			if (tileEntity instanceof SolarPanelBlockEntity) {
//				MenuProvider containerProvider = new MenuProvider() {
//					@Override
//					public Component getDisplayName() {
//						return new TranslatableComponent(SCREEN_SOLAR_PANEL);
//					}
//
//					@Override
//					public AbstractContainerMenu createMenu(int i, Inventory playerInv, Player player) {
//						System.out.println("SolarPanelScreen use() createMenu");
//						return new SolarPanelContainer(i, level, pos, playerInv, player);
//					}
//				};
//				NetworkHooks.openGui((ServerPlayer) player, containerProvider, tileEntity.getBlockPos());
//			} else {
//				throw new IllegalStateException("Our named container provider is missing!");
//			}
//		}
//		return InteractionResult.SUCCESS;
//	}
//
//}
//
//
