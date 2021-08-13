package jp.yama2211.update;

import org.bukkit.plugin.java.JavaPlugin;

import java.nio.charset.StandardCharsets;


public final class Main extends JavaPlugin {

    public static void main(String[] args){}

    @Override
    public void onEnable() {
        // Plugin startup logic
        if(getConfig().getBoolean("Update1")){
            new UpdateChecker(this,"PlayerFly").getVersion(version -> {
                if (!this.getDescription().getVersion().equalsIgnoreCase(version)) {
                    getLogger().warning("利用可能なアップデートがあります。配布フォーラムをご確認ください。\nリンク:https://ym21.ml/amc4e");
                }
            });
        }

        if(getConfig().getBoolean("Update2")){
        UpdateCheck updateCheck = new UpdateCheck("Update");
        String nowVer = getDescription().getVersion();
        String version = updateCheck.getVersion();

        if(version == null){
            getLogger().warning("アップデート情報の取得に失敗しました。");
        } else if(!nowVer.equals(version)){
            getLogger().warning("利用可能なアップデートがあります。");
            getLogger().info("配布フォーラムをご確認ください。リンク:https://ym21.ml/amc4e");
        }

        }

        //デフォConf
        saveDefaultConfig();

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
