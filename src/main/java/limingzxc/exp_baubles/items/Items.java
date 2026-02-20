package limingzxc.exp_baubles.items;

import baubles.creativetab.BaublesCreativeTab;
import limingzxc.exp_baubles.ExpBaubles;
import limingzxc.exp_baubles.items.Belt.GoldBelt;
import limingzxc.exp_baubles.items.amulet.MithrilAmulet;
import limingzxc.exp_baubles.items.head.NightVisionGoggles;
import limingzxc.exp_baubles.items.ring.*;
import limingzxc.exp_baubles.items.amulet.SilverAmulet;
import limingzxc.exp_baubles.util.Config;
import net.minecraft.Block;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;

public class Items {
    public static final Item COPPER_RING = new CopperRing(Config.COPPER_RING_ID.get());
    public static final Item SILVER_AMULET = new SilverAmulet(Config.SILVER_AMULET_ID.get());
    public static final Item GOLD_BELT = new GoldBelt(Config.GOLD_BELT_ID.get());
    public static final Item DIRT_RING = new DirtRing(Config.DIRT_RING_ID.get());
    public static final Item DRAGON_RING = new DragonRing(Config.DRAGON_RING_ID.get());
    public static final Item CLAY_RING = new ClayRing(Config.CLAY_RING_ID.get());
    public static final Item IRON_RING = new IronRing(Config.IRON_RING_ID.get());
    public static final Item NIGHT_VISION_GOGGLES = new NightVisionGoggles(Config.NIGHT_VISION_GOGGLES_ID.get());
    public static final Item MITHRIL_AMULET = new MithrilAmulet(Config.MITHRIL_AMULET_ID.get());

    public static void registerItems(ItemRegistryEvent event) {
        event.register(ExpBaubles.modID, "copper_ring", COPPER_RING, BaublesCreativeTab.TAB);
        event.register(ExpBaubles.modID, "silver_amulet", SILVER_AMULET, BaublesCreativeTab.TAB);
        event.register(ExpBaubles.modID, "gold_belt", GOLD_BELT, BaublesCreativeTab.TAB);
        event.register(ExpBaubles.modID, "dirt_ring", DIRT_RING, BaublesCreativeTab.TAB);
        event.register(ExpBaubles.modID, "clay_ring", CLAY_RING, BaublesCreativeTab.TAB);
        event.register(ExpBaubles.modID, "dragon_ring", DRAGON_RING, BaublesCreativeTab.TAB);
        event.register(ExpBaubles.modID, "iron_ring", IRON_RING, BaublesCreativeTab.TAB);
        event.register(ExpBaubles.modID, "night_vision_goggle", NIGHT_VISION_GOGGLES, BaublesCreativeTab.TAB);
        event.register(ExpBaubles.modID, "mithril_amulet", MITHRIL_AMULET, BaublesCreativeTab.TAB);
    }

    public static void registerRecipes(RecipeRegistryEvent event) {
        event.registerShapedRecipe(new ItemStack(COPPER_RING), true,
                " A ", "A A", " A ", 'A', Item.chainCopper);
        event.registerShapedRecipe(new ItemStack(SILVER_AMULET), true,
                "AAA", "A A", " B ", 'A', Item.chainSilver, 'B', Item.ingotSilver);
        event.registerShapedRecipe(new ItemStack(GOLD_BELT), true,
                "ABA", "A A", "ABA", 'A', Item.ingotGold, 'B', Item.chainGold);
        event.registerShapelessRecipe(new ItemStack(DIRT_RING), true,
                Block.dirt, Block.dirt, Block.dirt, Block.dirt);
        event.registerShapelessRecipe(new ItemStack(CLAY_RING), true,
                Item.clay, Item.clay, Item.clay, Block.dirt);
        event.registerShapedRecipe(new ItemStack(DRAGON_RING), true,
                "CAC", "ABA", "CAC", 'A', Item.chainAdamantium, 'B', Block.dragonEgg, 'C', Item.bucketAdamantiumLava);
        event.registerShapedRecipe(new ItemStack(IRON_RING), true,
                "BAB", "A A", "BAB", 'A', Item.ingotIron, 'B', Item.chainIron);
        event.registerShapedRecipe(new ItemStack(MITHRIL_AMULET), true,
                "BAB", "ACA", "BAB", 'A', Item.ingotMithril, 'B', Item.chainMithril, 'C', Item.expBottle);
    }
}
