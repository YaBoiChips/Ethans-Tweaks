package yaboichips.etweaks.common.events;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yaboichips.etweaks.ETweaks;

@Mod.EventBusSubscriber(modid = ETweaks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ToolTipEvent {
    @SubscribeEvent
    public void pocketToolTip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        World world = event.getEntity().world;
        if (world.isRemote){
            if (stack.hasTag()) {
                ITextComponent toolTip = (stack.getTag().toFormattedComponent());
                if (stack.getTag().getInt("Pocket") == 1) {
                    if (!event.getToolTip().contains(toolTip)) {
                        event.getToolTip().add(toolTip);
                    }
                }
            }
        }
    }
}
