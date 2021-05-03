package yaboichips.etweaks.common.events;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.NetworkHooks;
import yaboichips.etweaks.ETweaks;
import yaboichips.etweaks.common.items.tools.RocketBootsItem;
import yaboichips.etweaks.core.EItems;
import yaboichips.etweaks.core.EKeybinds;

@Mod.EventBusSubscriber(modid = ETweaks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerEvents {

    @SubscribeEvent
    public static void stepUpEvent(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getTags().contains("StepUp")) {
            if (player.collidedHorizontally) {
                float f7 = player.rotationYaw;
                float f = player.rotationPitch;
                float f1 = -MathHelper.sin(f7 * ((float) Math.PI / 180F)) * MathHelper.cos(f * ((float) Math.PI / 180F));
                float f2 = -MathHelper.sin(f * ((float) Math.PI / 180F));
                float f3 = MathHelper.cos(f7 * ((float) Math.PI / 180F)) * MathHelper.cos(f * ((float) Math.PI / 180F));
                float f4 = MathHelper.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
                float f5 = 0.05F;
                f1 = f1 * (f5 / f4);
                f2 = f2 * (f5 / f4);
                f3 = f3 * (f5 / f4);
                player.setPosition(player.getPosX(), player.getPosY() + 0.69, player.getPosZ());
                player.addVelocity(f1, 0, f3);

            }
        }
    }

    @SubscribeEvent
    public static void antiFallEvent(LivingFallEvent event) {
        LivingEntity player = event.getEntityLiving();
        if (player.getTags().contains("NoFall")) {
            event.setDistance(0f);
        }
    }

    @SubscribeEvent
    public static void rocketBootEvent(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        ItemStack itemstack = player.getItemStackFromSlot(EquipmentSlotType.FEET);
        World worldIn = player.world;
        if (player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == EItems.ROCKET_BOOTS) {
            if (EKeybinds.ROCKET_KEY.isPressed()) {
                if (player.isElytraFlying()) {
                    if (RocketBootsItem.isUsable(itemstack)) {
                        if (!worldIn.isRemote) {
                            FireworkRocketEntity firework = new FireworkRocketEntity(worldIn, itemstack, player);
                            worldIn.addEntity(firework);
                            firework.setSilent(true);
                            player.world.playSound(player, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH, SoundCategory.AMBIENT, 3.0F, 1.0F);
                            if (!player.isCreative()) {
                                itemstack.damageItem(1, player, (entity) -> {
                                    entity.sendBreakAnimation(EquipmentSlotType.FEET);
                                });
                            }
                        }
                    }
                }
                if (player.isOnGround()) {
                    if (!player.getCooldownTracker().hasCooldown(itemstack.getItem())) {
                        Vector3d vector3d = player.getMotion();
                        player.setMotion(vector3d.x, 3, vector3d.z);
                        player.world.playSound(player, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH, SoundCategory.AMBIENT, 3.0F, 1.0F);
                        player.getCooldownTracker().setCooldown(itemstack.getItem(), 600);
                    }
                }
            }
        }
    }
}