package fr.salsa.cvlst.world.feature;

import com.mojang.datafixers.Dynamic;
import fr.salsa.cvlst.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.*;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class LupunaTreeFeature extends AbstractSmallTreeFeature<TreeFeatureConfig> {

    public static final BlockState log = ModBlocks.LUPUNA_LOG.get().getDefaultState();
    public static final BlockState leaf = ModBlocks.LUPUNA_LEAVE.get().getDefaultState();

    public LupunaTreeFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> config) {
        super(config);
    }

    @Override
    protected boolean place(IWorldGenerationReader world, Random rand, BlockPos pos, Set<BlockPos> p_225557_4_, Set<BlockPos> p_225557_5_, MutableBoundingBox boundingBoxIn, TreeFeatureConfig configIn) {
        int height = 13 + rand.nextInt(3);
        double logheight = height - 2;
        boolean flag = true;
        if (pos.getY() >= 1 && pos.getY() + height + 1 <= world.getMaxHeight()) {
            for (int j = pos.getY(); j <= pos.getY() + 1 + height; ++j) {
                int k = 1;
                if (j == pos.getY()) k = 0;
                if (j >= pos.getY() + 1 + height - 2) k = 2;
                BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
                for (int l = pos.getX() - k; l <= pos.getX() + k && flag; ++l) {
                    for (int i1 = pos.getZ() - k; i1 <= pos.getZ() + k && flag; ++i1) {
                        if (j >= 0 && j < world.getMaxHeight()) {
                            if (!isAirOrLeaves(world, blockpos$mutableblockpos.setPos(l, j, i1))) flag = false;
                        } else flag = false;
                    }
                }
            }

            if (!flag) {
                return false;
            } else if (isSoil(world, pos.down(), configIn.getSapling()) && pos.getY() < world.getMaxHeight() - height - 1) {
                this.setDirtAt(world, pos.down(), pos);
                setBlockState(world, pos, Blocks.AIR.getDefaultState());
                genMiddleLeaves(world, pos.add(0, 2, 0));
                for (int i1 = 0; i1 < 2; i1++) {
                    int x1 = -1 + rand.nextInt(2);
                    int z1 = -1 + rand.nextInt(2);
                    genMiddleLeaves(world, pos.add(x1, logheight / 3 - 0.5 + logheight % 3 + ((logheight / 3 - 0.5) * i1), z1));
                    //tree top
                    if (i1 == 1) {
                        for (int i = 0; i < 2; i++) {
                            for (int i2 = 0; i2 < 3; i2++) {
                                for (int i3 = 0; i3 < 5; i3++) {
                                    setBlockState(world, pos.add(i3 - 2 + x1, i + logheight - 2, i2 - 1 + z1), leaf);
                                }
                            }
                        }
                        for (int i = 0; i < 2; i++) {
                            for (int i2 = 0; i2 < 3; i2++) {
                                setBlockState(world, pos.add(i2 - 1 + x1, i + logheight - 2, -2 + z1), leaf);
                            }
                            for (int i2 = 0; i2 < 3; i2++) {
                                setBlockState(world, pos.add(i2 - 1 + x1, i + logheight - 2, 2 + z1), leaf);
                            }
                        }
                        genMiddleLeaves(world, pos.add(x1, logheight, z1));
                    }
                    for (int i = 0; i < logheight / 3 - 0.5; i++) {
                        setBlockState(world, pos.add(x1, i + logheight / 3 - 0.5 + logheight % 3 + ((logheight / 3 - 0.5) * i1), z1), log);
                    }
                }
                for (int i = 0; i < logheight / 3 - 0.5 + logheight % 3; i++) {
                    setBlockState(world, pos.add(0, i, 0), log);
                }

                return true;
            }
            return false;
        }
        return false;
    }
    private void genMiddleLeaves(IWorldGenerationReader world, BlockPos pos){
        for(int i = 0; i < 3; i++){
            for(int i1 = 0; i1 < 5 - i * 2; i1++){
                setBlockState(world, pos.add(i1 + i - 2,0, i), leaf);
            }
        }
        for(int i = 0; i < 2; i++){
            for(int i1 = 0; i1 < 2; i1++) {
                for (int i2 = 0; i2 < 3 - i1 * 2; i2++) {
                    setBlockState(world, pos.add(i2 + i1 - 1, i, -i1 - (1 -i)), leaf);
                }
            }
        }
        setBlockState(world, pos.add(0,1,1), leaf);
    }

}
