package limingzxc.exp_baubles.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import limingzxc.exp_baubles.items.ItemNormalBaubles;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(GuiContainer.class)
public class GuiContainerMixin extends GuiScreen {
    @Shadow public Container inventorySlots;

    @Inject(method = "drawItemStackTooltip(Lnet/minecraft/ItemStack;IILnet/minecraft/Slot;)V",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/Slot;getContainer()Lnet/minecraft/Container;"))
    public void drawItemStackTooltip(ItemStack par1ItemStack, int par2, int par3, Slot slot, CallbackInfo ci,
                                     @Local(ordinal = 0, name = "var4") List var4) {
        Item item = par1ItemStack.getItem();
        if (item instanceof ItemNormalBaubles && this.mc.thePlayer.experience < ((ItemNormalBaubles)item).getExperienceValue()) {
            var4.add(EnumChatFormatting.GOLD + Translator.get("container.crafting.requiresExperience"));
            this.inventorySlots.crafting_result_shown_but_prevented = true;
        }
    }
}
