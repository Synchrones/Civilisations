package fr.salsa.cvlst.world.feature.tree;

import fr.salsa.cvlst.init.ModBlocks;
import fr.salsa.cvlst.init.ModFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import java.util.Random;


public class LupunaTree extends Tree {

    public static final TreeFeatureConfig lupunaTreeConfig = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(ModBlocks.LUPUNA_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(ModBlocks.LUPUNA_LEAVE.get().getDefaultState()),
            new BlobFoliagePlacer(3, 0))).baseHeight(13).heightRandA(3).setSapling((IPlantable)ModBlocks.LUPUNA_SAPLING.get()).build();


    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean b) {
        return ModFeatures.LUPUNA_TREE.get().withConfiguration(lupunaTreeConfig);

    }
}
