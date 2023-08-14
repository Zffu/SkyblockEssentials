package gg.zffu.skyblockessentials.features.events.jerryworkshop;

import gg.zffu.skyblockessentials.SkyblockEssentials;
import gg.zffu.skyblockessentials.utils.MinecraftInstance;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class JerryAttackOverlay extends MinecraftInstance {

    private boolean active = false;
    private boolean isNextWaveLastWave = false;

    private int pilesLeft = 0;

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {

        // Handles when the Jerry's Workshop Attack Event Starts and Ends

        if(event.message.getUnformattedText().contains("DEFEND JERRY'S WORKSHOP")) {
            active = true;
        }
        if(event.message.getUnformattedText().contains("Collect your Gifts at the Gift piles!")) {
            active = false;
        }

        // Handles when the next wave is announced as the last one
        if(event.message.getUnformattedText().contains("SEASON OF JERRY The last wave of Magma Cubes is coming soon!")) {
            isNextWaveLastWave = true;
        }
    }

    public static void onJerryWorkshopBreak() {
        SkyblockEssentials.sendMessage("§cThe Jerry Workshop Wave System Broke!, There are no more waves");
    }


}
