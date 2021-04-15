package Rzmor;

import Rzmor.init.ItemMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod(modid = "examplemod", name = "Example Mod", version = "1.0")
public class Main {

	@Instance("examplemod")
	public static Main ins;
	
	@SidedProxy(serverSide = "Rzmor.CommonProxy", clientSide = "Rzmor.ClientProxy")
	public static CommonProxy proxy;
	
	public static ItemArmor.ArmorMaterial lv1 = EnumHelper.addArmorMaterial("lv1", "saitama", 50, new int[] { 9, 9, 9, 9 }, 500, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1);
	public static ItemArmor.ArmorMaterial lv2 = EnumHelper.addArmorMaterial("lv2", "saitama", 75, new int[] { 11, 11, 11, 11 }, 500, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		//proxy.registerRenderers();
	}
	
	public static CreativeTabs tabHelmets = new CreativeTabs("tabHelmets") {
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemMod.SaitamaHead);
		}
	};
	
	@Mod.EventBusSubscriber
	public static class RegsitrationHandler {
		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) {
			proxy.registerRenders();
		}
	}
}