package limingzxc.exp_baubles.mixin;

import baubles.api.BaublesApi;
import limingzxc.exp_baubles.items.amulet.MithrilAmulet;
import limingzxc.exp_baubles.items.ring.CopperRing;
import limingzxc.exp_baubles.items.ring.IronRing;
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
            if (BaublesApi.getBaubles(player).getStackInSlot(0) != null
                    && BaublesApi.getBaubles(player).getStackInSlot(0).hasMaterial(Material.silver)) {
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
            ItemStack itemStack1 = BaublesApi.getBaubles(player).getStackInSlot(1);
            ItemStack itemStack2 = BaublesApi.getBaubles(player).getStackInSlot(2);
            if (itemStack1 != null && (itemStack1.getItem() instanceof CopperRing || itemStack1.getItem() instanceof IronRing)) {
                total_protection += 1;
            }
            if (itemStack2 != null && (itemStack2.getItem() instanceof CopperRing || itemStack2.getItem() instanceof IronRing)) {
                total_protection += 1;
            }
            cir.setReturnValue(cir.getReturnValue() + total_protection);
        }
    }

    @Redirect(method = "onDeathUpdate", at = @At(value = "INVOKE", target = "Lnet/minecraft/EntityLivingBase;getExperienceValue()I"))
    public int moreXpDrop(EntityLivingBase entityLivingBase) {
        int xp = this.getExperienceValue();
        if (!this.isEntityPlayer() && this.attackingPlayer != null
                && BaublesApi.getBaubles(this.attackingPlayer).getStackInSlot(0) != null
                && BaublesApi.getBaubles(this.attackingPlayer).getStackInSlot(0).getItem() instanceof MithrilAmulet) {
            return (int) (xp * 1.5);
        }
        return xp;
    }
}
