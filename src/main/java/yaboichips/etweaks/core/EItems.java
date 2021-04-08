package yaboichips.etweaks.core;

import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import yaboichips.etweaks.ETweaks;
import yaboichips.etweaks.common.items.foods.AnitFallApple;
import yaboichips.etweaks.common.items.foods.StepUpAppleItem;
import yaboichips.etweaks.common.items.misc.ReusableEnderPearl;
import yaboichips.etweaks.common.items.misc.VillagerTrapItem;
import yaboichips.etweaks.common.items.tools.RocketBootsItem;

import java.util.ArrayList;
import java.util.List;

public class EItems {

    public static List<Item> items = new ArrayList<>();

    public static final ItemGroup TWEAKS_TAB = new ItemGroup(ETweaks.MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(EItems.SUPERMEAL);
        }
        @Override
        public boolean hasScrollbar() {
            return true;
        }
        @Override
        public ResourceLocation getBackgroundImage() {
            return new ResourceLocation("minecraft", "textures/gui/container/creative_inventory/tab_items.png");
        }
    };

    //block items
    public static final Item SEWING_MACHINE = createItem(new BlockItem(EBlocks.SEWING_MACHINE, new Item.Properties().group(TWEAKS_TAB)), Registry.BLOCK.getKey(EBlocks.SEWING_MACHINE));
    public static final Item BLENDER = createItem(new BlockItem(EBlocks.BLENDER, new Item.Properties().group(TWEAKS_TAB)), Registry.BLOCK.getKey(EBlocks.BLENDER));

    //misc
    public static final Item VILLAGER_TRAP = createItem(new VillagerTrapItem(new Item.Properties().group(TWEAKS_TAB)), "villager_trap");
    public static final Item REUSEABLE_ENDER_PEARL = createItem(new ReusableEnderPearl(new Item.Properties().group(TWEAKS_TAB)), "reusable_ender_pearl");
    public static final Item REDDIT_SILVER = createItem(new Item(new Item.Properties().group(TWEAKS_TAB)), "reddit_silver");
    public static final Item REDDIT_GOLD = createItem(new Item(new Item.Properties().group(TWEAKS_TAB)), "reddit_gold");
    public static final Item POCKET = createItem(new Item(new Item.Properties().group(TWEAKS_TAB)), "pocket");
    public static final Item ROCKET_BOOTS = createItem(new RocketBootsItem(ArmorMaterial.NETHERITE, EquipmentSlotType.FEET, (new Item.Properties()).group(TWEAKS_TAB).isImmuneToFire()), "rocket_boots");

    //food
    public static final Item PICKLE = createItem(new Item(new Item.Properties().food(EFoods.PICKLE).group(TWEAKS_TAB)), "pickle");
    public static final Item STEPUPAPPLE = createItem(new StepUpAppleItem(new Item.Properties().food(EFoods.STEPUPAPPLE).group(TWEAKS_TAB)), "step_up_apple");
    public static final Item ANTIFALLAPPLE = createItem(new AnitFallApple(new Item.Properties().food(EFoods.ANTIFALLAPPLE).group(TWEAKS_TAB)), "anti_fall_apple");
    public static final Item SUPERMEAL = createItem(new Item(new Item.Properties().food(EFoods.SUPERMEAL).group(TWEAKS_TAB)), "supermeal");
    public static final Item MEATLOAF = createItem(new Item(new Item.Properties().food(EFoods.MEATLOAF).group(TWEAKS_TAB)), "meatloaf.json");
    public static final Item GROUND_BEEF = createItem(new Item(new Item.Properties().food(EFoods.GROUND_BEEF).group(TWEAKS_TAB)), "ground_beef");

    //end rods
    public static final Item RED_END_ROD = createItem(new BlockItem(EBlocks.RED_END_ROD, new Item.Properties().group(TWEAKS_TAB)), Registry.BLOCK.getKey(EBlocks.RED_END_ROD));
    public static final Item BLUE_END_ROD = createItem(new BlockItem(EBlocks.BLUE_END_ROD, new Item.Properties().group(TWEAKS_TAB)), Registry.BLOCK.getKey(EBlocks.BLUE_END_ROD));
    public static final Item GREEN_END_ROD = createItem(new BlockItem(EBlocks.GREEN_END_ROD, new Item.Properties().group(TWEAKS_TAB)), Registry.BLOCK.getKey(EBlocks.GREEN_END_ROD));
    public static final Item YELLOW_END_ROD = createItem(new BlockItem(EBlocks.YELLOW_END_ROD, new Item.Properties().group(TWEAKS_TAB)), Registry.BLOCK.getKey(EBlocks.YELLOW_END_ROD));
    public static final Item ORANGE_END_ROD = createItem(new BlockItem(EBlocks.ORANGE_END_ROD, new Item.Properties().group(TWEAKS_TAB)), Registry.BLOCK.getKey(EBlocks.ORANGE_END_ROD));
    public static final Item PINK_END_ROD = createItem(new BlockItem(EBlocks.PINK_END_ROD, new Item.Properties().group(TWEAKS_TAB)), Registry.BLOCK.getKey(EBlocks.PINK_END_ROD));
    public static final Item BLACK_END_ROD = createItem(new BlockItem(EBlocks.BLACK_END_ROD, new Item.Properties().group(TWEAKS_TAB)), Registry.BLOCK.getKey(EBlocks.BLACK_END_ROD));
    public static final Item PURPLE_END_ROD = createItem(new BlockItem(EBlocks.PURPLE_END_ROD, new Item.Properties().group(TWEAKS_TAB)), Registry.BLOCK.getKey(EBlocks.PURPLE_END_ROD));
    public static final Item LIGHT_BLUE_END_ROD = createItem(new BlockItem(EBlocks.LIGHT_BLUE_END_ROD, new Item.Properties().group(TWEAKS_TAB)), Registry.BLOCK.getKey(EBlocks.LIGHT_BLUE_END_ROD));

    public static Item createItem(Item item, String id) {
        return createItem(item, ETweaks.createResource(id));
    }

    public static Item createItem(Item item, ResourceLocation id) {
        if (id != null && !id.equals(new ResourceLocation("minecraft:air"))) {
            item.setRegistryName(id);

            items.add(item);

            return item;
        } else return null;
    }

    public static void init() {
    }
}
