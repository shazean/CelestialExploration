package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.datagen.util.PlanetTeleport;
import com.shim.celestialexploration.datagen.util.PlanetTeleportProvider;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialDimensions;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class PlanetTeleports extends PlanetTeleportProvider {
    public PlanetTeleports(DataGenerator generatorIn, String modid, ExistingFileHelper fileHelperIn) {
        super(generatorIn, modid, fileHelperIn);
    }

    @Override
    protected void register(Consumer<PlanetTeleport> consumer, ExistingFileHelper fileHelper) {

        PlanetTeleport.Builder.teleporter().dimension(CelestialDimensions.MOON).coordinates(coord(-2, 0))
                .block(CelestialBlocks.MOON_STONE.get()).block(CelestialBlocks.MOON_DEEPSLATE.get()).block(CelestialBlocks.MOON_CORE.get()).save(consumer, "moon");

        PlanetTeleport.Builder.teleporter().dimension(Level.OVERWORLD).coordinates(coord(-2, 0))
                .block(Blocks.STONE).block(Blocks.SANDSTONE).block(Blocks.WHITE_STAINED_GLASS).block(Blocks.GRASS_BLOCK).block(Blocks.SMOOTH_QUARTZ).block(Blocks.BLUE_STAINED_GLASS)
                .block(Blocks.ICE).block(Blocks.PACKED_ICE).block(Blocks.DEEPSLATE).block(Blocks.BEDROCK).save(consumer, "earth");

        PlanetTeleport.Builder.teleporter().dimension(CelestialDimensions.MARS).coordinates(coord(1, -3))
                .block(CelestialBlocks.MARS_STONE.get()).block(CelestialBlocks.MARS_DEEPSLATE.get()).block(CelestialBlocks.DRY_ICE.get()).block(CelestialBlocks.MARS_CORE.get()).save(consumer, "mars");

        PlanetTeleport.Builder.teleporter().dimension(CelestialDimensions.VENUS).coordinates(coord(0, 2))
                .block(CelestialBlocks.VENUS_STONE.get()).block(CelestialBlocks.VENUS_DEEPSLATE.get()).block(Blocks.YELLOW_STAINED_GLASS).block(CelestialBlocks.VENUS_CORE.get()).save(consumer, "venus");

        PlanetTeleport.Builder.teleporter().dimension(CelestialDimensions.MERCURY).coordinates(coord(1, 1))
                .block(CelestialBlocks.MERCURY_STONE.get()).block(CelestialBlocks.MERCURY_DEEPSLATE.get()).block(CelestialBlocks.MERCURY_CORE.get()).save(consumer, "mercury");

        PlanetTeleport.Builder.teleporter().dimension(CelestialDimensions.JUPITER).coordinates(coord(6, 2))
                .block(CelestialBlocks.JUPITER_DEEPSLATE.get()).block(CelestialBlocks.JUPITER_ATMOSPHERE.get()).block(Blocks.WHITE_STAINED_GLASS).block(Blocks.GRAY_STAINED_GLASS)
                .block(Blocks.BROWN_STAINED_GLASS).block(Blocks.RED_STAINED_GLASS).block(Blocks.ORANGE_STAINED_GLASS).block(CelestialBlocks.JUPITER_CORE.get()).save(consumer, "jupiter");

        PlanetTeleport.Builder.teleporter().dimension(CelestialDimensions.EUROPA).coordinates(coord(6, 2))
                .block(CelestialBlocks.EUROPA_CORE.get()).block(CelestialBlocks.EUROPA_HYDRATE.get()).block(CelestialBlocks.MOON_STONE.get()).save(consumer, "europa");

        PlanetTeleport.Builder.teleporter().dimension(CelestialDimensions.CALLISTO).coordinates(coord(6, 2))
                .block(CelestialBlocks.CALLISTO_CORE.get()).block(Blocks.ICE).block(CelestialBlocks.MOON_COBBLED_DEEPSLATE.get()).block(CelestialBlocks.COARSE_MOON_SAND.get()).save(consumer, "callisto");

        PlanetTeleport.Builder.teleporter().dimension(CelestialDimensions.IO).coordinates(coord(6, 2))
                .block(CelestialBlocks.IO_CORE.get()).block(CelestialBlocks.IO_STONE.get()).block(CelestialBlocks.IO_DEEPSLATE.get()).save(consumer, "io");

//        PlanetTeleport.Builder.teleporter().dimension(DimensionRegistry.GANYMEDE).coordinates(coord(6, 2))
//                .block(BlockRegistry.GANYMEDE_CORE.get()).block(BlockRegistry.MOON_COBBLESTONE.get()).block(BlockRegistry.MOON_DEEPSLATE.get()).save(consumer, "ganymede");


    }
}