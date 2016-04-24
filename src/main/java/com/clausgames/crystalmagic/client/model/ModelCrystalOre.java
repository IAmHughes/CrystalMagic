package com.clausgames.crystalmagic.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Crystal.tcn - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
public class ModelCrystalOre extends ModelBase
{
    public ModelRenderer Box1;
    public ModelRenderer Box3;
    public ModelRenderer Box4;
    public ModelRenderer Box5;
    public ModelRenderer Box6;
    public ModelRenderer Box7;
    public ModelRenderer Box8;
    public ModelRenderer Box9;
    public ModelRenderer Box10;
    public ModelRenderer Box11;
    public ModelRenderer Box12;
    public ModelRenderer Box13;
    public ModelRenderer Box14;

    public ModelCrystalOre()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Box10 = new ModelRenderer(this, 1, 49);
        this.Box10.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Box10.addBox(-1.5F, -12.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(Box10, -0.08726646259971647F, 0.0F, -0.5759586531581287F);
        this.Box6 = new ModelRenderer(this, 1, 33);
        this.Box6.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Box6.addBox(-2.0F, -10.0F, -2.0F, 4, 9, 4, 0.0F);
        this.setRotateAngle(Box6, 0.7330382858376184F, 0.2792526803190927F, 0.5410520681182421F);
        this.Box13 = new ModelRenderer(this, 1, 25);
        this.Box13.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Box13.addBox(-1.5F, -6.0F, -1.5F, 3, 2, 3, 0.0F);
        this.setRotateAngle(Box13, -0.5918411493512771F, -0.31869712141416456F, -0.40980330836826856F);
        this.Box7 = new ModelRenderer(this, 49, 1);
        this.Box7.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Box7.addBox(-1.5F, -12.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(Box7, 0.19198621771937624F, 0.0F, 0.5061454830783556F);
        this.Box14 = new ModelRenderer(this, 25, 33);
        this.Box14.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Box14.addBox(-1.5F, -9.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(Box14, 0.9075712110370513F, 0.2792526803190927F, 0.22689280275926282F);
        this.Box9 = new ModelRenderer(this, 41, 33);
        this.Box9.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Box9.addBox(-1.5F, -11.0F, -1.5F, 3, 6, 3, 0.0F);
        this.setRotateAngle(Box9, -0.8726646259971648F, 0.13962634015954636F, -0.13962634015954636F);
        this.Box1 = new ModelRenderer(this, 1, 1);
        this.Box1.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Box1.addBox(-2.0F, -13.0F, -2.0F, 4, 13, 4, 0.0F);
        this.setRotateAngle(Box1, 0.0F, 0.20943951023931953F, 0.0F);
        this.Box8 = new ModelRenderer(this, 25, 33);
        this.Box8.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Box8.addBox(-1.5F, -12.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(Box8, 0.7330382858376184F, 0.2792526803190927F, 0.5410520681182421F);
        this.Box11 = new ModelRenderer(this, 1, 25);
        this.Box11.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Box11.addBox(-1.5F, -15.0F, -1.5F, 3, 2, 3, 0.0F);
        this.Box12 = new ModelRenderer(this, 25, 1);
        this.Box12.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Box12.addBox(-2.0F, -10.0F, -2.0F, 3, 9, 4, 0.0F);
        this.setRotateAngle(Box12, -0.593411945678072F, -0.5410520681182421F, 0.9599310885968813F);
        this.Box3 = new ModelRenderer(this, 25, 1);
        this.Box3.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Box3.addBox(-2.0F, -10.0F, -2.0F, 4, 9, 4, 0.0F);
        this.setRotateAngle(Box3, 0.17453292519943295F, -0.0F, 0.6108652381980153F);
        this.Box4 = new ModelRenderer(this, 17, 17);
        this.Box4.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Box4.addBox(-2.0F, -10.0F, -2.0F, 4, 9, 4, 0.0F);
        this.setRotateAngle(Box4, 0.0F, -0.0F, -0.6108652381980153F);
        this.Box5 = new ModelRenderer(this, 41, 17);
        this.Box5.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Box5.addBox(-2.0F, -10.0F, -2.0F, 4, 9, 4, 0.0F);
        this.setRotateAngle(Box5, -0.8726646259971648F, 0.13962634015954636F, -0.13962634015954636F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.Box10.render(f5);
        this.Box6.render(f5);
        this.Box13.render(f5);
        this.Box7.render(f5);
        this.Box14.render(f5);
        this.Box9.render(f5);
        this.Box1.render(f5);
        this.Box8.render(f5);
        this.Box11.render(f5);
        this.Box12.render(f5);
        this.Box3.render(f5);
        this.Box4.render(f5);
        this.Box5.render(f5);
    }

    public void renderModel(float f)
    {
        this.Box10.render(f);
        this.Box6.render(f);
        this.Box13.render(f);
        this.Box7.render(f);
        this.Box14.render(f);
        this.Box9.render(f);
        this.Box1.render(f);
        this.Box8.render(f);
        this.Box11.render(f);
        this.Box12.render(f);
        this.Box3.render(f);
        this.Box4.render(f);
        this.Box5.render(f);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}