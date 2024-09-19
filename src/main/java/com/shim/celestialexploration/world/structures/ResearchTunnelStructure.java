package com.shim.celestialexploration.world.structures;

import com.mojang.serialization.Codec;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.world.features.ResearchTunnelConfiguration;
import net.minecraft.core.QuartPos;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.structure.PostPlacementProcessor;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ResearchTunnelStructure extends StructureFeature<ResearchTunnelConfiguration> {

    public ResearchTunnelStructure() {
        super(ResearchTunnelConfiguration.CODEC, PieceGeneratorSupplier.simple(ResearchTunnelStructure::checkLocation, ResearchTunnelStructure::generatePieces), PostPlacementProcessor.NONE);
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.UNDERGROUND_STRUCTURES;
    }

    public static boolean checkLocation(PieceGeneratorSupplier.Context<ResearchTunnelConfiguration> context) {
        WorldgenRandom worldgenrandom = new WorldgenRandom(new LegacyRandomSource(0L));
        worldgenrandom.setLargeFeatureSeed(context.seed(), context.chunkPos().x, context.chunkPos().z);
        double d0 = (context.config()).probability;
        return !(worldgenrandom.nextDouble() >= d0) && context.validBiome().test(context.chunkGenerator().getNoiseBiome(QuartPos.fromBlock(context.chunkPos().getMiddleBlockX()), QuartPos.fromBlock(50), QuartPos.fromBlock(context.chunkPos().getMiddleBlockZ())));
    }

    public static void generatePieces(StructurePiecesBuilder builder, PieceGenerator.Context<ResearchTunnelConfiguration> context) {
        ResearchTunnelPieces.ResearchTunnelRoom tunnelpieces$tunnelroom = new ResearchTunnelPieces.ResearchTunnelRoom(0, context.random(), context.chunkPos().getBlockX(2), context.chunkPos().getBlockZ(2), (context.config()).type);
        builder.addPiece(tunnelpieces$tunnelroom);
        tunnelpieces$tunnelroom.addChildren(tunnelpieces$tunnelroom, builder, context.random());
        int i = context.chunkGenerator().getSeaLevel();
        builder.moveBelowSeaLevel(i, context.chunkGenerator().getMinY(), context.random(), 10);
    }

    public enum Type implements StringRepresentable {
        MARS("mars", BlockRegistry.MARS_BRICKS.get(), BlockRegistry.MARS_BRICKS.get(), BlockRegistry.MARS_BRICK_WALL.get()),
        MOON("moon", BlockRegistry.MOON_BRICKS.get(), BlockRegistry.MOON_BRICKS.get(), BlockRegistry.MOON_BRICK_WALL.get()),
        VENUS("venus", BlockRegistry.VENUS_BRICKS.get(), BlockRegistry.VENUS_BRICKS.get(), BlockRegistry.VENUS_BRICK_WALL.get()),
        MERCURY("mercury", BlockRegistry.MERCURY_BRICKS.get(), BlockRegistry.MERCURY_BRICKS.get(), BlockRegistry.MERCURY_BRICK_WALL.get());

        public static final Codec<ResearchTunnelStructure.Type> CODEC = StringRepresentable.fromEnum(ResearchTunnelStructure.Type::values, ResearchTunnelStructure.Type::byName);
        private static final Map<String, ResearchTunnelStructure.Type> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(ResearchTunnelStructure.Type::getName, (p_66333_) -> p_66333_));
        private final String name;
        private final BlockState woodState;
        private final BlockState planksState;
        private final BlockState fenceState;

        Type(String name, Block woodState, Block plank, Block fence) {
            this.name = name;
            this.woodState = woodState.defaultBlockState();
            this.planksState = plank.defaultBlockState();
            this.fenceState = fence.defaultBlockState();
        }

        public String getName() {
            return this.name;
        }

        private static ResearchTunnelStructure.Type byName(String name) {
            return BY_NAME.get(name);
        }

        public static ResearchTunnelStructure.Type byId(int id) {
            return id >= 0 && id < values().length ? values()[id] : MOON;
        }

        public BlockState getWoodState() {
            return this.woodState;
        }

        public BlockState getPlanksState() {
            return this.planksState;
        }

        public BlockState getFenceState() {
            return this.fenceState;
        }

        public String getSerializedName() {
            return this.name;
        }
    }
}