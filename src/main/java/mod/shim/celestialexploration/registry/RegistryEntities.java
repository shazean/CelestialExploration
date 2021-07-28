package mod.shim.celestialexploration.registry;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableSet;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.entity.item.ShuttleEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class RegistryEntities {

	public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MODID);
	
	//Entity types
	public static final RegistryObject<EntityType<ShuttleEntity>> SHUTTLE = ENTITY_TYPES.register("shuttle",
			() -> EntityType.Builder.<ShuttleEntity>of(ShuttleEntity::new, EntityClassification.MISC)
			.sized(1.0f, 2.0f)
			.build(new ResourceLocation(Main.MODID, "shuttle").toString())
			);

	
	
	
}
