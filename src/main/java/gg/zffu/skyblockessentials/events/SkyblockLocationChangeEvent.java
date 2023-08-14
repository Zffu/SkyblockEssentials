package gg.zffu.skyblockessentials.events;

import net.minecraftforge.fml.common.eventhandler.Event;

public class SkyblockLocationChangeEvent extends Event {

    public String location;
    public String oldLocation;

    public SkyblockLocationChangeEvent(String location, String oldLocation) {
        this.location = location;
        this.oldLocation = oldLocation;
    }

}
