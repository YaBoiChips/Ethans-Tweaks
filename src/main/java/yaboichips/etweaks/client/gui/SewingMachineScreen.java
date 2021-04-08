package yaboichips.etweaks.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.AbstractRepairScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import yaboichips.etweaks.ETweaks;
import yaboichips.etweaks.common.containers.SewingContainer;

public class SewingMachineScreen extends AbstractRepairScreen<SewingContainer> {
    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(ETweaks.MOD_ID, "textures/gui/container/forging.png");

    public SewingMachineScreen(SewingContainer container, PlayerInventory playerInventory, ITextComponent title) {
        super(container, playerInventory, title, GUI_TEXTURE);
        this.titleX = 90;
        this.titleY = 10;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
        RenderSystem.disableBlend();
        super.drawGuiContainerForegroundLayer(matrixStack, x, y);
    }
}


