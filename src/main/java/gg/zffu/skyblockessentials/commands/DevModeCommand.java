package gg.zffu.skyblockessentials.commands;

import gg.zffu.skyblockessentials.SkyblockEssentials;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class DevModeCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "skyblockessentialsdev";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return null;
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) throws CommandException {
        SkyblockEssentials.getInstance().devMode = !SkyblockEssentials.getInstance().devMode;

        if(SkyblockEssentials.getInstance().devMode) {
            SkyblockEssentials.sendMessage("§aEnabled Dev Mode!");
            SkyblockEssentials.sendMessage("§e§lWARN: §r§cDev Mode enables features to help the Mod Developpers to add more features");
            SkyblockEssentials.sendMessage("§cSome Features might show a lot more information than usual");
            SkyblockEssentials.sendMessage("§cTo Disable Dev Mode use §c/skyblockessentialsdev");
        }
        else {
            SkyblockEssentials.sendMessage("§cDisabled Dev Mode!");
        }

    }
}
