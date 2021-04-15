package Rzmor.item;

import Rzmor.ClientProxy;
import Rzmor.Main;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Saitama extends ItemArmor{

	public String armorNamePrefix;
	
	public ItemArmor.ArmorMaterial material;
	
	public Saitama(ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
	}
	
	public ItemArmor.ArmorMaterial getArmorMaterial(ItemStack par1ItemStack) {
		return Main.lv2;
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return "Rzmor:textures/armors/Saitama.png"; 
	}
	
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
		ModelBiped armorModel = (ModelBiped)ClientProxy.armorModels.get(this);
		if (armorModel != null) {
		      armorModel.bipedHead.showModel = (armorSlot == EntityEquipmentSlot.HEAD);
		      armorModel.bipedHeadwear.showModel = false;
		      armorModel.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST || armorSlot == EntityEquipmentSlot.LEGS);
		      armorModel.bipedRightArm.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
		      armorModel.bipedLeftArm.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
		      armorModel.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET);
		      armorModel.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET);
		      armorModel.isSneak = entityLiving.isSneaking();
		      armorModel.isRiding = entityLiving.isRiding();
		      armorModel.isChild = entityLiving.isChild();
		      armorModel.rightArmPose = ModelBiped.ArmPose.EMPTY;
		      ItemStack held_item = entityLiving.getHeldItemMainhand();
		      if (held_item != null) {
		          armorModel.rightArmPose = ModelBiped.ArmPose.ITEM;
		          if (entityLiving.getItemInUseCount() > 0) {
		            EnumAction enumaction = held_item.getItemUseAction();
		            if (enumaction == EnumAction.BOW) {
		              armorModel.rightArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
		            } else if (enumaction == EnumAction.BLOCK) {
		              armorModel.rightArmPose = ModelBiped.ArmPose.BLOCK;
		            } 
		          } 
		        } 
		      } 
		      return armorModel;
		    }
		  }