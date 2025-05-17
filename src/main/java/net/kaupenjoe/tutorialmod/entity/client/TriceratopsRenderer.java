package net.kaupenjoe.tutorialmod.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.entity.TriceratopsVariant;
import net.kaupenjoe.tutorialmod.entity.custom.TriceratopsEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class TriceratopsRenderer extends MobRenderer<TriceratopsEntity, TriceratopsRenderState, TriceratopsModel<TriceratopsEntity>> {
    private static final Map<TriceratopsVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(TriceratopsVariant.class), map -> {
                map.put(TriceratopsVariant.GRAY,
                        ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/triceratops/triceratops_gray.png"));
                map.put(TriceratopsVariant.GREEN,
                        ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/triceratops/triceratops_green.png"));
            });

    public TriceratopsRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TriceratopsModel<>(pContext.bakeLayer(TriceratopsModel.LAYER_LOCATION)), 0.85f);
    }

    @Override
    public ResourceLocation getTextureLocation(TriceratopsRenderState state) {
        return LOCATION_BY_VARIANT.get(state.variant);
    }

    @Override
    public void render(TriceratopsRenderState state, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(state.isBaby) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            pPoseStack.scale(1f, 1f, 1f);
        }

        super.render(state, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public TriceratopsRenderState createRenderState() {
        return new TriceratopsRenderState();
    }

    @Override
    public void extractRenderState(TriceratopsEntity pEntity, TriceratopsRenderState pReusedState, float pPartialTick) {
        super.extractRenderState(pEntity, pReusedState, pPartialTick);
        pReusedState.idleAnimationState.copyFrom(pEntity.idleAnimationState);
        pReusedState.variant = pEntity.getVariant();
    }
}
