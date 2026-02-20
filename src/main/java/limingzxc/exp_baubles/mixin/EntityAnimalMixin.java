package limingzxc.exp_baubles.mixin;

import baubles.api.BaubleSlotHelper;
import limingzxc.exp_baubles.items.Items;
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
            int clayRingCount = BaubleSlotHelper.countRingsOfType(player, Items.CLAY_RING);
            if (clayRingCount > 0) {
                this.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 40, 1, true));
            }
        }
    }
}
