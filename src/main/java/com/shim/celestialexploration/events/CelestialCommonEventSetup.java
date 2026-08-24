package com.shim.celestialexploration.events;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.ambient.Eureka;
import com.shim.celestialexploration.entity.creatures.CelestialCat;
import com.shim.celestialexploration.entity.creatures.MoonCow;
import com.shim.celestialexploration.entity.monster.*;
import com.shim.celestialexploration.entity.monster.piglins.AstralPiglin;
import com.shim.celestialexploration.entity.monster.piglins.CyborgPiglin;
import com.shim.celestialexploration.entity.monster.piglins.VoidedPiglin;
import com.shim.celestialexploration.entity.monster.slimes.*;
import com.shim.celestialexploration.entity.robots.Drone;
import com.shim.celestialexploration.entity.robots.MechaCrow;
import com.shim.celestialexploration.entity.robots.Rover;
import com.shim.celestialexploration.packets.CelestialPacketHandler;
import com.shim.celestialexploration.registry.CelestialEntities;
import com.shim.celestialexploration.registry.CelestialItems;
import com.shim.celestialexploration.registry.CelestialPOIs;
import com.shim.celestialexploration.registry.CelestialStructurePieceType;
import com.shim.celestialexploration.world.structures.ResearchTunnelPieces;
import mod.azure.azurelib.animation.cache.AzIdentityRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CelestialCommonEventSetup {

    public static void commonSetup(final FMLCommonSetupEvent event) {
        SpawnPlacements.register(CelestialEntities.MARS_MALLOW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, MarsMallow::checkCelestialSlimeSpawnRules);
        SpawnPlacements.register(CelestialEntities.RUST_SLIME.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, RustSlime::checkCelestialSlimeSpawnRules);
        SpawnPlacements.register(CelestialEntities.LUNAR_SLIME.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, LunarSlime::checkCelestialSlimeSpawnRules);
        SpawnPlacements.register(CelestialEntities.QUICKSILVER_SLIME.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, QuicksilverSlime::checkCelestialSlimeSpawnRules);
        SpawnPlacements.register(CelestialEntities.VISCOUS_SLIME.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, ViscousSlime::checkCelestialSlimeSpawnRules);
        SpawnPlacements.register(CelestialEntities.LURKER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Lurker::checkMonsterSpawnRules);
        SpawnPlacements.register(CelestialEntities.VOIDED.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Voided::checkMonsterSpawnRules);
        SpawnPlacements.register(CelestialEntities.VOIDFELLOW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, VoidFellow::checkMonsterSpawnRules);
        SpawnPlacements.register(CelestialEntities.SULFUR_CUBE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, SulfurCube::checkSulfurCubeSpawnRules);
        SpawnPlacements.register(CelestialEntities.VOIDED_PIGLIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, VoidedPiglin::checkVoidedPiglinSpawnRules);
        SpawnPlacements.register(CelestialEntities.CYBORG_PIGLIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, CyborgPiglin::checkCyborgPiglinSpawnRules);
        SpawnPlacements.register(CelestialEntities.ASTRAL_PIGLIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AstralPiglin::checkAstralPiglinSpawnRules);
        SpawnPlacements.register(CelestialEntities.ASTRAL_HOGLIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AstralHoglin::checkMobSpawnRules);
        SpawnPlacements.register(CelestialEntities.VOIDED_ZOGLIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, VoidedZoglin::checkMonsterSpawnRules);
        SpawnPlacements.register(CelestialEntities.GYST.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Gyst::checkGystSpawnRules);
        SpawnPlacements.register(CelestialEntities.METEOR_CRAWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, MeteorCrawler::checkMeteorCrawlerSpawnRules);
        SpawnPlacements.register(CelestialEntities.VOID_CRAWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, VoidCrawler::checkMonsterSpawnRules);
        SpawnPlacements.register(CelestialEntities.CELESTIAL_CAT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, CelestialCat::checkCatSpawnRules);
        SpawnPlacements.register(CelestialEntities.EUREKA.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Eureka::checkEurekaSpawnRules);
        SpawnPlacements.register(CelestialEntities.GUST.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Gust::checkGustSpawnRules);
        SpawnPlacements.register(CelestialEntities.DRONE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Drone::checkDroneSpawnRules);
        SpawnPlacements.register(CelestialEntities.ROVER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Rover::checkRoverSpawnRules);
        SpawnPlacements.register(CelestialEntities.MECHACROW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, MechaCrow::checkMechaCrowSpawnRules);
        SpawnPlacements.register(CelestialEntities.MOON_COW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, MoonCow::checkSpawnRules);
//        SpawnPlacements.register(CelestialEntities.STARDUST_SQUID.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.WORLD_SURFACE, Mob::checkMobSpawnRules);
        SpawnPlacements.register(CelestialEntities.VULKAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Vulkan::checkAnyLightMonsterSpawnRules);


        //        SpawnPlacements.register(EntityRegistry.MECHADOG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, MechaDog::checkMobSpawnRules);

        CelestialPacketHandler.init();

        event.enqueueWork(() -> {

            CelestialPOIs.registerPOIs();

            CelestialStructurePieceType.RESEARCH_TUNNEL_CORRIDOR = CelestialStructurePieceType.register("RTCorridor", ResearchTunnelPieces.ResearchTunnelCorridor::new);
            CelestialStructurePieceType.RESEARCH_TUNNEL_CROSSING = CelestialStructurePieceType.register("RTCrossing", ResearchTunnelPieces.ResearchTunnelCrossing::new);
            CelestialStructurePieceType.RESEARCH_TUNNEL_ROOM = CelestialStructurePieceType.register("RTRoom", ResearchTunnelPieces.ResearchTunnelRoom::new);
            CelestialStructurePieceType.RESEARCH_TUNNEL_STAIRS = CelestialStructurePieceType.register("RTStairs", ResearchTunnelPieces.ResearchTunnelStairs::new);

            RecipeType.register(new ResourceLocation(CelestialExploration.MODID, "workbench_crafting").toString());

        });

        AzIdentityRegistry.register(CelestialItems.ADVANCED_SPACESUIT_HELMET.get(), CelestialItems.ADVANCED_SPACESUIT_CHESTPLATE.get(), CelestialItems.ADVANCED_SPACESUIT_LEGGINGS.get(), CelestialItems.ADVANCED_SPACESUIT_BOOTS.get());
        AzIdentityRegistry.register(CelestialItems.BASIC_SPACESUIT_HELMET.get(), CelestialItems.BASIC_SPACESUIT_CHESTPLATE.get(), CelestialItems.BASIC_SPACESUIT_LEGGINGS.get(), CelestialItems.BASIC_SPACESUIT_BOOTS.get());
        AzIdentityRegistry.register(CelestialItems.THERMAL_SPACESUIT_HELMET.get(), CelestialItems.THERMAL_SPACESUIT_CHESTPLATE.get(), CelestialItems.THERMAL_SPACESUIT_LEGGINGS.get(), CelestialItems.THERMAL_SPACESUIT_BOOTS.get());
        AzIdentityRegistry.register(CelestialItems.OG_HEAVY_DUTY_SPACESUIT_HELMET.get(), CelestialItems.OG_HEAVY_DUTY_SPACESUIT_CHESTPLATE.get(), CelestialItems.OG_HEAVY_DUTY_SPACESUIT_LEGGINGS.get(), CelestialItems.OG_HEAVY_DUTY_SPACESUIT_BOOTS.get());


    }

}
