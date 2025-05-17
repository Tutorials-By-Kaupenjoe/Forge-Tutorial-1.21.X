package net.kaupenjoe.tutorialmod.entity.client;

import net.kaupenjoe.tutorialmod.entity.TriceratopsVariant;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class TriceratopsRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public TriceratopsVariant variant;
}
