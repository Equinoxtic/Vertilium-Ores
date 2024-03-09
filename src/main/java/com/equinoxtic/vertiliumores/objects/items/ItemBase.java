package com.equinoxtic.vertiliumores.objects.items;

import com.equinoxtic.vertiliumores.Main;
import com.equinoxtic.vertiliumores.init.ItemInit;
import com.equinoxtic.vertiliumores.util.IHasModel;
import com.equinoxtic.vertiliumores.util.Reference;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.TransferQueue;

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
