package gg.zffu.skyblockessentials.listeners;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TooltipListener {

    @SubscribeEvent
    public void onToolTip(ItemTooltipEvent event) {
        if(event.itemStack.getTagCompound() != null) {
            NBTTagCompound compound = event.itemStack.getTagCompound();
        }
    }

}
