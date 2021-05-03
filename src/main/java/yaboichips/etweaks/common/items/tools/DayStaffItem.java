package yaboichips.etweaks.common.items.tools;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class DayStaffItem extends Item {
    public DayStaffItem(Properties properties) {
        super(properties);
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if (worldIn instanceof ServerWorld) {
            playerIn.getFoodStats().setFoodLevel(1);
            ((ServerWorld) worldIn).setDayTime(0);
            playerIn.getCooldownTracker().setCooldown(playerIn.getHeldItem(handIn).getItem(), 600);
        }
        return ActionResult.resultSuccess(stack);
    }
}
