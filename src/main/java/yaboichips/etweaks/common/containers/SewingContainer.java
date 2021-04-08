package yaboichips.etweaks.common.containers;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.AbstractRepairContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.world.World;
import yaboichips.etweaks.client.crafting.SewingRecipe;
import yaboichips.etweaks.core.EBlocks;
import yaboichips.etweaks.core.EContainers;
import yaboichips.etweaks.core.ERecipies;

import java.util.List;

public class SewingContainer extends AbstractRepairContainer {

    private final World world;
    private SewingRecipe recipe;
    private final List<SewingRecipe> sewingRecipe;


    public SewingContainer(int windowId, PlayerInventory playerInv, PacketBuffer packetBuffer) {
        this(windowId, playerInv, IWorldPosCallable.DUMMY);

    }


    public SewingContainer(int windowId, PlayerInventory playerInv, IWorldPosCallable posCallable) {
        super(EContainers.SEWING_CONTAINER.get(), windowId, playerInv, posCallable);
        this.world = playerInv.player.world;
        this.sewingRecipe = this.world.getRecipeManager().getRecipesForType(ERecipies.ModRecipeTypes.SEWING);
    }

    @Override
    protected boolean func_230303_b_(PlayerEntity player, boolean p_230303_2_) {
        return this.recipe != null && this.recipe.matches(this.field_234643_d_, this.world);
    }

    @Override
    protected ItemStack func_230301_a_(PlayerEntity player, ItemStack itemStack) {
        itemStack.onCrafting(player.world, player, itemStack.getCount());
        this.field_234642_c_.onCrafting(player);
        this.consumeItem(0);
        this.consumeItem(1);
        this.field_234644_e_.consume((p_234653_0_, p_234653_1_) -> {
            p_234653_0_.playEvent(1044, p_234653_1_, 0);
        });
        return itemStack;
    }

    @Override
    protected boolean func_230302_a_(BlockState blockState) {
        return blockState == EBlocks.SEWING_MACHINE.getDefaultState();
    }

    private void consumeItem(int p_234654_1_) {
        ItemStack itemstack = this.field_234643_d_.getStackInSlot(p_234654_1_);
        itemstack.shrink(1);
        this.field_234643_d_.setInventorySlotContents(p_234654_1_, itemstack);
    }


    @Override
    public void updateRepairOutput() {
        List<SewingRecipe> list = this.world.getRecipeManager().getRecipes(ERecipies.ModRecipeTypes.SEWING, this.field_234643_d_, this.world);
        if (list.isEmpty()) {
            this.field_234642_c_.setInventorySlotContents(0, ItemStack.EMPTY);
        } else {
            this.recipe = list.get(0);
            ItemStack itemstack = this.recipe.getCraftingResult(this.field_234643_d_);
            this.field_234642_c_.setRecipeUsed(this.recipe);
            this.field_234642_c_.setInventorySlotContents(0, itemstack);
        }

    }
}
