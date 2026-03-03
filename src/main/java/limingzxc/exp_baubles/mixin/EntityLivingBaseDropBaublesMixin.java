package limingzxc.exp_baubles.mixin;

import limingzxc.exp_baubles.items.Items;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityLivingBase.class)
public class EntityLivingBaseDropBaublesMixin {

    @Inject(method = "onDeath", at = @At("RETURN"))
    private void dropBaubles(DamageSource source, CallbackInfo ci) {

        EntityLivingBase self = (EntityLivingBase) (Object) this;

        if (self.worldObj == null || self.worldObj.isRemote) return;

        if (self instanceof EntityPlayer) return;

        if (self instanceof EntityAmbientCreature) {
            if (self.worldObj != null && self.worldObj.rand.nextDouble() < 0.01) {
                self.dropItem(Items.NIGHT_VISION_GOGGLES);
            }
        }
    }
}