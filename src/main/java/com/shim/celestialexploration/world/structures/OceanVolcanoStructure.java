package com.shim.celestialexploration.world.structures;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.PostPlacementProcessor;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.apache.logging.log4j.Level;

import java.util.Optional;

public class OceanVolcanoStructure extends StructureFeature<JigsawConfiguration> {

    public static final Codec<JigsawConfiguration> CODEC = RecordCodecBuilder.create((codec) -> codec.group(
            StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(JigsawConfiguration::startPool),
            Codec.intRange(0, 30).fieldOf("size").forGetter(JigsawConfiguration::maxDepth)
    ).apply(codec, JigsawConfiguration::new));

    public OceanVolcanoStructure() {
        super(CODEC, OceanVolcanoStructure::createPiecesGenerator, PostPlacementProcessor.NONE);
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

        if (!OceanVolcanoStructure.isFeatureChunk(context)) {
            return Optional.empty();
        }

        BlockPos blockpos = context.chunkPos().getMiddleBlockPosition(0);
        blockpos = blockpos.below(20);

        Optional<PieceGenerator<JigsawConfiguration>> structurePiecesGenerator = JigsawPlacement.addPieces(context, PoolElementStructurePiece::new, blockpos, false, true);

        if(structurePiecesGenerator.isPresent()) {
            CelestialExploration.LOGGER.log(Level.DEBUG, "Volcano at {}", blockpos);
        }

        return structurePiecesGenerator;
    }


}
