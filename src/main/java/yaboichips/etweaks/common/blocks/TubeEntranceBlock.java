package yaboichips.etweaks.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Pose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class TubeEntranceBlock extends Block {
    protected static final VoxelShape SHAPE = VoxelShapes.combineAndSimplify(VoxelShapes.fullCube(), VoxelShapes.or(makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D), makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D), makeCuboidShape(0.0D, 0.0D, 0.0D, 0.0D, 16.0D, 1.0D), makeCuboidShape(0.0D, 0.0D, 15.0D, 0.0D, 16.0D, 16.0D)), IBooleanFunction.ONLY_FIRST);

    public TubeEntranceBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        player.setPose(Pose.SWIMMING);
        player.setPosition(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
        player.setPose(Pose.SWIMMING);
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
    public VoxelShape getRaytraceShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return SHAPE;
    }

}
