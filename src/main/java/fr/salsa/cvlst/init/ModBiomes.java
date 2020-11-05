package fr.salsa.cvlst.init;

import fr.salsa.cvlst.ModMain;
import fr.salsa.cvlst.world.biomes.DenseJungle;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {

    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, ModMain.ModID);

    public static final RegistryObject<Biome> denseJungle = BIOMES.register("dense_jungle", () -> new DenseJungle(new Biome.Builder().scale(0.2F).category(Biome.Category.JUNGLE).downfall(0.7F).depth(0.2F)
            .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState()))
            .precipitation(Biome.RainType.RAIN).temperature(0.95F).waterColor(4159204).waterFogColor(329011).parent(null)));


    public static void registerBiomes(){
        registerBiome(denseJungle.get(), BiomeManager.BiomeType.WARM, 100, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.OVERWORLD);

    }

    private static void registerBiome(Biome biome, BiomeManager.BiomeType biomeType, int weigh, BiomeDictionary.Type... type){
        BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, weigh));
        BiomeDictionary.addTypes(biome, type);
        BiomeManager.addSpawnBiome(biome);


    }

}
