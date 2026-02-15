package limingzxc.exp_baubles.mixin;

import limingzxc.exp_baubles.items.ItemNormalBaubles;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SlotCrafting.class)
public abstract class SlotCraftingMixin extends Slot {
    public SlotCraftingMixin(IInventory inventory, int slot_index, int display_x, int display_y) {
        super(inventory, slot_index, display_x, display_y);
    }

    @Inject(method = "canPlayerCraftItem", at = @At("RETURN"), cancellable = true)
    public void canPlayerCraftItem(EntityPlayer player, CallbackInfoReturnable<Boolean> cir) {
        if (this.getStack() == null) {
            return;
        }
        Item item = this.getStack().getItem();
        if (item instanceof ItemNormalBaubles && player.experience < ((ItemNormalBaubles)item).getExperienceValue()) {
            cir.setReturnValue(false);
        }
    }
}
