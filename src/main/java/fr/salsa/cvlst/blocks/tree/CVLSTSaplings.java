package fr.salsa.cvlst.blocks.tree;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.trees.Tree;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.Random;
import java.util.function.Supplier;

public class CVLSTSaplings extends BushBlock implements IGrowable{
    public static final IntegerProperty stage = BlockStateProperties.STAGE_0_1;
    protected static final VoxelShape shape = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    private final Supplier<Tree> tree;

    public CVLSTSaplings(Supplier<Tree> treeIn, Properties properties) {
        super(properties);
        this.tree = treeIn;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return super.getShape(state, worldIn, pos, context);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        super.tick(state, world, pos, rand);
        if(!world.isAreaLoaded(pos, 1)){
            return;
        }
        if(world.getLight(pos.up()) >= 9 && rand.nextInt(7) == 0){
            this.grow(world, rand, pos, state);

        }
    }


    public void grow(ServerWorld serverWorld, BlockPos pos, BlockState state, Random rand) {
        if (state.get(stage) == 0) {
            serverWorld.setBlockState(pos, state.cycle(stage), 4);
        } else {
            if (!ForgeEventFactory.saplingGrowTree(serverWorld, rand, pos))
                return;
            this.tree.get().place(serverWorld, serverWorld.getChunkProvider().getChunkGenerator(), pos, state, rand);
        }
    }

    @Override
    public void grow(ServerWorld serverWorld, Random rand, BlockPos pos, BlockState state) {
        this.grow(serverWorld, pos, state, rand);
    }

    @Override
    public boolean canGrow(IBlockReader iBlockReader, BlockPos blockPos, BlockState blockState, boolean b) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World world, Random random, BlockPos blockPos, BlockState blockState) {
        return (double)world.rand.nextFloat() < 0.45D;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(stage);
    }
}
