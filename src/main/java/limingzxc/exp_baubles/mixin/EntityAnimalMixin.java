package limingzxc.exp_baubles.mixin;

import baubles.api.BaublesApi;
import limingzxc.exp_baubles.items.ring.ClayRing;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityAnimal.class)
public abstract class EntityAnimalMixin extends EntityAgeable implements IAnimals {
    public EntityAnimalMixin(World par1World) {
        super(par1World);
    }

    @Inject(method = "attackEntityFrom", at = @At("RETURN"))
    public void attackEntityFrom(Damage damage, CallbackInfoReturnable<EntityDamageResult> cir) {
        if (damage.getSource().getResponsibleEntity() instanceof EntityPlayer player) {
            ItemStack itemStack1 = BaublesApi.getBaubles(player).getStackInSlot(1);
            ItemStack itemStack2 = BaublesApi.getBaubles(player).getStackInSlot(2);
            if (itemStack1 != null && itemStack1.getItem() instanceof ClayRing) {
                this.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 40, 1, true));
            }
            if (itemStack2 != null && itemStack2.getItem() instanceof ClayRing) {
                this.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 40, 1, true));
            }
        }
    }
}
