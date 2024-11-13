package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.datagen.util.DimensionTeleport;
import com.shim.celestialexploration.datagen.util.DimensionTeleportProvider;
import com.shim.celestialexploration.registry.DimensionRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class DimensionTeleports extends DimensionTeleportProvider {
    public DimensionTeleports(DataGenerator generatorIn, String modid, ExistingFileHelper fileHelperIn) {
        super(generatorIn, modid, fileHelperIn);
    }

    @Override
    protected void register(Consumer<DimensionTeleport> consumer, ExistingFileHelper fileHelper) {

        DimensionTeleport.Builder.teleporter().dimension(DimensionRegistry.MOON).coordinates(coord(-2, 0)).save(consumer, "moon");
        DimensionTeleport.Builder.teleporter().dimension(Level.OVERWORLD).coordinates(coord(-2, 0)).save(consumer, "earth");
        DimensionTeleport.Builder.teleporter().dimension(DimensionRegistry.MARS).coordinates(coord(1, -3)).save(consumer, "mars");
        DimensionTeleport.Builder.teleporter().dimension(DimensionRegistry.VENUS).coordinates(coord(0, 2)).save(consumer, "venus");
        DimensionTeleport.Builder.teleporter().dimension(DimensionRegistry.MERCURY).coordinates(coord(1, 1)).save(consumer, "mercury");
        DimensionTeleport.Builder.teleporter().dimension(DimensionRegistry.JUPITER).coordinates(coord(6, 2)).save(consumer, "jupiter");

        DimensionTeleport.Builder.teleporter().dimension(DimensionRegistry.EUROPA).coordinates(coord(6, 2)).save(consumer, "europa");

//        DimensionTeleport.Builder.teleporter().dimension(Level.END).coordinates(coord(-4, 2)).save(consumer, "the_end");
        DimensionTeleport.Builder.teleporter().dimension(Level.END).coordinateScale(0.75D).save(consumer, "the_end");

    }
}