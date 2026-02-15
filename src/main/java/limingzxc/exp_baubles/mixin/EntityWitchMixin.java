package limingzxc.exp_baubles.mixin;

import baubles.api.BaublesApi;
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
        if (BaublesApi.getBaubles(player).getStackInSlot(3) != null
                && BaublesApi.getBaubles(player).getStackInSlot(3).hasMaterial(Material.gold)) {
            if (this.rand.nextInt(20) <= 1) {
                ItemDamageResult result = BaublesApi.getBaubles(player).getStackInSlot(3).tryDamageItem(this.worldObj, 1, false);
                if (result != null && result.itemWasDestroyed()) {
                    BaublesApi.getBaubles(player).setInventorySlotContents(3, null);
                }
            }
            ci.cancel();
        }
    }
}
