package net.flybywire.airliner;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

import static net.neoforged.neoforge.internal.versions.neoforge.NeoForgeVersion.MOD_ID;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CreateAirliners.MODID)
public class CreateAirliners {

    public static final String MODID = "airliner";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CreateAirliners(IEventBus modEventBus, ModContainer modContainer) {
        REGISTRATE.defaultCreativeTab((ResourceKey<CreativeModeTab>) null);
        REGISTRATE.registerEventListeners(modEventBus);
        // For later
        CASoundEvents.register();

        CAItems();
        CABlocks();
        CAFluids();
        CAEntityTypes();
        CABlockEntityTypes();
        CAPackets();
        CAConfigs();

        modEventBus.addListener(CASoundEvents::register);
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}