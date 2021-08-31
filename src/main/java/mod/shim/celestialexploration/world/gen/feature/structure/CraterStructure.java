package mod.shim.celestialexploration.world.gen.feature.structure;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.Level;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.registry.RegistryStructures;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.DesertPyramidPiece;
import net.minecraft.world.gen.feature.structure.DesertPyramidStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class CraterStructure extends Structure<NoFeatureConfig> {
	   public CraterStructure(Codec<NoFeatureConfig> p_i231947_1_) {
		      super(p_i231947_1_);
		   }

		   public Structure.IStartFactory<NoFeatureConfig> getStartFactory() {
		      return DesertPyramidStructure.Start::new;
		   }

		   public static class Start extends StructureStart<NoFeatureConfig> {
		      public Start(Structure<NoFeatureConfig> p_i225801_1_, int p_i225801_2_, int p_i225801_3_, MutableBoundingBox p_i225801_4_, int p_i225801_5_, long p_i225801_6_) {
		         super(p_i225801_1_, p_i225801_2_, p_i225801_3_, p_i225801_4_, p_i225801_5_, p_i225801_6_);
		      }

		      public void generatePieces(DynamicRegistries p_230364_1_, ChunkGenerator p_230364_2_, TemplateManager p_230364_3_, int p_230364_4_, int p_230364_5_, Biome p_230364_6_, NoFeatureConfig p_230364_7_) {
		         CraterPiece craterpiece = new CraterPiece(RegistryStructures.CRATER.get(), null);
		         this.pieces.add(craterpiece);
		         this.calculateBoundingBox();
		      }
		   }
		}