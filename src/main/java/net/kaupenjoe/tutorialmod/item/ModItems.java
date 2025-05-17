package net.kaupenjoe.tutorialmod.item;

import com.jcraft.jorbis.Block;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.entity.ModEntities;
import net.kaupenjoe.tutorialmod.item.custom.*;
import net.kaupenjoe.tutorialmod.sound.ModSounds;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Function;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> ALEXANDRITE = registerItem("alexandrite",
            Item::new);
    public static final RegistryObject<Item> RAW_ALEXANDRITE = registerItem("raw_alexandrite",
            Item::new);

    public static final RegistryObject<Item> CHISEL = registerItem("chisel",
            (properties) -> new ChiselItem(properties.durability(32)));

    public static final RegistryObject<Item> KOHLRABI = registerItem("kohlrabi",
            (properties) -> new Item(properties.food(ModFoodProperties.KOHLRABI)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.kohlrabi"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });
    public static final RegistryObject<Item> AURORA_ASHES = registerItem("aurora_ashes",
            (properties) -> new FuelItem(properties, 1200));

    public static final RegistryObject<Item> ALEXANDRITE_SWORD = registerItem("alexandrite_sword",
            (properties) -> new SwordItem(ModToolTiers.ALEXANDRITE, 3, -2.4f, properties));
    public static final RegistryObject<Item> ALEXANDRITE_PICKAXE = registerItem("alexandrite_pickaxe",
            (properties) -> new PickaxeItem(ModToolTiers.ALEXANDRITE, 1, -2.8f, properties));
    public static final RegistryObject<Item> ALEXANDRITE_SHOVEL = registerItem("alexandrite_shovel",
            (properties) -> new ShovelItem(ModToolTiers.ALEXANDRITE, 1.5f, -3.0f, properties));
    public static final RegistryObject<Item> ALEXANDRITE_AXE = registerItem("alexandrite_axe",
            (properties) -> new AxeItem(ModToolTiers.ALEXANDRITE, 6, -3.2f, properties));
    public static final RegistryObject<Item> ALEXANDRITE_HOE = registerItem("alexandrite_hoe",
            (properties) -> new HoeItem(ModToolTiers.ALEXANDRITE, 0, -3.0f, properties));

    public static final RegistryObject<Item> ALEXANDRITE_HAMMER = registerItem("alexandrite_hammer",
            (properties) -> new HammerItem(ModToolTiers.ALEXANDRITE, 7, -3.5f, properties));

    public static final RegistryObject<Item> ALEXANDRITE_HELMET = registerItem("alexandrite_helmet",
            (properties) -> new ModArmorItem(ModArmorMaterials.ALEXANDRITE_ARMOR_MATERIAL, ArmorType.HELMET,
                    properties.durability(ArmorType.HELMET.getDurability(18))));
    public static final RegistryObject<Item> ALEXANDRITE_CHESTPLATE = registerItem("alexandrite_chestplate",
            (properties) -> new ArmorItem(ModArmorMaterials.ALEXANDRITE_ARMOR_MATERIAL, ArmorType.CHESTPLATE,
                    properties.durability(ArmorType.CHESTPLATE.getDurability(18))));
    public static final RegistryObject<Item> ALEXANDRITE_LEGGINGS = registerItem("alexandrite_leggings",
            (properties) -> new ArmorItem(ModArmorMaterials.ALEXANDRITE_ARMOR_MATERIAL, ArmorType.LEGGINGS,
                    properties.durability(ArmorType.LEGGINGS.getDurability(18))));
    public static final RegistryObject<Item> ALEXANDRITE_BOOTS = registerItem("alexandrite_boots",
            (properties) -> new ArmorItem(ModArmorMaterials.ALEXANDRITE_ARMOR_MATERIAL, ArmorType.BOOTS,
                    properties.durability(ArmorType.BOOTS.getDurability(18))));

    public static final RegistryObject<Item> ALEXANDRITE_HORSE_ARMOR = registerItem("alexandrite_horse_armor",
            (properties) -> new AnimalArmorItem(ModArmorMaterials.ALEXANDRITE_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                    properties.stacksTo(1)));

    public static final RegistryObject<Item> KAUPEN_SMITHING_TEMPLATE = registerItem("kaupen_armor_trim_smithing_template",
            SmithingTemplateItem::createArmorTrimTemplate);

    public static final RegistryObject<Item> KAUPEN_BOW = registerItem("kaupen_bow",
            (properties) -> new BowItem(properties.durability(500)));

    public static final RegistryObject<Item> BAR_BRAWL_MUSIC_DISC = registerItem("bar_brawl_music_disc",
            (properties) -> new Item(properties.jukeboxPlayable(ModSounds.BAR_BRAWL_KEY).stacksTo(1)));

    public static final RegistryObject<Item> KOHLRABI_SEEDS = registerItem("kohlrabi_seeds",
            (properties) -> new BlockItem(ModBlocks.KOHLRABI_CROP.get(), properties));

    public static final RegistryObject<Item> HONEY_BERRIES = registerItem("honey_berries",
            (properties) -> new BlockItem(ModBlocks.HONEY_BERRY_BUSH.get(), properties.food(ModFoodProperties.HONEY_BERRY)));

    public static final RegistryObject<Item> TRICERATOPS_SPAWN_EGG = registerItem("triceratops_spawn_egg",
            (properties) -> new ForgeSpawnEggItem(ModEntities.TRICERATOPS, 0x53524b, 0xdac741, properties));

    public static final RegistryObject<Item> TOMAHAWK = registerItem("tomahawk",
            (properties) -> new TomahawkItem(properties.stacksTo(16)));

    public static final RegistryObject<Item> RADIATION_STAFF = registerItem("radiation_staff",
            (properties) -> new Item(properties.stacksTo(1)));

    public static RegistryObject<Item> registerItem(String name, Function<Item.Properties, Item> function) {
        return ModItems.ITEMS.register(name, () -> function.apply(new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name)))));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
