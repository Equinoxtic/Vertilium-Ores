package com.equinoxtic.vertiliumores.objects.blocks;

import com.equinoxtic.vertiliumores.Main;
import com.equinoxtic.vertiliumores.init.BlockInit;
import com.equinoxtic.vertiliumores.init.ItemInit;
import com.equinoxtic.vertiliumores.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class BlockBase extends Block implements IHasModel
{
    public BlockBase(String name, Material material) {
        super(material);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.VERTILIUM_ORES);
        setHarvestLevel("pickaxe", 3);

        BlockInit.BLOCKS.add(this);

        ItemInit.ITEMS.add(new ItemBlock(this)
                .setRegistryName(this.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack item, @Nullable World world, List<String> tooltip, ITooltipFlag advanced) {
        // super.addInformation(item, world, tooltip, advanced);
        tooltip.add("\u00A75 A compact block of Vertilium Ingots.");
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
