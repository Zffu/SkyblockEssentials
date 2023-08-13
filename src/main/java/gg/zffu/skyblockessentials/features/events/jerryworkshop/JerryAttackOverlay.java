package gg.zffu.skyblockessentials.features.events.jerryworkshop;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class JerryAttackOverlay {

    private boolean active = false;
    private boolean isNextWaveLastWave = false;

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

}
