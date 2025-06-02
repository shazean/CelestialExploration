package com.shim.celestialexploration.item;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TestItem extends Item {
    public final TestItemDispatcher dispatcher;

    public TestItem(Properties p_41383_) {
        super(p_41383_);
        this.dispatcher = new TestItemDispatcher();
    }

    @Override
    public void inventoryTick(ItemStack stack, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {
        super.inventoryTick(stack, p_41405_, p_41406_, p_41407_, p_41408_);

        dispatcher.idle(p_41406_, stack);
    }
}
