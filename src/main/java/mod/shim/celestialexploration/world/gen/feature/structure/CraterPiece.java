package mod.shim.celestialexploration.world.gen.feature.structure;

import java.util.List;

import java.util.Map;
import java.util.Random;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import mod.shim.celestialexploration.Main;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.DrownedEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.OceanRuinConfig;
import net.minecraft.world.gen.feature.structure.OceanRuinPieces;
import net.minecraft.world.gen.feature.structure.OceanRuinStructure;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.IntegrityProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class CraterPiece {
//	   private boolean placedMainChest;
//	   private boolean placedHiddenChest;
//	   private boolean placedTrap1;
//	   private boolean placedTrap2;
//	   private static final SmallCraterPiece.Selector MOSS_STONE_SELECTOR = new SmallCraterPiece.Selector();

	private static final ResourceLocation SMALL_CRATER = new ResourceLocation(Main.MODID + ":small_crater");
	private static final ResourceLocation MEDIUM_CRATER = new ResourceLocation(Main.MODID + ":medium_crater");
	private static final ResourceLocation LARGE_CRATER = new ResourceLocation(Main.MODID + ":large_crater");

	
//	private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.of(SMALL_CRATER, new BlockPos(0, 1, 0));

	
	
	static Random rand = new Random(10);
	
	private static ResourceLocation createRandomCraterPiece(Random rand) {
		
		switch(rand.nextInt()) {
		
		case 0:
		case 1:
		case 2:
		case 3:
			return SMALL_CRATER;
		
		case 4:
		case 5:
		case 6:
			return MEDIUM_CRATER;

		case 7:
		case 8:		
		case 9:
			return LARGE_CRATER;

		default:
			return SMALL_CRATER;

		}
	}
	
	
	private static final Map<ResourceLocation, BlockPos> CRATER_PIECE = ImmutableMap.of(createRandomCraterPiece(rand), new BlockPos(0, 1, 0));
	
	
	

	   public static void addPieces(TemplateManager p_204041_0_, BlockPos p_204041_1_, Rotation p_204041_2_, List<StructurePiece> p_204041_3_, Random p_204041_4_, NoFeatureConfig p_204041_5_) {
		   	boolean flag = p_204041_4_.nextFloat() <= Math.random();
		      float f = flag ? 0.9F : 0.8F;
		      addPiece(p_204041_0_, p_204041_1_, p_204041_2_, p_204041_3_, p_204041_4_, p_204041_5_, flag, f);
//		      if (flag && p_204041_4_.nextFloat() <= p_204041_5_.clusterProbability) {
//		         addClusterRuins(p_204041_0_, p_204041_4_, p_204041_2_, p_204041_1_, p_204041_5_, p_204041_3_);
//		      }

		   }

//		   private static void addClusterRuins(TemplateManager p_204047_0_, Random p_204047_1_, Rotation p_204047_2_, BlockPos p_204047_3_, NoFeatureConfig p_204047_4_, List<StructurePiece> p_204047_5_) {
//		      int i = p_204047_3_.getX();
//		      int j = p_204047_3_.getZ();
//		      BlockPos blockpos = Template.transform(new BlockPos(15, 0, 15), Mirror.NONE, p_204047_2_, BlockPos.ZERO).offset(i, 0, j);
//		      MutableBoundingBox mutableboundingbox = MutableBoundingBox.createProper(i, 0, j, blockpos.getX(), 0, blockpos.getZ());
//		      BlockPos blockpos1 = new BlockPos(Math.min(i, blockpos.getX()), 0, Math.min(j, blockpos.getZ()));
//		      List<BlockPos> list = allPositions(p_204047_1_, blockpos1.getX(), blockpos1.getZ());
//		      int k = MathHelper.nextInt(p_204047_1_, 4, 8);
//
//		      for(int l = 0; l < k; ++l) {
//		         if (!list.isEmpty()) {
//		            int i1 = p_204047_1_.nextInt(list.size());
//		            BlockPos blockpos2 = list.remove(i1);
//		            int j1 = blockpos2.getX();
//		            int k1 = blockpos2.getZ();
//		            Rotation rotation = Rotation.getRandom(p_204047_1_);
//		            BlockPos blockpos3 = Template.transform(new BlockPos(5, 0, 6), Mirror.NONE, rotation, BlockPos.ZERO).offset(j1, 0, k1);
//		            MutableBoundingBox mutableboundingbox1 = MutableBoundingBox.createProper(j1, 0, k1, blockpos3.getX(), 0, blockpos3.getZ());
//		            if (!mutableboundingbox1.intersects(mutableboundingbox)) {
//		               addPiece(p_204047_0_, blockpos2, rotation, p_204047_5_, p_204047_1_, p_204047_4_, false, 0.8F);
//		            }
//		         }
//		      }
//
//		   }

		   private static List<BlockPos> allPositions(Random p_204044_0_, int p_204044_1_, int p_204044_2_) {
		      List<BlockPos> list = Lists.newArrayList();
		      list.add(new BlockPos(p_204044_1_ - 16 + MathHelper.nextInt(p_204044_0_, 1, 8), 90, p_204044_2_ + 16 + MathHelper.nextInt(p_204044_0_, 1, 7)));
		      list.add(new BlockPos(p_204044_1_ - 16 + MathHelper.nextInt(p_204044_0_, 1, 8), 90, p_204044_2_ + MathHelper.nextInt(p_204044_0_, 1, 7)));
		      list.add(new BlockPos(p_204044_1_ - 16 + MathHelper.nextInt(p_204044_0_, 1, 8), 90, p_204044_2_ - 16 + MathHelper.nextInt(p_204044_0_, 4, 8)));
		      list.add(new BlockPos(p_204044_1_ + MathHelper.nextInt(p_204044_0_, 1, 7), 90, p_204044_2_ + 16 + MathHelper.nextInt(p_204044_0_, 1, 7)));
		      list.add(new BlockPos(p_204044_1_ + MathHelper.nextInt(p_204044_0_, 1, 7), 90, p_204044_2_ - 16 + MathHelper.nextInt(p_204044_0_, 4, 6)));
		      list.add(new BlockPos(p_204044_1_ + 16 + MathHelper.nextInt(p_204044_0_, 1, 7), 90, p_204044_2_ + 16 + MathHelper.nextInt(p_204044_0_, 3, 8)));
		      list.add(new BlockPos(p_204044_1_ + 16 + MathHelper.nextInt(p_204044_0_, 1, 7), 90, p_204044_2_ + MathHelper.nextInt(p_204044_0_, 1, 7)));
		      list.add(new BlockPos(p_204044_1_ + 16 + MathHelper.nextInt(p_204044_0_, 1, 7), 90, p_204044_2_ - 16 + MathHelper.nextInt(p_204044_0_, 4, 8)));
		      return list;
		   }

		   private static void addPiece(TemplateManager p_204045_0_, BlockPos p_204045_1_, Rotation p_204045_2_, List<StructurePiece> p_204045_3_, Random p_204045_4_, NoFeatureConfig p_204045_5_, boolean p_204045_6_, float p_204045_7_) {

			   
	
			   p_204045_3_.add(new CraterPiece.Piece(p_204045_0_, (ResourceLocation) CRATER_PIECE, p_204045_1_, p_204045_2_, p_204045_7_,p_204045_5_, p_204045_6_));
	
		   }

		   public static class Piece extends TemplateStructurePiece {
//		      private final NoFeatureConfig biomeType;
		      private final float integrity;
		      private final ResourceLocation templateLocation;
		      private final Rotation rotation;
		      private final boolean isLarge;

		      public Piece(TemplateManager p_i48868_1_, ResourceLocation p_i48868_2_, BlockPos p_i48868_3_, Rotation p_i48868_4_, float p_i48868_5_, NoFeatureConfig p_i48868_6_, boolean p_i48868_7_) {
		         super(IStructurePieceType.OCEAN_RUIN, 0);
		         this.templateLocation = p_i48868_2_;
		         this.templatePosition = p_i48868_3_;
		         this.rotation = p_i48868_4_;
		         this.integrity = p_i48868_5_;
//		         this.biomeType = p_i48868_6_;
		         this.isLarge = p_i48868_7_;
		         this.loadTemplate(p_i48868_1_);
		      }

		      public Piece(TemplateManager p_i50592_1_, CompoundNBT p_i50592_2_) {
		         super(IStructurePieceType.OCEAN_RUIN, p_i50592_2_);
		         this.templateLocation = new ResourceLocation(p_i50592_2_.getString("Template"));
		         this.rotation = Rotation.valueOf(p_i50592_2_.getString("Rot"));
		         this.integrity = p_i50592_2_.getFloat("Integrity");
//		         this.biomeType = CraterStructure.Type.valueOf(p_i50592_2_.getString("BiomeType"));
		         this.isLarge = p_i50592_2_.getBoolean("IsLarge");
		         this.loadTemplate(p_i50592_1_);
		      }

//		      public Piece(TemplateManager p_204045_0_, Map<ResourceLocation, BlockPos> craterPiece, BlockPos p_204045_1_,
//					Rotation p_204045_2_, float p_204045_7_, boolean p_204045_6_) {
//				// TODO Auto-generated constructor stub
//			}

			private void loadTemplate(TemplateManager p_204034_1_) {
		         Template template = p_204034_1_.getOrCreate(this.templateLocation);
		         PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_AND_AIR);
		         this.setup(template, this.templatePosition, placementsettings);
		      }

		      protected void addAdditionalSaveData(CompoundNBT p_143011_1_) {
		         super.addAdditionalSaveData(p_143011_1_);
		         p_143011_1_.putString("Template", this.templateLocation.toString());
		         p_143011_1_.putString("Rot", this.rotation.name());
		         p_143011_1_.putFloat("Integrity", this.integrity);
//		         p_143011_1_.putString("BiomeType", this.biomeType.toString());
		         p_143011_1_.putBoolean("IsLarge", this.isLarge);
		      }

		      protected void handleDataMarker(String p_186175_1_, BlockPos p_186175_2_, IServerWorld p_186175_3_, Random p_186175_4_, MutableBoundingBox p_186175_5_) {
		         if ("chest".equals(p_186175_1_)) {
		            p_186175_3_.setBlock(p_186175_2_, Blocks.CHEST.defaultBlockState().setValue(ChestBlock.WATERLOGGED, Boolean.valueOf(p_186175_3_.getFluidState(p_186175_2_).is(FluidTags.WATER))), 2);
		            TileEntity tileentity = p_186175_3_.getBlockEntity(p_186175_2_);
		            if (tileentity instanceof ChestTileEntity) {
		               ((ChestTileEntity)tileentity).setLootTable(this.isLarge ? LootTables.UNDERWATER_RUIN_BIG : LootTables.UNDERWATER_RUIN_SMALL, p_186175_4_.nextLong());
		            }
		         } else if ("drowned".equals(p_186175_1_)) {
		            DrownedEntity drownedentity = EntityType.DROWNED.create(p_186175_3_.getLevel());
		            drownedentity.setPersistenceRequired();
		            drownedentity.moveTo(p_186175_2_, 0.0F, 0.0F);
		            drownedentity.finalizeSpawn(p_186175_3_, p_186175_3_.getCurrentDifficultyAt(p_186175_2_), SpawnReason.STRUCTURE, (ILivingEntityData)null, (CompoundNBT)null);
		            p_186175_3_.addFreshEntityWithPassengers(drownedentity);
		            if (p_186175_2_.getY() > p_186175_3_.getSeaLevel()) {
		               p_186175_3_.setBlock(p_186175_2_, Blocks.AIR.defaultBlockState(), 2);
		            } else {
		               p_186175_3_.setBlock(p_186175_2_, Blocks.WATER.defaultBlockState(), 2);
		            }
		         }

		      }

		      public boolean postProcess(ISeedReader p_230383_1_, StructureManager p_230383_2_, ChunkGenerator p_230383_3_, Random p_230383_4_, MutableBoundingBox p_230383_5_, ChunkPos p_230383_6_, BlockPos p_230383_7_) {
		         this.placeSettings.clearProcessors().addProcessor(new IntegrityProcessor(this.integrity)).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_AND_AIR);
		         int i = p_230383_1_.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, this.templatePosition.getX(), this.templatePosition.getZ());
		         this.templatePosition = new BlockPos(this.templatePosition.getX(), i, this.templatePosition.getZ());
		         BlockPos blockpos = Template.transform(new BlockPos(this.template.getSize().getX() - 1, 0, this.template.getSize().getZ() - 1), Mirror.NONE, this.rotation, BlockPos.ZERO).offset(this.templatePosition);
		         this.templatePosition = new BlockPos(this.templatePosition.getX(), this.getHeight(this.templatePosition, p_230383_1_, blockpos), this.templatePosition.getZ());
		         return super.postProcess(p_230383_1_, p_230383_2_, p_230383_3_, p_230383_4_, p_230383_5_, p_230383_6_, p_230383_7_);
		      }

		      private int getHeight(BlockPos p_204035_1_, IBlockReader p_204035_2_, BlockPos p_204035_3_) {
		         int i = p_204035_1_.getY();
		         int j = 512;
		         int k = i - 1;
		         int l = 0;

		         for(BlockPos blockpos : BlockPos.betweenClosed(p_204035_1_, p_204035_3_)) {
		            int i1 = blockpos.getX();
		            int j1 = blockpos.getZ();
		            int k1 = p_204035_1_.getY() - 1;
		            BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(i1, k1, j1);
		            BlockState blockstate = p_204035_2_.getBlockState(blockpos$mutable);

		            for(FluidState fluidstate = p_204035_2_.getFluidState(blockpos$mutable); (blockstate.isAir() || fluidstate.is(FluidTags.WATER) || blockstate.getBlock().is(BlockTags.ICE)) && k1 > 1; fluidstate = p_204035_2_.getFluidState(blockpos$mutable)) {
		               --k1;
		               blockpos$mutable.set(i1, k1, j1);
		               blockstate = p_204035_2_.getBlockState(blockpos$mutable);
		            }

		            j = Math.min(j, k1);
		            if (k1 < k - 2) {
		               ++l;
		            }
		         }

		         int l1 = Math.abs(p_204035_1_.getX() - p_204035_3_.getX());
		         if (k - j > 2 && l > l1 - 2) {
		            i = j + 1;
		         }

		         return i;
		      }
		   }
		}