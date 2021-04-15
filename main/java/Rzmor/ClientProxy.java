package Rzmor;

import java.util.HashMap;
import java.util.Map;

import Rzmor.Model.SaitamaModel;
import Rzmor.init.ItemMod;
import Rzmor.init.ItemRenderRegister;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy{
	
	public static final Map<Item, ModelBiped> armorModels = new HashMap<>();
	
	@Override
	public void registerRenderers() {
		ItemRenderRegister.registerItemRenderer();
		SaitamaModel clotharmor = new SaitamaModel(1.0f);
		armorModels.put(ItemMod.SaitamaHead, clotharmor);
	}
	
	@Override
	public void registerRenders() {
		ItemMod.renders();
	}
}
