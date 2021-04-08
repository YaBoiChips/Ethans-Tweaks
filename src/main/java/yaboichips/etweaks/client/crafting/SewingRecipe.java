package yaboichips.etweaks.client.crafting;

import com.google.gson.JsonObject;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.CapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import yaboichips.etweaks.ETweaks;
import yaboichips.etweaks.core.EItems;
import yaboichips.etweaks.core.ERecipies;

public class SewingRecipe implements IRecipe<IInventory> {

    private final Ingredient base;
    private final Ingredient addition;
    private final ItemStack result;
    private final ResourceLocation recipeId;

    public SewingRecipe(ResourceLocation recipeId, Ingredient base, Ingredient addition, ItemStack result) {
        this.recipeId = recipeId;
        this.base = base;
        this.addition = addition;
        this.result = result;
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        return this.base.test(inv.getStackInSlot(0)) && this.addition.test(inv.getStackInSlot(1));
    }

    @Override
    public ItemStack getCraftingResult(IInventory inv) {

        for (int j = 0; j < inv.getSizeInventory(); ++j) {
            ItemStack itemStack1 = inv.getStackInSlot(1);
            ItemStack itemStack2 = this.result;
            CompoundNBT compoundnbt = itemStack2.getTag().copy();
            if (itemStack1.getItem() == EItems.POCKET){
                compoundnbt.putInt("Pocket", 1);
                itemStack2.setTag(compoundnbt);
                return itemStack2;
            }
        }
        return this.result.copy();
    }

    @Override
    public boolean canFit(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.result;
    }

    @Override
    public ResourceLocation getId() {
        return this.recipeId;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ERecipies.ModRecipeSerializers.SEWING;
    }

    @Override
    public IRecipeType<?> getType() {
        return ERecipies.ModRecipeTypes.SEWING;
    }


    public static class Serializer extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<SewingRecipe> {

            @Override
            public void write(PacketBuffer buffer, SewingRecipe recipe) {
                recipe.base.write(buffer);
                recipe.addition.write(buffer);
                buffer.writeItemStack(recipe.result);

            }

            public SewingRecipe read(ResourceLocation recipeId, JsonObject json) {
                Ingredient ingredient = Ingredient.deserialize(JSONUtils.getJsonObject(json, "base"));
                Ingredient ingredient1 = Ingredient.deserialize(JSONUtils.getJsonObject(json, "addition"));
                ItemStack itemstack = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"));
                return new SewingRecipe(recipeId, ingredient, ingredient1, itemstack);
            }

            public SewingRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
                Ingredient ingredient = Ingredient.read(buffer);
                Ingredient ingredient1 = Ingredient.read(buffer);
                ItemStack itemstack = buffer.readItemStack();
                return new SewingRecipe(recipeId, ingredient, ingredient1, itemstack);
            }
        }
    }