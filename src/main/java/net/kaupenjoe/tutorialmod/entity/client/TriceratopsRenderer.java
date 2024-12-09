package net.kaupenjoe.tutorialmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.entity.custom.TriceratopsEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TriceratopsRenderer extends MobRenderer<TriceratopsEntity, TriceratopsModel<TriceratopsEntity>> {
    public TriceratopsRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TriceratopsModel<>(pContext.bakeLayer(TriceratopsModel.LAYER_LOCATION)), 0.85f);
    }

    @Override
    public ResourceLocation getTextureLocation(TriceratopsEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/triceratops/triceratops_gray.png");
    }

    @Override
    public void render(TriceratopsEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            pPoseStack.scale(1f, 1f, 1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
