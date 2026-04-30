package com.shim.celestialexploration.world.structures;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialFluids;
import net.minecraft.core.*;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.BuiltinStructureSets;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.PostPlacementProcessor;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pools.EmptyPoolElement;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import org.apache.commons.lang3.mutable.MutableObject;
import org.apache.logging.log4j.Level;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class VolcanoStructure extends StructureFeature<JigsawConfiguration> {

    public static final Codec<JigsawConfiguration> CODEC = RecordCodecBuilder.create((codec) -> codec.group(
            StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(JigsawConfiguration::startPool),
            Codec.intRange(0, 30).fieldOf("size").forGetter(JigsawConfiguration::maxDepth)
    ).apply(codec, JigsawConfiguration::new));

    public VolcanoStructure() {
        super(CODEC, VolcanoStructure::createPiecesGenerator, PostPlacementProcessor.NONE);
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.LOCAL_MODIFICATIONS;
    }

    protected static boolean isFeatureChunk(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
//        ChunkPos chunkpos = context.chunkPos();
//
//        BlockPos centerOfChunkPos = context.chunkPos().getMiddleBlockPosition(0);
//        BlockPos initialPos = new BlockPos(centerOfChunkPos.getX(), centerOfChunkPos.getY(), centerOfChunkPos.getZ()).below(21);
//        NoiseColumn blockView = context.chunkGenerator().getBaseColumn(centerOfChunkPos.getX(), centerOfChunkPos.getZ(), context.heightAccessor());
//
//        BlockState state = blockView.getBlock(initialPos.getY());
//        CelestialExploration.LOGGER.debug("state is: " + state.getBlock().toString());
//        if (state.isAir() || state.getFluidState().is(Fluids.LAVA) || state.getFluidState().is(CelestialFluids.SULFUR.get())) return false;
//
//        state = blockView.getBlock(initialPos.west(36).getY());
//        if (state.isAir() || state.getFluidState().is(Fluids.LAVA) || state.getFluidState().is(CelestialFluids.SULFUR.get())) return false;
//
//        state = blockView.getBlock(initialPos.east(36).getY());
//        if (state.isAir() || state.getFluidState().is(Fluids.LAVA) || state.getFluidState().is(CelestialFluids.SULFUR.get())) return false;
//
//        state = blockView.getBlock(initialPos.north(36).getY());
//        if (state.isAir() || state.getFluidState().is(Fluids.LAVA) || state.getFluidState().is(CelestialFluids.SULFUR.get())) return false;
//
//        state = blockView.getBlock(initialPos.south(36).getY());
//        if (state.isAir() || state.getFluidState().is(Fluids.LAVA) || state.getFluidState().is(CelestialFluids.SULFUR.get())) return false;

        return true;

//        return !context.chunkGenerator().hasFeatureChunkInRange(BuiltinStructureSets.OCEAN_MONUMENTS, context.seed(), chunkpos.x, chunkpos.z, 10);
    }

    public static Optional<PieceGenerator<JigsawConfiguration>> createPiecesGenerator(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {

        if (!VolcanoStructure.isFeatureChunk(context)) {
            return Optional.empty();
        }

        BlockPos blockpos = context.chunkPos().getMiddleBlockPosition(0);
        blockpos = blockpos.below(1);

        Optional<PieceGenerator<JigsawConfiguration>> structurePiecesGenerator = JigsawPlacement.addPieces(context, PoolElementStructurePiece::new, blockpos, false, true);

        if(structurePiecesGenerator.isPresent()) {
            CelestialExploration.LOGGER.log(Level.DEBUG, "Volcano at {}", blockpos);
        }

        return structurePiecesGenerator;
    }

}