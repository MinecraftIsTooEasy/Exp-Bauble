package limingzxc.exp_baubles.mixin;

import baubles.api.BaubleSlotHelper;
import limingzxc.exp_baubles.items.Items;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityPigZombie.class)
public abstract class EntityPigZombieMixin extends EntityZombie {
    public EntityPigZombieMixin(World par1World) {
        super(par1World);
    }

    @Redirect(method = "findPlayerToAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/EntityZombie;findPlayerToAttack(F)Lnet/minecraft/EntityPlayer;"))
    public EntityPlayer becomeAngryAt(EntityZombie entityZombie, float max_distance) {
        EntityPlayer player = super.findPlayerToAttack(max_distance);
        if (player != null && BaubleSlotHelper.hasBeltOfType(player, Items.GOLD_BELT)) {
            return null;
        }
        return player;
    }
}
