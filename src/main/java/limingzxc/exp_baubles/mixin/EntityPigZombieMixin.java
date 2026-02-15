package limingzxc.exp_baubles.mixin;

import baubles.api.BaublesApi;
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
        if (player != null && BaublesApi.getBaubles(player).getStackInSlot(3) != null
            && BaublesApi.getBaubles(player).getStackInSlot(3).getItem().hasMaterial(Material.gold)) {
            return null;
        }
        return player;
    }
}
