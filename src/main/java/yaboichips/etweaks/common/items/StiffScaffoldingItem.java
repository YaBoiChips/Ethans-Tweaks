package yaboichips.etweaks.common.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.network.play.server.SChatPacket;
import net.minecraft.util.Direction;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import yaboichips.etweaks.common.blocks.StiffScaffoldingBlock;

import javax.annotation.Nullable;

public class StiffScaffoldingItem extends BlockItem {
    public StiffScaffoldingItem(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    @Nullable
    public BlockItemUseContext getBlockItemUseContext(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        World world = context.getWorld();
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = this.getBlock();
        if (!blockstate.matchesBlock(block)) {
            return StiffScaffoldingBlock.getDistance(world, blockpos) == 14 ? null : context;
        } else {
            Direction direction;
            if (context.hasSecondaryUseForPlayer()) {
                direction = context.isInside() ? context.getFace().getOpposite() : context.getFace();
            } else {
                direction = context.getFace() == Direction.UP ? context.getPlacementHorizontalFacing() : Direction.UP;
            }

            int i = 0;
            BlockPos.Mutable blockpos$mutable = blockpos.toMutable().move(direction);

            while(i < 14) {
                if (!world.isRemote && !World.isValid(blockpos$mutable)) {
                    PlayerEntity playerentity = context.getPlayer();
                    int j = world.getHeight();
                    if (playerentity instanceof ServerPlayerEntity && blockpos$mutable.getY() >= j) {
                        SChatPacket schatpacket = new SChatPacket((new TranslationTextComponent("build.tooHigh", j)).mergeStyle(TextFormatting.RED), ChatType.GAME_INFO, Util.DUMMY_UUID);
                        ((ServerPlayerEntity)playerentity).connection.sendPacket(schatpacket);
                    }
                    break;
                }

                blockstate = world.getBlockState(blockpos$mutable);
                if (!blockstate.matchesBlock(this.getBlock())) {
                    if (blockstate.isReplaceable(context)) {
                        return BlockItemUseContext.func_221536_a(context, blockpos$mutable, direction);
                    }
                    break;
                }

                blockpos$mutable.move(direction);
                if (direction.getAxis().isHorizontal()) {
                    ++i;
                }
            }

            return null;
        }
    }

    protected boolean checkPosition() {
        return false;
    }
}

