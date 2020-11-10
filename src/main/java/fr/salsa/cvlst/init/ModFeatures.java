package fr.salsa.cvlst.init;

import fr.salsa.cvlst.ModMain;
import fr.salsa.cvlst.world.feature.LupunaTreeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<Feature<?>>(ForgeRegistries.FEATURES, ModMain.ModID);

    public static final RegistryObject<Feature<TreeFeatureConfig>> LUPUNA_TREE = FEATURES.register("lupuna_tree", () -> new LupunaTreeFeature(TreeFeatureConfig::func_227338_a_));
}
