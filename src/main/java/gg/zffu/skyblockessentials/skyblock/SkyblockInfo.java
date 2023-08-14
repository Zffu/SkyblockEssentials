package gg.zffu.skyblockessentials.skyblock;

import gg.zffu.skyblockessentials.events.SkyblockLocationChangeEvent;
import gg.zffu.skyblockessentials.features.events.jerryworkshop.JerryAttackOverlay;
import gg.zffu.skyblockessentials.utils.MinecraftInstance;
import gg.zffu.skyblockessentials.utils.StringUtils;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.List;

public class SkyblockInfo extends MinecraftInstance {

    public String location;

    public boolean isJerryWorkshopWaveBroken = false;

    public void tick() {

        try {
            Scoreboard scoreboard = mc().theWorld.getScoreboard();
            ScoreObjective sidebar = scoreboard.getObjectiveInDisplaySlot(1);

            List<Score> scores = new ArrayList<>(scoreboard.getSortedScores(sidebar));
            List<String> lines = new ArrayList<>();

            for(int i = scores.size() - 1; i >= 0; i--) {
                Score score = scores.get(i);
                ScorePlayerTeam scorePlayerTeam = scoreboard.getPlayersTeam(score.getPlayerName());
                String line = ScorePlayerTeam.formatPlayerName(scorePlayerTeam, score.getPlayerName());

                lines.add(line);
            }

            for(String line : lines) {
                if(line.contains("⏣")) {
                    String l = StringUtils.cleanColour(line).replaceAll("[^A-Za-z0-9() ]", "").trim();
                    if(!l.equals(location)) {
                        MinecraftForge.EVENT_BUS.post(new SkyblockLocationChangeEvent(l, location));
                        location = l;
                    }
                }

                if(line.contains("Next Wave") && line.contains("Soon")) {
                    if(!isJerryWorkshopWaveBroken) {
                        JerryAttackOverlay.onJerryWorkshopBreak();
                    }
                }

            }
        } catch (Exception e) {

        }

    }

}
