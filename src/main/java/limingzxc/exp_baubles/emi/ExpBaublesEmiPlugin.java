package limingzxc.exp_baubles.emi;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiInfoRecipe;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import limingzxc.exp_baubles.items.Items;
import net.minecraft.ItemStack;
import net.minecraft.ResourceLocation;
import net.minecraft.Translator;
import shims.java.net.minecraft.text.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExpBaublesEmiPlugin implements EmiPlugin {

    @Override
    public void register(EmiRegistry registry) {
        addCopperRingInfo(registry);
        addDirtRingInfo(registry);
        addClayRingInfo(registry);
        addDragonRingInfo(registry);
        addIronRingInfo(registry);
        addSilverAmuletInfo(registry);
        addMithrilAmuletInfo(registry);
        addGoldBeltInfo(registry);
        addNightVisionGogglesInfo(registry);
    }

    private void addNightVisionGogglesInfo(EmiRegistry registry) {
        List<EmiIngredient> stacks = Collections.singletonList(
            EmiStack.of(new ItemStack(Items.NIGHT_VISION_GOGGLES))
        );

        List<Text> text = Arrays.asList(
            Text.literal("§6" + Translator.get("item.night_vision_goggle.name")),
            Text.literal(""),
            Text.literal("§b" + Translator.get("emi.night_vision_goggle.desc")),
            Text.literal(""),
            Text.literal("§e" + Translator.get("emi.night_vision_goggle.obtain"))
        );

        registry.addRecipe(new EmiInfoRecipe(
            stacks,
            text,
            new ResourceLocation("exp_baubles", "info/night_vision_goggle")
        ));
    }

    private void addCopperRingInfo(EmiRegistry registry) {
        List<EmiIngredient> stacks = Collections.singletonList(
            EmiStack.of(new ItemStack(Items.COPPER_RING))
        );

        List<Text> text = Arrays.asList(
            Text.literal("§6" + Translator.get("item.copper_ring.name")),
            Text.literal(""),
            Text.literal("§b" + Translator.get("item.copper_ring.description")),
            Text.literal(""),
            Text.literal("§e" + Translator.get("emi.copper_ring.obtain"))
        );

        registry.addRecipe(new EmiInfoRecipe(
            stacks,
            text,
            new ResourceLocation("exp_baubles", "info/copper_ring")
        ));
    }

    private void addDirtRingInfo(EmiRegistry registry) {
        List<EmiIngredient> stacks = Collections.singletonList(
            EmiStack.of(new ItemStack(Items.DIRT_RING))
        );

        List<Text> text = Arrays.asList(
            Text.literal("§6" + Translator.get("item.dirt_ring.name")),
            Text.literal(""),
            Text.literal("§b" + Translator.get("item.dirt_ring.description")),
            Text.literal(""),
            Text.literal("§e" + Translator.get("emi.dirt_ring.obtain"))
        );

        registry.addRecipe(new EmiInfoRecipe(
            stacks,
            text,
            new ResourceLocation("exp_baubles", "info/dirt_ring")
        ));
    }

    private void addClayRingInfo(EmiRegistry registry) {
        List<EmiIngredient> stacks = Collections.singletonList(
            EmiStack.of(new ItemStack(Items.CLAY_RING))
        );

        List<Text> text = Arrays.asList(
            Text.literal("§6" + Translator.get("item.clay_ring.name")),
            Text.literal(""),
            Text.literal("§b" + Translator.get("item.clay_ring.description")),
            Text.literal(""),
            Text.literal("§e" + Translator.get("emi.clay_ring.obtain"))
        );

        registry.addRecipe(new EmiInfoRecipe(
            stacks,
            text,
            new ResourceLocation("exp_baubles", "info/clay_ring")
        ));
    }

    private void addDragonRingInfo(EmiRegistry registry) {
        List<EmiIngredient> stacks = Collections.singletonList(
            EmiStack.of(new ItemStack(Items.DRAGON_RING))
        );

        List<Text> text = Arrays.asList(
            Text.literal("§6" + Translator.get("item.dragon_ring.name")),
            Text.literal(""),
            Text.literal("§b" + Translator.get("item.dragon_ring.description")),
            Text.literal(""),
            Text.literal("§e" + Translator.get("emi.dragon_ring.obtain"))
        );

        registry.addRecipe(new EmiInfoRecipe(
            stacks,
            text,
            new ResourceLocation("exp_baubles", "info/dragon_ring")
        ));
    }

    private void addIronRingInfo(EmiRegistry registry) {
        List<EmiIngredient> stacks = Collections.singletonList(
            EmiStack.of(new ItemStack(Items.IRON_RING))
        );

        List<Text> text = Arrays.asList(
            Text.literal("§6" + Translator.get("item.iron_ring.name")),
            Text.literal(""),
            Text.literal("§b" + Translator.get("item.iron_ring.description")),
            Text.literal(""),
            Text.literal("§e" + Translator.get("emi.iron_ring.obtain"))
        );

        registry.addRecipe(new EmiInfoRecipe(
            stacks,
            text,
            new ResourceLocation("exp_baubles", "info/iron_ring")
        ));
    }

    private void addSilverAmuletInfo(EmiRegistry registry) {
        List<EmiIngredient> stacks = Collections.singletonList(
            EmiStack.of(new ItemStack(Items.SILVER_AMULET))
        );

        List<Text> text = Arrays.asList(
            Text.literal("§6" + Translator.get("item.silver_amulet.name")),
            Text.literal(""),
            Text.literal("§b" + Translator.get("item.silver_amulet.description")),
            Text.literal(""),
            Text.literal("§e" + Translator.get("emi.silver_amulet.obtain"))
        );

        registry.addRecipe(new EmiInfoRecipe(
            stacks,
            text,
            new ResourceLocation("exp_baubles", "info/silver_amulet")
        ));
    }

    private void addMithrilAmuletInfo(EmiRegistry registry) {
        List<EmiIngredient> stacks = Collections.singletonList(
            EmiStack.of(new ItemStack(Items.MITHRIL_AMULET))
        );

        List<Text> text = Arrays.asList(
            Text.literal("§6" + Translator.get("item.mithril_amulet.name")),
            Text.literal(""),
            Text.literal("§b" + Translator.get("item.mithril_amulet.description")),
            Text.literal(""),
            Text.literal("§e" + Translator.get("emi.mithril_amulet.obtain"))
        );

        registry.addRecipe(new EmiInfoRecipe(
            stacks,
            text,
            new ResourceLocation("exp_baubles", "info/mithril_amulet")
        ));
    }

    private void addGoldBeltInfo(EmiRegistry registry) {
        List<EmiIngredient> stacks = Collections.singletonList(
            EmiStack.of(new ItemStack(Items.GOLD_BELT))
        );

        List<Text> text = Arrays.asList(
            Text.literal("§6" + Translator.get("item.gold_belt.name")),
            Text.literal(""),
            Text.literal("§b" + Translator.get("item.gold_belt.description")),
            Text.literal(""),
            Text.literal("§e" + Translator.get("emi.gold_belt.obtain"))
        );

        registry.addRecipe(new EmiInfoRecipe(
            stacks,
            text,
            new ResourceLocation("exp_baubles", "info/gold_belt")
        ));
    }

}