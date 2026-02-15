package limingzxc.exp_baubles.mixin;

import baubles.api.BaublesApi;
import limingzxc.exp_baubles.items.amulet.SilverAmulet;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityBat.class)
public abstract class EntityBatMixin extends EntityAmbientCreature {
    public EntityBatMixin(World par1World) {
        super(par1World);
    }

    @Redirect(method = "updateAITasks", at = @At(value = "INVOKE", target = "Ljava/lang/Math;signum(D)D"))
    public double awayPlayerMotion(double d) {
        if (this.getAttackTarget() instanceof EntityPlayer player) {
            if (BaublesApi.getBaubles(player).getStackInSlot(0) != null
                    && BaublesApi.getBaubles(player).getStackInSlot(0).getItem() instanceof SilverAmulet) {
                return -Math.signum(d);
            }
        }
        return Math.signum(d);
    }

//    @Redirect(method = "updateAITasks", at = @At(value = "INVOKE", target = "Lnet/minecraft/MathHelper;wrapAngleTo180_float(F)F"))
//    public float awayPlayerRotationYaw(float par0) {
//        if (((EntityLiving)(Object) this).getAttackTarget() instanceof EntityPlayer player) {
//            if (BaublesApi.getBaubles(player).getStackInSlot(0) != null
//                    && BaublesApi.getBaubles(player).getStackInSlot(0).getItem() instanceof SilverAmulet) {
//                return -MathHelper.wrapAngleTo180_float(par0);
//            }
//        }
//        return MathHelper.wrapAngleTo180_float(par0);
//    }
}
