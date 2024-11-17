package com.shim.celestialexploration.util;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.registry.DimensionRegistry;
import com.shim.celestialexploration.registry.FluidRegistry;
import com.shim.celestialexploration.util.teleportation.AbstractCelestialTeleportData;
import com.shim.celestialexploration.util.teleportation.CelestialCoordinateTeleport;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
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

    //Credit to https://www.baeldung.com/java-fibonacci
    public static int getFibonacciTerm(int n) {
        double squareRootOf5 = Math.sqrt(5);
        double phi = (1 + squareRootOf5) / 2;
        return (int) ((Math.pow(phi, n) - Math.pow(-phi, -n)) / squareRootOf5);
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

    public static final Map<ResourceKey<Level>, Vec3> CE_DIMENSION_LOCATION = Util.make(new Object2ObjectArrayMap<>(), (dimension) -> {
        dimension.put(DimensionRegistry.MERCURY, new Vec3(1, 0, 1));
        dimension.put(DimensionRegistry.VENUS, new Vec3(0, 0, 2));
        dimension.put(Level.OVERWORLD, new Vec3(-2, 0, 0));
        dimension.put(DimensionRegistry.MOON, new Vec3(-2, 0, 0));
        dimension.put(DimensionRegistry.MARS, new Vec3(1, 0, -3));
        dimension.put(DimensionRegistry.JUPITER, new Vec3(6, 0, 2));
        dimension.put(DimensionRegistry.EUROPA, new Vec3(6, 0, 2));

        dimension.put(Level.END, new Vec3(12, 0, 12));
    });

    protected static final Map<ResourceKey<Level>, AbstractCelestialTeleportData> DIMENSION_LOCATION = new HashMap<>();
    protected static final AbstractCelestialTeleportData defaultDimensionLocation = new CelestialCoordinateTeleport(-2, 0);

    public static AbstractCelestialTeleportData getDimensionLocation(ResourceKey<Level> dimension) {
        return DIMENSION_LOCATION.get(dimension);
    }

    public static void setDimensionLocation(ResourceKey<Level> dimension, AbstractCelestialTeleportData data) {
        DIMENSION_LOCATION.put(dimension, data);
    }

    public static void clearDimensionLocations() {
        DIMENSION_LOCATION.clear();
    }

    public static Vec3 getDimensionToSpaceCoordinates(ResourceKey<Level> dimension, ChunkPos pos) {
        Vec3 coord = getDimensionLocation(dimension).getOutputCoordinates(pos.x, pos.z); //new Vec3(CE_DIMENSION_LOCATION.get(dimension).x() * CelestialUtil.getSpaceRatio(), 0, CE_DIMENSION_LOCATION.get(dimension).z() * CelestialUtil.getSpaceRatio()); //getDimensionLocation(dimension).getOutputCoordinates(pos.x, pos.z); //FIXME
        if (coord == null) coord = defaultDimensionLocation.getOutputCoordinates(pos.x, pos.z);
        coord = new Vec3(coord.x * 16, 145.0, coord.z * 16); //convert from chunk to block pos
        return coord;
    }

    protected static final Map<ResourceKey<Level>, Vec3> PLANET_LOCATIONS = new HashMap<>();
//    protected static final Vec3 defaultPlanetLocation = new Vec3(-2, 0, 0);

    public static Vec3 getPlanetLocation(ResourceKey<Level> dimension) {
        return PLANET_LOCATIONS.get(dimension);
    }

    public static Map<ResourceKey<Level>, Vec3> getPlanetLocations() {
        return PLANET_LOCATIONS;
    }

    public static void setPlanetLocation(ResourceKey<Level> dimension, Vec3 data) {
        PLANET_LOCATIONS.put(dimension, data);
        CelestialExploration.LOGGER.debug("planets: " + PLANET_LOCATIONS.keySet());
    }

    public static void clearPlanetLocations() {
        PLANET_LOCATIONS.clear();
    }

    public static Vec3 getPlanetaryChunkCoordinates(ResourceKey<Level> planet) {
        Vec3 coord = getPlanetLocation(planet); //CE_DIMENSION_LOCATION.get(planet); //getPlanetLocation(planet); //
//        if (coord == null) coord = CE_DIMENSION_LOCATION.get(Level.OVERWORLD);
        coord = new Vec3(coord.x * getSpaceRatio(), coord.y, coord.z * getSpaceRatio());
        return coord;
    }

//    @Deprecated
//    public static Vec3 getPlanetaryChunkCoordinates(String planet) {
//        Vec3 coord = PLANET_LOCATION.get(planet);
//        coord = new Vec3(coord.x * getSpaceRatio(), coord.y, coord.z * getSpaceRatio());
//        return coord;
//    }

    @Deprecated
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

    public static boolean isInRectangle(double centerX, double centerY, int radius, double x, double y) {
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
        } else if (fluidStack.getFluid().isSame(FluidRegistry.MOLTEN_IRON.get())) {
            return 3;
        } else if (fluidStack.getFluid().isSame(FluidRegistry.MOLTEN_STEEL.get())) {
            return 4;
        } else if (fluidStack.getFluid().isSame(FluidRegistry.MOLTEN_COPPER.get())) {
            return 5;
        } else if (fluidStack.getFluid().isSame(FluidRegistry.MOLTEN_GOLD.get())) {
            return 6;
//        } else if (blockEntity.fluidHandler.getFluid().getFluid().isSame(FluidRegistry.MOLTEN_NETHERITE.get())) {
//            blockEntity.fluidType = 7;
        } else if (fluidStack.getFluid().isSame(FluidRegistry.MOLTEN_ALUMINUM.get())) {
            return 8;
        } else {
            return 0;
        }
    }

    public static FluidStack getFluidFromId(int id, int amount) {
        return switch (id) {
            case 1 -> new FluidStack(Fluids.WATER, amount);
            case 2 -> new FluidStack(Fluids.LAVA, amount);
            case 3 -> new FluidStack(FluidRegistry.MOLTEN_IRON.get(), amount);
            case 4 -> new FluidStack(FluidRegistry.MOLTEN_STEEL.get(), amount);
            case 5 -> new FluidStack(FluidRegistry.MOLTEN_COPPER.get(), amount);
            case 6 -> new FluidStack(FluidRegistry.MOLTEN_GOLD.get(), amount);
//            case 7 -> new FluidStack(FluidRegistry.MOLTEN_NETHERITE.get(), amount);
            case 8 -> new FluidStack(FluidRegistry.MOLTEN_ALUMINUM.get(), amount);
            default -> FluidStack.EMPTY;
        };
    }

    public static int getIdFromDimension(ResourceKey<Level> dimension) {
        if (dimension.equals(DimensionRegistry.MERCURY)) {
            return 1;
        } else if (dimension.equals(DimensionRegistry.VENUS)) {
            return 2;
        } else if (dimension.equals(Level.OVERWORLD)) {
            return 3;
        } else if (dimension.equals(DimensionRegistry.MOON)) {
            return 4;
        } else if (dimension.equals(DimensionRegistry.MARS)) {
            return 5;
        } else if (dimension.equals(DimensionRegistry.JUPITER)) {
            return 6;
        } else {
            return 0;
        }
    }

    public static ResourceKey<Level> getDimensionFromId(int id) {
        return switch (id) {
            case 1 -> DimensionRegistry.MERCURY;
            case 2 -> DimensionRegistry.VENUS;
            case 3 -> Level.OVERWORLD;
            case 4 -> DimensionRegistry.MOON;
            case 5 -> DimensionRegistry.MARS;
            case 6 -> DimensionRegistry.JUPITER;
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