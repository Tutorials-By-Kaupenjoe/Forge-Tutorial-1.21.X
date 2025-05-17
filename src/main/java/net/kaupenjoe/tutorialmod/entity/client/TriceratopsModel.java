package net.kaupenjoe.tutorialmod.entity.client;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.entity.custom.TriceratopsEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class TriceratopsModel<T extends TriceratopsEntity> extends EntityModel<TriceratopsRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "triceratops"), "main");
    private final ModelPart body;
    private final ModelPart head;

    public TriceratopsModel(ModelPart root) {
        super(root);
        this.body = root.getChild("body");
        this.head = body.getChild("upper").getChild("neck").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 9.0F, 6.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition lower = body.addOrReplaceChild("lower", CubeListBuilder.create().texOffs(72, 103).addBox(-7.0F, -5.5F, -6.6667F, 14.0F, 11.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(78, 0).addBox(-6.0F, -6.5F, -6.6667F, 12.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(78, 44).addBox(-6.0F, 5.5F, -6.6667F, 12.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -0.3333F));

        PartDefinition rearlegL = lower.addOrReplaceChild("rearlegL", CubeListBuilder.create().texOffs(31, 54).addBox(-1.0F, -3.5F, -4.0F, 3.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -1.0F, 1.3333F, -0.0438F, -0.0872F, 0.0038F));

        PartDefinition upperlegL = rearlegL.addOrReplaceChild("upperlegL", CubeListBuilder.create().texOffs(70, 63).addBox(-1.5F, -0.5F, -3.0F, 3.0F, 9.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.5F, 2.0F, -1.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition lowerlegL = upperlegL.addOrReplaceChild("lowerlegL", CubeListBuilder.create().texOffs(30, 23).addBox(-1.5F, -0.5F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 8.0F, -0.5F, 0.3491F, 0.0F, 0.0F));

        PartDefinition footL = lowerlegL.addOrReplaceChild("footL", CubeListBuilder.create().texOffs(73, 33).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.2F, -0.5F));

        PartDefinition rearlegR = lower.addOrReplaceChild("rearlegR", CubeListBuilder.create().texOffs(46, 62).mirror().addBox(-2.0F, -3.5F, -4.0F, 3.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -1.0F, 1.3333F, -0.0436F, 0.0873F, 0.0F));

        PartDefinition upperlegR = rearlegR.addOrReplaceChild("upperlegR", CubeListBuilder.create().texOffs(89, 63).mirror().addBox(-1.5F, -0.5F, -3.0F, 3.0F, 9.0F, 6.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.0F, -1.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition lowerlegR = upperlegR.addOrReplaceChild("lowerlegR", CubeListBuilder.create().texOffs(14, 54).mirror().addBox(-1.5F, -0.5F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, -0.5F, 0.0873F, 0.0F, 0.0F));

        PartDefinition footR = lowerlegR.addOrReplaceChild("footR", CubeListBuilder.create().texOffs(80, 93).mirror().addBox(-1.5F, 0.7F, -3.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.5F, -0.5F, -0.5236F, 0.0F, 0.0F));

        PartDefinition tail = lower.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 67).addBox(-5.0F, -4.0F, -1.0F, 10.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.3333F, -0.1745F, 0.0F, 0.0F));

        PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(18, 36).addBox(-4.0F, -4.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(100, 71).addBox(-3.0F, -3.5F, -1.0F, 6.0F, 7.0F, 8.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, -0.5F, 7.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(52, 40).addBox(-2.0F, -3.0F, -1.0F, 4.0F, 6.0F, 9.0F, new CubeDeformation(-0.03F)), PartPose.offsetAndRotation(0.0F, -0.5F, 7.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition tail5 = tail4.addOrReplaceChild("tail5", CubeListBuilder.create().texOffs(0, 20).addBox(-2.0F, -2.5F, -1.0F, 4.0F, 5.0F, 9.0F, new CubeDeformation(-0.04F)), PartPose.offsetAndRotation(0.0F, -0.5F, 8.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition upper = body.addOrReplaceChild("upper", CubeListBuilder.create().texOffs(0, 103).addBox(-7.0F, -5.5F, -12.0F, 14.0F, 11.0F, 14.0F, new CubeDeformation(-0.1F))
                .texOffs(80, 30).addBox(-6.0F, -6.3F, -11.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(-0.1F))
                .texOffs(80, 16).addBox(-6.0F, 5.3F, -11.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.5F, -7.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition armL = upper.addOrReplaceChild("armL", CubeListBuilder.create().texOffs(0, 46).addBox(-1.5F, -3.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 1.0F, -8.5F, 0.0F, -0.0873F, 0.0F));

        PartDefinition upperarmL = armL.addOrReplaceChild("upperarmL", CubeListBuilder.create().texOffs(61, 57).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.5F, 0.3491F, 0.0F, 0.0F));

        PartDefinition lowerarmL = upperarmL.addOrReplaceChild("lowerarmL", CubeListBuilder.create().texOffs(115, 107).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 4.5F, -0.5F, -0.6109F, 0.0F, 0.0F));

        PartDefinition handL = lowerarmL.addOrReplaceChild("handL", CubeListBuilder.create().texOffs(47, 82).addBox(-1.5F, 0.0F, -2.5F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.5F, 0.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition armR = upper.addOrReplaceChild("armR", CubeListBuilder.create().texOffs(112, 59).mirror().addBox(-1.5F, -3.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 1.0F, -8.5F, 0.0F, 0.0873F, 0.0F));

        PartDefinition upperarmR = armR.addOrReplaceChild("upperarmR", CubeListBuilder.create().texOffs(0, 89).mirror().addBox(-1.5F, -1.5F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.5F, 0.5F, 0.3491F, 0.0F, 0.0F));

        PartDefinition lowerarmR = upperarmR.addOrReplaceChild("lowerarmR", CubeListBuilder.create().texOffs(86, 81).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offsetAndRotation(0.0F, 4.5F, -0.5F, -0.6109F, 0.0F, 0.0F));

        PartDefinition handR = lowerarmR.addOrReplaceChild("handR", CubeListBuilder.create().texOffs(0, 82).mirror().addBox(-1.5F, 0.0F, -2.5F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.5F, 0.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition neck = upper.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(56, 99).addBox(-4.0F, -4.0F, -4.2F, 8.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -11.8F, 0.1309F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(18, 82).addBox(-5.0F, -5.0475F, -8.0281F, 10.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(100, 87).addBox(-3.0F, -4.0475F, -16.0281F, 6.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(1, 107).addBox(-2.0F, -3.0475F, -17.0281F, 4.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(16, 86).addBox(-1.5F, 3.9525F, -17.0281F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.8525F, -3.1719F, -0.0873F, 0.0F, 0.0F));

        PartDefinition HornL3_r1 = head.addOrReplaceChild("HornL3_r1", CubeListBuilder.create().texOffs(9, 95).mirror().addBox(-0.5F, -0.5F, -5.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.2F, -7.6475F, -8.8281F, -0.3531F, 0.0578F, -0.073F));

        PartDefinition HornL2_r1 = head.addOrReplaceChild("HornL2_r1", CubeListBuilder.create().texOffs(34, 71).mirror().addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-3.5F, -5.8475F, -5.0281F, -0.4437F, 0.1382F, -0.1069F));

        PartDefinition HornL2_r2 = head.addOrReplaceChild("HornL2_r2", CubeListBuilder.create().texOffs(9, 95).addBox(-0.5F, -0.5F, -5.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2F, -7.6475F, -8.8281F, -0.3531F, -0.0578F, 0.073F));

        PartDefinition HornL1_r1 = head.addOrReplaceChild("HornL1_r1", CubeListBuilder.create().texOffs(34, 71).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(3.5F, -5.8475F, -5.0281F, -0.4437F, -0.1382F, 0.1069F));

        PartDefinition snouthorn_r1 = head.addOrReplaceChild("snouthorn_r1", CubeListBuilder.create().texOffs(122, 72).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.8475F, -15.5281F, 0.2618F, 0.0F, 0.0F));

        PartDefinition crest3_r1 = head.addOrReplaceChild("crest3_r1", CubeListBuilder.create().texOffs(58, 113).addBox(-2.5F, -8.0F, -0.5F, 5.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5F, -3.0475F, 0.4719F, -0.1314F, 0.0865F, -0.0114F));

        PartDefinition crest2_r1 = head.addOrReplaceChild("crest2_r1", CubeListBuilder.create().texOffs(43, 101).addBox(-2.5F, -8.0F, -0.5F, 5.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -3.0475F, 0.4719F, -0.1314F, -0.0865F, 0.0114F));

        PartDefinition crestspikeR1_r1 = head.addOrReplaceChild("crestspikeR1_r1", CubeListBuilder.create().texOffs(24, 13).mirror().addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
                .texOffs(24, 13).addBox(2.3F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-1.4F, -14.1432F, 1.7371F, -0.1309F, 0.0F, 0.0F));

        PartDefinition crestspikeR4_r1 = head.addOrReplaceChild("crestspikeR4_r1", CubeListBuilder.create().texOffs(24, 13).mirror().addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-8.4F, -10.2432F, 1.5371F, -0.1314F, 0.0865F, -0.0114F));

        PartDefinition crestspikeR2_r1 = head.addOrReplaceChild("crestspikeR2_r1", CubeListBuilder.create().texOffs(24, 13).mirror().addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
                .texOffs(24, 13).addBox(6.3F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-3.4F, -13.6432F, 1.6371F, -0.1309F, 0.0F, 0.0F));

        PartDefinition crestspikeR3_r1 = head.addOrReplaceChild("crestspikeR3_r1", CubeListBuilder.create().texOffs(24, 13).mirror().addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-6.4F, -10.7432F, 1.3371F, -0.1314F, 0.0865F, -0.0114F));

        PartDefinition crestspikeR5_r1 = head.addOrReplaceChild("crestspikeR5_r1", CubeListBuilder.create().texOffs(24, 13).mirror().addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-9.4F, -9.2432F, 1.4371F, -0.0873F, -0.1309F, -1.5708F));

        PartDefinition crestspikeR6_r1 = head.addOrReplaceChild("crestspikeR6_r1", CubeListBuilder.create().texOffs(24, 13).mirror().addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-9.9F, -7.2432F, 1.2371F, -0.0873F, -0.1309F, -1.5708F));

        PartDefinition crestspikeR7_r1 = head.addOrReplaceChild("crestspikeR7_r1", CubeListBuilder.create().texOffs(24, 13).mirror().addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-10.4F, -5.2432F, 0.9371F, -0.0873F, -0.1309F, -1.5708F));

        PartDefinition crestspikeR8_r1 = head.addOrReplaceChild("crestspikeR8_r1", CubeListBuilder.create().texOffs(24, 13).mirror().addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-10.4F, -3.2432F, 0.7371F, -0.0873F, -0.1309F, -1.5708F));

        PartDefinition crestspikeR9_r1 = head.addOrReplaceChild("crestspikeR9_r1", CubeListBuilder.create().texOffs(24, 13).mirror().addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-9.9F, -0.9432F, 0.3371F, -0.0873F, -0.1309F, -1.5708F));

        PartDefinition crestspikeR10_r1 = head.addOrReplaceChild("crestspikeR10_r1", CubeListBuilder.create().texOffs(24, 13).mirror().addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-9.4F, 1.2568F, 0.0371F, -0.0873F, -0.1309F, -1.5708F));

        PartDefinition crestspikeR12_r1 = head.addOrReplaceChild("crestspikeR12_r1", CubeListBuilder.create().texOffs(24, 13).mirror().addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-6.4F, 2.2568F, -0.3629F, -0.1314F, 0.0865F, -0.0114F));

        PartDefinition crestspikeR11_r1 = head.addOrReplaceChild("crestspikeR11_r1", CubeListBuilder.create().texOffs(24, 13).mirror().addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-8.4F, 2.2568F, -0.1629F, -0.1314F, 0.0865F, -0.0114F));

        PartDefinition crestspikeL12_r1 = head.addOrReplaceChild("crestspikeL12_r1", CubeListBuilder.create().texOffs(24, 13).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(6.4F, 2.2568F, -0.3629F, -0.1314F, -0.0865F, 0.0114F));

        PartDefinition crestspikeL11_r1 = head.addOrReplaceChild("crestspikeL11_r1", CubeListBuilder.create().texOffs(24, 13).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(8.4F, 2.2568F, -0.1629F, -0.1314F, -0.0865F, 0.0114F));

        PartDefinition crestspikeL10_r1 = head.addOrReplaceChild("crestspikeL10_r1", CubeListBuilder.create().texOffs(24, 13).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(9.4F, 1.2568F, 0.0371F, -0.0873F, 0.1309F, 1.5708F));

        PartDefinition crestspikeL9_r1 = head.addOrReplaceChild("crestspikeL9_r1", CubeListBuilder.create().texOffs(24, 13).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(9.9F, -0.9432F, 0.3371F, -0.0873F, 0.1309F, 1.5708F));

        PartDefinition crestspikeL8_r1 = head.addOrReplaceChild("crestspikeL8_r1", CubeListBuilder.create().texOffs(24, 13).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(10.4F, -3.2432F, 0.7371F, -0.0873F, 0.1309F, 1.5708F));

        PartDefinition crestspikeL7_r1 = head.addOrReplaceChild("crestspikeL7_r1", CubeListBuilder.create().texOffs(24, 13).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(10.4F, -5.2432F, 0.9371F, -0.0873F, 0.1309F, 1.5708F));

        PartDefinition crestspikeL6_r1 = head.addOrReplaceChild("crestspikeL6_r1", CubeListBuilder.create().texOffs(24, 13).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(9.9F, -7.2432F, 1.2371F, -0.0873F, 0.1309F, 1.5708F));

        PartDefinition crestspikeL5_r1 = head.addOrReplaceChild("crestspikeL5_r1", CubeListBuilder.create().texOffs(24, 13).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(9.4F, -9.2432F, 1.4371F, -0.0873F, 0.1309F, 1.5708F));

        PartDefinition crestspikeL4_r1 = head.addOrReplaceChild("crestspikeL4_r1", CubeListBuilder.create().texOffs(24, 13).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(8.4F, -10.2432F, 1.5371F, -0.1314F, -0.0865F, 0.0114F));

        PartDefinition crestspikeL3_r1 = head.addOrReplaceChild("crestspikeL3_r1", CubeListBuilder.create().texOffs(24, 13).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(6.4F, -10.7432F, 1.3371F, -0.1314F, -0.0865F, 0.0114F));

        PartDefinition crest1_r1 = head.addOrReplaceChild("crest1_r1", CubeListBuilder.create().texOffs(62, 79).addBox(-5.0F, -10.0F, -0.5F, 10.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0475F, 0.3719F, -0.1309F, 0.0F, 0.0F));

        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(59, 19).addBox(-2.0F, -0.1F, -8.0F, 4.0F, 2.0F, 11.0F, new CubeDeformation(-0.1F))
                .texOffs(2, 60).addBox(-1.5F, -1.2F, -8.2F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F))
                .texOffs(121, 92).addBox(-1.0F, -2.0F, -8.2F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 2.9525F, -8.0281F, 0.0873F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(TriceratopsRenderState state) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(state.yRot, state.xRot);

        this.animateWalk(TriceratopsAnimations.ANIM_TRICERATOPS_WALKING, state.walkAnimationPos, state.walkAnimationSpeed, 2f, 2.5f);
        this.animate(state.idleAnimationState, TriceratopsAnimations.ANIM_TRICERATOPS_IDLE, state.ageInTicks, 1f);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }
}
