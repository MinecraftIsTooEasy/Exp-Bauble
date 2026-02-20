package limingzxc.exp_baubles.mixin;

import baubles.api.BaubleSlotHelper;
import limingzxc.exp_baubles.items.Items;
import net.minecraft.EntityPlayer;
import net.minecraft.FoodStats;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FoodStats.class)
public class FoodStatsMixin {
    @Shadow private EntityPlayer player;

    /**
     * @author limingzxc
     * @reason Dirt
     */
    @Overwrite
    public int getNutritionLimit() {
        int nutritionLimit = Math.max(Math.min(6 + this.player.getExperienceLevel() / 5 * 2, 20), 6);
        // Count how many dirt rings the player has equipped
        int dirtRingCount = BaubleSlotHelper.countRingsOfType(player, Items.DIRT_RING);
        nutritionLimit += dirtRingCount * 2;
        return nutritionLimit;
    }
}
