package mod.shim.celestialexploration.registry;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.entity.RoverEntity;
import mod.shim.celestialexploration.entity.item.ShuttleEntity;
import mod.shim.celestialexploration.entity.mobs.LurkerEntity;
import mod.shim.celestialexploration.entity.mobs.slimes.RustSlimeEntity;
import mod.shim.celestialexploration.entity.mobs.slimes.SulfuricSlimeEntity;
import mod.shim.celestialexploration.entity.mobs.slimes.WhiteSlimeEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class RegistryEntities {

	public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MODID);

	//Entity types
	public static final RegistryObject<EntityType<ShuttleEntity>> SHUTTLE = ENTITY_TYPES.register("shuttle", () -> 
		EntityType.Builder.of(ShuttleEntity::new, EntityClassification.MISC)
		.sized(12.0f, 4.0f)
		.build(new ResourceLocation(Main.MODID, "shuttle").toString())
			);

	public static final RegistryObject<EntityType<RoverEntity>> ROVER = ENTITY_TYPES.register("rover", () -> 
		EntityType.Builder.of(RoverEntity::new, EntityClassification.MISC)
		.sized(2.0f, 2.0f)
		.build(new ResourceLocation(Main.MODID, "rover").toString()));


	public static final RegistryObject<EntityType<LurkerEntity>> LURKER = ENTITY_TYPES.register("lurker", () -> 
		EntityType.Builder.of(LurkerEntity::new, EntityClassification.MISC)
		.sized(0.8f, 2.0f)
		.build(new ResourceLocation(Main.MODID, "lurker").toString()));

	public static final RegistryObject<EntityType<RustSlimeEntity>> RUST_SLIME = ENTITY_TYPES.register("rust_slime", () -> 
		EntityType.Builder.of(RustSlimeEntity::new, EntityClassification.MISC)
		.sized(1.8f, 1.8f)
		.build(new ResourceLocation(Main.MODID, "rust_slime").toString()));

	public static final RegistryObject<EntityType<WhiteSlimeEntity>> WHITE_SLIME = ENTITY_TYPES.register("white_slime", () -> 
		EntityType.Builder.of(WhiteSlimeEntity::new, EntityClassification.MISC)
		.sized(1.8f, 1.8f)
		.build(new ResourceLocation(Main.MODID, "white_slime").toString()));

	public static final RegistryObject<EntityType<SulfuricSlimeEntity>> SULFURIC_SLIME = ENTITY_TYPES.register("sulfuric_slime", () -> 
		EntityType.Builder.of(SulfuricSlimeEntity::new, EntityClassification.MISC)
		.sized(1.8f, 1.8f)
		.build(new ResourceLocation(Main.MODID, "sulfuric_slime").toString()));


}
