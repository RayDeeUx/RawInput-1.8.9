package com.kuri0.rawinput;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.Loader;

import java.awt.Desktop;

public class OpenFileCommand extends CommandBase {
	@Override
	public String getCommandName() {
		return "modfolder";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		try {
			Desktop.getDesktop().open(Loader.instance().activeModContainer().getSource().getParentFile());
		} catch (Exception e) {
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[RawInput] You are currently on " + System.getProperty("os.name") + ", and RawInput had a problem trying to access your mods folder. Please screenshot this message and ping Erymanthus#5074 in the SkyClient Discord server: https://inv.wtf/skyclient"));
		}
	}
	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}
}
