package limingzxc.exp_baubles.mixin;

import baubles.api.BaubleSlotHelper;
import baubles.api.BaublesApi;
import limingzxc.exp_baubles.items.Items;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityWitch.class)
public abstract class EntityWitchMixin extends EntityMob
        implements IRangedAttackMob {
    public EntityWitchMixin(World par1World) {
        super(par1World);
    }

    @Inject(method = "cursePlayer", at = @At("HEAD"), cancellable = true)
    public void cursePlayer(ServerPlayer player, CallbackInfo ci) {
        if (BaubleSlotHelper.hasBeltOfType(player, Items.GOLD_BELT)) {
            ItemStack belt = BaubleSlotHelper.getBelt(player);
            if (this.rand.nextInt(20) <= 1) {
                ItemDamageResult result = belt.tryDamageItem(this.worldObj, 1, false);
                if (result != null && result.itemWasDestroyed()) {
                    BaublesApi.getBaubles(player).setInventorySlotContents(BaubleSlotHelper.BELT_SLOT, null);
                }
            }
            ci.cancel();
        }
    }
}