package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;

import java.util.Locale;

public class CelestialStructurePieceType {
    public static StructurePieceType RESEARCH_TUNNEL_CORRIDOR;
    public static StructurePieceType RESEARCH_TUNNEL_CROSSING;
    public static StructurePieceType RESEARCH_TUNNEL_ROOM;
    public static StructurePieceType RESEARCH_TUNNEL_STAIRS;

    public static StructurePieceType register(String name, StructurePieceType.ContextlessType structurePiece) {
        return Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(CelestialExploration.MODID, name.toLowerCase(Locale.ROOT)), structurePiece);
    }
}
