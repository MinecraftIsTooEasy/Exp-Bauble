package limingzxc.exp_baubles.mixin;

import baubles.api.BaubleSlotHelper;
import limingzxc.exp_baubles.items.Items;
import net.minecraft.EntityPlayer;
import net.minecraft.ItemRock;
import net.minecraft.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemRock.class)
public class ItemRockMixin {
    @Inject(method = "onItemRightClick(Lnet/minecraft/EntityPlayer;Lnet/minecraft/ItemStack;FZ)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/EntityPlayer;addExperience(I)V"))
    private static void onItemRightClick(EntityPlayer player, ItemStack item_stack, float partial_tick, boolean ctrl_is_down, CallbackInfoReturnable<Boolean> cir) {
        if (BaubleSlotHelper.hasAmuletOfType(player, Items.MITHRIL_AMULET)) {
            int xp_value = ItemRock.getExperienceValueWhenSacrificed(item_stack);
            player.addExperience((int) (xp_value * 0.2));
        }
    }
}
