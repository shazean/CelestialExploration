package com.shim.celestialexploration.entity;


import javax.annotation.Nullable;
import javax.naming.ldap.Control;
import java.util.Iterator;
import java.util.List;

//public class ControlPanel extends HangingEntity {
//    public Motive motive = Motive.KEBAB;
//
//    public ControlPanel(EntityType<? extends ControlPanel> p_31904_, Level p_31905_) {
//        super(p_31904_, p_31905_);
//    }
//
//    public ControlPanel(Level level, BlockPos pos, Direction direction) {
//        super(EntityRegistry.CONTROL_PANEL.get(), level, pos);
//        List<Motive> list = Lists.newArrayList();
//        int i = 0;
//
//        for(Motive motive : Registry.MOTIVE) {
//            this.motive = motive;
//            this.setDirection(direction);
//            if (this.survives()) {
//                list.add(motive);
//                int j = motive.getWidth() * motive.getHeight();
//                if (j > i) {
//                    i = j;
//                }
//            }
//        }
//
//        if (!list.isEmpty()) {
//            Iterator<Motive> iterator = list.iterator();
//
//            while(iterator.hasNext()) {
//                Motive motive1 = iterator.next();
//                if (motive1.getWidth() * motive1.getHeight() < i) {
//                    iterator.remove();
//                }
//            }
//
//            this.motive = list.get(this.random.nextInt(list.size()));
//        }
//
//        this.setDirection(direction);
//    }
//
//    public ControlPanel(Level level, BlockPos pos, Direction direction, Motive motive) {
//        this(level, pos, direction);
//        this.motive = motive;
//        this.setDirection(direction);
//    }
//
//    public void addAdditionalSaveData(CompoundTag p_31935_) {
//        p_31935_.putString("Motive", Registry.MOTIVE.getKey(this.motive).toString());
//        p_31935_.putByte("Facing", (byte)this.direction.get2DDataValue());
//        super.addAdditionalSaveData(p_31935_);
//    }
//
//    public void readAdditionalSaveData(CompoundTag p_31927_) {
//        this.motive = Registry.MOTIVE.get(ResourceLocation.tryParse(p_31927_.getString("Motive")));
//        this.direction = Direction.from2DDataValue(p_31927_.getByte("Facing"));
//        super.readAdditionalSaveData(p_31927_);
//        this.setDirection(this.direction);
//    }
//
//    public int getWidth() {
//        return this.motive.getWidth();
//    }
//
//    public int getHeight() {
//        return this.motive.getHeight();
//    }
//
//    public void dropItem(@Nullable Entity entity) {
//        if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
//            this.playSound(SoundEvents.PAINTING_BREAK, 1.0F, 1.0F);
//            if (entity instanceof Player player) {
//                if (player.getAbilities().instabuild) {
//                    return;
//                }
//            }
//
//            this.spawnAtLocation(ItemRegistry.CONTROL_PANEL.get());
//        }
//    }
//
//    public void playPlacementSound() {
//        this.playSound(SoundEvents.PAINTING_PLACE, 1.0F, 1.0F);
//    }
//
//    public void moveTo(double p_31929_, double p_31930_, double p_31931_, float p_31932_, float p_31933_) {
//        this.setPos(p_31929_, p_31930_, p_31931_);
//    }
//
//    public void lerpTo(double p_31917_, double p_31918_, double p_31919_, float p_31920_, float p_31921_, int p_31922_, boolean p_31923_) {
//        BlockPos blockpos = this.pos.offset(p_31917_ - this.getX(), p_31918_ - this.getY(), p_31919_ - this.getZ());
//        this.setPos((double)blockpos.getX(), (double)blockpos.getY(), (double)blockpos.getZ());
//    }
//
//    public Packet<?> getAddEntityPacket() {
//        return new ControlPanelPacket(this);
//    }
//
//    public ItemStack getPickResult() {
//        return new ItemStack(ItemRegistry.CONTROL_PANEL.get());
//    }
//}