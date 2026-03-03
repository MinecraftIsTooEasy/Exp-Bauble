package limingzxc.exp_baubles.items.head;

import baubles.api.BaubleType;
import limingzxc.exp_baubles.items.ItemBaseBaubles;
import net.minecraft.*;

public class NightVisionGoggles extends ItemBaseBaubles {
    public NightVisionGoggles(int id) {
        super(id, Material.grass, "night_vision_goggle");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.HEAD;
    }

    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        if (player instanceof EntityPlayer) {
            if (player.ticksExisted % 200 == 0) {
                player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 400, 0));
            }
        }
    }
}