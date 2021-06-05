package yaboichips.etweaks.core;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.particles.ParticleTypes;
import net.minecraftforge.common.ToolType;
import yaboichips.etweaks.ETweaks;
import yaboichips.etweaks.common.blocks.BlenderBlock;
import yaboichips.etweaks.common.blocks.StiffScaffoldingBlock;
import yaboichips.etweaks.common.blocks.TubeEntranceBlock;

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
    
    //misc
    public static final Block BLENDER = registerBlock("blender", new BlenderBlock(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(4.0f, 1.5f).sound(SoundType.ANCIENT_DEBRIS).notSolid().harvestTool(ToolType.PICKAXE)));
    public static final Block STIFF_SCAFFOLDING = registerBlock("stiff_scaffolding", new StiffScaffoldingBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS, MaterialColor.SAND).doesNotBlockMovement().sound(SoundType.SCAFFOLDING).variableOpacity()));
    public static final Block TUBE_ENTRANCE_BLOCK = registerBlock("tube_entrance_block", new TubeEntranceBlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(4.0f, 1.5f).sound(SoundType.STONE).notSolid().harvestTool(ToolType.PICKAXE)));

    static @Nonnull
    <T extends Block> T registerBlock(String id, @Nonnull T block) {
        block.setRegistryName(ETweaks.createResource(id));

        blocks.add(block);

        return block;
    }

    public static void init() {
    }
}
