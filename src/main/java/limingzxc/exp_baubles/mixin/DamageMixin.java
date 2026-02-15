package limingzxc.exp_baubles.mixin;

import baubles.api.BaublesApi;
import limingzxc.exp_baubles.items.ring.IronRing;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Damage.class)
public class DamageMixin {
    @Redirect(method = "applyTargetDefenseModifiers", at = @At(value = "INVOKE", target = "Lnet/minecraft/EntityLivingBase;getProtectionFromArmor(Lnet/minecraft/DamageSource;Z)F"))
    public float reduceArmorDamage(EntityLivingBase instance, DamageSource damage_source, boolean include_enchantments) {
        float protectionFromArmor = instance.getProtectionFromArmor(damage_source, include_enchantments);
        if (instance instanceof EntityPlayer player) {
            ItemStack itemStack1 = BaublesApi.getBaubles(player).getStackInSlot(1);
            ItemStack itemStack2 = BaublesApi.getBaubles(player).getStackInSlot(2);
            if (itemStack1 != null && itemStack1.getItem() instanceof IronRing) {
                protectionFromArmor *= 0.8F;
            }
            if (itemStack2 != null && itemStack2.getItem() instanceof IronRing) {
                protectionFromArmor *= 0.8F;
            }
        }
        return protectionFromArmor;
    }
}
