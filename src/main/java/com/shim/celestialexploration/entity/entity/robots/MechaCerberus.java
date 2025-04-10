package com.shim.celestialexploration.entity.entity.robots;

import com.shim.celestialexploration.entity.entity.mob.Gust;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class MechaCerberus extends AbstractCerberus implements PlayerRideable {
    public MechaCerberus(EntityType<? extends AbstractCerberus> p_30369_, Level p_30370_) {
        super(p_30369_, p_30370_);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new CerberusPanicGoal(1.5D));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(3, new CerberusAvoidEntityGoal<>(this, Gust.class, 24.0F, 1.5D, 1.5D));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(9, new BegGoal(this, 8.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
//        this.targetSelector.addGoal(4, new NearestAttackableTargetPeacefulGoal<>(this, Player.class, true, false));
//        this.targetSelector.addGoal(5, new NonTameCreatureRandomTargetGoal<>(this, Animal.class, false, PREY_SELECTOR));
//        this.targetSelector.addGoal(6, new NonTameCreatureRandomTargetGoal<>(this, Turtle.class, false, Turtle.BABY_ON_LAND_SELECTOR));
//        this.targetSelector.addGoal(7, new TameCreatureRandomTargetGoal<>(this, AbstractSkeleton.class, false, null));

    }

    protected boolean canRide(Entity entity) {
        //TODO saddle check?
        return entity instanceof LivingEntity livingEntity && this.isTame() && this.isOwnedBy(livingEntity);
    }

    public InteractionResult mobInteract(Player p_30412_, InteractionHand p_30413_) {
        ItemStack itemstack = p_30412_.getItemInHand(p_30413_);
        Item item = itemstack.getItem();
        if (this.level.isClientSide) {
            boolean flag = this.isOwnedBy(p_30412_) || this.isTame(); // || itemstack.is(tameItem) && !this.isTame(); // && !this.isAngry();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (this.isTame()) {
                if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
//                    this.heal((float)itemstack.getFoodProperties(this).getNutrition());
                    this.heal(5);
                    if (!p_30412_.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }

                    this.gameEvent(GameEvent.MOB_INTERACT, this.eyeBlockPosition());
                    return InteractionResult.SUCCESS;
                }

                if (!(item instanceof DyeItem)) {
                    InteractionResult interactionresult = super.mobInteract(p_30412_, p_30413_);
                    if ((!interactionresult.consumesAction() || this.isBaby()) && this.isOwnedBy(p_30412_)) {
                        this.setOrderedToSit(!this.isOrderedToSit());
                        this.jumping = false;
                        this.navigation.stop();
                        this.setTarget((LivingEntity)null);
                        return InteractionResult.SUCCESS;
                    }

                    return interactionresult;
                }
//                DyeColor dyecolor = ((DyeItem)item).getDyeColor();
//                if (dyecolor != this.getCollarColor()) {
//                    this.setCollarColor(dyecolor);
//                    if (!p_30412_.getAbilities().instabuild) {
//                        itemstack.shrink(1);
//                    }
//
//                    return InteractionResult.SUCCESS;
//                }
            }
//            else if (itemstack.is(tameItem)) { // && !this.isAngry()) {
//                if (!p_30412_.getAbilities().instabuild) {
//                    itemstack.shrink(1);
//                }
//
//                if (this.random.nextInt(3) == 0) { // && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_30412_)) {
//                    this.tame(p_30412_);
//                    this.navigation.stop();
//                    this.setTarget((LivingEntity)null);
//                    this.setOrderedToSit(true);
//                    this.level.broadcastEntityEvent(this, (byte)7);
//                } else {
//                    this.level.broadcastEntityEvent(this, (byte)6);
//                }
//
//                return InteractionResult.SUCCESS;
//            }
            return super.mobInteract(p_30412_, p_30413_);
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.ATTACK_DAMAGE, 2.2D);
    }
}