package com.shim.celestialexploration.blocks;

import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RailShape;

import javax.annotation.Nullable;
import java.util.List;

public class MagRailState {
    private final Level level;
    private final BlockPos pos;
    private final BaseMagRailBlock block;
    private BlockState state;
    private final boolean isStraight;
    private final List<BlockPos> connections = Lists.newArrayList();
    private final boolean canMakeSlopes;

    public MagRailState(Level level, BlockPos pos, BlockState state) {
        this.level = level;
        this.pos = pos;
        this.state = state;
        this.block = (BaseMagRailBlock)state.getBlock();
        RailShape railshape = this.block.getRailDirection(state, level, pos, null);
        this.isStraight = !this.block.isFlexibleRail(state, level, pos);
        this.canMakeSlopes = this.block.canMakeSlopes(state, level, pos);
        this.updateConnections(railshape);
    }

    public List<BlockPos> getConnections() {
        return this.connections;
    }

    private void updateConnections(RailShape shape) {
        this.connections.clear();
        switch (shape) {
            case NORTH_SOUTH -> {
                this.connections.add(this.pos.north());
                this.connections.add(this.pos.south());
            }
            case EAST_WEST -> {
                this.connections.add(this.pos.west());
                this.connections.add(this.pos.east());
            }
            case ASCENDING_EAST -> {
                this.connections.add(this.pos.west());
                this.connections.add(this.pos.east().above());
            }
            case ASCENDING_WEST -> {
                this.connections.add(this.pos.west().above());
                this.connections.add(this.pos.east());
            }
            case ASCENDING_NORTH -> {
                this.connections.add(this.pos.north().above());
                this.connections.add(this.pos.south());
            }
            case ASCENDING_SOUTH -> {
                this.connections.add(this.pos.north());
                this.connections.add(this.pos.south().above());
            }
            case SOUTH_EAST -> {
                this.connections.add(this.pos.east());
                this.connections.add(this.pos.south());
            }
            case SOUTH_WEST -> {
                this.connections.add(this.pos.west());
                this.connections.add(this.pos.south());
            }
            case NORTH_WEST -> {
                this.connections.add(this.pos.west());
                this.connections.add(this.pos.north());
            }
            case NORTH_EAST -> {
                this.connections.add(this.pos.east());
                this.connections.add(this.pos.north());
            }
        }

    }

    private void removeSoftConnections() {
        for(int i = 0; i < this.connections.size(); ++i) {
            MagRailState railstate = this.getRail(this.connections.get(i));
            if (railstate != null && railstate.connectsTo(this)) {
                this.connections.set(i, railstate.pos);
            } else {
                this.connections.remove(i--);
            }
        }

    }

    private boolean hasRail(BlockPos pos) {
        return BaseMagRailBlock.isRail(this.level, pos) || BaseMagRailBlock.isRail(this.level, pos.above()) || BaseMagRailBlock.isRail(this.level, pos.below());
    }

    @Nullable
    private MagRailState getRail(BlockPos pos) {
        BlockState blockstate = this.level.getBlockState(pos);
        if (BaseMagRailBlock.isRail(blockstate)) {
            return new MagRailState(this.level, pos, blockstate);
        } else {
            BlockPos $$1 = pos.above();
            blockstate = this.level.getBlockState($$1);
            if (BaseMagRailBlock.isRail(blockstate)) {
                return new MagRailState(this.level, $$1, blockstate);
            } else {
                $$1 = pos.below();
                blockstate = this.level.getBlockState($$1);
                return BaseMagRailBlock.isRail(blockstate) ? new MagRailState(this.level, $$1, blockstate) : null;
            }
        }
    }

    private boolean connectsTo(MagRailState state) {
        return this.hasConnection(state.pos);
    }

    private boolean hasConnection(BlockPos pos) {
        for(int i = 0; i < this.connections.size(); ++i) {
            BlockPos blockpos = this.connections.get(i);
            if (blockpos.getX() == pos.getX() && blockpos.getZ() == pos.getZ()) {
                return true;
            }
        }

        return false;
    }

    public int countPotentialConnections() {
        int i = 0;

        for(Direction direction : Direction.Plane.HORIZONTAL) {
            if (this.hasRail(this.pos.relative(direction))) {
                ++i;
            }
        }

        return i;
    }

    private boolean canConnectTo(MagRailState railState) {
        return this.connectsTo(railState) || this.connections.size() != 2;
    }

    private void connectTo(MagRailState railState) {
        this.connections.add(railState.pos);
        BlockPos posNorth = this.pos.north();
        BlockPos posSouth = this.pos.south();
        BlockPos posWest = this.pos.west();
        BlockPos posEast = this.pos.east();
        boolean hasNorth = this.hasConnection(posNorth);
        boolean hasSouth = this.hasConnection(posSouth);
        boolean hasWest = this.hasConnection(posWest);
        boolean hasEast = this.hasConnection(posEast);
        RailShape railshape = null;
        if (hasNorth || hasSouth) {
            railshape = RailShape.NORTH_SOUTH;
        }

        if (hasWest || hasEast) {
            railshape = RailShape.EAST_WEST;
        }

        if (!this.isStraight) {
            if (hasSouth && hasEast && !hasNorth && !hasWest) {
                railshape = RailShape.SOUTH_EAST;
            }

            if (hasSouth && hasWest && !hasNorth && !hasEast) {
                railshape = RailShape.SOUTH_WEST;
            }

            if (hasNorth && hasWest && !hasSouth && !hasEast) {
                railshape = RailShape.NORTH_WEST;
            }

            if (hasNorth && hasEast && !hasSouth && !hasWest) {
                railshape = RailShape.NORTH_EAST;
            }
        }

        if (railshape == RailShape.NORTH_SOUTH && canMakeSlopes) {
            if (BaseMagRailBlock.isRail(this.level, posNorth.above())) {
                railshape = RailShape.ASCENDING_NORTH;
            }

            if (BaseMagRailBlock.isRail(this.level, posSouth.above())) {
                railshape = RailShape.ASCENDING_SOUTH;
            }
        }

        if (railshape == RailShape.EAST_WEST && canMakeSlopes) {
            if (BaseMagRailBlock.isRail(this.level, posEast.above())) {
                railshape = RailShape.ASCENDING_EAST;
            }

            if (BaseMagRailBlock.isRail(this.level, posWest.above())) {
                railshape = RailShape.ASCENDING_WEST;
            }
        }

        if (railshape == null) {
            railshape = RailShape.NORTH_SOUTH;
        }

        if (!this.block.isValidRailShape(railshape)) { // Forge: allow rail block to decide if the new shape is valid
            this.connections.remove(railState.pos);
            return;
        }
        this.state = this.state.setValue(this.block.getShapeProperty(), railshape);
        this.level.setBlock(this.pos, this.state, 3);
    }

    private boolean hasNeighborRail(BlockPos p_55447_) {
        MagRailState railstate = this.getRail(p_55447_);
        if (railstate == null) {
            return false;
        } else {
            railstate.removeSoftConnections();
            return railstate.canConnectTo(this);
        }
    }

    public MagRailState place(boolean p_55432_, boolean p_55433_, RailShape railShape) {
        BlockPos posNorth = this.pos.north();
        BlockPos posSouth = this.pos.south();
        BlockPos posWest = this.pos.west();
        BlockPos posEast = this.pos.east();
        boolean hasNorth = this.hasNeighborRail(posNorth);
        boolean hasSouth = this.hasNeighborRail(posSouth);
        boolean hasWest = this.hasNeighborRail(posWest);
        boolean hasEast = this.hasNeighborRail(posEast);
        RailShape railshape = null;
        boolean hasNorthOrSouth = hasNorth || hasSouth;
        boolean hasEastOrWest = hasWest || hasEast;
        if (hasNorthOrSouth && !hasEastOrWest) {
            railshape = RailShape.NORTH_SOUTH;
        }

        if (hasEastOrWest && !hasNorthOrSouth) {
            railshape = RailShape.EAST_WEST;
        }

        boolean hasSouthEast = hasSouth && hasEast;
        boolean hasSouthWest = hasSouth && hasWest;
        boolean hasNorthEast = hasNorth && hasEast;
        boolean hasNorthWest = hasNorth && hasWest;
        if (!this.isStraight) {
            if (hasSouthEast && !hasNorth && !hasWest) railshape = RailShape.SOUTH_EAST;
            if (hasSouthWest && !hasNorth && !hasEast) railshape = RailShape.SOUTH_WEST;
            if (hasNorthWest && !hasSouth && !hasEast) railshape = RailShape.NORTH_WEST;
            if (hasNorthEast && !hasSouth && !hasWest) railshape = RailShape.NORTH_EAST;
        }

        if (railshape == null) {
            if (hasNorthOrSouth && hasEastOrWest) {
                railshape = railShape;
            } else if (hasNorthOrSouth) {
                railshape = RailShape.NORTH_SOUTH;
            } else if (hasEastOrWest) {
                railshape = RailShape.EAST_WEST;
            }

            if (!this.isStraight) {
                if (p_55432_) {
                    if (hasSouthEast) railshape = RailShape.SOUTH_EAST;
                    if (hasSouthWest) railshape = RailShape.SOUTH_WEST;
                    if (hasNorthEast) railshape = RailShape.NORTH_EAST;
                    if (hasNorthWest)railshape = RailShape.NORTH_WEST;
                } else {
                    if (hasNorthWest) railshape = RailShape.NORTH_WEST;
                    if (hasNorthEast) railshape = RailShape.NORTH_EAST;
                    if (hasSouthWest) railshape = RailShape.SOUTH_WEST;
                    if (hasSouthEast) railshape = RailShape.SOUTH_EAST;
                }
            }
        }

        if (railshape == RailShape.NORTH_SOUTH && canMakeSlopes) {
            if (BaseMagRailBlock.isRail(this.level, posNorth.above())) railshape = RailShape.ASCENDING_NORTH;
            if (BaseMagRailBlock.isRail(this.level, posSouth.above())) railshape = RailShape.ASCENDING_SOUTH;
        }

        if (railshape == RailShape.EAST_WEST && canMakeSlopes) {
            if (BaseMagRailBlock.isRail(this.level, posEast.above())) railshape = RailShape.ASCENDING_EAST;
            if (BaseMagRailBlock.isRail(this.level, posWest.above())) railshape = RailShape.ASCENDING_WEST;
        }

        if (railshape == null || !this.block.isValidRailShape(railshape)) { // Forge: allow rail block to decide if the new shape is valid
            railshape = railShape;
        }

        this.updateConnections(railshape);
        this.state = this.state.setValue(this.block.getShapeProperty(), railshape);
        if (p_55433_ || this.level.getBlockState(this.pos) != this.state) {
            this.level.setBlock(this.pos, this.state, 3);

            for (BlockPos connection : this.connections) {
                MagRailState railstate = this.getRail(connection);
                if (railstate != null) {
                    railstate.removeSoftConnections();
                    if (railstate.canConnectTo(this)) {
                        railstate.connectTo(this);
                    }
                }
            }
        }

        return this;
    }

    public BlockState getState() {
        return this.state;
    }
}
