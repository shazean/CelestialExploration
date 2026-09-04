package com.shim.celestialexploration.capabilities;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.item.armor.SpacesuitArmorItem;
import com.shim.celestialexploration.packets.CelestialPacketHandler;
import com.shim.celestialexploration.packets.OxygenHandlerPacket;
import com.shim.celestialexploration.registry.CelestialDamageSource;
import com.shim.celestialexploration.registry.CelestialEffects;
import com.shim.celestialexploration.registry.CelestialTags;
import com.shim.celestialexploration.util.OxygenDamage;
import com.shim.celestialexploration.util.OxygenUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkDirection;

public class OxygenHandler {

    int maxOxygen;
    int currentOxygen;
    int tickDelay = 0;
    final static float DAMAGE = 1.0F;

    public void tick(Player player) {
        if (CelestialCommonConfig.OXYGEN_MECHANIC_ENABLED.get()) {
            boolean accessToOxygen = player.hasEffect(CelestialEffects.OXYGENATED_EFFECT.get());

//            CelestialExploration.LOGGER.debug("oxygen? " + accessToOxygen);

            if (!accessToOxygen) {
                if (this.inLocationWithoutOxygen(player) && !player.isCreative()) {
                    this.useOxygen(player.isSprinting(), player);
                }
            }

            if (accessToOxygen)
                this.refillOxygen();

            if (currentOxygen > maxOxygen)
                currentOxygen = maxOxygen;

            if (currentOxygen <= 0) {
                currentOxygen = 0; //reset to 0 so adding oxygen works properly
                tickDelay++;

                if (tickDelay == 60) {
                    tickDelay = 0;
                    Level level = player.level;

                    applyDamage(level, player);
                    applyDebuff(level, player);
                }
            }

            if (player instanceof ServerPlayer serverPlayer) {
                CelestialPacketHandler.INSTANCE.sendTo(new OxygenHandlerPacket(currentOxygen), serverPlayer.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
            }

//        this.checkMaxOxygen(player);

//        CelestialExploration.LOGGER.debug("currentOxygen: " + currentOxygen + ", max: " + maxOxygen);
        }
    }

    private void applyDebuff(Level level, Player player) {
        if (CelestialCommonConfig.OXYGEN_SCALES_WITH_DIFFICULTY.get()) {
            Difficulty difficulty = level.getDifficulty();

            if (CelestialCommonConfig.OXYGEN_DEBUFF.get())
                if (difficulty == Difficulty.NORMAL || difficulty == Difficulty.HARD)
                    player.addEffect(new MobEffectInstance(CelestialEffects.SUFFOCATION_EFFECT.get(), 260, 0, true, true));

        } else {
            if (CelestialCommonConfig.OXYGEN_DEBUFF.get())
                player.addEffect(new MobEffectInstance(CelestialEffects.SUFFOCATION_EFFECT.get(), 260, 0, true, true));
        }
    }

    private void applyDamage(Level level, Player player) {

        if (CelestialCommonConfig.OXYGEN_SCALES_WITH_DIFFICULTY.get()) {
            Difficulty difficulty = level.getDifficulty();

            if (CelestialCommonConfig.OXYGEN_DAMAGE_TYPE.get() == OxygenDamage.FULL) {
                if (difficulty == Difficulty.NORMAL || difficulty == Difficulty.HARD) {
                    player.hurt(CelestialDamageSource.SUFFOCATE, DAMAGE);
                }
                if (difficulty == Difficulty.EASY) {
                    if (player.getHealth() >= (DAMAGE + 0.5F)) {
                        player.hurt(CelestialDamageSource.SUFFOCATE, DAMAGE);
                    }
                }
                //do nothing if peaceful
            }

            if (CelestialCommonConfig.OXYGEN_DAMAGE_TYPE.get() == OxygenDamage.HALF_HEART) {
                if (difficulty == Difficulty.HARD) {
                    player.hurt(CelestialDamageSource.SUFFOCATE, DAMAGE);
                }
                if (difficulty == Difficulty.EASY || difficulty == Difficulty.NORMAL) {
                    if (player.getHealth() >= (DAMAGE + 0.5F)) {
                        player.hurt(CelestialDamageSource.SUFFOCATE, DAMAGE);
                    }
                }
                //do nothing if peaceful
            }
        } else {
            if (CelestialCommonConfig.OXYGEN_DAMAGE_TYPE.get() == OxygenDamage.FULL) {
                player.hurt(CelestialDamageSource.SUFFOCATE, DAMAGE);
            } else if (CelestialCommonConfig.OXYGEN_DAMAGE_TYPE.get() == OxygenDamage.HALF_HEART) {
                if (player.getHealth() >= (DAMAGE + 0.5F)) {
                    player.hurt(CelestialDamageSource.SUFFOCATE, DAMAGE);
                }
            }
        }
    }

    private void refillOxygen() {
        this.currentOxygen += 3;
    }

    public void instantOxygen(int amount) {
        this.currentOxygen += amount;
    }

    public void setOxygen(int oxygen) {
        this.currentOxygen = oxygen;
    }

    public boolean inLocationWithoutOxygen(Player player) {
        Level level = player.level;
        BlockPos pos = player.blockPosition();

        return level.getBiome(pos).is(CelestialTags.Biomes.NO_OXYGEN_BIOMES);
    }

    public void useOxygen(boolean isSprintingOrAttacking, Player player) {
        if (isSprintingOrAttacking) {
            ItemStack helmet = player.getInventory().getArmor(3);
            if (helmet.getItem() instanceof SpacesuitArmorItem spacesuit) {
                if (SpacesuitArmorItem.isHeavyDuty(spacesuit)) {
                    this.currentOxygen--;
                } else
                    this.currentOxygen -= 2;
            } else
                this.currentOxygen -= 2;
        } else
            this.currentOxygen--;
    }

    public void setOxygenToFull() {
        this.currentOxygen = this.maxOxygen;
    }

    public void checkEquipmentAndAddOxygen(ItemStack itemStack, Player player, EquipmentSlot slot) {
        int oxygenToAdd = 0;

        if (itemStack.getItem() instanceof SpacesuitArmorItem) {
            oxygenToAdd = SpacesuitArmorItem.getOxygenBoost(itemStack, player);
        } else if (slot == EquipmentSlot.HEAD) {
            oxygenToAdd = OxygenUtil.DEFAULT_OXYGEN_WITH_HELMET;
        }

        this.addOxygen(oxygenToAdd);
    }

    public void addOxygen(int amount) {
        if (this.currentOxygen < 0)
            this.currentOxygen = 0;
        this.currentOxygen += amount;
        if (this.currentOxygen > this.maxOxygen)
            this.currentOxygen = this.maxOxygen;
        //TODO remove debuffs
    }

    public void equipSuitAddOxygen(Player player) {
        ItemStack helmet = player.getInventory().getArmor(3);
        if (helmet.getItem() instanceof SpacesuitArmorItem) {
            this.currentOxygen += OxygenUtil.DEFAULT_OXYGEN_NO_HELMET;
        }
    }

    public boolean checkMaxOxygen(Player player) {
        ItemStack helmet = player.getInventory().getArmor(3);
        if (helmet.isEmpty()) { //no helmet
            this.maxOxygen = OxygenUtil.DEFAULT_OXYGEN_NO_HELMET;
            this.currentOxygen += OxygenUtil.DEFAULT_OXYGEN_NO_HELMET / 4;
        } else if (helmet.getItem() instanceof SpacesuitArmorItem) { //spacesuit helmet(s)
            int oxygenFromHelmet = SpacesuitArmorItem.getOxygenBoost(helmet, player);
            this.maxOxygen = oxygenFromHelmet;
            this.currentOxygen += oxygenFromHelmet / 4;
            //get value from helmet
        } else { //non-spacesuit helmet
            this.maxOxygen = OxygenUtil.DEFAULT_OXYGEN_WITH_HELMET;
            this.currentOxygen += OxygenUtil.DEFAULT_OXYGEN_WITH_HELMET / 4;
        }

        ItemStack chestplate = player.getInventory().getArmor(2); //FIXME check this is the right value?
        if (!chestplate.isEmpty() && chestplate.getItem() instanceof SpacesuitArmorItem) {
            //if wearing a chestplate, add appropriate oxygen amounts
            this.maxOxygen += SpacesuitArmorItem.getOxygenBoost(chestplate, player);
        }
        return false;
    }

    public void setData(CompoundTag nbt) {
        if (nbt.contains("current")) this.currentOxygen = nbt.getInt("current");
        if (nbt.contains("max")) this.maxOxygen = nbt.getInt("max");
    }

    public CompoundTag getData() {
        CompoundTag nbt = new CompoundTag();
        nbt.putInt("current", this.currentOxygen);
        nbt.putInt("max", this.maxOxygen);
        return nbt;
    }

    public int getOxygen() {
        return this.currentOxygen;
    }
}
