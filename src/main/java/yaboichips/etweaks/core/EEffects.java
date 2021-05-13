package yaboichips.etweaks.core;

import net.minecraft.block.Block;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import yaboichips.etweaks.ETweaks;
import yaboichips.etweaks.common.effects.FloatResistanceEffect;
import yaboichips.etweaks.common.effects.SpiderManEffect;
import yaboichips.etweaks.common.effects.WitherResistanceEffect;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class EEffects {
    public static List<Effect> effects = new ArrayList<>();

    public static Effect WITHER_RESISTANCE = registerEffect(new WitherResistanceEffect(EffectType.BENEFICIAL, 7211), "wither_resistance");
    public static Effect FLOAT_RESISTANCE = registerEffect(new FloatResistanceEffect(EffectType.BENEFICIAL, 7211), "float_resistance");
    public static Effect SPIDERMAN = registerEffect(new SpiderManEffect(EffectType.BENEFICIAL, 341), "spiderman");


    static @Nonnull
    <T extends Effect> T registerEffect( @Nonnull T effect, String id){
        effect.setRegistryName(ETweaks.createResource(id));

        effects.add(effect);

        return effect;
    }

    public static void init(){
    }
}
