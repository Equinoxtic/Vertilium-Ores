package com.equinoxtic.vertiliumores.init;

import com.equinoxtic.vertiliumores.objects.blocks.BlockOres;
import com.equinoxtic.vertiliumores.objects.blocks.BlockVertilium;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block BLOCK_VERTILIUM = new BlockVertilium(Material.IRON);

    public static final Block ORE_VERTILIETE_OVERWORLD = new BlockOres("ore_overworld", "overworld");
    // public static final Block ORE_VERTILIETE_END = new BlockOres("ore_end", "end");
}
