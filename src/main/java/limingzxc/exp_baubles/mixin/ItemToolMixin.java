package limingzxc.exp_baubles.mixin;

import baubles.api.BaubleSlotHelper;
import limingzxc.exp_baubles.items.Items;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemTool.class)
public abstract class ItemToolMixin {
    @Shadow public abstract int getToolDecayFromAttackingEntity(ItemStack item_stack, EntityLivingBase entity_living_base);

    /**
     * @author limingzxc
     * @reason Reduce damage itemStack
     */
    @Overwrite
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
        if (par2EntityLivingBase.onClient()) {
            Minecraft.setErrorMessage("ItemTool.hitEntity: called on client?");
        }
        if (par3EntityLivingBase instanceof EntityPlayer && ((EntityPlayer)par3EntityLivingBase).capabilities.isCreativeMode) {
            return false;
        }
        float toolDecayFromAttackingEntity = this.getToolDecayFromAttackingEntity(par1ItemStack, par2EntityLivingBase);
        if (par3EntityLivingBase instanceof EntityPlayer player) {
            int ironRingCount = BaubleSlotHelper.countRingsOfType(player, Items.IRON_RING);
            // Each iron ring reduces tool decay by 20% (multiply by 0.8)
            for (int i = 0; i < ironRingCount; i++) {
                toolDecayFromAttackingEntity *= 0.8F;
            }
        }
        par1ItemStack.tryDamageItem(DamageSource.generic, Math.round(toolDecayFromAttackingEntity), par3EntityLivingBase);
        return true;
    }
}
