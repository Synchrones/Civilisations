package fr.salsa.cvlst.util;


import fr.salsa.cvlst.init.ModBiomes;
import fr.salsa.cvlst.init.ModBlocks;
import fr.salsa.cvlst.init.ModFeatures;
import fr.salsa.cvlst.init.ModItems;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


public class RegistryHandler {

    public static void init(){
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModBiomes.BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModFeatures.FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());

    }










}
