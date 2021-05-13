package yaboichips.etweaks.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class RoundShieldModel extends Model {

    private final ModelRenderer bb_main;

    public RoundShieldModel() {
        super(RenderType::getEntitySolid);
        textureWidth = 64;
        textureHeight = 64;

        bb_main = new ModelRenderer(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        bb_main.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 0).addBox(-4.0F, -1.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 0).addBox(3.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 0).addBox(-5.0F, -1.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 0).addBox(4.0F, -1.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 0).addBox(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 0).addBox(-5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 0).addBox(-4.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, 5.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 0).addBox(3.0F, -1.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 0).addBox(4.0F, -1.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 53).addBox(-3.0F, -2.0F, -5.0F, 6.0F, 1.0F, 10.0F, 0.0F, false);
        bb_main.setTextureOffset(48, 57).addBox(-5.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
        bb_main.setTextureOffset(48, 50).addBox(3.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
        bb_main.setTextureOffset(60, 6).addBox(3.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bb_main.setTextureOffset(60, 12).addBox(-4.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bb_main.setTextureOffset(60, 27).addBox(3.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bb_main.setTextureOffset(60, 7).addBox(-4.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 0).addBox(5.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}
