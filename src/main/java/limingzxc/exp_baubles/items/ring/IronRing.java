package limingzxc.exp_baubles.items.ring;

import baubles.api.BaubleType;
import limingzxc.exp_baubles.items.ItemNormalBaubles;
import net.minecraft.ItemStack;
import net.minecraft.Material;

public class IronRing extends ItemNormalBaubles {

    public IronRing(int id) {
        super(id, Material.iron, "iron_ring");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @Override
    public int getExperienceValue() {
        return 1000;
    }

}
