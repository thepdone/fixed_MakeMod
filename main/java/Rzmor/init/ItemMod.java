package Rzmor.init;

import Rzmor.Main;
import Rzmor.item.Saitama;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemMod {
	
	public static Item SaitamaHead = ((Item)(new Saitama(Main.lv2, 4, EntityEquipmentSlot.HEAD)).setUnlocalizedName("saitamahead").setRegistryName("saitamahead")).setCreativeTab(Main.tabHelmets);	
	
	@EventBusSubscriber(modid = "examplemod")
	public static class RegistrationHandler {
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			IForgeRegistry<Item> registry = event.getRegistry();
			registry.register((Item)ItemMod.SaitamaHead);
		}
	}
	
	public static void renders() {
		render(SaitamaHead);
	}
	
	public static void render(Item item){
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation("examplemod", item.getUnlocalizedName().substring(5)), "inventory"));
	}
}