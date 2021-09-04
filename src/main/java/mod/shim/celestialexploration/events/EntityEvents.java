package mod.shim.celestialexploration.events;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.registry.RegistryEntities;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Main.MODID, bus = Bus.MOD)
public class EntityEvents {
	
//	@SubscribeEvent
//	public static void onBiomeLoad(BiomeLoadingEvent event) {
//		if (event.getName() == null)
//			return;
//		
//		MobSpawnInfoBuilder spawns = event.getSpawns();
//		
//		System.out.println(event.getName());
//		
//		if(event.getCategory().equals(Biome.Category.BEACH)) {
//			spawns.addSpawn(EntityClassification.MONSTER,
//					new MobSpawnInfo.Spawners(RegistryEntities.LURKER.get(), 10, 3, 10));
//		}
//	}

}
