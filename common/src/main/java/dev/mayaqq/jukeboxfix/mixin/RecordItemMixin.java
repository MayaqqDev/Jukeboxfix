package dev.mayaqq.jukeboxfix.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(RecordItem.class)
public class RecordItemMixin {
    @ModifyArg(
            method = "useOn",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/JukeboxBlockEntity;setFirstItem(Lnet/minecraft/world/item/ItemStack;)V"),
            index = 0
    )
    private ItemStack modifyRecordItem(ItemStack stack) {
        return stack.copyWithCount(1);
    }
}