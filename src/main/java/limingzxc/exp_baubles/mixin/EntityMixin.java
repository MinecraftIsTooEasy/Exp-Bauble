package limingzxc.exp_baubles.mixin;

import baubles.api.BaublesApi;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Shadow public abstract EntityDamageResult attackEntityFrom(Damage damage);

    @Shadow public abstract void setFire(int par1);

    @Redirect(method = "setOnFireFromLava", at = @At(value = "INVOKE", target = "Lnet/minecraft/Entity;attackEntityFrom(Lnet/minecraft/Damage;)Lnet/minecraft/EntityDamageResult;"))
    public EntityDamageResult attackEntityFromLava(Entity entity, Damage damage) {
        if (entity instanceof EntityPlayer player) {
            if (BaublesApi.getBaubles(player).getStackInSlot(3) != null
                    && BaublesApi.getBaubles(player).getStackInSlot(3).hasMaterial(Material.gold)) {
                damage.setAmount(2.0f);
            }
        }
        return this.attackEntityFrom(damage);
    }

//    @Redirect(method = "setOnFireFromLava", at = @At(value = "INVOKE", target = "Lnet/minecraft/Entity;setFire(I)V"))
//    public void setFireTime(Entity entity, int fireTime) {
//        if (entity instanceof EntityPlayer player) {
//            if (BaublesApi.getBaubles(player).getStackInSlot(3) != null
//                    && BaublesApi.getBaubles(player).getStackInSlot(3).hasMaterial(Material.gold)) {
//                this.setFire(25);
//                return;
//            }
//        }
//        this.setFire(15);
//    }
}
