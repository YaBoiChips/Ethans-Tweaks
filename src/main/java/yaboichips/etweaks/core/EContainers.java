package yaboichips.etweaks.core;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import yaboichips.etweaks.ETweaks;
import yaboichips.etweaks.common.containers.PocketContainer;
import yaboichips.etweaks.common.containers.SewingContainer;

public class EContainers {
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, ETweaks.MOD_ID);

    public static final RegistryObject<ContainerType<SewingContainer>> SEWING_CONTAINER = CONTAINER_TYPES
            .register("sewing_container", () -> IForgeContainerType.create(SewingContainer::new));

    public static final RegistryObject<ContainerType<PocketContainer>> POCKET_CONTAINER = CONTAINER_TYPES
            .register("pocket_container", () -> new ContainerType<>(PocketContainer::new));


}
