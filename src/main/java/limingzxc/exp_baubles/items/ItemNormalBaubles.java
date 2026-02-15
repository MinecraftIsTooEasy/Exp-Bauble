package limingzxc.exp_baubles.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import net.minecraft.*;

import java.util.List;

public abstract class ItemNormalBaubles extends ItemBaseBaubles implements IDamageableItem {
    public ItemNormalBaubles(int id, Material material, String texture) {
        super(id, material, texture);
        this.setMaxDamage(1);
    }

    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack) {
        return EnumRarity.common;
    }

    public abstract int getExperienceValue();

    @Override
    public void onCreated(ItemStack item_stack, World world, EntityPlayer player) {
        player.addExperience(-this.getExperienceValue(), false, true);
    }

    public int getNumComponentsForDurability() {
        return 1;
    }

    public int getRepairCost() {
        return super.getRepairCost();
    }
}
