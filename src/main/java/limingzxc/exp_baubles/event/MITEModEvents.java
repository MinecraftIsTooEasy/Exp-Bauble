package limingzxc.exp_baubles.event;

import com.google.common.eventbus.Subscribe;
import limingzxc.exp_baubles.items.Items;
import net.xiaoyu233.fml.reload.event.*;

public class MITEModEvents {

    @Subscribe
    public void onItemRegister(ItemRegistryEvent event) {
        Items.registerItems(event);
    }

    @Subscribe
    public void onRecipeRegister(RecipeRegistryEvent event) {
        Items.registerRecipes(event);
    }
    
    @Subscribe
    public void onPlayerLoggedIn(PlayerLoggedInEvent event) {

    }

    @Subscribe
    public void onEntityRendererRegister(EntityRendererRegistryEvent event){

    }

    @Subscribe
    public void onPacketRegister(PacketRegisterEvent event){

    }
}
