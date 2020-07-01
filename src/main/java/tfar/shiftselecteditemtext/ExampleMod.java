package tfar.shiftselecteditemtext;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

public class ExampleMod {

	public static int hook(int old){
		PlayerEntity player = MinecraftClient.getInstance().player;
		if (player.getArmor() > 0 && player.getAbsorptionAmount() > 0) {
			return old - 3;
		}
		return old;
	}
}
