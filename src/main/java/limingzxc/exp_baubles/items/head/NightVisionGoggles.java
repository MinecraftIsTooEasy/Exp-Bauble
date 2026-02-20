package limingzxc.exp_baubles.items.head;

import baubles.api.BaubleType;
import limingzxc.exp_baubles.items.ItemExpBaubles;
import net.minecraft.*;

public class NightVisionGoggles extends ItemExpBaubles {
    public NightVisionGoggles(int id) {
        super(id, Material.grass, "night_vision_goggle");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.HEAD;
    }

    @Override
    public int canEquipExperienceLevel() {
        return 0;
    }

    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        if (player instanceof EntityPlayer entityPlayer) {
            if (player.ticksExisted % 200 == 0) {
                if (entityPlayer.experience >= getLessExperienceValue()) {
                    player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 400, 0));
                    entityPlayer.addExperience(-this.getLessExperienceValue(), false, true);
                }
            }
        }
    }

    @Override
    public int getLessExperienceValue() {
        return 3;
    }
}
