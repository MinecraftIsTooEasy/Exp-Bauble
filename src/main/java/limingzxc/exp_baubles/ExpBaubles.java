package limingzxc.exp_baubles;

import limingzxc.exp_baubles.event.EventListeners;
import limingzxc.exp_baubles.util.Config;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.xiaoyu233.fml.config.ConfigRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class ExpBaubles implements ModInitializer, PreLaunchEntrypoint {
    public static final String modID  = "exp_baubles";
    public static final String modName = "Exp-Baubles";

    public static final Logger LOGGER = LogManager.getLogger("exp_baubles");

    private transient final ConfigRegistry configRegistry = new ConfigRegistry(Config.baubles, Config.CONFIG_FILE);

    @Override
    public void onInitialize() {
        EventListeners.registerAllEvents();
    }

    @Override
    public void onPreLaunch() {
        System.out.println("[" + modName + "] Early riser registering chat formatting");
    }

    @Override
    public Optional<ConfigRegistry> createConfig() {
        return Optional.ofNullable(configRegistry);
    }
}
