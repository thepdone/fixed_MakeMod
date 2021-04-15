	package Rzmor.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemRenderRegister {
	public static void reg(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation("Rzmor:" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void registerItemRenderer() {
		reg(ItemMod.SaitamaHead);
	}
}
