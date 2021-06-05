package yaboichips.etweaks.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import yaboichips.etweaks.core.EItems;
import yaboichips.etweaks.core.ESounds;

public class BlenderBlock extends Block {
    public BlenderBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack stack = player.getHeldItem(handIn);
        if (!player.getCooldownTracker().hasCooldown(stack.getItem())) {
            if (stack.getItem() == Items.BEEF) {
                worldIn.playSound(player, player.getPosX(), player.getPosY(), player.getPosZ(), ESounds.BLENDER, SoundCategory.AMBIENT, 0.7F, 1F);
                player.getCooldownTracker().setCooldown(stack.getItem(), 25);
                player.addItemStackToInventory(EItems.GROUND_BEEF.getDefaultInstance());
                if (!player.isCreative())
                    stack.shrink(1);
            } else if (stack.getItem() == Items.APPLE) {
                worldIn.playSound(player, player.getPosX(), player.getPosY(), player.getPosZ(), ESounds.BLENDER, SoundCategory.AMBIENT, 0.7F, 1F);
                player.getCooldownTracker().setCooldown(stack.getItem(), 25);
                player.addItemStackToInventory(EItems.APPLE_JUICE.getDefaultInstance());
                if (!player.isCreative())
                    stack.shrink(1);
            } else if (stack.getItem() == Items.SWEET_BERRIES) {
                worldIn.playSound(player, player.getPosX(), player.getPosY(), player.getPosZ(), ESounds.BLENDER, SoundCategory.AMBIENT, 0.7F, 1F);
                player.getCooldownTracker().setCooldown(stack.getItem(), 25);
                player.addItemStackToInventory(EItems.SWEET_BERRY_JUICE.getDefaultInstance());
                if (!player.isCreative())
                    stack.shrink(1);
            }
        }
            return ActionResultType.SUCCESS;
    }
}
