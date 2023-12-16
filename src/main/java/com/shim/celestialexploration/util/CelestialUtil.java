package com.shim.celestialexploration.util;

import com.shim.celestialexploration.config.CelestialCommonConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.phys.Vec3;

public class CelestialUtil {

    //Credit to https://www.baeldung.com/java-fibonacci
    public static int getFibonacciTerm(int n) {
        double squareRootOf5 = Math.sqrt(5);
        double phi = (1 + squareRootOf5)/2;
        return (int) ((Math.pow(phi, n) - Math.pow(-phi, -n))/squareRootOf5);
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
        if(isInRectangle(centerX, centerY, radius, x, y)) {
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
}