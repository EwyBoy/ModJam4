// Date: 18.05.2014 13:40:18
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.modjam.terrifictransportation.Models;

public class ModelCoveyor extends ModelBase
{
  //fields
    ModelRenderer Main;
    ModelRenderer SideSlice1;
    ModelRenderer SideSlice2;
  
  public ModelCoveyor()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Main = new ModelRenderer(this, 0, 0);
      Main.addBox(0F, -1F, -8F, 16, 2, 16);
      Main.setRotationPoint(-8F, 23F, 0F);
      Main.setTextureSize(64, 64);
      Main.mirror = true;
      setRotation(Main, 0F, 0F, 0F);
      SideSlice1 = new ModelRenderer(this, 0, 23);
      SideSlice1.addBox(-8F, 0F, -1F, 16, 1, 2);
      SideSlice1.setRotationPoint(0F, 21F, -7F);
      SideSlice1.setTextureSize(64, 64);
      SideSlice1.mirror = true;
      setRotation(SideSlice1, 0F, 0F, 0F);
      SideSlice2 = new ModelRenderer(this, 0, 19);
      SideSlice2.addBox(-8F, 0F, -1F, 16, 1, 2);
      SideSlice2.setRotationPoint(0F, 21F, 7F);
      SideSlice2.setTextureSize(64, 64);
      SideSlice2.mirror = true;
      setRotation(SideSlice2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Main.render(f5);
    SideSlice1.render(f5);
    SideSlice2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}
