package mod.shim.celestialexploration.registry;

import mod.shim.celestialexploration.Main;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class RegistryDimensions {

    public static final ResourceLocation MARS_ID = new ResourceLocation(Main.MODID, "mars");
    public static final ResourceLocation MOON_ID = new ResourceLocation(Main.MODID, "moon");
    public static final ResourceLocation VENUS_ID = new ResourceLocation(Main.MODID, "venus");
    public static final ResourceLocation MERCURY_ID = new ResourceLocation(Main.MODID, "mercury");


    public static final RegistryKey<World> MARS_DIMENSION = RegistryKey.create(Registry.DIMENSION_REGISTRY, MARS_ID);
    public static final RegistryKey<World> MOON_DIMENSION = RegistryKey.create(Registry.DIMENSION_REGISTRY, MOON_ID);
    public static final RegistryKey<World> VENUS_DIMENSION = RegistryKey.create(Registry.DIMENSION_REGISTRY, VENUS_ID);
    public static final RegistryKey<World> MERCURY_DIMENSION = RegistryKey.create(Registry.DIMENSION_REGISTRY, MERCURY_ID);


}
