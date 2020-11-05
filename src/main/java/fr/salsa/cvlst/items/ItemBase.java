package fr.salsa.cvlst.items;

import fr.salsa.cvlst.ModMain;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().group(ModMain.CVLSTTab));
    }
}
