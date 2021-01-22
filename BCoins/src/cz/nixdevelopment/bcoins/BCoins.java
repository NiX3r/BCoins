package cz.nixdevelopment.bcoins;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import cz.nixdevelopment.bcoins.commands.BCoinCommand;
import cz.nixdevelopment.bcoins.commands.BShopCommand;
import cz.nixdevelopment.bcoins.events.*;
import cz.nixdevelopment.bcoins.instances.DatabaseInstance;
import cz.nixdevelopment.bcoins.instances.ListBCoinPlayersInstance;
import cz.nixdevelopment.bcoins.instances.MessagesInstance;
import cz.nixdevelopment.bcoins.listeners.OnJoinListener;
import cz.nixdevelopment.bcoins.listeners.OnLeaveListener;
import cz.nixdevelopment.bcoins.schedulers.CloudSynchronizeScheduler;
import cz.nixdevelopment.bcoins.utils.BCoinsUtil;
import cz.nixdevelopment.bcoins.utils.DefaultFiles;
import cz.nixdevelopment.bcoins.utils.MessagesUtil;
import cz.nixdevelopment.bcoins.utils.MySQL;
import cz.nixdevelopment.bcoins.utils.PAPIManager;

public class BCoins extends JavaPlugin{
    
    private static DatabaseInstance DBS;
    
    private static JavaPlugin inst;
    private static ArrayList<ShopItemEvent> items = new ArrayList<ShopItemEvent>();
    private static ListBCoinPlayersInstance players = new ListBCoinPlayersInstance();
    private static String Prefix;
    private static MessagesInstance Messages;
    private static Boolean UseSQL;
    private static int Sync;
    
    private static Connection connection;
    
    public static JavaPlugin GetInst() {
        return inst;
    }
    public static ArrayList<ShopItemEvent> GetItems(){
        return items;
    }
    public static ListBCoinPlayersInstance GetPlayers() {
        return players;
    }
    public static String GetPrefix() {
        return Prefix;
    }
    public static MessagesInstance GetMessages() {
        return Messages;
    }
    public static Boolean GetUseSQL() {
        return UseSQL;
    }
    public static int GetSync() {
        return Sync;
    }
    
    public void onEnable() {

        // plugin needs PlaceHolderAPI
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PAPIManager().register();
        } else {
            this.getPluginLoader().disablePlugin(this);
        }
        
        new File("plugins/BCoins").mkdir();

        inst = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        DefaultFiles.BShop();
        DefaultFiles.Messages();
        DefaultFiles.Cloud();
        
        ReloadFile();
        
        if(UseSQL)
            setUpDatabase();
        
        this.getCommand("bcoin").setExecutor(new BCoinCommand());
        this.getCommand("bshop").setExecutor(new BShopCommand());
        
        Bukkit.getPluginManager().registerEvents(new OnJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new OnLeaveListener(), this);
        if(UseSQL)
            MySQL.createTable();
        BCoinsUtil.LoadBShop();
        CloudSynchronizeScheduler.Scheduler();
        
    }
    
    public void onDisable() {
        BCoinsUtil.UnloadBShop();
    }
    
    public static void ReloadFile() {

        Messages = new MessagesInstance();
        MessagesUtil.LoadMessages();
        
        FileConfiguration config = YamlConfiguration.loadConfiguration(new File("plugins/BCoins/config.yml"));
        
        UseSQL = config.getBoolean("SQL.Use");
        Sync = config.getInt("SQL.Sync");
        if(UseSQL)
            DBS = new DatabaseInstance(config.getString("SQL.Host"), config.getInt("SQL.Port"), config.getString("SQL.Database"), config.getString("SQL.User"), config.getString("SQL.Pass"));
        Prefix = config.getString("Prefix").replaceAll("&", "§");
        
    }
    
    private void setUpDatabase() {
        
        try {
            
            synchronized(this) {
                
                if(getConnection() != null && !getConnection().isClosed())
                    return;
                
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(DBS.GetConnectionString(), DBS.GetUsername(), DBS.GetPassword());
                System.out.println("[BCoins] MySQL connection is successfully conected");
                
            }
            
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
            this.getPluginLoader().disablePlugin(this);
        }
        catch(ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            this.getPluginLoader().disablePlugin(this);
        }
        
    }
    
    public static Connection getConnection() {
        return connection;
    }
    
}
