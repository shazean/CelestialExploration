package com.shim.celestialexploration.capabilities;

import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.item.armor.SpacesuitArmorItem;
import com.shim.celestialexploration.registry.CelestialDamageSource;
import com.shim.celestialexploration.registry.CelestialEffects;
import com.shim.celestialexploration.registry.CelestialTags;
import com.shim.celestialexploration.util.OxygenUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class OxygenHandler {

    int maxOxygen;
    int currentOxygen;
    int tickDelay = 0;

    public void tick(Player player) {
        boolean accessToOxygen = player.hasEffect(CelestialEffects.OXYGENATED_EFFECT.get());

        if (!accessToOxygen) {
            if (
                this.inLocationWithoutOxygen(player) &&
                    !player.isCreative()) {
                this.useOxygen(player.isSprinting(), player);
            }
        }

        if (accessToOxygen)
            this.incrementOxygen();

        if (currentOxygen > maxOxygen)
            currentOxygen = maxOxygen;

        if (currentOxygen <= 0) {
            currentOxygen = 0; //reset to 0 so adding oxygen works properly
            tickDelay++;

            if (tickDelay == 60) {
                tickDelay = 0;

                if (CelestialCommonConfig.OXYGEN_DAMAGE_TYPE.get() == CelestialCommonConfig.OxygenDamage.FULL) {
                    //player should take full damage
                    player.hurt(CelestialDamageSource.SUFFOCATE, 2.0F);
                } else if (CelestialCommonConfig.OXYGEN_DAMAGE_TYPE.get() == CelestialCommonConfig.OxygenDamage.HALF_HEART) {
                    //player should take damage only until half a heart
                    if (player.getHealth() > 0.5F) {
                        player.hurt(CelestialDamageSource.SUFFOCATE, 2.0F);
                    }
                }

                if (CelestialCommonConfig.OXYGEN_DEBUFF.get()) {
                    player.addEffect(new MobEffectInstance(CelestialEffects.SUFFOCATION_EFFECT.get(), 260, 0, true, true));
                }
            }
        }

//        this.checkMaxOxygen(player);

//        CelestialExploration.LOGGER.debug("currentOxygen: " + currentOxygen + ", max: " + maxOxygen);
    }

    private void incrementOxygen() {
        this.currentOxygen++;
    }

    private boolean inLocationWithoutOxygen(Player player) {
        Level level = player.level;
        BlockPos pos = player.blockPosition();

        return level.getBiome(pos).is(CelestialTags.Biomes.NO_OXYGEN_BIOMES);
    }

    public void useOxygen(boolean isSprintingOrAttacking, Player player) {
        if (isSprintingOrAttacking) {
            ItemStack helmet = player.getInventory().getArmor(3);
            if (helmet.getItem() instanceof SpacesuitArmorItem spacesuit) {
                if (SpacesuitArmorItem.isHelmet(spacesuit)) {
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

    public void checkMaxOxygen(Player player) {
        ItemStack helmet = player.getInventory().getArmor(3);
        if (helmet.isEmpty()) { //no helmet
            this.maxOxygen = OxygenUtil.DEFAULT_OXYGEN_NO_HELMET;
        } else if (helmet.getItem() instanceof SpacesuitArmorItem) { //spacesuit helmet(s)
            this.maxOxygen = SpacesuitArmorItem.getOxygenBoost(helmet, player);
            //get value from helmet
        } else { //non-spacesuit helmet
            this.maxOxygen = OxygenUtil.DEFAULT_OXYGEN_WITH_HELMET;
        }

        ItemStack chestplate = player.getInventory().getArmor(2); //FIXME check this is the right value?
        if (!chestplate.isEmpty() && chestplate.getItem() instanceof SpacesuitArmorItem) {
            //if wearing a chestplate, add appropriate oxygen amounts
            this.maxOxygen += SpacesuitArmorItem.getOxygenBoost(chestplate, player);
        }
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
}
