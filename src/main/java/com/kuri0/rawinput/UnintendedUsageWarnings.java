package com.kuri0.rawinput;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Util;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/***********************
 * UnintendedUsageWarnings
 * 
 * A Java class written by Erymanthus / RayDeeUx as a means to minimize instances of unintentionally loading
 * the RawInput mod in Minecraft instances outside of the Microsoft Windows operating system.
 * An additional check is included to detect a SkyClient instance specifically to complement the soon-to-be
 * (as of time of writing) plan to add a warning for users not on Windows who attempt to select the RawInput
 * mod in the SkyClient installer, as folks who can't read are probably going to go out of their way to sneak
 * the RawInput mod into their SkyClient installation despite those warnings.
 * 
 * We truly are living in the future, folks.
***********************/
public class UnintendedUsageWarnings {
    private boolean hasSentWarningForSession = false;
    private String warningMessage = "his mod is only intended for Windows. Please remove this mod from your mods folder and relaunch your game as soon as possible, as this mod is dormant when used outside of Windows.";
    private String warningMessagePrefix = "[RawInput] T";
    private String os = System.getProperty("os.name");
    private EntityPlayerSP mcgmtp = Minecraft.getMinecraft().thePlayer;

    @SubscribeEvent
    public void sendWarning(TickEvent.ClientTickEvent event){
        if (hasSentWarningForSession || (Util.getOSType() == Util.EnumOS.WINDOWS) || Minecraft.getMinecraft().thePlayer == null) return;
        if ((Loader.isModLoaded("skyclientcosmetics") || Loader.isModLoaded("skyblockclientupdater"))) warningMessagePrefix = "[RawInput] Hi there! This is another reminder that t";
        mcgmtp.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + warningMessagePrefix + warningMessage));
        mcgmtp.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[RawInput] You are currently on " + os + ". If you feel that this message was a mistake, please ping Erymanthus#5074 in the SkyClient Discord server: https://inv.wtf/skyclient"));
        //prevent sending warning more than once per session
        hasSentWarningForSession = true;
    }
}