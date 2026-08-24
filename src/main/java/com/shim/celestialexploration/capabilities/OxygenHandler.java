package com.shim.celestialexploration.capabilities;

import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.item.armor.SpacesuitArmorItem;
import com.shim.celestialexploration.registry.CelestialDamageSource;
import com.shim.celestialexploration.util.OxygenUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public class OxygenHandler {

    int maxOxygen;
    int currentOxygen;
    int tickDelay = 0;
    static final int DEFAULT_HELMET = 100;

    public void tick(Player player) {
        //TODO where should player location be checked?
        this.useOxygen(player.isSprinting());

        if (currentOxygen <= 0) {
            currentOxygen = 0; //reset to 0 so adding oxygen works properly
            tickDelay++;

            if (tickDelay == 20) {
                tickDelay = 0;

                if (CelestialCommonConfig.OXYGEN_DAMAGE_TYPE.get() == CelestialCommonConfig.OxygenDamage.FULL) {
                    //player should take full damage
                    player.hurt(CelestialDamageSource.SUFFOCATE, 0.5F);
                } else if (CelestialCommonConfig.OXYGEN_DAMAGE_TYPE.get() == CelestialCommonConfig.OxygenDamage.HALF_HEART) {
                    //player should take damage only until half a heart
                    if (player.getHealth() > 0.5F) {
                        player.hurt(CelestialDamageSource.SUFFOCATE, 0.5F);
                    }
                }

                if (CelestialCommonConfig.OXYGEN_DEBUFF.get()) {
                    //TODO apply debuffs
                    //
                }
            }
        }

        this.checkMaxOxygen(player);
    }

    public void useOxygen(boolean isSprintingOrAttacking) {
        if (isSprintingOrAttacking)
            this.currentOxygen -= 2;
        else
            this.currentOxygen--;
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
        } else if (helmet.getItem() instanceof SpacesuitArmorItem armorItem) { //spacesuit helmet(s)
            this.maxOxygen = SpacesuitArmorItem.getOxygenBoost(helmet, player);
            //get value from helmet
        } else { //non-spacesuit helmet
            this.maxOxygen = OxygenUtil.DEFAULT_OXYGEN_HELMET;
        }

        ItemStack chestplate = player.getInventory().getArmor(2); //FIXME check this is the right value?
        if (!chestplate.isEmpty() && chestplate.getItem() instanceof SpacesuitArmorItem) {
            //if wearing a chestpiece, add appropriate oxygen amounts
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
