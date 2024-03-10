package com.equinoxtic.vertiliumores.objects.blocks;

import com.equinoxtic.vertiliumores.Main;
import com.equinoxtic.vertiliumores.init.BlockInit;
import com.equinoxtic.vertiliumores.init.ItemInit;
import com.equinoxtic.vertiliumores.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockVertilium extends Block implements IHasModel
{
    private String block_name = "block_vertilium";

    public BlockVertilium(Material material) {
        super(material);

        setUnlocalizedName(block_name);
        setRegistryName(block_name);
        setCreativeTab(Main.VERTILIUM_ORES);

        BlockInit.BLOCKS.add(this);

        ItemInit.ITEMS.add(new ItemBlock(this)
                .setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
