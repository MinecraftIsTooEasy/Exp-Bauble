package limingzxc.exp_baubles.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import net.minecraft.*;

import java.util.List;

public abstract class ItemExpBaubles extends ItemBaseBaubles {
    public ItemExpBaubles(int id, Material material, String texture) {
        super(id, material, texture);
    }

    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack) {
        return EnumRarity.epic;
    }

    @Override
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        if (player instanceof EntityPlayer entityPlayer) {
            return entityPlayer.getExperienceLevel() >= canEquipExperienceLevel();
        }
        return false;
    }

    public abstract int canEquipExperienceLevel();

    public abstract int getLessExperienceValue();
}
