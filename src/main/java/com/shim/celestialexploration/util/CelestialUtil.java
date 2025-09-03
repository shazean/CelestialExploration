package com.shim.celestialexploration.util;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.registry.CelestialDimensions;
import com.shim.celestialexploration.registry.CelestialFluids;
import com.shim.celestialexploration.util.teleportation.AbstractCelestialTeleportData;
import com.shim.celestialexploration.util.teleportation.CelestialCoordinateTeleport;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CelestialUtil {

    public static ResourceLocation getModLoc(String texture) {
        return new ResourceLocation(CelestialExploration.MODID, texture);
    }

    public static int getSpaceRatio() {
        return CelestialCommonConfig.RANGE_OF_SPACE.get();
    }

    @Deprecated //to remove after all planet dimensions are added
    public static final Map<String, Vec3> PLANET_LOCATION = Util.make(new Object2ObjectArrayMap<>(), (dimension) -> {
        dimension.put("Mercury", new Vec3(1, 0, 1));
        dimension.put("Venus", new Vec3(0, 0, 2));
        dimension.put("Overworld", new Vec3(-2, 0, 0));
        dimension.put("Mars", new Vec3(1, 0, -3));
        dimension.put("Jupiter", new Vec3(6, 0, 2));
        dimension.put("Saturn", new Vec3(-2, 0, 10));
        dimension.put("Uranus", new Vec3(-15, 0, -3));
        dimension.put("Neptune", new Vec3(6, 0, -24));
    });

    protected static final Map<ResourceKey<Level>, Vec3> PLANET_LOCATIONS = new HashMap<>();
//    protected static final Vec3 defaultPlanetLocation = new Vec3(-2, 0, 0);

    public static Vec3 getPlanetLocation(ResourceKey<Level> dimension) {
        return PLANET_LOCATIONS.get(dimension);
    }

    public static Map<ResourceKey<Level>, Vec3> getPlanetLocations() {
        return PLANET_LOCATIONS;
    }

    public static Vec3 getPlanetaryChunkCoordinates(ResourceKey<Level> planet) {
        Vec3 coord = getPlanetLocation(planet); //CE_DIMENSION_LOCATION.get(planet); //getPlanetLocation(planet); //
//        if (coord == null) coord = CE_DIMENSION_LOCATION.get(Level.OVERWORLD);
        coord = new Vec3(coord.x * getSpaceRatio(), coord.y, coord.z * getSpaceRatio());
        return coord;
    }

    @Deprecated //to remove after all planet dimensions are added
    public static Vec3 getPlanetaryChunkCoordinates(int planetNum) {
        int x;
        int z;

        switch (planetNum) {
            case 1 -> { //MERCURY
                x = 1;
                z = 1;
            }
            case 2 -> { //VENUS
                x = 0;
                z = 2;
            }
            case 3 -> { //EARTH
                x = -2;
                z = 0;
            }
            case 4 -> { //MARS
                x = 1;
                z = -3;
            }
            case 5 -> { //JUPITER
                x = 6;
                z = 2;
            }
            case 6 -> { //SATURN
                x = -2;
                z = 10;
            }
            case 7 -> { //URANUS
                x = -15;
                z = -3;
            }
            case 8 -> { //NEPTUNE
                x = 6;
                z = -24;
            }
            default -> {
                x = 0;
                z = 0;
            }
        }
        x = x * getSpaceRatio();
        z = z * getSpaceRatio();

        return new Vec3(x, 0, z);
    }

    //Credit to: https://stackoverflow.com/questions/481144/equation-for-testing-if-a-point-is-inside-a-circle
    public static boolean isInRectangle(int centerX, int centerY, int radius, int x, int y) {
        return x >= centerX - radius && x <= centerX + radius &&
                y >= centerY - radius && y <= centerY + radius;
    }

    //Credit to: https://stackoverflow.com/questions/481144/equation-for-testing-if-a-point-is-inside-a-circle
    public static boolean isPointInCircle(int centerX, int centerY, int radius, int x, int y) {
        if (isInRectangle(centerX, centerY, radius, x, y)) {
            int dx = centerX - x;
            int dy = centerY - y;
            dx *= dx;
            dy *= dy;
            int distanceSquared = dx + dy;
            int radiusSquared = radius * radius;
            return distanceSquared <= radiusSquared;
        }
        return false;
    }

    public static int getCalculatedCircleRadius(double radius) {
        return (int) (radius * getSpaceRatio());
    }

    public static int getIdFromFluid(FluidStack fluidStack) {
        if (fluidStack.getFluid().isSame(Fluids.WATER)) {
            return 1;
        } else if (fluidStack.getFluid().isSame(Fluids.LAVA)) {
            return 2;
        } else if (fluidStack.getFluid().isSame(CelestialFluids.MOLTEN_IRON.get())) {
            return 3;
        } else if (fluidStack.getFluid().isSame(CelestialFluids.MOLTEN_STEEL.get())) {
            return 4;
        } else if (fluidStack.getFluid().isSame(CelestialFluids.MOLTEN_COPPER.get())) {
            return 5;
        } else if (fluidStack.getFluid().isSame(CelestialFluids.MOLTEN_GOLD.get())) {
            return 6;
//        } else if (blockEntity.fluidHandler.getFluid().getFluid().isSame(FluidRegistry.MOLTEN_NETHERITE.get())) {
//            blockEntity.fluidType = 7;
        } else if (fluidStack.getFluid().isSame(CelestialFluids.MOLTEN_ALUMINUM.get())) {
            return 8;
        } else {
            return 0;
        }
    }

    public static FluidStack getFluidFromId(int id, int amount) {
        return switch (id) {
            case 1 -> new FluidStack(Fluids.WATER, amount);
            case 2 -> new FluidStack(Fluids.LAVA, amount);
            case 3 -> new FluidStack(CelestialFluids.MOLTEN_IRON.get(), amount);
            case 4 -> new FluidStack(CelestialFluids.MOLTEN_STEEL.get(), amount);
            case 5 -> new FluidStack(CelestialFluids.MOLTEN_COPPER.get(), amount);
            case 6 -> new FluidStack(CelestialFluids.MOLTEN_GOLD.get(), amount);
//            case 7 -> new FluidStack(FluidRegistry.MOLTEN_NETHERITE.get(), amount);
            case 8 -> new FluidStack(CelestialFluids.MOLTEN_ALUMINUM.get(), amount);
            default -> FluidStack.EMPTY;
        };
    }

    public static int getIdFromDimension(ResourceKey<Level> dimension) {
        if (dimension.equals(CelestialDimensions.MERCURY)) {
            return 1;
        } else if (dimension.equals(CelestialDimensions.VENUS)) {
            return 2;
        } else if (dimension.equals(Level.OVERWORLD)) {
            return 3;
        } else if (dimension.equals(CelestialDimensions.MOON)) {
            return 4;
        } else if (dimension.equals(CelestialDimensions.MARS)) {
            return 5;
        } else if (dimension.equals(CelestialDimensions.JUPITER)) {
            return 6;
        } else {
            return 0;
        }
    }

    public static ResourceKey<Level> getDimensionFromId(int id) {
        return switch (id) {
            case 1 -> CelestialDimensions.MERCURY;
            case 2 -> CelestialDimensions.VENUS;
            case 3 -> Level.OVERWORLD;
            case 4 -> CelestialDimensions.MOON;
            case 5 -> CelestialDimensions.MARS;
            case 6 -> CelestialDimensions.JUPITER;
            default -> null;
        };
    }

    private static final ArrayList<CelestialBodyDetails> PLANET_DETAILS = Util.make(new ArrayList<>(), (list) -> {
        list.add(new CelestialBodyDetails(new TranslatableComponent("celestialexploration.planet_details.sun_name"), new Vec2(0, 0), new TranslatableComponent("celestialexploration.planet_details.sun_resources")));
        list.add(new CelestialBodyDetails(new TranslatableComponent("celestialexploration.planet_details.mercury_name"), new Vec2((float) getPlanetaryChunkCoordinates(1).x * 16, (float) getPlanetaryChunkCoordinates(1).z * 16), new TranslatableComponent("celestialexploration.planet_details.mercury_resources")));
        list.add(new CelestialBodyDetails(new TranslatableComponent("celestialexploration.planet_details.venus_name"), new Vec2((float) getPlanetaryChunkCoordinates(2).x * 16, (float) getPlanetaryChunkCoordinates(2).z * 16), new TranslatableComponent("celestialexploration.planet_details.venus_resources")));
        list.add(new CelestialBodyDetails(new TranslatableComponent("celestialexploration.planet_details.overworld_name"), new Vec2((float) getPlanetaryChunkCoordinates(3).x * 16, (float) getPlanetaryChunkCoordinates(3).z * 16), new TranslatableComponent("celestialexploration.planet_details.overworld_resources"), new TranslatableComponent("celestialexploration.planet_details.overworld_moons")));
        list.add(new CelestialBodyDetails(new TranslatableComponent("celestialexploration.planet_details.mars_name"), new Vec2((float) getPlanetaryChunkCoordinates(4).x * 16, (float) getPlanetaryChunkCoordinates(4).z * 16), new TranslatableComponent("celestialexploration.planet_details.mars_resources")));
        list.add(new CelestialBodyDetails(new TranslatableComponent("celestialexploration.planet_details.jupiter_name"), new Vec2((float) getPlanetaryChunkCoordinates(5).x * 16, (float) getPlanetaryChunkCoordinates(5).z * 16), new TranslatableComponent("celestialexploration.planet_details.jupiter_resources"), new TranslatableComponent("celestialexploration.planet_details.jupiter_moons")));
        list.add(new CelestialBodyDetails(new TranslatableComponent("celestialexploration.planet_details.saturn_name"), new Vec2((float) getPlanetaryChunkCoordinates(6).x * 16, (float) getPlanetaryChunkCoordinates(6).z * 16), new TranslatableComponent("celestialexploration.planet_details.saturn_resources"), new TranslatableComponent("celestialexploration.planet_details.saturn_moons")));
        list.add(new CelestialBodyDetails(new TranslatableComponent("celestialexploration.planet_details.uranus_name"), new Vec2((float) getPlanetaryChunkCoordinates(7).x * 16, (float) getPlanetaryChunkCoordinates(7).z * 16), new TranslatableComponent("celestialexploration.planet_details.uranus_resources"), new TranslatableComponent("celestialexploration.planet_details.uranus_moons")));
        list.add(new CelestialBodyDetails(new TranslatableComponent("celestialexploration.planet_details.neptune_name"), new Vec2((float) getPlanetaryChunkCoordinates(8).x * 16, (float) getPlanetaryChunkCoordinates(8).z * 16), new TranslatableComponent("celestialexploration.planet_details.neptune_resources"), new TranslatableComponent("celestialexploration.planet_details.neptune_moons")));
    });

    public static CelestialBodyDetails getPlanetDetail(int index) {
        return PLANET_DETAILS.get(index);
    }


    public record CelestialBodyDetails(Component name, Component location, Component resources, Component moons) {
        private static final Component coordinatesString = new TranslatableComponent("celestialexploration.planet_details.location");
        private static final Component moonsString = new TranslatableComponent("celestialexploration.planet_details.moons");
        private static final Component noMoons = new TranslatableComponent("celestialexploration.planet_details.no_moons");
        private static final Component resourcesString = new TranslatableComponent("celestialexploration.planet_details.resources");

        CelestialBodyDetails(Component name, Vec2 coordinates, Component resources) {
            this(name, coordinates, resources, noMoons);
        }

        CelestialBodyDetails(Component name, Vec2 coordinates, Component resources, Component moons) {
            this(name, new TextComponent(coordinatesString.getString() + ": " + (int)coordinates.x + "," + (int)coordinates.y), new TextComponent(resourcesString.getString() + ": " + resources.getString()), new TextComponent(moonsString.getString() + ": " + moons.getString()));
        }
    }

}