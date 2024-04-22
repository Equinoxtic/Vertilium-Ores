package com.equinoxtic.vertiliumores.init;

import com.equinoxtic.vertiliumores.objects.items.IngotVertilium;
import com.equinoxtic.vertiliumores.objects.tools.ToolAxe;
import com.equinoxtic.vertiliumores.objects.tools.ToolPickaxe;
import com.equinoxtic.vertiliumores.objects.tools.ToolSword;
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
            2576, // Durability
            18.0F, // Efficiency
            9.0F, // Base Damage
            22 // Enchantability
    );

    public static final ToolMaterial SWORD_MATERIAL = EnumHelper.addToolMaterial(
            "tool_sword_vertilium",
            4, // Harvest Level
            3044, // Durability
            12.0F, // Efficiency
            18.0F, // Base Damage
            24 // Enchantability
    );

    public static final ToolMaterial AXE_MATERIAL = EnumHelper.addToolMaterial(
            "tool_axe_vertilium",
            4, // Harvest Level
            2810, // Durability
            16.0F, // Efficiency
            17.0F, // Base Damage
            23 // Enchantability
    );

    public static final ToolMaterial HOE_MATERIAL = EnumHelper.addToolMaterial(
            "tool_hoe_vertilium",
            4, // Harvest Level
            2342, // Durability
            18.0F, // Efficiency
            12.0F, // Base Damage
            21 // Enchantability
    );

    // Items
    public static final Item VERTILIUM = new IngotVertilium();

    // Tools
    public static final Item VERTILIUM_PICKAXE = new ToolPickaxe("vertilium_pickaxe", PICKAXE_MATERIAL);
    public static final Item VERTILIUM_SWORD = new ToolSword("vertilium_sword", SWORD_MATERIAL);
    public static final Item VERTILIUM_AXE = new ToolAxe("vertilium_axe", AXE_MATERIAL);
    public static final Item VERTILIUM_HOE = new ToolAxe("vertilium_hoe", HOE_MATERIAL);
}
