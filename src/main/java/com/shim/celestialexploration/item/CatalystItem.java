package com.shim.celestialexploration.item;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.DimensionRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class CatalystItem extends Item {
    public CatalystItem() {
        super(new Properties()
                .tab(CelestialExploration.CELESTIAL_MISC_TAB)
//                .stacksTo(1)
//                .rarity(Rarity.RARE)
        );
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        if(player != null) {
            if(player.level.dimension() == DimensionRegistry.MARS
                    || player.level.dimension() == DimensionRegistry.MOON
                    || player.level.dimension() == DimensionRegistry.VENUS

                    || player.level.dimension() == Level.OVERWORLD) {
                for(Direction direction : Direction.Plane.VERTICAL) {
                    BlockPos framePos = context.getClickedPos().relative(direction);
                    if(BlockRegistry.MARS_PORTAL.get().trySpawnPortal(level, framePos)) {
                        level.playSound(player, framePos,
                                SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                        return InteractionResult.CONSUME;
                    }
                    else if(BlockRegistry.MOON_PORTAL.get().trySpawnPortal(level, framePos)) {
                        level.playSound(player, framePos,
                                SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                        return InteractionResult.CONSUME;
                    }
                    else if(BlockRegistry.VENUS_PORTAL.get().trySpawnPortal(level, framePos)) {
                        level.playSound(player, framePos,
                                SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                        return InteractionResult.CONSUME;
                    }
                    else return InteractionResult.FAIL;
                }
            }
        }
        return InteractionResult.FAIL;
    }
}
