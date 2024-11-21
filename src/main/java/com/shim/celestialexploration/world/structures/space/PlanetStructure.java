package com.shim.celestialexploration.world.structures.space;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.util.CelestialUtil;
import com.shim.celestialexploration.world.structures.CelestialConfiguration;
import com.shim.celestialexploration.world.structures.CelestialPlacement;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.PostPlacementProcessor;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class PlanetStructure extends StructureFeature<CelestialConfiguration> {

//    public static final Codec<CelestialConfiguration> CODEC = RecordCodecBuilder.create((codec) -> {
//        return codec.group(
//                StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(CelestialConfiguration::startPool),
//                Codec.intRange(0, 30).fieldOf("size").forGetter(CelestialConfiguration::maxDepth)
//        ).apply(codec, CelestialConfiguration::new);
//    });

    public PlanetStructure() {
        super(CelestialConfiguration.CODEC, PlanetStructure::createPiecesGenerator, PostPlacementProcessor.NONE);
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    private static boolean isFeatureChunk(PieceGeneratorSupplier.Context<CelestialConfiguration> context) {
        ChunkPos chunkpos = context.chunkPos();

//        Vec3 coordinates = CelestialUtil.getPlanetaryChunkCoordinates(3);
        return chunkpos.x == (context.config().x() * CelestialUtil.getSpaceRatio()) && chunkpos.z == (context.config().z() * CelestialUtil.getSpaceRatio());
    }

    public static @NotNull Optional<PieceGenerator<CelestialConfiguration>> createPiecesGenerator(PieceGeneratorSupplier.Context<CelestialConfiguration> context) {
        if (!PlanetStructure.isFeatureChunk(context)) {
            return Optional.empty();
        }

        BlockPos blockpos = context.chunkPos().getMiddleBlockPosition(0);

        blockpos = new BlockPos(blockpos.getX(), 64, blockpos.getZ());

        Optional<PieceGenerator<CelestialConfiguration>> structurePiecesGenerator =
                CelestialPlacement.addPieces(context, PoolElementStructurePiece::new, blockpos, false, false);

        if(structurePiecesGenerator.isPresent()) {
//            CelestialExploration.LOGGER.log(Level.DEBUG, "Planet at {}", blockpos);
        }

        return structurePiecesGenerator;
    }
}