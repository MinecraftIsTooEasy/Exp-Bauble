package limingzxc.exp_baubles.mixin;

import baubles.api.BaublesApi;
import limingzxc.exp_baubles.items.ring.DirtRing;
import net.minecraft.EntityPlayer;
import net.minecraft.FoodStats;
import net.minecraft.ItemStack;
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
        ItemStack itemStack1 = BaublesApi.getBaubles(player).getStackInSlot(1);
        ItemStack itemStack2 = BaublesApi.getBaubles(player).getStackInSlot(2);
        if (itemStack1 != null && itemStack1.getItem() instanceof DirtRing) {
            nutritionLimit += 2;
        }
        if (itemStack2 != null && itemStack2.getItem() instanceof DirtRing) {
            nutritionLimit += 2;
        }
        return nutritionLimit;
    }

//    @Inject(method = "addFoodValue", at = @At(value = "INVOKE",
//            target = "Lnet/minecraft/EntityPlayer;getAsEntityPlayerMP()Lnet/minecraft/ServerPlayer;"),
//            cancellable = true)
//    public void addFoodValue(Item item, CallbackInfo ci) {
//        if (this.player instanceof ServerPlayer) {
//            ItemStack itemStack1 = BaublesApi.getBaubles(player).getStackInSlot(1);
//            ItemStack itemStack2 = BaublesApi.getBaubles(player).getStackInSlot(2);
//            if (itemStack1 != null && itemStack1.getItem() instanceof DirtRing) {
//                ci.cancel();
//            }
//            if (itemStack2 != null && itemStack2.getItem() instanceof DirtRing) {
//                ci.cancel();
//            }
//        }
//    }
}
