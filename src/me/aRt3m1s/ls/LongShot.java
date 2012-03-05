package me.aRt3m1s.ls;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Christian
 * Date: 9/16/11
 * Time: 7:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class LongShot extends JavaPlugin{
    private static final Logger log = Logger.getLogger("Minecraft");
    private final lsEL el = new lsEL(this);
    FileConfiguration config;
    /**
     * Called when this plugin is disabled
     */
    @Override
    public void onDisable() {
        log.info(getDescription().getName()+" version v"+getDescription().getVersion()+" is Disabled!");
    }

    /**
     * Called when this plugin is enabled
     */
    @Override
    public void onEnable() {
        getConfig().setHeader("###########################################################",
                         "# @critical-hits                                          #",
                         "#   @double: true                                         #",
                         "#     the damage will be doubled                          #",
                         "#   @double: false                                        #",
                         "#     random number will be added to the damage           #",
                         "#   @random-range                                         #",
                         "#     if double is false, random number from 0 to range   #",
                         "#      will be added to the damage                        #",
                         "# @distance/BLOCKS-damagePlus:                            #",
                         "#   if 0, critical hits will be enabled                   #",
                         "#   if >0, will divide the distance by this number and    #",
                         "#    add it to the damage                                 #",
                         "###########################################################");
        getConfig().getBoolean("LongShot.critical-hits.double", true);
        getConfig().getInt("LongShot.critical-hits.random-range", 6);
        getConfig().getInt("LongShot.distance/BLOCKS-damagePlus", 10);
        saveConfig();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(el, this);
        log.info(getDescription().getName()+" version v"+getDescription().getVersion()+" is Enabled!");
    }
}
