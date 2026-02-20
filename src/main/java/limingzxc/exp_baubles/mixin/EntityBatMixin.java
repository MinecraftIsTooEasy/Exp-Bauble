package limingzxc.exp_baubles.mixin;

import baubles.api.BaubleSlotHelper;
import limingzxc.exp_baubles.items.Items;
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
            if (BaubleSlotHelper.hasAmuletOfType(player, Items.SILVER_AMULET)) {
                return -Math.signum(d);
            }
        }
        return Math.signum(d);
    }
}
