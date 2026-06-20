// ═══════════════════════════════════════════
// THE FOG MOD — FogMod.java (главный класс)
// Fabric Loader 0.15.x | MC 1.20.1
// ═══════════════════════════════════════════

package com.fogmod;

import com.fogmod.config.FogConfig;
import com.fogmod.handler.FogTickHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FogMod implements ModInitializer {

    public static final String MODID = "fog_mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public void onInitialize() {
        // Загружаем конфиг из fog_mod.json
        FogConfig.load();

        // Регистрируем серверный тик-колбэк
        ServerTickEvents.END_SERVER_TICK.register(new FogTickHandler());

        LOGGER.info("[TheFog] Мод загружен. Туман придёт на день: {}",
            FogConfig.FOG_START_DAY);
    }
}
