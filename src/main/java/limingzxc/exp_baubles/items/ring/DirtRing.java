package limingzxc.exp_baubles.items.ring;

import baubles.api.BaubleType;
import limingzxc.exp_baubles.items.ItemNormalBaubles;
import net.minecraft.*;

public class DirtRing extends ItemNormalBaubles {
    public DirtRing(int id) {
        super(id, Material.dirt, "dirt_ring");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @Override
    public int getExperienceValue() {
        return 0;
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
        if (player instanceof EntityPlayer entityPlayer) {
            entityPlayer.getFoodStats().setNutrition(0, false);
            entityPlayer.getFoodStats().setSatiation(0, false);
        }
    }
}
