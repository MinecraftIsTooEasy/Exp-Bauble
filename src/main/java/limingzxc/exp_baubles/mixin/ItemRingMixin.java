package limingzxc.exp_baubles.mixin;

import baubles.common.items.ItemRing;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.List;

@Mixin(ItemRing.class)
public class ItemRingMixin extends Item {
    /**
     * @author limingzxc
     * @reason addExperience
     */
    @Overwrite
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        if (player instanceof EntityPlayer entityPlayer) {
            if (entityPlayer.experience >= getLessExperienceValue() && !player.isPotionActive(Potion.digSpeed)) {
                entityPlayer.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 20 * 2, 0, true));
                entityPlayer.addExperience(-this.getLessExperienceValue(), false, true);
            }
        }
    }

    @Override
    public void addInformationBeforeEnchantments(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(I18n.getString("item." + this.getIconString() + ".description"));
        }
    }

    @Unique
    private int getLessExperienceValue() {
        return 1;
    }
}
