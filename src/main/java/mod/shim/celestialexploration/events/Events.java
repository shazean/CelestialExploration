package mod.shim.celestialexploration.events;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.registry.RegistryEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.TickEvent.WorldTickEvent;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Main.MODID, bus = Bus.FORGE)
public class Events {
	
	@SubscribeEvent
	public static void onWorldTick(WorldTickEvent event) {
		World world = event.world;
		

		if (world.dimension().location().toString().equals("celestialexploration:mars")) {
			
		}
		
	}
	
//	@SubscribeEvent
//	public static void testEvent(EntityEvent event) {
//		World world = event.getEntity().getCommandSenderWorld();
//		PlayerEntity player = (PlayerEntity) event.getEntity();
//
//		player.addEffect(new EffectInstance(RegistryEffects.GRAVITY.get(), 50, -7, false, false, false));
//		
//		if (world.dimension().location().toString().equals("celestialexploration:mars")) {
//			player.addEffect(new EffectInstance(RegistryEffects.GRAVITY.get(), 50, -7, false, false, false));
//		}
//		
//		
//	}
	
//	@SubscribeEvent
//	public static void onLivingEntityEvent(LivingEvent event) {
//		LivingEntity player = event.getEntityLiving();
//		World world = event.getEntityLiving().getCommandSenderWorld();
//		
//	      if (!world.isClientSide) {
//
//	  		if (world.dimension().location().toString().equals("celestialexploration:mars")) {
//				System.out.println("onLivingEntityEvent - if statement success");
//				player.addEffect(new EffectInstance(RegistryEffects.GRAVITY.get(), 1, -3, false, false, false));
//	  		}
//	    	  
//	      }

		
//		player.addEffect(new EffectInstance(RegistryEffects.GRAVITY.get(), 50, -3, false, false, false));

		
//		if (world.dimension().location().toString().equals("celestialexploration:mars")) {
//			player.addEffect(new EffectInstance(Effects.GLOWING, 50, 1, false, false, false));
//			System.out.println("onLivingEntityEvent - if statement success");
//		}
		
		
//	}
	
	@SubscribeEvent
	public static void onChangeDimenstion(EntityTravelToDimensionEvent event) {
//		System.out.println(event.getDimension().location().toString());
//		
//		
//		PlayerEntity player = (PlayerEntity) event.getEntity();
//		LivingEntity entity = (LivingEntity) event.getEntity();
//
////		PlayerEntity.createAttributes().add(ForgeMod.ENTITY_GRAVITY.get(), 0.01);
//		
//		player.addEffect(new EffectInstance(RegistryEffects.GRAVITY.get(), 50, -3, false, false, false));
//		entity.addEffect(new EffectInstance(RegistryEffects.GRAVITY.get(), 50, -3, false, false, false));
//
//		
////	    public static final RegistryObject<Attribute> ENTITY_GRAVITY = ATTRIBUTES.register("entity_gravity", () -> new RangedAttribute("forge.entity_gravity", 0.08D, -8.0D, 8.0D).setSyncable(true));
//		
////				return CreatureEntity.createLivingAttributes().add(Attributes.MAX_HEALTH, 20.0f).add(Attributes.MOVEMENT_SPEED, 1.2f).add(Attributes.FOLLOW_RANGE, 5);
//
//		
//		if (event.getDimension().location().toString().equals("celestialexploration:mars")) {
//			player.addEffect(new EffectInstance(Effects.JUMP, 50, 1, false, false, false));
//			player.addEffect(new EffectInstance(Effects.SLOW_FALLING, 50, 1, false, false, false));
//		
//		}
//		else {
//			System.out.println("Not mars!");
//		}
		
	}
	
	
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent event) {
		PlayerEntity player = event.player;
		
//		player.createLivingAttributes().add(ForgeMod.ENTITY_GRAVITY.get(), 0.01);

//		player.addEffect(new EffectInstance(Effects.GLOWING, 50, 1, false, false, false));
//		player.addEffect(new EffectInstance(RegistryEffects.GRAVITY.get(), 50, -3, false, false, false));


		
//		System.out.println(player.getAttributeValue(ForgeMod.ENTITY_GRAVITY.get()));
		
		
		
	}
	

}
