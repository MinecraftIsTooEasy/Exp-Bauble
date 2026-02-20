package limingzxc.exp_baubles.mixin;

import baubles.api.BaubleSlotHelper;
import limingzxc.exp_baubles.items.Items;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Shadow public abstract EntityDamageResult attackEntityFrom(Damage damage);

    @Redirect(method = "setOnFireFromLava", at = @At(value = "INVOKE", target = "Lnet/minecraft/Entity;attackEntityFrom(Lnet/minecraft/Damage;)Lnet/minecraft/EntityDamageResult;"))
    public EntityDamageResult attackEntityFromLava(Entity entity, Damage damage) {
        if (entity instanceof EntityPlayer player) {
            if (BaubleSlotHelper.hasBeltOfType(player, Items.GOLD_BELT)) {
                damage.setAmount(2.0f);
            }
        }
        return this.attackEntityFrom(damage);
    }
}
