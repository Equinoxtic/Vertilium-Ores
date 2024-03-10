package com.equinoxtic.vertiliumores.objects.blocks;

import com.equinoxtic.vertiliumores.Main;
import com.equinoxtic.vertiliumores.init.BlockInit;
import com.equinoxtic.vertiliumores.init.ItemInit;
import com.equinoxtic.vertiliumores.init.ParticlesInit;
import com.equinoxtic.vertiliumores.objects.blocks.item.ItemBlockVariants;
import com.equinoxtic.vertiliumores.particles.ParticleCustom;
import com.equinoxtic.vertiliumores.util.handlers.EnumHandler;
import com.equinoxtic.vertiliumores.util.interfaces.IHasModel;
import com.equinoxtic.vertiliumores.util.interfaces.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;
import java.util.Random;

public class BlockOres extends Block implements IHasModel, IMetaName
{
    public static final PropertyEnum<EnumHandler.EnumType> VARIANT =
            PropertyEnum.<EnumHandler.EnumType>create("variant", EnumHandler.EnumType.class);
    private String name, dimension;

    public BlockOres(String name, String dimension) {
        super(Material.ROCK);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.VERTILIUM_ORES);
        setHardness(1.5F);
        setResistance(3.5F);
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumType.VERTILIETE));

        this.name = name;
        this.dimension = dimension;

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlockVariants(this)
                .setRegistryName(this.getRegistryName()));
    }

    @Override
    public int damageDropped(IBlockState state) {
        return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumType.byMetadata(meta));
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for (EnumHandler.EnumType variant : EnumHandler.EnumType.values()) {
            items.add(new ItemStack(this, 1, variant.getMeta()));
        }
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

    @Override
    public String getSpecialName(ItemStack stack) {
        return EnumHandler.EnumType.values()[stack.getItemDamage()].getName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        double baseMotion = 0.231D * RANDOM.nextDouble() - 0.035D;

        // Thank you for the particle system @jabelar :)
        // https://github.com/jabelar
        Particle theParticle = new ParticleCustom(
                ParticlesInit.SPARKLE,
                worldIn,
                0.0D, pos.getY() - 0.005, 0.0D,
                baseMotion, baseMotion, baseMotion)
                .setLifeSpan(20 + rand.nextInt(45))
                .setGravity(0.1F)
                .setScale(2.0F)
                .setCanCollide(false)
                .setInitialAlpha(1.0F)
                .setFinalAlpha(0.0F)
                .setInitalTint(Color.WHITE)
                .setFinalTint(Color.WHITE);
        Minecraft.getMinecraft().effectRenderer.addEffect(theParticle);
    }

    @Override
    public void registerModels() {
        // Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
        for (int i = 0; i < EnumHandler.EnumType.values().length; i++) {
            Main.proxy.registerVariantRenderer(
                    Item.getItemFromBlock(this),
                    i,
                    "ore_" + this.dimension + "_" + EnumHandler.EnumType.values()[i].getName(),
                    "inventory"
            );
        }
    }
}
