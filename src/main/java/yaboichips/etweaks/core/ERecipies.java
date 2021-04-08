package yaboichips.etweaks.core;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yaboichips.etweaks.ETweaks;
import yaboichips.etweaks.client.crafting.SewingRecipe;

import java.util.Optional;

public class ERecipies {

    public static class ModRecipeTypes {

        public static final IRecipeType<SewingRecipe> SEWING = new IRecipeType<SewingRecipe>() {

            @Override
            public <C extends IInventory> Optional<SewingRecipe> matches(IRecipe<C> recipe, World worldIn, C inv) {
                return recipe.matches(inv, worldIn) ? Optional.of((SewingRecipe) recipe) : Optional.empty();
            }
        };

        static {
            Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(ETweaks.MOD_ID, "sewing"), SEWING);
        }
    }

    public static class ModRecipeSerializers {
        public static final IRecipeSerializer<SewingRecipe> SEWING = new SewingRecipe.Serializer();

        @SubscribeEvent
        public void onRegisterSerializers(RegistryEvent.Register<IRecipeSerializer<?>> event) {
            event.getRegistry().registerAll(
                    (SEWING.setRegistryName(new ResourceLocation(ETweaks.MOD_ID, "sewing")))
            );
        }
    }
}
