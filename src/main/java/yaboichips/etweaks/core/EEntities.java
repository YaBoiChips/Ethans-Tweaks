package yaboichips.etweaks.core;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import yaboichips.etweaks.ETweaks;
import yaboichips.etweaks.common.entities.RoundShieldEntity;

import java.util.ArrayList;
import java.util.List;

public class EEntities {
    public static List<EntityType<?>> entities = new ArrayList<>();

    public static final EntityType<RoundShieldEntity> ROUND_SHIELD_ENTITY = createEntity("round_shield", EntityType.Builder.<RoundShieldEntity>create(RoundShieldEntity::new, EntityClassification.MISC).size(0.5F, 0.5F).trackingRange(4).updateInterval(20).build("round_shield"));


    public static <E extends Entity, ET extends EntityType<E>> ET createEntity(String id, ET entityType) {
        entityType.setRegistryName(new ResourceLocation(ETweaks.MOD_ID, id));
        entities.add(entityType);
        return entityType;
    }

    public static void init() {
    }
}
