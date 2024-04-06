package com.equinoxtic.vertiliumores.init;

import com.equinoxtic.vertiliumores.objects.items.IngotVertilium;
import com.equinoxtic.vertiliumores.objects.tools.ToolPickaxe;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemInit
{
    public static final List<Item> ITEMS = new ArrayList<Item>();

    // Materials
    public static final ToolMaterial PICKAXE_MATERIAL = EnumHelper.addToolMaterial(
            "tool_pickaxe_vertilium",
            4, // Harvest Level
            2342, // Durability
            15.0F, // Efficiency
            12.0F, // Base Damage
            12 // Enchantability
    );

    // Items
    public static final Item VERTILIUM = new IngotVertilium();

    // Tools
    public static final Item PICKAXE_VERTILIUM = new ToolPickaxe("pickaxe_vertilium", PICKAXE_MATERIAL);
}
