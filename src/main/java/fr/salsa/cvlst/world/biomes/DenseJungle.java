package fr.salsa.cvlst.world.biomes;

import fr.salsa.cvlst.init.ModFeatures;
import fr.salsa.cvlst.world.feature.tree.LupunaTree;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;


public class DenseJungle extends Biome {

    public DenseJungle(Builder biomeBuilder) {
        super(biomeBuilder);
        addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.PARROT, 5, 3, 6));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.LUPUNA_TREE.get().withConfiguration(LupunaTree.lupunaTreeConfig).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
                .configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
    }


}
