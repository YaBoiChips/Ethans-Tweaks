package yaboichips.etweaks.common.events;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import yaboichips.etweaks.ETweaks;

@Mod.EventBusSubscriber(modid = ETweaks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlockEvents {

    private static final String[] IS_EDITABLE_FIELDS = {
            "field_145916_j",
            "isEditable",
    };
    @SubscribeEvent
    public static void editSign(PlayerInteractEvent.RightClickBlock event){
        PlayerEntity player = event.getPlayer();
        if (canPlayerEdit(player, event.getItemStack())){
            TileEntity tileentity = event.getWorld().getTileEntity(event.getPos());
            if(tileentity instanceof SignTileEntity){
                SignTileEntity sign = (SignTileEntity) tileentity;
                setSignEditable(sign);
                if(sign.getIsEditable()){
                    player.openSignEditor(sign);
                }
                else{
                    player.sendMessage(new TranslationTextComponent(ETweaks.MOD_ID + ".action.not_editable"), Util.DUMMY_UUID);
                }
            }
        }
    }
    public static boolean canPlayerEdit(PlayerEntity playerEntity, ItemStack itemStack){
        return !playerEntity.isCrouching() && !isHoldingDye(itemStack);
    }
    private static boolean isHoldingDye(ItemStack itemStack){
        return itemStack.getItem() instanceof DyeItem;
    }
    private static void setSignEditable(SignTileEntity sign) {
        for (String field : IS_EDITABLE_FIELDS) {
            try {
                ObfuscationReflectionHelper.setPrivateValue(SignTileEntity.class, sign, true, field);
                return;
            } catch (ObfuscationReflectionHelper.UnableToFindFieldException e) {
                ETweaks.LOGGER.debug("Failed to get field {}", field);
            }
        }
    }

    @SubscribeEvent
    public static void fixAnvil(PlayerInteractEvent.RightClickBlock event){
        PlayerEntity player = event.getPlayer();
        World world = player.world;
        Item stack = player.getHeldItemMainhand().getItem();
        BlockPos pos = event.getPos();
        Block block = event.getWorld().getBlockState(pos).getBlock();
        if (player.isCrouching()){
            if (stack == Items.IRON_INGOT){
                if(block == Blocks.DAMAGED_ANVIL) {
                    world.setBlockState(pos, Blocks.CHIPPED_ANVIL.getDefaultState());
                    world.playSound(player, pos, SoundEvents.BLOCK_ANVIL_USE, SoundCategory.AMBIENT, 1.0f, 1.0f);
                    stack.getDefaultInstance().shrink(1);

                }
                else if(block == Blocks.CHIPPED_ANVIL) {
                world.setBlockState(pos, Blocks.ANVIL.getDefaultState());
                world.playSound(player, pos, SoundEvents.BLOCK_ANVIL_USE, SoundCategory.AMBIENT, 1.0f, 1.0f);
                stack.getDefaultInstance().shrink(1);
                }
            }
        }
    }
}
