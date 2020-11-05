package fr.salsa.cvlst;

import fr.salsa.cvlst.init.ModBiomes;
import fr.salsa.cvlst.init.ModBlocks;
import fr.salsa.cvlst.init.ModItems;
import fr.salsa.cvlst.util.RegistryHandler;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("cvlst")
@Mod.EventBusSubscriber(modid = ModMain.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModMain {
    public static ModMain instance;
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String ModID = "cvlst";


    public ModMain(){
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        RegistryHandler.init();

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);


    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        ModBlocks.BLOCKS.getEntries().stream()
                .map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(ModMain.CVLSTTab);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event){
        ModBiomes.registerBiomes();
    }


    private void setup(final FMLCommonSetupEvent event){

    }

    private void doClientStuff(final FMLClientSetupEvent event){

    }

    public static final ItemGroup CVLSTTab = new ItemGroup("CVLSTTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.RUBY.get());
        }
    };
}
