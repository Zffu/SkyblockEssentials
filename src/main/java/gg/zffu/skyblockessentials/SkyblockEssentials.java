package gg.zffu.skyblockessentials;

import gg.zffu.skyblockessentials.versioning.BuildType;
import jline.internal.Log;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = SkyblockEssentials.MOD_ID, version = SkyblockEssentials.VERSION)
public class SkyblockEssentials {

    public static final String MOD_ID = "skyblockessentials", VERSION = "1.0.0";
    public static final BuildType BUILD_TYPE = BuildType.DEV;
    private static SkyblockEssentials INSTANCE;

    private final Logger logger = LogManager.getLogger("SkyblockEssentials");

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        logger.info("Loading SkyblockEssentials v" + VERSION);
        INSTANCE = this;
    }

    public static SkyblockEssentials getInstance() {
        return INSTANCE;
    }

    public static Logger getLogger() {return INSTANCE.logger;}


}
