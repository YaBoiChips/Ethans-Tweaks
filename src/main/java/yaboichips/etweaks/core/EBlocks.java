package yaboichips.etweaks.core;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.particles.ParticleTypes;
import net.minecraftforge.common.ToolType;
import yaboichips.etweaks.ETweaks;
import yaboichips.etweaks.common.blocks.BlenderBlock;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class EBlocks {

    public static List<Block> blocks = new ArrayList<>();

    //end rods
    public static final Block RED_END_ROD = registerBlock("red_end_rod", new EndRodBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().setLightLevel((state) -> 14)));
    public static final Block BLUE_END_ROD = registerBlock("blue_end_rod", new EndRodBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().setLightLevel((state) -> 14)));
    public static final Block GREEN_END_ROD = registerBlock("green_end_rod", new EndRodBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().setLightLevel((state) -> 14)));
    public static final Block YELLOW_END_ROD = registerBlock("yellow_end_rod", new EndRodBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().setLightLevel((state) -> 14)));
    public static final Block ORANGE_END_ROD = registerBlock("orange_end_rod", new EndRodBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().setLightLevel((state) -> 14)));
    public static final Block PINK_END_ROD = registerBlock("pink_end_rod", new EndRodBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().setLightLevel((state) -> 14)));
    public static final Block BLACK_END_ROD = registerBlock("black_end_rod", new EndRodBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().setLightLevel((state) -> 14)));
    public static final Block PURPLE_END_ROD = registerBlock("purple_end_rod", new EndRodBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().setLightLevel((state) -> 14)));
    public static final Block LIGHT_BLUE_END_ROD = registerBlock("light_blue_end_rod", new EndRodBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().setLightLevel((state) -> 14)));

    //torches
    public static final Block RED_TORCH = registerBlock("red_torch", new TorchBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> 14).sound(SoundType.WOOD), ParticleTypes.FLAME));
    public static final Block BLUE_TORCH = registerBlock("blue_torch", new TorchBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> 14).sound(SoundType.WOOD), ParticleTypes.FLAME));
    public static final Block GREEN_TORCH = registerBlock("green_torch", new TorchBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> 14).sound(SoundType.WOOD), ParticleTypes.FLAME));
    public static final Block YELLOW_TORCH = registerBlock("yellow_torch", new TorchBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> 14).sound(SoundType.WOOD), ParticleTypes.FLAME));
    public static final Block ORANGE_TORCH = registerBlock("orange_torch", new TorchBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> 14).sound(SoundType.WOOD), ParticleTypes.FLAME));
    public static final Block PINK_TORCH = registerBlock("pink_torch", new TorchBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> 14).sound(SoundType.WOOD), ParticleTypes.FLAME));
    public static final Block BLACK_TORCH = registerBlock("black_torch", new TorchBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> 14).sound(SoundType.WOOD), ParticleTypes.FLAME));
    public static final Block PURPLE_TORCH = registerBlock("purple_torch", new TorchBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> 14).sound(SoundType.WOOD), ParticleTypes.FLAME));
    public static final Block LIGHT_BLUE_TORCH = registerBlock("light_blue_torch", new TorchBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> 14).sound(SoundType.WOOD), ParticleTypes.FLAME));

    //
    public static final Block BLENDER = registerBlock("blender", new BlenderBlock(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(4.0f, 1.5f).sound(SoundType.ANCIENT_DEBRIS).harvestTool(ToolType.PICKAXE)));


    static @Nonnull
    <T extends Block> T registerBlock(String id, @Nonnull T block) {
        block.setRegistryName(ETweaks.createResource(id));

        blocks.add(block);

        return block;
    }

    public static void init() {
    }
}
