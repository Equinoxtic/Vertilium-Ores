package com.equinoxtic.vertiliumores.objects.items;

import com.equinoxtic.vertiliumores.Main;
import com.equinoxtic.vertiliumores.init.ItemInit;
import com.equinoxtic.vertiliumores.util.interfaces.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class IngotVertilium extends Item implements IHasModel {

    private String item_name = "ingot_vertilium";

    public IngotVertilium() {
        setUnlocalizedName(item_name);
        setRegistryName(item_name);
        setCreativeTab(Main.VERTILIUM_ORES);

        ItemInit.ITEMS.add(this);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack item, @Nullable World world, List<String> tooltip, ITooltipFlag advanced) {
        // super.addInformation(item, world, tooltip, advanced);
        tooltip.add("\u00A75 A powerful and strong material,\n\u00A75 intended for crafting powerful tools and weapons.");
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
