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
    public static final ToolMaterial TOOL_VERTILIUM = EnumHelper.addToolMaterial(
            "tool_vertilium",
            4,
            2342,
            8.0F,
            12.0F,
            12);

    // Items
    public static final Item VERTILIUM = new IngotVertilium();

    // Tools
    public static final Item PICKAXE_VERTILIUM = new ToolPickaxe("pickaxe_vertilium", TOOL_VERTILIUM);
}
