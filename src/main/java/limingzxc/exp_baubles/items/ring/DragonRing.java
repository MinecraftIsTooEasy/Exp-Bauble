package limingzxc.exp_baubles.items.ring;

import baubles.api.BaubleType;
import limingzxc.exp_baubles.items.ItemExpBaubles;
import net.minecraft.*;

import java.util.List;

public class DragonRing extends ItemExpBaubles {

    public DragonRing(int id) {
        super(id, Material.adamantium, "dragon_ring");
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
        super.onEquipped(itemstack, player);
        if (player instanceof EntityPlayer entityPlayer) {
            allowPlayerFlying(entityPlayer);
        }
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
        if (player instanceof EntityPlayer entityPlayer) {
            notAllowPlayerFlying(entityPlayer);
        }
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        if (player instanceof EntityPlayer entityPlayer) {
            if (entityPlayer.experience >= getLessExperienceValue()) {
                allowPlayerFlying(entityPlayer);
                if (entityPlayer.capabilities.isFlying) {
                    entityPlayer.addExperience(-this.getLessExperienceValue(), false, true);
                }
            } else {
                notAllowPlayerFlying(entityPlayer);
            }
        }
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @Override
    public int canEquipExperienceLevel() {
        return 45;
    }

    @Override
    public int getLessExperienceValue() {
        return 10;
    }

    private void allowPlayerFlying(EntityPlayer player) {
        if (!player.capabilities.allowFlying) {
            player.capabilities.allowFlying = true;
            player.sendPlayerAbilities();
        }
    }

    private void notAllowPlayerFlying(EntityPlayer player) {
        if (player.capabilities.allowFlying) {
            player.capabilities.allowFlying = false;
            player.capabilities.isFlying = false;
            player.sendPlayerAbilities();
            player.fallDistance = 0;
        }
    }
}
