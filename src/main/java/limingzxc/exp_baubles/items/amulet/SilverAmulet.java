package limingzxc.exp_baubles.items.amulet;

import baubles.api.BaubleType;
import limingzxc.exp_baubles.items.ItemNormalBaubles;
import net.minecraft.*;

public class SilverAmulet extends ItemNormalBaubles {
    public SilverAmulet(int id)
    {
        super(id, Material.silver, "silver_amulet");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.AMULET;
    }

    @Override
    public int getExperienceValue() {
        return 150;
    }
}
