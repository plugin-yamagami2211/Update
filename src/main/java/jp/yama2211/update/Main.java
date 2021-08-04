package jp.yama2211.update;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        if(getConfig().getBoolean("Update")){
            new UpdateChecker(this,"PlayerFly").getVersion(version -> {
                if (!this.getDescription().getVersion().equalsIgnoreCase(version)) {
                    getLogger().warning("利用可能なアップデートがあります。配布フォーラムをご確認ください。\nリンク:https://ym21.ml/amc4e");
                }
            });
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
