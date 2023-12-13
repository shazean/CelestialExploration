package com.shim.celestialexploration.world.structures;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.util.CelestialUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
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
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Random;

public class SmallAsteroidStructure extends StructureFeature<JigsawConfiguration> {
    static Random rand = new Random();

    public static final Codec<JigsawConfiguration> CODEC = RecordCodecBuilder.create((codec) -> {
        return codec.group(
                StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(JigsawConfiguration::startPool),
                Codec.intRange(0, 30).fieldOf("size").forGetter(JigsawConfiguration::maxDepth)
        ).apply(codec, JigsawConfiguration::new);
    });

    public SmallAsteroidStructure() {
        super(CODEC, SmallAsteroidStructure::createPiecesGenerator, PostPlacementProcessor.NONE);
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    private static boolean isFeatureChunk(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
        // Grabs the chunk position we are at
        ChunkPos chunkpos = context.chunkPos();

        boolean asteroidBelt = true;
        boolean kuiperBelt = true;

        //ASTEROID BELT
        //Not inside of large circle
        if (!CelestialUtil.isPointInCircle(0, 0, CelestialUtil.getCalculatedCircleRadius(4.5), chunkpos.x, chunkpos.z)) {
            asteroidBelt = false;
        }

        //only check if we didn't eliminate the asteroid belt in the previous step
        //eliminate the inner circle
        if (asteroidBelt && CelestialUtil.isPointInCircle(0, 0, CelestialUtil.getCalculatedCircleRadius(4.0), chunkpos.x, chunkpos.z)) {
            asteroidBelt = false;
        }

        //KUIPER BELT
        //Not inside of large circle
        if (!CelestialUtil.isPointInCircle(0, 0, CelestialUtil.getCalculatedCircleRadius(28.0), chunkpos.x, chunkpos.z)) {
            kuiperBelt = false;
        }

        //only check if we didn't eliminate the asteroid belt in the previous step
        //eliminate the inner circle
        if (kuiperBelt && CelestialUtil.isPointInCircle(0, 0, CelestialUtil.getCalculatedCircleRadius(26.25), chunkpos.x, chunkpos.z)) {
            kuiperBelt = false;
        }

        return asteroidBelt || kuiperBelt;
    }

    public static @NotNull Optional<PieceGenerator<JigsawConfiguration>> createPiecesGenerator(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {

        if (!SmallAsteroidStructure.isFeatureChunk(context)) {
            return Optional.empty();
        }

        BlockPos blockpos = context.chunkPos().getMiddleBlockPosition(0);

        int y = 32 + rand.nextInt(64);

        blockpos = new BlockPos(blockpos.getX(), y, blockpos.getZ());

        Optional<PieceGenerator<JigsawConfiguration>> structurePiecesGenerator = JigsawPlacement.addPieces(context, PoolElementStructurePiece::new, blockpos, false,false);

        if(structurePiecesGenerator.isPresent()) {
//            CelestialExploration.LOGGER.log(Level.DEBUG, "Small asteroid at {}", blockpos);
        }

        return structurePiecesGenerator;
    }
}