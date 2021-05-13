package yaboichips.etweaks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yaboichips.etweaks.client.renderers.ECutOutTextures;
import yaboichips.etweaks.client.renderers.RoundShieldRenderer;
import yaboichips.etweaks.core.*;

import javax.annotation.Nonnull;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ETweaks.MOD_ID)
public class ETweaks {

    public static final String MOD_ID = "etweaks";
    public static final Logger LOGGER = LogManager.getLogger();

    public ETweaks() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM PREINIT");
        EPotions.addBrewingRecipes();
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        EKeybinds.register();
        ECutOutTextures.renderCutOuts();
        RenderingRegistry.registerEntityRenderingHandler(EEntities.ROUND_SHIELD_ENTITY, RoundShieldRenderer::new);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo("etweaks", "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event) {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    public static @Nonnull
    ResourceLocation createResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            LOGGER.info("HELLO from Register Block");
            EBlocks.init();
            EBlocks.blocks.forEach(block -> event.getRegistry().register(block));
            EBlocks.blocks.clear();
            EBlocks.blocks = null;
            LOGGER.info("ETweaks: Blocks registered!");
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            LOGGER.debug("ETweaks: Registering items...");
            EItems.init();
            EItems.items.forEach(item -> event.getRegistry().register(item));
            EItems.items.clear();
            EItems.items = null;
            LOGGER.info("ETweaks: Items registered!");
        }

        @SubscribeEvent
        public static void registerEffects(RegistryEvent.Register<Effect> event) {
            LOGGER.debug("GeckoMod: Registering items...");
            EEffects.init();
            EEffects.effects.forEach(effect -> event.getRegistry().register(effect));
            EEffects.effects.clear();
            EEffects.effects = null;
            LOGGER.info("ETweaks: Effects registered!");
        }
        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
            LOGGER.debug("Preparing Entities");
            EEntities.init();
            EEntities.entities.forEach(entityType -> event.getRegistry().register(entityType));
            EEntities.entities.clear();
            EEntities.entities = null;
            LOGGER.info("Entities registered!!");
        }
        @SubscribeEvent
        public static void registerPotions(final RegistryEvent.Register<Potion> event) {
            LOGGER.debug("Preparing Potions");
            EPotions.init();
            EPotions.potions.forEach(potion -> event.getRegistry().register(potion));
            EPotions.potions.clear();
            EPotions.potions = null;
            LOGGER.info("Potions registered!!");
        }
    }

    /* Notes:
    -Editable Signs-
    -No Fall Damage Apple-
    -Time Set Day/Night Staff-
    Step up apple
    -Rocket Boots-
    -Super Saturating Food- (need texture)
    -Villager Traps- (need texture)
    -Edible Pickles- (need texture)
    -Reusable Ender Pearl- (need texture)
    -Float Resistance-
    -Wither Resistance-
    -Repairable Anvil-
    -Ground Beef- (need texture)
    -Meatloaf- (need texture)
    -Stiff Scaffolding-
    Zoom Pickaxe (need texture)
    Coloured Lamps
    Coloured Torches (need texture)
    Banner Duplicator
    -Blender-
    Juices (need texture)
    Round Sheild
    -I'm Waking Up Music Disc-
     */
}
