//package mod.shim.celestialexploration.world.gen.feature.structure;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
//
//import javax.annotation.Nullable;
//
//import com.google.common.collect.ImmutableMap;
//
//import mod.shim.celestialexploration.Main;
//import mod.shim.celestialexploration.world.gen.feature.CelestialFeature;
//import net.minecraft.block.Blocks;
//import net.minecraft.nbt.CompoundNBT;
//import net.minecraft.tileentity.ChestTileEntity;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.util.Direction;
//import net.minecraft.util.Mirror;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.Rotation;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.ChunkPos;
//import net.minecraft.util.math.MutableBoundingBox;
//import net.minecraft.world.IServerWorld;
//import net.minecraft.world.IWorld;
//import net.minecraft.world.gen.ChunkGenerator;
//import net.minecraft.world.gen.feature.structure.MineshaftPieces;
//import net.minecraft.world.gen.feature.structure.MineshaftStructure;
//import net.minecraft.world.gen.feature.structure.StructurePiece;
//import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
//import net.minecraft.world.gen.feature.template.PlacementSettings;
//import net.minecraft.world.gen.feature.template.Template;
//import net.minecraft.world.gen.feature.template.TemplateManager;
//
//public class CraterMeteorPiece {
////	   private boolean placedMainChest;
////	   private boolean placedHiddenChest;
////	   private boolean placedTrap1;
////	   private boolean placedTrap2;
////	   private static final SmallCraterPiece.Selector MOSS_STONE_SELECTOR = new SmallCraterPiece.Selector();
//
//	private static final ResourceLocation SMALL_CRATER_GOLD = new ResourceLocation(Main.MODID + ":small_crater_gold"); //
//	private static final ResourceLocation SMALL_CRATER_EMERALD = new ResourceLocation(Main.MODID + ":small_crater_emerald"); // /
//	private static final ResourceLocation SMALL_CRATER_IRON = new ResourceLocation(Main.MODID + ":small_crater_iron"); ///
//	private static final ResourceLocation SMALL_CRATER_LAPIS_LAZULI = new ResourceLocation(Main.MODID + ":small_crater_lapis_lazuli"); //
//	private static final ResourceLocation SMALL_CRATER_REDSTONE = new ResourceLocation(Main.MODID + ":small_crater_redstone"); //
//	private static final ResourceLocation SMALL_CRATER_COAL = new ResourceLocation(Main.MODID + ":small_crater_coal"); ////
//	private static final ResourceLocation SMALL_CRATER_DIAMOND = new ResourceLocation(Main.MODID + ":small_crater_diamond"); // /
//	private static final ResourceLocation MEDIUM_CRATER_GOLD = new ResourceLocation(Main.MODID + ":medium_crater_gold"); //
//	private static final ResourceLocation MEDIUM_CRATER_EMERALD = new ResourceLocation(Main.MODID + ":medium_crater_emerald"); // /
//	private static final ResourceLocation MEDIUM_CRATER_IRON = new ResourceLocation(Main.MODID + ":medium_crater_iron"); ///
//	private static final ResourceLocation MEDIUM_CRATER_LAPIS_LAZULI = new ResourceLocation(Main.MODID + ":medium_crater_lapis_lazuli"); //
//	private static final ResourceLocation MEDIUM_CRATER_REDSTONE = new ResourceLocation(Main.MODID + ":medium_crater_redstone"); //
//	private static final ResourceLocation MEDIUM_CRATER_COAL = new ResourceLocation(Main.MODID + ":medium_crater_coal"); ////
//	private static final ResourceLocation MEDIUM_CRATER_DIAMOND = new ResourceLocation(Main.MODID + ":medium_crater_diamond"); // /
//	private static final ResourceLocation LARGE_CRATER_GOLD = new ResourceLocation(Main.MODID + ":large_crater_gold"); //
//	private static final ResourceLocation LARGE_CRATER_EMERALD = new ResourceLocation(Main.MODID + ":large_crater_emerald"); // /
//	private static final ResourceLocation LARGE_CRATER_IRON = new ResourceLocation(Main.MODID + ":large_crater_iron"); ///
//	private static final ResourceLocation LARGE_CRATER_LAPIS_LAZULI = new ResourceLocation(Main.MODID + ":large_crater_lapis_lazuli"); //
//	private static final ResourceLocation LARGE_CRATER_REDSTONE = new ResourceLocation(Main.MODID + ":large_crater_redstone"); //
//	private static final ResourceLocation LARGE_CRATER_COAL = new ResourceLocation(Main.MODID + ":large_crater_coal"); ////
//	private static final ResourceLocation LARGE_CRATER_DIAMOND = new ResourceLocation(Main.MODID + ":large_crater_diamond"); // /
//	private static final ResourceLocation SMALL_CRATER_METEOR = new ResourceLocation(Main.MODID + ":small_crater_meteor"); // /
//	private static final ResourceLocation MEDIUM_CRATER_METEOR = new ResourceLocation(Main.MODID + ":medium_crater_meteor"); // /
//	private static final ResourceLocation LARGE_CRATER_METEOR = new ResourceLocation(Main.MODID + ":large_crater_meteor"); // /
//	
// //	private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.of(SMALL_CRATER, new BlockPos(0, 1, 0));
//	static Random rand = new Random(80);
//	
//	private static ResourceLocation createRandomMeteorPiece(Random rand) {
//		
//		
//		if (rand.nextInt() <= 2) {
//			return SMALL_CRATER_GOLD;
//		}
//		else if (rand.nextInt() == 3) {
//			return SMALL_CRATER_EMERALD;
//		}
//
//		else if (rand.nextInt() <= 6) {
//			return SMALL_CRATER_IRON;
//		}
//
//		else if (rand.nextInt() <= 8) {
//			return SMALL_CRATER_LAPIS_LAZULI;
//		}
//		
//		else if (rand.nextInt() <= 10) {
//			return SMALL_CRATER_REDSTONE;
//			}
//
//		else if (rand.nextInt() == 11) {
//			return SMALL_CRATER_DIAMOND;	
//			}
//		
//		else if (rand.nextInt() <15) {
//			return SMALL_CRATER_COAL;
//		}
//			
//		else if (rand.nextInt() <= 18) {
//			return MEDIUM_CRATER_GOLD;
//		}
//			
//			else if (rand.nextInt() == 19) {
//			return MEDIUM_CRATER_EMERALD;
//			}
//			
//			else if (rand.nextInt() <= 22) {
//			return MEDIUM_CRATER_IRON;
//			}
//
//			else if (rand.nextInt() <= 24) {
//			return MEDIUM_CRATER_LAPIS_LAZULI;
//			}
//		
//			else if (rand.nextInt() <= 26) {
//			return MEDIUM_CRATER_REDSTONE;
//			}
//			
//			else if (rand.nextInt() == 27) {
//				return MEDIUM_CRATER_DIAMOND;
//			}
//		
//			else if (rand.nextInt() <= 32) {
//			return MEDIUM_CRATER_COAL;
//			}
//			
//			else if (rand.nextInt() <= 35) {
//			return LARGE_CRATER_GOLD;
//			}
//			
//			else if (rand.nextInt() == 36) {
//			return LARGE_CRATER_EMERALD;
//			}
//			
//			else if (rand.nextInt() <= 39) {
//			return LARGE_CRATER_IRON;
//			}
//		
//			else if (rand.nextInt() <= 41) {
//			return LARGE_CRATER_LAPIS_LAZULI;
//			}
//			
//			else if (rand.nextInt() <= 43) {
//			return LARGE_CRATER_REDSTONE;
//			}
//		
//		else if (rand.nextInt() == 44) {
//			return LARGE_CRATER_DIAMOND;
//		}
//			
//		else if (rand.nextInt() <= 49) {
//			return LARGE_CRATER_COAL;
//		}
//			
//		else if (rand.nextInt() <= 59) {
//			return SMALL_CRATER_METEOR;
//		}
//		
//			else if (rand.nextInt() <= 69) {
//			return MEDIUM_CRATER_METEOR;
//			}
//			
//			else if (rand.nextInt() <= 79) {
//			return LARGE_CRATER_METEOR;
//			}
//			
//			else {
//			return SMALL_CRATER_METEOR;
//
//		}
//	}
//	
//	
//	private static final Map<ResourceLocation, BlockPos> METEOR_PIECE = ImmutableMap.of(createRandomMeteorPiece(rand), new BlockPos(0, 0, 0));
//
//	
////	   private static MineshaftPieces.Piece createRandomShaftPiece(List<StructurePiece> p_189940_0_, Random p_189940_1_, int p_189940_2_, int p_189940_3_, int p_189940_4_, @Nullable Direction p_189940_5_, int p_189940_6_, MineshaftStructure.Type p_189940_7_) {
////	      int i = p_189940_1_.nextInt(100);
////	      if (i >= 80) {
////	         MutableBoundingBox mutableboundingbox = MineshaftPieces.Cross.findCrossing(p_189940_0_, p_189940_1_, p_189940_2_, p_189940_3_, p_189940_4_, p_189940_5_);
////	         if (mutableboundingbox != null) {
////	            return new MineshaftPieces.Cross(p_189940_6_, mutableboundingbox, p_189940_5_, p_189940_7_);
////	         }
////	      } else if (i >= 70) {
////	         MutableBoundingBox mutableboundingbox1 = MineshaftPieces.Stairs.findStairs(p_189940_0_, p_189940_1_, p_189940_2_, p_189940_3_, p_189940_4_, p_189940_5_);
////	         if (mutableboundingbox1 != null) {
////	            return new MineshaftPieces.Stairs(p_189940_6_, mutableboundingbox1, p_189940_5_, p_189940_7_);
////	         }
////	      } else {
////	         MutableBoundingBox mutableboundingbox2 = MineshaftPieces.Corridor.findCorridorSize(p_189940_0_, p_189940_1_, p_189940_2_, p_189940_3_, p_189940_4_, p_189940_5_);
////	         if (mutableboundingbox2 != null) {
////	            return new MineshaftPieces.Corridor(p_189940_6_, p_189940_1_, mutableboundingbox2, p_189940_5_, p_189940_7_);
////	         }
////	      }
////
////	      return null;
////	   }
//	
//	/*
//	 * Begins assembling your structure and where the pieces needs to go.
//	 */
//	public static void start(TemplateManager templateManager, BlockPos pos, Rotation rotation, List<StructurePiece> pieceList, Random random)
//	{
//				
//		int x = pos.getX();
//		int z = pos.getZ();
//
//		//This is how we factor in rotation for multi-piece structures. 
//		//
//		//I would recommend using the OFFSET map above to have each piece at correct height relative of each other 
//		//and keep the X and Z equal to 0. And then in rotations, have the centermost piece have a rotation 
//		//of 0, 0, 0 and then have all other pieces' rotation be based off of the bottommost left corner of 
//		//that piece (the corner that is smallest in X and Z). 
//		//
//		//Lots of trial and error may be needed to get this right for your structure.
//		BlockPos rotationOffSet = new BlockPos(0, -3, 0).rotate(rotation);
//		BlockPos blockpos = rotationOffSet.offset(x, pos.getY(), z);
//		pieceList.add(new CraterMeteorPiece.Piece(templateManager, createRandomMeteorPiece(rand), blockpos, rotation));
//	}
//
//	/*
//	 * Here's where some voodoo happens. Most of this doesn't need to be touched but you do have to pass in the
//	 * IStructurePieceType you registered into the super constructors.
//	 * 
//	 * The method you will most likely want to touch is the handleDataMarker method.
//	 */
//	public static class Piece extends TemplateStructurePiece
//	{
//		private ResourceLocation resourceLocation;
//		private Rotation rotation;
//
//
//		public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos, Rotation rotationIn)
//		{
//			super(CelestialFeature.CMP, 0);
//			this.resourceLocation = resourceLocationIn;
//			BlockPos blockpos = CraterMeteorPiece.METEOR_PIECE.get(resourceLocation);
//			this.templatePosition = pos.offset(blockpos.getX(), blockpos.getY(), blockpos.getZ());
//			this.rotation = rotationIn;
//			this.setupPiece(templateManagerIn);
//		}
//
//
//		public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound)
//		{
//			super(CelestialFeature.CMP, tagCompound);
//			this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
//			this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
//			this.setupPiece(templateManagerIn);
//		}
//
//
//		private void setupPiece(TemplateManager templateManager)
//		{
//			Template template = templateManager.getTemplateDefaulted(this.resourceLocation);
//			PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE);
//			this.setup(template, this.templatePosition, placementsettings);
//		}
//
//
//		/**
//		 * (abstract) Helper method to read subclass data from NBT
//		 */
//		@Override
//		protected void readAdditional(CompoundNBT tagCompound)
//		{
//			super.readAdditional(tagCompound);
//			tagCompound.putString("Template", this.resourceLocation.toString());
//			tagCompound.putString("Rot", this.rotation.name());
//		}
//
//
//		/*
//		 * If you added any data marker structure blocks to your structure, you can access and modify them here. In this case,
//		 * our structure has a data maker with the string "chest" put into it. So we check to see if the incoming function is
//		 * "chest" and if it is, we now have that exact position.
//		 * 
//		 * So what is done here is we replace the structure block with a chest and we can then set the loottable for it.
//		 * 
//		 * You can set other data markers to do other behaviors such as spawn a random mob in a certain spot, randomize what
//		 * rare block spawns under the floor, or what item an Item Frame will have.
//		 */
//		@Override
//		protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand, MutableBoundingBox sbb)
//		{
//			if ("chest".equals(function))
//			{
//				worldIn.setBlockState(pos, Blocks.CHEST.getDefaultState(), 2);
//				TileEntity tileentity = worldIn.getTileEntity(pos);
//
//				//Just another check to make sure everything is going well before we try to set the chest.
//				if (tileentity instanceof ChestTileEntity)
//				{
//					//((ChestTileEntity) tileentity).setLootTable(<resource_location_to_loottable>, rand.nextLong());
//
//				}
//			}
//		}
//
//		
//		// This may be called func_225577_a_ instead of create on older mappings
//		@Override
//		public boolean create(IWorld worldIn, ChunkGenerator<?> p_225577_2_, Random randomIn, MutableBoundingBox structureBoundingBoxIn, ChunkPos chunkPos)
//		{
//			PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE);
//			BlockPos blockpos = CraterMeteorPiece.METEOR_PIECE.get(this.resourceLocation);
//			this.templatePosition.add(Template.transformedBlockPos(placementsettings, new BlockPos(0 - blockpos.getX(), 0, 0 - blockpos.getZ())));
//
//			return super.create(worldIn, p_225577_2_, randomIn, structureBoundingBoxIn, chunkPos);
//		}
//
//
//		@Override
//		protected void handleDataMarker(String p_186175_1_, BlockPos p_186175_2_, IServerWorld p_186175_3_,
//				Random p_186175_4_, MutableBoundingBox p_186175_5_) {
//			// TODO Auto-generated method stub
//			
//		}
//	}
//
//}
//
