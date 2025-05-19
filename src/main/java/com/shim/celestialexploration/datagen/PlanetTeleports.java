package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.datagen.util.PlanetTeleport;
import com.shim.celestialexploration.datagen.util.PlanetTeleportProvider;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.DimensionRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class PlanetTeleports extends PlanetTeleportProvider {
    public PlanetTeleports(DataGenerator generatorIn, String modid, ExistingFileHelper fileHelperIn) {
        super(generatorIn, modid, fileHelperIn);
    }

    @Override
    protected void register(Consumer<PlanetTeleport> consumer, ExistingFileHelper fileHelper) {

        PlanetTeleport.Builder.teleporter().dimension(DimensionRegistry.MOON).coordinates(coord(-2, 0))
                .block(BlockRegistry.MOON_STONE.get()).block(BlockRegistry.MOON_DEEPSLATE.get()).block(BlockRegistry.MOON_CORE.get()).save(consumer, "moon");

        PlanetTeleport.Builder.teleporter().dimension(Level.OVERWORLD).coordinates(coord(-2, 0))
                .block(Blocks.STONE).block(Blocks.SANDSTONE).block(Blocks.WHITE_STAINED_GLASS).block(Blocks.GRASS_BLOCK).block(Blocks.SMOOTH_QUARTZ).block(Blocks.BLUE_STAINED_GLASS)
                .block(Blocks.ICE).block(Blocks.PACKED_ICE).block(Blocks.DEEPSLATE).block(Blocks.BEDROCK).save(consumer, "earth");

        PlanetTeleport.Builder.teleporter().dimension(DimensionRegistry.MARS).coordinates(coord(1, -3))
                .block(BlockRegistry.MARS_STONE.get()).block(BlockRegistry.MARS_DEEPSLATE.get()).block(BlockRegistry.DRY_ICE.get()).block(BlockRegistry.MARS_CORE.get()).save(consumer, "mars");

        PlanetTeleport.Builder.teleporter().dimension(DimensionRegistry.VENUS).coordinates(coord(0, 2))
                .block(BlockRegistry.VENUS_STONE.get()).block(BlockRegistry.VENUS_DEEPSLATE.get()).block(Blocks.YELLOW_STAINED_GLASS).block(BlockRegistry.VENUS_CORE.get()).save(consumer, "venus");

        PlanetTeleport.Builder.teleporter().dimension(DimensionRegistry.MERCURY).coordinates(coord(1, 1))
                .block(BlockRegistry.MERCURY_STONE.get()).block(BlockRegistry.MERCURY_DEEPSLATE.get()).block(BlockRegistry.MERCURY_CORE.get()).save(consumer, "mercury");

        PlanetTeleport.Builder.teleporter().dimension(DimensionRegistry.JUPITER).coordinates(coord(6, 2))
                .block(BlockRegistry.JUPITER_DEEPSLATE.get()).block(BlockRegistry.JUPITER_ATMOSPHERE.get()).block(Blocks.WHITE_STAINED_GLASS).block(Blocks.GRAY_STAINED_GLASS)
                .block(Blocks.BROWN_STAINED_GLASS).block(Blocks.RED_STAINED_GLASS).block(Blocks.ORANGE_STAINED_GLASS).block(BlockRegistry.JUPITER_CORE.get()).save(consumer, "jupiter");

        PlanetTeleport.Builder.teleporter().dimension(DimensionRegistry.EUROPA).coordinates(coord(6, 2))
                .block(BlockRegistry.EUROPA_CORE.get()).block(BlockRegistry.EUROPA_HYDRATE.get()).block(BlockRegistry.MOON_STONE.get()).save(consumer, "europa");

        PlanetTeleport.Builder.teleporter().dimension(DimensionRegistry.CALLISTO).coordinates(coord(6, 2))
                .block(BlockRegistry.CALLISTO_CORE.get()).block(Blocks.ICE).block(BlockRegistry.MOON_COBBLED_DEEPSLATE.get()).block(BlockRegistry.COARSE_MOON_SAND.get()).save(consumer, "callisto");

        PlanetTeleport.Builder.teleporter().dimension(DimensionRegistry.IO).coordinates(coord(6, 2))
                .block(BlockRegistry.IO_CORE.get()).block(BlockRegistry.IO_STONE.get()).block(BlockRegistry.IO_DEEPSLATE.get()).save(consumer, "io");

//        PlanetTeleport.Builder.teleporter().dimension(DimensionRegistry.GANYMEDE).coordinates(coord(6, 2))
//                .block(BlockRegistry.GANYMEDE_CORE.get()).block(BlockRegistry.MOON_COBBLESTONE.get()).block(BlockRegistry.MOON_DEEPSLATE.get()).save(consumer, "ganymede");


    }
}