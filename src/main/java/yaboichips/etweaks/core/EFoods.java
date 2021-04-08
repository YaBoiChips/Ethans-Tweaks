package yaboichips.etweaks.core;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import yaboichips.etweaks.ETweaks;

import java.util.ArrayList;
import java.util.List;

public class EFoods {

    public static List<Food> foods = new ArrayList<>();


    public static final Food PICKLE = (new Food.Builder()).hunger(4).saturation(0.3F).fastToEat().build();
    public static final Food STEPUPAPPLE = (new Food.Builder()).hunger(3).saturation(0.3F).setAlwaysEdible().build();
    public static final Food ANTIFALLAPPLE = (new Food.Builder()).hunger(3).saturation(0.3F).setAlwaysEdible().build();
    public static final Food SUPERMEAL = (new Food.Builder()).hunger(7).saturation(2.4F).build();
    public static final Food GROUND_BEEF = (new Food.Builder()).hunger(1).saturation(0.3f).effect(new EffectInstance(Effects.POISON, 200, 0), 1).build();
    public static final Food MEATLOAF = (new Food.Builder()).hunger(6).saturation(0.9f).build();

}
