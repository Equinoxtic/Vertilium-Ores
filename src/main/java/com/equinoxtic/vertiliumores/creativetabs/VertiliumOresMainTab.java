package com.equinoxtic.vertiliumores.creativetabs;

import com.equinoxtic.vertiliumores.Main;
import com.equinoxtic.vertiliumores.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class VertiliumOresMainTab extends CreativeTabs
{
    public VertiliumOresMainTab()
    {
        super("vertilium_ores");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemInit.VERTILIUM);
    }
}
