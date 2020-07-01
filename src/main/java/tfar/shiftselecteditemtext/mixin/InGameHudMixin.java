package tfar.shiftselecteditemtext.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import tfar.shiftselecteditemtext.ExampleMod;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
	@Shadow protected abstract PlayerEntity getCameraPlayer();

	@ModifyVariable(method = "renderHeldItemTooltip",
					at = @At(value = "INVOKE", target = "net/minecraft/client/gui/hud/InGameHud.getFontRenderer()Lnet/minecraft/client/font/TextRenderer;")
	,ordinal = 1)
	private int fixOffset(int old) {
		return ExampleMod.hook(old);
	}
}

