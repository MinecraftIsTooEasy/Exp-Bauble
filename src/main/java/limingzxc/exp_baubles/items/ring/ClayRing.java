package limingzxc.exp_baubles.items.ring;

import baubles.api.BaubleType;
import limingzxc.exp_baubles.items.ItemNormalBaubles;
import net.minecraft.*;

public class ClayRing extends ItemNormalBaubles {
    public ClayRing(int id) {
        super(id, Material.clay, "clay_ring");
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
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
//        if (!player.isPotionActive(Potion.moveSlowdown)) {
//            player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 0, true));
//        }
    }
}
