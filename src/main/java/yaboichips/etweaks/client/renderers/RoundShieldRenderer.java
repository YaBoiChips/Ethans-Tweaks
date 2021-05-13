package yaboichips.etweaks.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import yaboichips.etweaks.ETweaks;
import yaboichips.etweaks.client.models.RoundShieldModel;
import yaboichips.etweaks.common.entities.RoundShieldEntity;

public class RoundShieldRenderer extends EntityRenderer<RoundShieldEntity> {
    public static final ResourceLocation ROUND_SHIELD = new ResourceLocation(ETweaks.MOD_ID, "textures/entity/shield.png");
    private final RoundShieldModel roundShieldModel = new RoundShieldModel();

    public RoundShieldRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    public void render(RoundShieldEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90.0F));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch) + 90.0F));
        IVertexBuilder ivertexbuilder = net.minecraft.client.renderer.ItemRenderer.getEntityGlintVertexBuilder(bufferIn, this.roundShieldModel.getRenderType(this.getEntityTexture(entityIn)), false, false);
        this.roundShieldModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public ResourceLocation getEntityTexture(RoundShieldEntity entity) {
        return ROUND_SHIELD;
    }
}
