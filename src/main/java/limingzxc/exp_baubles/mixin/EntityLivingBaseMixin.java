package limingzxc.exp_baubles.mixin;

import baubles.api.BaubleSlotHelper;
import limingzxc.exp_baubles.items.Items;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityLivingBase.class)
public abstract class EntityLivingBaseMixin extends Entity {
    public EntityLivingBaseMixin(World par1World) {
        super(par1World);
    }

    @Shadow public abstract float getSilverArmorCoverage();

    @Shadow public abstract int getExperienceValue();

    @Shadow protected EntityPlayer attackingPlayer;

    @Shadow public abstract EntityDamageResult attackEntityFrom(Damage damage);

    @Redirect(method = "getResistanceToPoison", at = @At(value = "INVOKE", target = "Lnet/minecraft/EntityLivingBase;getSilverArmorCoverage()F"))
    public float getResistanceToPoison(EntityLivingBase entityLivingBase) {
        return this.getAllSilverArmorCoverage(entityLivingBase) * 0.5f;
    }

    @Redirect(method = "getResistanceToDrain", at = @At(value = "INVOKE", target = "Lnet/minecraft/EntityLivingBase;getSilverArmorCoverage()F"))
    public float getResistanceToDrain(EntityLivingBase entityLivingBase) {
        return this.getAllSilverArmorCoverage(entityLivingBase) * 0.5f;
    }

    @Redirect(method = "getResistanceToShadow", at = @At(value = "INVOKE", target = "Lnet/minecraft/EntityLivingBase;getSilverArmorCoverage()F"))
    public float getResistanceToShadow(EntityLivingBase entityLivingBase) {
        return this.getAllSilverArmorCoverage(entityLivingBase) * 0.5f;
    }

    @Unique
    public float getAllSilverArmorCoverage(EntityLivingBase entityLivingBase) {
        float silverArmorCoverage = getSilverArmorCoverage();
        if (entityLivingBase instanceof EntityPlayer player) {
            if (BaubleSlotHelper.hasAmuletOfType(player, Items.SILVER_AMULET)) {
                silverArmorCoverage += 0.5f;
            }
        }
        return  silverArmorCoverage;
    }

    @Inject(method = "getProtectionFromArmor", at = @At("RETURN"), cancellable = true)
    public void addProtectionFromBaubles(DamageSource damage_source, boolean include_enchantments, CallbackInfoReturnable<Float> cir) {
        if (cir.getReturnValue() == 0) {
            return;
        }
        if (((EntityLivingBase)(Object) this) instanceof EntityPlayer player) {
            int total_protection = 0;
            // Count copper and iron rings in both ring slots
            int copperRingCount = BaubleSlotHelper.countRingsOfType(player, Items.COPPER_RING);
            int ironRingCount = BaubleSlotHelper.countRingsOfType(player, Items.IRON_RING);
            total_protection += copperRingCount + ironRingCount;

            cir.setReturnValue(cir.getReturnValue() + total_protection);
        }
    }

    @Redirect(method = "onDeathUpdate", at = @At(value = "INVOKE", target = "Lnet/minecraft/EntityLivingBase;getExperienceValue()I"))
    public int moreXpDrop(EntityLivingBase entityLivingBase) {
        int xp = this.getExperienceValue();
        if (!this.isEntityPlayer() && this.attackingPlayer != null
                && BaubleSlotHelper.hasAmuletOfType(this.attackingPlayer, Items.MITHRIL_AMULET)) {
            return (int) (xp * 1.5);
        }
        return xp;
    }
}
