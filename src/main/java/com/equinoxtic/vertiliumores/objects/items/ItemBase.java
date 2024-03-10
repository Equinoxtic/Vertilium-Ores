package com.equinoxtic.vertiliumores.objects.items;

import com.equinoxtic.vertiliumores.Main;
import com.equinoxtic.vertiliumores.init.ItemInit;
import com.equinoxtic.vertiliumores.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name, CreativeTabs creativetab) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.VERTILIUM_ORES);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
