package com.equinoxtic.vertiliumores.recipes;

import com.equinoxtic.vertiliumores.init.BlockInit;
import com.equinoxtic.vertiliumores.init.ItemInit;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingRecipes
{
    public static void init() {
        GameRegistry.addSmelting(
                new ItemStack(BlockInit.ORE_VERTILIETE_OVERWORLD),
                new ItemStack(ItemInit.VERTILIUM),
                1.15f);
    }
}

