package limingzxc.exp_baubles.items.Belt;

import baubles.api.BaubleType;
import limingzxc.exp_baubles.items.ItemNormalBaubles;
import net.minecraft.*;

public class GoldBelt extends ItemNormalBaubles {

    public GoldBelt(int id)
    {
        super(id, Material.gold, "gold_belt");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.BELT;
    }

    @Override
    public int getExperienceValue() {
        return 800;
    }
}
