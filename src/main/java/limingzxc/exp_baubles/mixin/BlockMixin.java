package limingzxc.exp_baubles.mixin;

import baubles.api.BaublesApi;
import com.llamalad7.mixinextras.sugar.Local;
import limingzxc.exp_baubles.items.amulet.MithrilAmulet;
import net.minecraft.Block;
import net.minecraft.BlockBreakInfo;
import net.minecraft.EntityPlayer;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(Block.class)
public abstract class BlockMixin {
    @Shadow protected abstract void dropXpOnBlockBreak(World par1World, int par2, int par3, int par4, int par5);

    @Inject(method = "dropBlockAsEntityItem(Lnet/minecraft/BlockBreakInfo;IIIF)I",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/Block;dropXpOnBlockBreak(Lnet/minecraft/World;IIII)V"), locals = LocalCapture.CAPTURE_FAILHARD)
    public void moreXpDrop(BlockBreakInfo info, int id_dropped, int subtype, int quantity, float chance, CallbackInfoReturnable<Integer> cir, int damage, int num_drops, int xp_reward_per_unit) {
        if (info.responsible_entity instanceof EntityPlayer entityPlayer) {
            if (BaublesApi.getBaubles(entityPlayer).getStackInSlot(0) != null
                    && BaublesApi.getBaubles(entityPlayer).getStackInSlot(0).getItem() instanceof MithrilAmulet) {
                this.dropXpOnBlockBreak(info.world, info.x, info.y, info.z, (int) (xp_reward_per_unit * num_drops * 0.5));
            }
        }
    }
}
