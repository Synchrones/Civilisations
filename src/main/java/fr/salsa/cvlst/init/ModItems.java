package fr.salsa.cvlst.init;

import fr.salsa.cvlst.ModMain;
import fr.salsa.cvlst.items.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ModMain.ModID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);

}
