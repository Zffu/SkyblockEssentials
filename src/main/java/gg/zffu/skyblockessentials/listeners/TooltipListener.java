package gg.zffu.skyblockessentials.listeners;

import gg.zffu.skyblockessentials.SkyblockEssentials;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TooltipListener {

    @SubscribeEvent
    public void onToolTip(ItemTooltipEvent event) {
        if(event.itemStack.getTagCompound() != null) {
            NBTTagCompound compound = event.itemStack.getTagCompound();

            if(compound.getCompoundTag("ExtraAttributes") != null) {
                NBTTagCompound custom = compound.getCompoundTag("ExtraAttributes");

                boolean hasUUID = false;

                if(custom.getString("uuid") != "") {
                    hasUUID = true;
                }

                if(hasUUID && !custom.hasKey("petInfo")) {
                    if(custom.getByte("donated_museum") == (byte) 1) {
                        event.toolTip.add("§a§l✔ §r§8Donated to museum");
                    }
                    else {
                        event.toolTip.add("§c§l✘ §r§8Not Donated to museum");
                    }
                    event.toolTip.add("§8UUID: " + custom.getString("uuid"));
                }

                if(custom.hasKey("petInfo")) {

                }

                if(custom.getString("id") != "") {
                    event.toolTip.add("§8skyblock:" + custom.getString("id"));
                }

                if(SkyblockEssentials.getInstance().devMode) {
                    event.toolTip.add("");
                    event.toolTip.add(custom.toString());
                }
            }

        }
    }

}
