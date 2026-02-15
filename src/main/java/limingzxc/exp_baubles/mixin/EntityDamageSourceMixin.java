package limingzxc.exp_baubles.mixin;

import baubles.api.BaublesApi;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityDamageSource.class)
public abstract class EntityDamageSourceMixin extends DamageSource {
    protected EntityDamageSourceMixin(String par1Str) {
        super(par1Str);
    }

    @Inject(method = "<init>(Ljava/lang/String;Lnet/minecraft/Entity;Lnet/minecraft/Entity;)V", at = @At("RETURN"))
    public void setSilverAspect(String par1Str, Entity immediate_entity, Entity responsible_entity, CallbackInfo ci) {
        if (immediate_entity instanceof EntityPlayer player) {
            if (BaublesApi.getBaubles(player).getStackInSlot(0) != null
                    && BaublesApi.getBaubles(player).getStackInSlot(0).hasMaterial(Material.silver)) {
                this.setMagicAspect();
            }
        }
    }
}
