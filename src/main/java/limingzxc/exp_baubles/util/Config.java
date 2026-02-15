package limingzxc.exp_baubles.util;

import net.xiaoyu233.fml.config.ConfigEntry;
import net.xiaoyu233.fml.config.ConfigRoot;
import net.xiaoyu233.fml.util.FieldReference;

import java.io.File;

public class Config {
    public static final File CONFIG_FILE = new File("Exp-Baubles.json");

    // config properties
    public static FieldReference<Integer> COPPER_RING_ID = new FieldReference<>(6668);
    public static FieldReference<Integer> SILVER_AMULET_ID = new FieldReference<>(6669);
    public static FieldReference<Integer> GOLD_BELT_ID = new FieldReference<>(6670);
    public static FieldReference<Integer> DIRT_RING_ID = new FieldReference<>(6671);
    public static FieldReference<Integer> DRAGON_RING_ID = new FieldReference<>(6672);
    public static FieldReference<Integer> CLAY_RING_ID = new FieldReference<>(6673);
    public static FieldReference<Integer> IRON_RING_ID = new FieldReference<>(6674);
    public static FieldReference<Integer> NIGHT_VISION_GOGGLES_ID = new FieldReference<>(6675);
    public static FieldReference<Integer> MITHRIL_AMULET_ID = new FieldReference<>(6676);

    public static final ConfigRoot baubles = ConfigRoot.create(Constant.CONFIG_VERSION)
            .addEntry(ConfigEntry.of("copper_ring", COPPER_RING_ID).withComment("铜戒指的物品ID"))
            .addEntry(ConfigEntry.of("silver_amulet", SILVER_AMULET_ID).withComment("银护身符的物品ID"))
            .addEntry(ConfigEntry.of("gold_belt", GOLD_BELT_ID).withComment("金腰带的物品ID"))
            .addEntry(ConfigEntry.of("dirt_ring", GOLD_BELT_ID).withComment("泥土戒指的物品ID"))
            .addEntry(ConfigEntry.of("dragon_ring", DRAGON_RING_ID).withComment("龙之戒的物品ID"))
            .addEntry(ConfigEntry.of("clay_ring", CLAY_RING_ID).withComment("粘土戒指的物品ID"))
            .addEntry(ConfigEntry.of("iron_ring", CLAY_RING_ID).withComment("铁指环的物品ID"))
            .addEntry(ConfigEntry.of("night_vision_goggle", CLAY_RING_ID).withComment("夜视眼镜的物品ID"))
            .addEntry(ConfigEntry.of("mithril_amulet", CLAY_RING_ID).withComment("秘银项链的物品ID"));
}
