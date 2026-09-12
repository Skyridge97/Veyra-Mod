package net.mcreator.veyramod.client.screens;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.veyramod.procedures.StarCondition5Procedure;
import net.mcreator.veyramod.procedures.StarCondition4Procedure;
import net.mcreator.veyramod.procedures.StarCondition3Procedure;
import net.mcreator.veyramod.procedures.StarCondition2Procedure;
import net.mcreator.veyramod.procedures.StarCondition1Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class WantedOverlayOverlay {
	private static final ResourceLocation IMAGE_0 = new ResourceLocation("veyra_mod:textures/screens/star_gta5_32x32.png");
	private static final ResourceLocation IMAGE_1 = new ResourceLocation("veyra_mod:textures/screens/star_gta5_32x32.png");
	private static final ResourceLocation IMAGE_2 = new ResourceLocation("veyra_mod:textures/screens/star_gta5_32x32.png");
	private static final ResourceLocation IMAGE_3 = new ResourceLocation("veyra_mod:textures/screens/star_gta5_32x32.png");
	private static final ResourceLocation IMAGE_4 = new ResourceLocation("veyra_mod:textures/screens/star_gta5_32x32.png");

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			if (StarCondition1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_0, w - 23, 11, 0, 0, 16, 16, 16, 16);
			}
			if (StarCondition2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_1, w - 39, 11, 0, 0, 16, 16, 16, 16);
			}
			if (StarCondition3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_2, w - 55, 11, 0, 0, 16, 16, 16, 16);
			}
			if (StarCondition4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_3, w - 71, 11, 0, 0, 16, 16, 16, 16);
			}
			if (StarCondition5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_4, w - 87, 11, 0, 0, 16, 16, 16, 16);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}