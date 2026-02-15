package limingzxc.exp_baubles.mixin;

import limingzxc.exp_baubles.items.Items;
import net.minecraft.WeightedRandomChestContent;
import net.minecraft.WorldGenDungeons;
import net.minecraft.WorldGenerator;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldGenDungeons.class)
public abstract class WorldGenDungeonsMixin extends WorldGenerator {
    @Mutable
    @Final
    @Shadow
    private static WeightedRandomChestContent[] field_111189_a;
    @Mutable
    @Final
    @Shadow
    private static WeightedRandomChestContent[] chest_contents_for_underworld;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void addBaublesLoot(CallbackInfo ci) {
        field_111189_a = WeightedRandomChestContent.func_92080_a(field_111189_a,
                new WeightedRandomChestContent(Items.COPPER_RING.itemID, 0, 1, 1, 1),
                new WeightedRandomChestContent(Items.SILVER_AMULET.itemID, 0, 1, 1, 1),
                new WeightedRandomChestContent(Items.GOLD_BELT.itemID, 0, 1, 1, 1),
                new WeightedRandomChestContent(Items.IRON_RING.itemID, 0, 1, 1, 1)

        );
        chest_contents_for_underworld = WeightedRandomChestContent.func_92080_a(chest_contents_for_underworld,
                new WeightedRandomChestContent(Items.NIGHT_VISION_GOGGLES.itemID, 0, 1, 1, 1),
                new WeightedRandomChestContent(baubles.common.items.Items.RING.itemID, 0, 1, 1, 1)
        );
    }
}
