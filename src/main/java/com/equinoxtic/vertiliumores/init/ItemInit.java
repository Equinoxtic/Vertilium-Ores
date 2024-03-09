package com.equinoxtic.vertiliumores.init;

import com.equinoxtic.vertiliumores.objects.items.IngotVertilium;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemInit
{
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item VERTILIUM = new IngotVertilium();
}
