package limingzxc.exp_baubles.items.ring;

import baubles.api.BaubleType;
import limingzxc.exp_baubles.items.ItemNormalBaubles;
import net.minecraft.*;

import java.util.List;

public class CopperRing extends ItemNormalBaubles {
	public CopperRing(int id)
	{
		super(id, Material.copper, "copper_ring");
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}

	@Override
	public int getExperienceValue() {
		return 20;
	}
}
