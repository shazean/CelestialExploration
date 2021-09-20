package mod.shim.celestialexploration.entity.item;

import java.util.List;

import javax.annotation.Nullable;

import mod.shim.celestialexploration.registry.RegistryEntities;
import mod.shim.celestialexploration.registry.RegistryItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.entity.item.minecart.ChestMinecartEntity;
import net.minecraft.entity.item.minecart.CommandBlockMinecartEntity;
import net.minecraft.entity.item.minecart.FurnaceMinecartEntity;
import net.minecraft.entity.item.minecart.HopperMinecartEntity;
import net.minecraft.entity.item.minecart.MinecartEntity;
import net.minecraft.entity.item.minecart.SpawnerMinecartEntity;
import net.minecraft.entity.item.minecart.TNTMinecartEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.client.CSteerBoatPacket;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.TeleportationRepositioner;
import net.minecraft.util.TransportationHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class ShuttleEntity extends Entity {

	private static final DataParameter<Integer> DATA_ID_HURT = EntityDataManager.defineId(ShuttleEntity.class, DataSerializers.INT);
	private static final DataParameter<Integer> DATA_ID_HURTDIR = EntityDataManager.defineId(ShuttleEntity.class, DataSerializers.INT);
	private static final DataParameter<Float> DATA_ID_DAMAGE = EntityDataManager.defineId(ShuttleEntity.class, DataSerializers.FLOAT);
	private static final DataParameter<Integer> DATA_ID_COLOR = EntityDataManager.defineId(ShuttleEntity.class, DataSerializers.INT);
	private float outOfControlTicks;
	private float deltaRotation;
	private int lerpSteps;
	private double lerpX;
	private double lerpY;
	private double lerpZ;
	private double lerpYRot;
	private double lerpXRot;
	private boolean inputLeft;
	private boolean inputRight;
	private boolean inputUp;
	private boolean inputDown;
	private double lastYd;
	private ShuttleEntity.Status status;

	public ShuttleEntity(EntityType<? extends ShuttleEntity> p_i48580_1_, World p_i48580_2_) {
		super(p_i48580_1_, p_i48580_2_);
		this.noPhysics = true;
		//		this.setColor(color);
	}


	public ShuttleEntity(World p_i1705_1_, double p_i1705_2_, double p_i1705_4_, double p_i1705_6_) {
		this(RegistryEntities.SHUTTLE.get(), p_i1705_1_);
		this.setPos(p_i1705_2_, p_i1705_4_, p_i1705_6_);
		this.setDeltaMovement(Vector3d.ZERO);
		this.xo = p_i1705_2_;
		this.yo = p_i1705_4_;
		this.zo = p_i1705_6_;
	}

	public static ShuttleEntity createShuttle(World p_184263_0_, ShuttleEntity.Color color) {
		//	      if (color == ShuttleEntity.Color.WHITE) {
		return new ShuttleEntity(RegistryEntities.SHUTTLE.get(), p_184263_0_);
		//	      } else if (color == ShuttleEntity.Color.BLACK) {
		//	         return new FurnaceMinecartEntity(p_184263_0_, p_184263_1_, p_184263_3_, p_184263_5_);
		//	      } else if (color == ShuttleEntity.Color.RED) {
		//	         return new TNTMinecartEntity(p_184263_0_, p_184263_1_, p_184263_3_, p_184263_5_);
		//	      } else if (color == ShuttleEntity.Color.ORANGE) {
		//	         return new SpawnerMinecartEntity(p_184263_0_, p_184263_1_, p_184263_3_, p_184263_5_);
		//	      } else if (color == ShuttleEntity.Color.YELLOW) {
		//	         return new HopperMinecartEntity(p_184263_0_, p_184263_1_, p_184263_3_, p_184263_5_);
		//	      } else {
		//	         return (ShuttleEntity)(p_184263_7_ == ShuttleEntity.Type.COMMAND_BLOCK ? new CommandBlockMinecartEntity(p_184263_0_, p_184263_1_, p_184263_3_, p_184263_5_) : new MinecartEntity(p_184263_0_, p_184263_1_, p_184263_3_, p_184263_5_));
		//	      }
	}


	@Override
	protected void defineSynchedData() {
		this.entityData.define(DATA_ID_HURT, 0);
		this.entityData.define(DATA_ID_HURTDIR, 1);
		this.entityData.define(DATA_ID_DAMAGE, 0.0F);
		this.entityData.define(DATA_ID_COLOR, ShuttleEntity.Color.WHITE.ordinal());

	}

	@Override
	protected void readAdditionalSaveData(CompoundNBT p_70037_1_) {
		if (p_70037_1_.contains("Color", 8)) {
			this.setColor(ShuttleEntity.Color.byName(p_70037_1_.getString("Color")));
		}
	}

	@Override
	protected void addAdditionalSaveData(CompoundNBT p_213281_1_) {
		p_213281_1_.putString("Color", this.getShuttleColor().getName());

	}

	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public boolean canCollideWith(Entity p_241849_1_) {
		return canVehicleCollide(this, p_241849_1_);
	}

	public static boolean canVehicleCollide(Entity p_242378_0_, Entity p_242378_1_) {
		return (p_242378_1_.canBeCollidedWith() || p_242378_1_.isPushable()) && !p_242378_0_.isPassengerOfSameVehicle(p_242378_1_);
	}
	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	@Override
	public boolean isPushable() {
		return false;
	}


	@Override
	protected Vector3d getRelativePortalPosition(Direction.Axis p_241839_1_, TeleportationRepositioner.Result p_241839_2_) {
		return LivingEntity.resetForwardDirectionOfRelativePortalPosition(super.getRelativePortalPosition(p_241839_1_, p_241839_2_));
	}
	@Override
	public double getPassengersRidingOffset() {
		return -0.3D;
	}

	@Override
	public boolean hurt(DamageSource p_70097_1_, float p_70097_2_) {
		if (this.isInvulnerableTo(p_70097_1_)) {
			return false;
		} else if (!this.level.isClientSide && !this.removed) {
			this.setHurtDir(-this.getHurtDir());
			this.setHurtTime(10);
			this.setDamage(this.getDamage() + p_70097_2_ * 10.0F);
			this.markHurt();
			boolean flag = p_70097_1_.getEntity() instanceof PlayerEntity && ((PlayerEntity)p_70097_1_.getEntity()).abilities.instabuild;
			if (flag || this.getDamage() > 40.0F) {
				if (!flag && this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
					this.spawnAtLocation(this.getDropItem());
				}

				this.remove();
			}

			return true;
		} else {
			return true;
		}
	}



	//		   public void push(Entity p_70108_1_) {
	//		      if (p_70108_1_ instanceof ShuttleEntity) {
	//		         if (p_70108_1_.getBoundingBox().minY < this.getBoundingBox().maxY) {
	//		            super.push(p_70108_1_);
	//		         }
	//		      } else if (p_70108_1_.getBoundingBox().minY <= this.getBoundingBox().minY) {
	//		         super.push(p_70108_1_);
	//		      }
	//		   }

	public Item getDropItem() {
		switch(this.getShuttleColor()) {
		case WHITE:
		default:
			return RegistryItems.WHITE_SHUTTLE.get();
		case RED:
			return RegistryItems.RED_SHUTTLE.get();
		case ORANGE:
			return RegistryItems.ORANGE_SHUTTLE.get();
		case YELLOW:
			return RegistryItems.YELLOW_SHUTTLE.get();
		case GREEN:
			return RegistryItems.GREEN_SHUTTLE.get();
		case BLUE:
			return RegistryItems.BLUE_SHUTTLE.get();
		case PURPLE:
			return RegistryItems.PURPLE_SHUTTLE.get();
		case BLACK:
			return RegistryItems.BLACK_SHUTTLE.get();
		}
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateHurt() {
		this.setHurtDir(-this.getHurtDir());
		this.setHurtTime(10);
		this.setDamage(this.getDamage() * 11.0F);
	}

	@Override
	public boolean isPickable() {
		return !this.removed;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void lerpTo(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		this.lerpX = p_180426_1_;
		this.lerpY = p_180426_3_;
		this.lerpZ = p_180426_5_;
		this.lerpYRot = p_180426_7_;
		this.lerpXRot = p_180426_8_;
		this.lerpSteps = 10;
	}

	@Override
	public Direction getMotionDirection() {
		return this.getDirection().getClockWise();
	}

	@Override
	public void tick() {
		//		      this.status = this.getStatus();
		//		      if (this.status != ShuttleEntity.Status.UNDER_WATER && this.status != ShuttleEntity.Status.UNDER_FLOWING_WATER) {
		//		         this.outOfControlTicks = 0.0F;
		//		      } else {
		//		         ++this.outOfControlTicks;
		//		      }

		if (!this.level.isClientSide && this.outOfControlTicks >= 60.0F) {
			this.ejectPassengers();
		}

		if (this.getHurtTime() > 0) {
			this.setHurtTime(this.getHurtTime() - 1);
		}

		if (this.getDamage() > 0.0F) {
			this.setDamage(this.getDamage() - 1.0F);
		}

		super.tick();
		this.tickLerp();
		if (this.isControlledByLocalInstance()) {

			if (this.level.isClientSide) {
				this.controlShuttle();
				this.level.sendPacketToServer(new CSteerBoatPacket());
			}

			this.move(MoverType.SELF, this.getDeltaMovement());
		} else {
			this.setDeltaMovement(Vector3d.ZERO);
		}


		this.checkInsideBlocks();
		List<Entity> list = this.level.getEntities(this, this.getBoundingBox().inflate(0.2F, -0.01F, 0.2F), EntityPredicates.pushableBy(this));
		if (!list.isEmpty()) {
			boolean flag = !this.level.isClientSide && !(this.getControllingPassenger() instanceof PlayerEntity);

			for(int j = 0; j < list.size(); ++j) {
				Entity entity = list.get(j);
				if (!entity.hasPassenger(this)) {
					if (flag && this.getPassengers().size() < 2 && !entity.isPassenger() && entity.getBbWidth() < this.getBbWidth() && entity instanceof LivingEntity && !(entity instanceof WaterMobEntity) && !(entity instanceof PlayerEntity)) {
						entity.startRiding(this);
					} else {
						this.push(entity);
					}
				}
			}
		}

	}

	private void tickLerp() {
		if (this.isControlledByLocalInstance()) {
			this.lerpSteps = 0;
			this.setPacketCoordinates(this.getX(), this.getY(), this.getZ());
		}

		if (this.lerpSteps > 0) {
			double d0 = this.getX() + (this.lerpX - this.getX()) / this.lerpSteps;
			double d1 = this.getY() + (this.lerpY - this.getY()) / this.lerpSteps;
			double d2 = this.getZ() + (this.lerpZ - this.getZ()) / this.lerpSteps;
			double d3 = MathHelper.wrapDegrees(this.lerpYRot - this.yRot);
			this.yRot = (float)(this.yRot + d3 / this.lerpSteps);
			this.xRot = (float)(this.xRot + (this.lerpXRot - this.xRot) / this.lerpSteps);
			--this.lerpSteps;
			this.setPos(d0, d1, d2);
			this.setRot(this.yRot, this.xRot);
		}
	}


	//				   
	//		   private ShuttleEntity.Status getStatus() {
	//		      ShuttleEntity.Status shuttleentity$status = this.isUnderwater();
	//		      if (shuttleentity$status != null) {
	//		         this.waterLevel = this.getBoundingBox().maxY;
	//		         return shuttleentity$status;
	//		      } else if (this.checkInWater()) {
	//		         return ShuttleEntity.Status.IN_WATER;
	//		      } else {
	//		         float f = this.getGroundFriction();
	//		         if (f > 0.0F) {
	//		            this.landFriction = f;
	//		            return ShuttleEntity.Status.ON_LAND;
	//		         } else {
	//		            return ShuttleEntity.Status.IN_AIR;
	//		         }
	//		      }
	//		   }



	//		   public float getGroundFriction() {
	//		      AxisAlignedBB axisalignedbb = this.getBoundingBox();
	//		      AxisAlignedBB axisalignedbb1 = new AxisAlignedBB(axisalignedbb.minX, axisalignedbb.minY - 0.001D, axisalignedbb.minZ, axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
	//		      int i = MathHelper.floor(axisalignedbb1.minX) - 1;
	//		      int j = MathHelper.ceil(axisalignedbb1.maxX) + 1;
	//		      int k = MathHelper.floor(axisalignedbb1.minY) - 1;
	//		      int l = MathHelper.ceil(axisalignedbb1.maxY) + 1;
	//		      int i1 = MathHelper.floor(axisalignedbb1.minZ) - 1;
	//		      int j1 = MathHelper.ceil(axisalignedbb1.maxZ) + 1;
	//		      VoxelShape voxelshape = VoxelShapes.create(axisalignedbb1);
	//		      float f = 0.0F;
	//		      int k1 = 0;
	//		      BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
	//
	//		      for(int l1 = i; l1 < j; ++l1) {
	//		         for(int i2 = i1; i2 < j1; ++i2) {
	//		            int j2 = (l1 != i && l1 != j - 1 ? 0 : 1) + (i2 != i1 && i2 != j1 - 1 ? 0 : 1);
	//		            if (j2 != 2) {
	//		               for(int k2 = k; k2 < l; ++k2) {
	//		                  if (j2 <= 0 || k2 != k && k2 != l - 1) {
	//		                     blockpos$mutable.set(l1, k2, i2);
	//		                     BlockState blockstate = this.level.getBlockState(blockpos$mutable);
	//		                     if (!(blockstate.getBlock() instanceof LilyPadBlock) && VoxelShapes.joinIsNotEmpty(blockstate.getCollisionShape(this.level, blockpos$mutable).move((double)l1, (double)k2, (double)i2), voxelshape, IBooleanFunction.AND)) {
	//		                        f += blockstate.getSlipperiness(this.level, blockpos$mutable, this);
	//		                        ++k1;
	//		                     }
	//		                  }
	//		               }
	//		            }
	//		         }
	//		      }
	//
	//		      return f / (float)k1;
	//		   }



	private void controlShuttle() {
		//		System.out.println("ShuttleEntity controlShuttle");
		if (this.isVehicle()) {
			float f = 0.0F;
			if (this.inputLeft) {
				System.out.println("ShuttleEntity controlShuttle inputLeft");
				--this.deltaRotation;
			}

			if (this.inputRight) {
				System.out.println("ShuttleEntity controlShuttle inputRight");
				++this.deltaRotation;
			}

			if (this.inputRight != this.inputLeft && !this.inputUp && !this.inputDown) {
				System.out.println("ShuttleEntity controlShuttle inputRight != inputLeft && !inputUp && !inputDown");
				f += 0.005F;
			}

			this.yRot += this.deltaRotation;
			if (this.inputUp) {
				System.out.println("ShuttleEntity controlShuttle inputUp");

				f += 0.04F;
			}

			if (this.inputDown) {
				System.out.println("ShuttleEntity controlShuttle inputDown");
				f -= 0.005F;
			}

			this.setDeltaMovement(this.getDeltaMovement().add(MathHelper.sin(-this.yRot * ((float)Math.PI / 180F)) * f, 0.0D, MathHelper.cos(this.yRot * ((float)Math.PI / 180F)) * f));
		}
	}

	@Override
	public void positionRider(Entity p_184232_1_) {
		if (this.hasPassenger(p_184232_1_)) {
			float f = 0.0F;
			float f1 = (float)((this.removed ? (double)0.01F : this.getPassengersRidingOffset()) + p_184232_1_.getMyRidingOffset());
			if (this.getPassengers().size() > 1) {
				int i = this.getPassengers().indexOf(p_184232_1_);
				if (i == 0) {
					f = 0.2F;
				} else {
					f = -0.6F;
				}

				if (p_184232_1_ instanceof AnimalEntity) {
					f = (float)(f + 0.2D);
				}
			}

			Vector3d vector3d = (new Vector3d(f, 0.0D, 5.5D)).yRot(-this.yRot * ((float)Math.PI / 180F) - ((float)Math.PI / 2F)); //0.0D -> 5.5D FIXME probably change when model facing appropriate direction
			p_184232_1_.setPos(this.getX() + vector3d.x, this.getY() + f1, this.getZ() + vector3d.z);
			p_184232_1_.yRot += this.deltaRotation;
			p_184232_1_.setYHeadRot(p_184232_1_.getYHeadRot() + this.deltaRotation);
			this.clampRotation(p_184232_1_);
			if (p_184232_1_ instanceof AnimalEntity && this.getPassengers().size() > 1) {
				int j = p_184232_1_.getId() % 2 == 0 ? 90 : 270;
				p_184232_1_.setYBodyRot(((AnimalEntity)p_184232_1_).yBodyRot + j);
				p_184232_1_.setYHeadRot(p_184232_1_.getYHeadRot() + j);
			}

		}
	}

	@Override
	public Vector3d getDismountLocationForPassenger(LivingEntity p_230268_1_) {
		Vector3d vector3d = getCollisionHorizontalEscapeVector(this.getBbWidth() * MathHelper.SQRT_OF_TWO, p_230268_1_.getBbWidth(), this.yRot);
		double d0 = this.getX() + vector3d.x;
		double d1 = this.getZ() + vector3d.z;
		BlockPos blockpos = new BlockPos(d0, this.getBoundingBox().maxY, d1);
		BlockPos blockpos1 = blockpos.below();
		if (!this.level.isWaterAt(blockpos1)) {
			double d2 = blockpos.getY() + this.level.getBlockFloorHeight(blockpos);
			double d3 = blockpos.getY() + this.level.getBlockFloorHeight(blockpos1);

			for(Pose pose : p_230268_1_.getDismountPoses()) {
				Vector3d vector3d1 = TransportationHelper.findDismountLocation(this.level, d0, d2, d1, p_230268_1_, pose);
				if (vector3d1 != null) {
					p_230268_1_.setPose(pose);
					return vector3d1;
				}

				Vector3d vector3d2 = TransportationHelper.findDismountLocation(this.level, d0, d3, d1, p_230268_1_, pose);
				if (vector3d2 != null) {
					p_230268_1_.setPose(pose);
					return vector3d2;
				}
			}
		}

		return super.getDismountLocationForPassenger(p_230268_1_);
	}

	protected void clampRotation(Entity p_184454_1_) {
		p_184454_1_.setYBodyRot(this.yRot);
		float f = MathHelper.wrapDegrees(p_184454_1_.yRot - this.yRot);
		float f1 = MathHelper.clamp(f, -105.0F, 105.0F);
		p_184454_1_.yRotO += f1 - f;
		p_184454_1_.yRot += f1 - f;
		p_184454_1_.setYHeadRot(p_184454_1_.yRot);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void onPassengerTurned(Entity p_184190_1_) {
		this.clampRotation(p_184190_1_);
	}

	@Override
	public ActionResultType interact(PlayerEntity p_184230_1_, Hand p_184230_2_) {

		if (p_184230_1_.isSecondaryUseActive()) {
			return ActionResultType.PASS;
		} else if (this.outOfControlTicks < 60.0F) {
			if (!this.level.isClientSide) {
				return p_184230_1_.startRiding(this) ? ActionResultType.CONSUME : ActionResultType.PASS;
			} else {
				return ActionResultType.SUCCESS;
			}
		} else {
			return ActionResultType.PASS;
		}
	}

	@Override
	protected void checkFallDamage(double p_184231_1_, boolean p_184231_3_, BlockState p_184231_4_, BlockPos p_184231_5_) {
		this.lastYd = this.getDeltaMovement().y;
		if (!this.isPassenger()) {
			if (p_184231_3_) {
				if (this.fallDistance > 3.0F) {
					if (this.status != ShuttleEntity.Status.ON_LAND) {
						this.fallDistance = 0.0F;
						return;
					}

					this.causeFallDamage(this.fallDistance, 1.0F);
					if (!this.level.isClientSide && !this.removed) {
						this.remove();
						if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
							for(int i = 0; i < 3; ++i) {
								//		                        this.spawnAtLocation(this.getShuttleColor(); //.getPlanks());
							}

							for(int j = 0; j < 2; ++j) {
								this.spawnAtLocation(Items.STICK);
							}
						}
					}
				}

				this.fallDistance = 0.0F;
			} else if (!this.level.getFluidState(this.blockPosition().below()).is(FluidTags.WATER) && p_184231_1_ < 0.0D) {
				this.fallDistance = (float)(this.fallDistance - p_184231_1_);
			}

		}
	}

	public void setDamage(float p_70266_1_) {
		this.entityData.set(DATA_ID_DAMAGE, p_70266_1_);
	}

	public float getDamage() {
		return this.entityData.get(DATA_ID_DAMAGE);
	}

	public void setHurtTime(int p_70265_1_) {
		this.entityData.set(DATA_ID_HURT, p_70265_1_);
	}

	public int getHurtTime() {
		return this.entityData.get(DATA_ID_HURT);
	}

	public void setHurtDir(int p_70269_1_) {
		this.entityData.set(DATA_ID_HURTDIR, p_70269_1_);
	}

	public int getHurtDir() {
		return this.entityData.get(DATA_ID_HURTDIR);
	}

	public void setColor(ShuttleEntity.Color p_184458_1_) {
		this.entityData.set(DATA_ID_COLOR, p_184458_1_.ordinal());
	}

	public ShuttleEntity.Color getShuttleColor() {
		return ShuttleEntity.Color.byId(this.entityData.get(DATA_ID_COLOR));
	}

	@Override
	protected boolean canAddPassenger(Entity p_184219_1_) {
		return this.getPassengers().size() < 2; //&& !this.isEyeInFluid(FluidTags.WATER);
	}

	protected void doPlayerRide(PlayerEntity p_110237_1_) {
		if (!this.level.isClientSide) {
			p_110237_1_.yRot = this.yRot;
			p_110237_1_.xRot = this.xRot;
			p_110237_1_.startRiding(this);
		}

	}

	public boolean canBeControlledByRider() {
		return this.getControllingPassenger() instanceof LivingEntity;
	}


	public void travel(Vector3d p_213352_1_) {
		//	      if (this.isAlive()) {
		if (this.isVehicle() && this.canBeControlledByRider()) {
			LivingEntity livingentity = (LivingEntity)this.getControllingPassenger();
			this.yRot = livingentity.yRot;
			this.yRotO = this.yRot;
			this.xRot = livingentity.xRot * 0.5F;
			this.setRot(this.yRot, this.xRot);
			//	            this.yBodyRot = this.yRot;
			//	            this.yHeadRot = this.yBodyRot;
			float f = livingentity.xxa * 0.5F;
			float f1 = livingentity.zza;
			//	            if (f1 <= 0.0F) {
			//	               f1 *= 0.25F;
			//	               this.gallopSoundCounter = 0;
			//	            }

			//	            if (this.onGround && this.playerJumpPendingScale == 0.0F && this.isStanding() && !this.allowStandSliding) {
			//	               f = 0.0F;
			//	               f1 = 0.0F;
			//	            }
			//
			//	            if (this.playerJumpPendingScale > 0.0F && !this.isJumping() && this.onGround) {
			//	               double d0 = this.getCustomJump() * (double)this.playerJumpPendingScale * (double)this.getBlockJumpFactor();
			double d1;
			//	               if (this.hasEffect(Effects.JUMP)) {
			//	                  d1 = d0 + (double)((float)(this.getEffect(Effects.JUMP).getAmplifier() + 1) * 0.1F);
			//	               } else {
			//	                  d1 = d0;
			//	               }

			Vector3d vector3d = this.getDeltaMovement();
			//	               this.setDeltaMovement(vector3d.x, d1, vector3d.z);
			//	               this.setIsJumping(true);
			this.hasImpulse = true;
			//	               net.minecraftforge.common.ForgeHooks.onLivingJump(this);
			if (f1 > 0.0F) {
				float f2 = MathHelper.sin(this.yRot * ((float)Math.PI / 180F));
				float f3 = MathHelper.cos(this.yRot * ((float)Math.PI / 180F));
				//	                  this.setDeltaMovement(this.getDeltaMovement().add((double)(-0.4F * f2 * this.playerJumpPendingScale), 0.0D, (double)(0.4F * f3 * this.playerJumpPendingScale)));
			}

			//	               this.playerJumpPendingScale = 0.0F;
			//	            }

			//	            this.flyingSpeed = this.getSpeed() * 0.1F;
			//	            if (this.isControlledByLocalInstance()) {
			//	               this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
			//	               super.travel(new Vector3d((double)f, p_213352_1_.y, (double)f1));
			//	            } else
			if (livingentity instanceof PlayerEntity) {
				this.setDeltaMovement(Vector3d.ZERO);
			}
			//
			//	            if (this.onGround) {
			//	               this.playerJumpPendingScale = 0.0F;
			//	               this.setIsJumping(false);
			//	            }

			//	            this.calculateEntityAnimation(this, false);
			//	         } else {
			////	            this.flyingSpeed = 0.02F;
			////	            super.travel(p_213352_1_);
			//	         }
		}
	}

	@Override
	@Nullable
	public Entity getControllingPassenger() {
		List<Entity> list = this.getPassengers();
		return list.isEmpty() ? null : list.get(0);
	}

	@OnlyIn(Dist.CLIENT)
	public void setInput(boolean p_184442_1_, boolean p_184442_2_, boolean p_184442_3_, boolean p_184442_4_) {
		this.inputLeft = p_184442_1_;
		this.inputRight = p_184442_2_;
		this.inputUp = p_184442_3_;
		this.inputDown = p_184442_4_;
	}

	@Override
	public boolean isUnderWater() {
		return this.status == ShuttleEntity.Status.UNDER_WATER || this.status == ShuttleEntity.Status.UNDER_FLOWING_WATER;
	}

	// Forge: Fix MC-119811 by instantly completing lerp on board
	@Override
	protected void addPassenger(Entity passenger) {
		super.addPassenger(passenger);
		if (this.isControlledByLocalInstance() && this.lerpSteps > 0) {
			this.lerpSteps = 0;
			this.absMoveTo(this.lerpX, this.lerpY, this.lerpZ, (float)this.lerpYRot, (float)this.lerpXRot);
		}
	}




	public static enum Status {
		IN_WATER,
		UNDER_WATER,
		UNDER_FLOWING_WATER,
		ON_LAND,
		IN_AIR;
	}

	public static enum Color {
		WHITE("white"),
		RED("red"),
		ORANGE("orange"),
		YELLOW("yellow"),
		GREEN("green"),
		BLUE("blue"),
		PURPLE("purple"),
		BLACK("black");

		private final String name;
		//		      private final Block planks;

		private Color(String p_i48146_4_) {
			this.name = p_i48146_4_;
			//		         this.color = p_i48146_3_;
		}

		public String getName() {
			return this.name;
		}

		//		      public Block getPlanks() {
		//		         return this.planks;
		//		      }

		@Override
		public String toString() {
			return this.name;
		}

		public static ShuttleEntity.Color byId(int p_184979_0_) {
			ShuttleEntity.Color[] ashuttleentity$color = values();
			if (p_184979_0_ < 0 || p_184979_0_ >= ashuttleentity$color.length) {
				p_184979_0_ = 0;
			}
			return ashuttleentity$color[p_184979_0_];

		}

		public static ShuttleEntity.Color byName(String p_184981_0_) {
			ShuttleEntity.Color[] ashuttleentity$color = values();

			for(int i = 0; i < ashuttleentity$color.length; ++i) {
				if (ashuttleentity$color[i].getName().equals(p_184981_0_)) {
					return ashuttleentity$color[i];
				}
			}

			return ashuttleentity$color[0];
		}
	}

}