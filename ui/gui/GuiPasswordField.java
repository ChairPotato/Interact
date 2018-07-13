package us.interact.ui.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ChatAllowedCharacters;

public class GuiPasswordField extends GuiTextField {

	public GuiPasswordField(int p_i45542_1_, FontRenderer fontrenderer, int posX, int posY, int width, int height) {
		super(p_i45542_1_, fontrenderer, posX, posY, width, height);
	}

	@Override
	public void drawTextBox() {
		if (this.getVisible()) {
			if (this.getEnableBackgroundDrawing()) {
				drawRect(this.xPosition - 1, this.yPosition - 1, this.xPosition + this.width + 1, this.yPosition + this.height + 1, -6250336);
				drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, -16777216);
			}

			int var1 = this.isEnabled ? this.enabledColor : this.disabledColor;
			int var2 = this.cursorPosition - this.lineScrollOffset;
			int var3 = this.selectionEnd - this.lineScrollOffset;
			String var14 = this.fontRendererInstance.trimStringToWidth(this.text.substring(this.lineScrollOffset), this.getWidth());
			String var4 = "";
			for(int i = 0; i < var14.length(); i++) {
				var4 += "*";
			}
			boolean var5 = var2 >= 0 && var2 <= var4.length();
			boolean var6 = this.isFocused && this.cursorCounter / 6 % 2 == 0 && var5;
			int var7 = this.enableBackgroundDrawing ? this.xPosition + 4 : this.xPosition;
			int var8 = this.enableBackgroundDrawing ? this.yPosition + (this.height - 8) / 2 : this.yPosition;
			int var9 = var7;

			if (var3 > var4.length()) {
				var3 = var4.length();
			}

			if (var4.length() > 0) {
				String var10 = var5 ? var4.substring(0, var2) : var4;
				var9 = this.fontRendererInstance.func_175063_a(var10, (float) var7, (float) var8, var1);
			}

			boolean var13 = this.cursorPosition < this.text.length() || this.text.length() >= this.getMaxStringLength();
			int var11 = var9;

			if (!var5) {
				var11 = var2 > 0 ? var7 + this.width : var7;
			} else if (var13) {
				var11 = var9 - 1;
				--var9;
			}

			if (var4.length() > 0 && var5 && var2 < var4.length()) {
				var9 = this.fontRendererInstance.func_175063_a(var4.substring(var2), (float) var9, (float) var8, var1);
			}

			if (var6) {
				if (var13) {
					Gui.drawRect(var11, var8 - 1, var11 + 1, var8 + 1 + this.fontRendererInstance.FONT_HEIGHT,
							-3092272);
				} else {
					this.fontRendererInstance.func_175063_a("_", (float) var11, (float) var8, var1);
				}
			}

			if (var3 != var2) {
				int var12 = var7 + this.fontRendererInstance.getStringWidth(var4.substring(0, var3));
				this.drawCursorVertical(var11, var8 - 1, var12 - 1, var8 + 1 + this.fontRendererInstance.FONT_HEIGHT);
			}
		}
	}

}
