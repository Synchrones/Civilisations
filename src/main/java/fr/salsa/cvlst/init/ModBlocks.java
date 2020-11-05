package fr.salsa.cvlst.init;

import fr.salsa.cvlst.ModMain;
import fr.salsa.cvlst.blocks.tree.CVLSTSaplings;
import fr.salsa.cvlst.world.feature.tree.LupunaTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.userdev.FMLUserdevClientLaunchProvider;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ModMain.ModID);


    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new Block(Block.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> LUPUNA_PLANK = BLOCKS.register("lupuna_plank", () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> LUPUNA_LOG = BLOCKS.register("lupuna_log", () -> new LogBlock(MaterialColor.WOOD ,Block.Properties.from(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> LUPUNA_LEAVE = BLOCKS.register("lupuna_leave", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> LUPUNA_SAPLING = BLOCKS.register("lupuna_sapling", () -> new CVLSTSaplings(() -> new LupunaTree(), Block.Properties.from(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> LUPUNA_STAIRS = BLOCKS.register("lupuna_stairs", () -> new StairsBlock(() -> Blocks.OAK_PLANKS.getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)));

    public static final RegistryObject<Block> LUPUNA_FENCE = BLOCKS.register("lupuna_fence", () -> new FenceBlock(Block.Properties.from(Blocks.OAK_FENCE)));

    public static final RegistryObject<Block> LUPUNA_FENCE_GATE = BLOCKS.register("lupuna_fence_gate", () -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));

}
