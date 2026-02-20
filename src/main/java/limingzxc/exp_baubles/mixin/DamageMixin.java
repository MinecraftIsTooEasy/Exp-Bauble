package limingzxc.exp_baubles.mixin;

import baubles.api.BaubleSlotHelper;
import limingzxc.exp_baubles.items.Items;
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
            int ironRingCount = BaubleSlotHelper.countRingsOfType(player, Items.IRON_RING);
            // Each iron ring reduces protection by 20% (multiply by 0.8)
            for (int i = 0; i < ironRingCount; i++) {
                protectionFromArmor *= 0.8F;
            }
        }
        return protectionFromArmor;
    }
}
