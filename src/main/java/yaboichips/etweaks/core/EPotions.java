package yaboichips.etweaks.core;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.*;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import yaboichips.etweaks.ETweaks;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class EPotions {
    public static List<Potion> potions = new ArrayList<>();

    public static Potion SPIDERMAN_POTION = registerPotion(new Potion(new EffectInstance(EEffects.SPIDERMAN, 3600)), "spiderman");
    public static Potion LONG_SPIDERMAN_POTION = registerPotion(new Potion(new EffectInstance(EEffects.SPIDERMAN, 9600)), "spiderman_long");
    public static Potion WITHER_RESISTANCE_POTION = registerPotion(new Potion(new EffectInstance(EEffects.WITHER_RESISTANCE, 3600)), "wither_resistance_long");
    public static Potion LONG_WITHER_RESISTANCE_POTION = registerPotion(new Potion(new EffectInstance(EEffects.WITHER_RESISTANCE, 9600)), "wither_resistance");
    public static Potion FLOAT_RESISTANCE_POTION = registerPotion(new Potion(new EffectInstance(EEffects.FLOAT_RESISTANCE, 3600)), "float_resistance");
    public static Potion LONG_FLOAT_RESISTANCE_POTION = registerPotion(new Potion(new EffectInstance(EEffects.FLOAT_RESISTANCE, 9600)), "float_resistance_long");

    static @Nonnull
    <T extends Potion> T registerPotion(@Nonnull T potion, String id){
        potion.setRegistryName(ETweaks.createResource(id));
        potions.add(potion);
        return potion;
    }

    public static void init(){
    }

    public static void addBrewingRecipes(){
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.AWKWARD)), Ingredient.fromStacks(new ItemStack(Items.COBWEB)), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), EPotions.SPIDERMAN_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), EPotions.SPIDERMAN_POTION)), Ingredient.fromStacks(new ItemStack(Items.REDSTONE)), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), EPotions.LONG_SPIDERMAN_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.FIRE_RESISTANCE)), Ingredient.fromStacks(new ItemStack(Items.COAL)), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), EPotions.WITHER_RESISTANCE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), EPotions.WITHER_RESISTANCE_POTION)), Ingredient.fromStacks(new ItemStack(Items.REDSTONE)), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), EPotions.LONG_WITHER_RESISTANCE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.FIRE_RESISTANCE)), Ingredient.fromStacks(new ItemStack(Items.ENDER_PEARL)), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), EPotions.FLOAT_RESISTANCE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), EPotions.FLOAT_RESISTANCE_POTION)), Ingredient.fromStacks(new ItemStack(Items.REDSTONE)), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), EPotions.LONG_FLOAT_RESISTANCE_POTION));
    }
}
