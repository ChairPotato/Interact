package us.interact.ui.font;

import java.awt.Font;
import java.io.InputStream;

import net.minecraft.client.Minecraft;

public class Raleway {

	public static UnicodeFontRenderer small;
	public static UnicodeFontRenderer medium;
	public static UnicodeFontRenderer big;
	public static UnicodeFontRenderer tab;
	public static UnicodeFontRenderer bar;
	public static UnicodeFontRenderer chat;
	
	public static void load() {
		
		InputStream is = Raleway.class.getResourceAsStream("/us/interact/ui/font/fonts/Raleway.TTF");
		
		Font font = null;
		
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, is);

			chat = new UnicodeFontRenderer(font.deriveFont(10F));
			bar = new UnicodeFontRenderer(font.deriveFont(17F));
			tab = new UnicodeFontRenderer(font.deriveFont(30F));
			small = new UnicodeFontRenderer(font.deriveFont(30F));
			medium = new UnicodeFontRenderer(font.deriveFont(70F));
			big = new UnicodeFontRenderer(font.deriveFont(90F));
			
			if(Minecraft.getMinecraft().gameSettings.language != null) {
				small.setUnicodeFlag(true);
				small.setBidiFlag(Minecraft.getMinecraft().mcLanguageManager.isCurrentLanguageBidirectional());
				chat.setUnicodeFlag(true);
				chat.setBidiFlag(Minecraft.getMinecraft().mcLanguageManager.isCurrentLanguageBidirectional());
				medium.setUnicodeFlag(true);
				medium.setBidiFlag(Minecraft.getMinecraft().mcLanguageManager.isCurrentLanguageBidirectional());
				big.setUnicodeFlag(true);
				big.setBidiFlag(Minecraft.getMinecraft().mcLanguageManager.isCurrentLanguageBidirectional());
				tab.setUnicodeFlag(true);
				tab.setBidiFlag(Minecraft.getMinecraft().mcLanguageManager.isCurrentLanguageBidirectional());
				bar.setUnicodeFlag(true);
				bar.setBidiFlag(Minecraft.getMinecraft().mcLanguageManager.isCurrentLanguageBidirectional());
			}
		} catch (Exception e) {e.printStackTrace();}
		
	}

}
