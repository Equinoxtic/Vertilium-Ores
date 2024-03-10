package com.equinoxtic.vertiliumores.world.gen;

import com.equinoxtic.vertiliumores.init.BlockInit;
import com.equinoxtic.vertiliumores.objects.blocks.BlockOres;
import com.equinoxtic.vertiliumores.util.handlers.EnumHandler;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenCustomOres implements IWorldGenerator
{
    private WorldGenerator ore_overworld_vertiliete;

    public WorldGenCustomOres() {
        ore_overworld_vertiliete = new WorldGenMinable(BlockInit.ORE_VERTILIETE_OVERWORLD.getDefaultState()
                .withProperty(BlockOres.VARIANT, EnumHandler.EnumType.VERTILIETE),
                9, // Amount of ores in a vein
                BlockMatcher.forBlock(Blocks.STONE));
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator iChunkGenerator, IChunkProvider iChunkProvider) {
        switch (world.provider.getDimension()) {
            case 0:
                runGenerator(ore_overworld_vertiliete,
                        world, random, chunkX, chunkZ,
                        10,     // Chance for ore to generate
                        0,              // Minimum Height for ore to generate
                        10              // Maximum Height for ore to generate
                );
                break;
        }
    }

    private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight) {
        if (minHeight > maxHeight || minHeight < 0 || maxHeight > 256) {
            throw new IllegalArgumentException("ORE GENERATED OUT OF BOUNDS");
        }

        int heightDiff = maxHeight - minHeight + 1;

        for (int i = 0; i < chance; i++) {
            int x = chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunkZ * 16 + rand.nextInt(16);

            gen.generate(world, rand, new BlockPos(x, y, z));
        }


    }
}
