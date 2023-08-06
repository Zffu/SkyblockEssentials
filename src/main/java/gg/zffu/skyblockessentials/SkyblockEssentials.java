package gg.zffu.skyblockessentials;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import gg.zffu.skyblockessentials.config.SkyblockEssentialsConfig;
import gg.zffu.skyblockessentials.versioning.BuildType;
import jline.internal.Log;
import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Set;


@Mod(modid = SkyblockEssentials.MOD_ID, version = SkyblockEssentials.VERSION)
public class SkyblockEssentials {

    public static final String MOD_ID = "skyblockessentials", VERSION = "1.0.0";
    public static final BuildType BUILD_TYPE = BuildType.DEV;
    private static SkyblockEssentials INSTANCE;

    private final Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    private final Logger logger = LogManager.getLogger("SkyblockEssentials");
    private File modFolder;
    private File configFile;
    private SkyblockEssentialsConfig config;

    private boolean hasSkyblockScoreboard;

    private static final Set<String> SKYBLOCK_NAMES =
            Sets.newHashSet("SKYBLOCK", "\u7A7A\u5C9B\u751F\u5B58", "\u7A7A\u5CF6\u751F\u5B58");

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        logger.info("Loading SkyblockEssentials v" + VERSION);
        INSTANCE = this;

        this.modFolder = new File(event.getModConfigurationDirectory(), "skyblockessentials");
        this.modFolder.mkdirs();

        this.configFile = new File(this.modFolder, "config.json");

        if(this.configFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.configFile), StandardCharsets.UTF_8));
                this.config = gson.fromJson(reader, SkyblockEssentialsConfig.class);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


    }

    public static SkyblockEssentials getInstance() {
        return INSTANCE;
    }

    public static Logger getLogger() {return INSTANCE.logger;}

    public void updateScoreboard() {
        Minecraft mc = Minecraft.getMinecraft();
        // Checks if the client brand is from an hypixel server
        if(mc.isSingleplayer() || mc.thePlayer.getClientBrand() == null || !mc.thePlayer.getClientBrand().toLowerCase().contains("hypixel")) {
            this.hasSkyblockScoreboard = false;
            return;
        }

        Scoreboard scoreboard = mc.theWorld.getScoreboard();
        ScoreObjective sidebar = scoreboard.getObjectiveInDisplaySlot(1);

        if(sidebar != null) {
            String name = sidebar.getDisplayName().replaceAll("(?i)\\u00A7.", "");
            for(String n : SKYBLOCK_NAMES) {
                if(name.startsWith(n)) {
                    hasSkyblockScoreboard = true;
                    return;
                }
            }
        }
        hasSkyblockScoreboard = false;
    }

}
