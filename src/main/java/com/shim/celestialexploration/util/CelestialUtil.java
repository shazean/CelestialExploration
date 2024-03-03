package com.shim.celestialexploration.util;

import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.registry.FluidRegistry;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidStack;

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

    public static Vec3 getPlanetaryChunkCoordinates(int planetNum) {
        int x;
        int z;

        //FIXME find a better way of doing this?
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

}