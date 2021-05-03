package yaboichips.etweaks.client.renderers;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import yaboichips.etweaks.core.EBlocks;

import java.util.Arrays;

public class ECutOutTextures {

    public static void renderCutOuts(){
        Block[] blocks = {
                EBlocks.BLENDER.getBlock(),
                EBlocks.STIFF_SCAFFOLDING.getBlock()
        };
        Arrays.stream(blocks).forEach((block) -> RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped()));

        RenderTypeLookup.setRenderLayer(EBlocks.BLENDER.getBlock(), RenderType.getTranslucent());
    }
}
