package mod.shim.celestialexploration.registry;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.entity.RoverEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class RegistryEntities {

	public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MODID);
	
	//Entity types
//	public static final RegistryObject<EntityType<ShuttleEntity>> SHUTTLE = ENTITY_TYPES.register("shuttle",
//			() -> EntityType.Builder.<ShuttleEntity>of(ShuttleEntity::new, EntityClassification.MISC)
//			.sized(1.0f, 2.0f)
//			.build(new ResourceLocation(Main.MODID, "shuttle").toString())
//			);

	public static final RegistryObject<EntityType<RoverEntity>> ROVER = ENTITY_TYPES.register("rover", () -> 
				EntityType.Builder.of(RoverEntity::new, EntityClassification.MISC)
				.sized(2.0f, 2.0f)
				.build(new ResourceLocation(Main.MODID, "rover").toString()));
	
	
}
