package limingzxc.exp_baubles.event;

import limingzxc.exp_baubles.items.Items;
import moddedmite.rustedironcore.api.event.listener.ILootTableRegisterListener;
import net.minecraft.ItemStack;
import net.minecraft.WeightedRandomChestContent;

import java.util.List;

public class NVGogglesLootListener implements ILootTableRegisterListener {

    @Override
    public void onFortressRegister(List<WeightedRandomChestContent> original) {

            original.add(new WeightedRandomChestContent(
                    new ItemStack(Items.NIGHT_VISION_GOGGLES, 1),
                    1,
                    1,
                    3
            ));
    }
}