package limingzxc.exp_baubles.items.amulet;

import baubles.api.BaubleType;
import limingzxc.exp_baubles.items.ItemNormalBaubles;
import net.minecraft.ItemStack;
import net.minecraft.Material;

public class MithrilAmulet extends ItemNormalBaubles {
    public MithrilAmulet(int id) {
        super(id, Material.mithril, "mithril_amulet");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.AMULET;
    }

    @Override
    public int getExperienceValue() {
        return 5000;
    }
}
