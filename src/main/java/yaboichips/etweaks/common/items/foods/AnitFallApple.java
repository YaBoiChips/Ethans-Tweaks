package yaboichips.etweaks.common.items.foods;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AnitFallApple extends Item {
    public AnitFallApple(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entity) {
        ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entity);
        PlayerEntity player = (PlayerEntity) entity;
        if (!player.getTags().contains("NoFall")) {
            player.addTag("NoFall");
        } else {
            player.removeTag("NoFall");
        }
        return itemstack;
    }
}
