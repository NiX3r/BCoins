package cz.nixdevelopment.bcoins.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import cz.nixdevelopment.bcoins.BCoins;

public class DefaultFiles {

    public static void BShop() {
        
        File msg = new File("plugins/BCoins/bshop.yml");
        if (!msg.exists()) {
          
            try {
              
                msg.createNewFile();
              
            } catch (IOException ex) {
              
                System.out.println("ERROR: Failed to create bshop.yml file!");
                ex.printStackTrace();
              
            }
          
            FileConfiguration msgfc = YamlConfiguration.loadConfiguration(msg);
            
            ArrayList<String> commands = new ArrayList<String>();
            
            commands.add("tellraw @a NiX3r is da best!");
            commands.add("fly %NICK%");
            
            msgfc.set("BShop.Test.Commands", commands);
            msgfc.set("BShop.Test.Cost", 30.0);
            
            try {
                msgfc.save(msg);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
    public static void Cloud() {
        
        File msg = new File("plugins/BCoins/cloud.yml");
        if (!msg.exists()) {
          
            try {
              
                msg.createNewFile();
              
            } catch (IOException ex) {
              
                System.out.println("ERROR: Failed to create cloud.yml file!");
                ex.printStackTrace();
              
            }
          
            FileConfiguration msgfc = YamlConfiguration.loadConfiguration(msg);
            
            try {
                msgfc.save(msg);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
    public static void Messages() {
        
        File msg = new File("plugins/BCoins/messages.yml");
        if (!msg.exists()) {
          
            try {
              
                msg.createNewFile();
              
            } catch (IOException ex) {
              
                System.out.println("ERROR: Failed to create yml file!");
                ex.printStackTrace();
              
            }
          
            FileConfiguration msgfc = YamlConfiguration.loadConfiguration(msg);
            
            msgfc.set("UnknownCommandBCoin", "Unknown command! Please type: &c/bcoin");
            msgfc.set("UnknownCommandBShop", "Unknown command! Please type: &c/bshop");
            msgfc.set("Reload", "You successfully reloaded config and messages!");
            msgfc.set("ItemNotExists", "Item does not exist! Type: &c/bshop list");
            msgfc.set("ItemExists", "Item already exist! Type: &c/bshop list");
            msgfc.set("RemoveItem", "You have successfully removed item &4%ITEM%");
            msgfc.set("CreateItem", "You have successfully created item &4%ITEM%");
            msgfc.set("HaveNotPerm", "Unfortunately you do not have the following permission: &4%PERM%");
            msgfc.set("TooPoor", "Unfortunately you do not have enough BCoins to buy this");
            msgfc.set("TargetOffline", "Target is currently offline!");
            msgfc.set("UncorrectBCoinFormat", "You have to type the amount of BCoins");
            msgfc.set("AddCommand", "You have successfully added command into &4%ITEM%\n%CMD%");
            msgfc.set("RemoveCommand", "You have successfully removed command from &4%ITEM%\n%CMD%");
            msgfc.set("PlayerWallet", "&4%NICK%&7s wallet: &4%BCOIN% &7BCoins");
            msgfc.set("PlayerBuySelf", "You have bought item &4%ITEM%&7. You now have &4%WALLET% &7BCoins");
            msgfc.set("PlayerBuyPlayer", "You have bought item &4%ITEM%&7 to %NICK%. You now have &4%WALLET% &7BCoins");
            msgfc.set("PlayerBuyYou", "Player &4%NICK% &7bought you item &4%ITEM%");
            msgfc.set("AdminGiveYou", "Admin &4%NICK% &7gave you item &4%ITEM%");
            msgfc.set("YouGivePlayer", "You gave &4%NICK% &7item &4%ITEM%");
            msgfc.set("YouSetPlayer", "You set &4%NICK% &7BCoins to &4%BCOIN% &7BCoins");
            msgfc.set("AdminSetYou", "Admin &4%NICK% &7set your BCoins to &4%BCOIN% &7BCoins");
            msgfc.set("YouAddPlayer", "You added &4%NICK% &4%BCOIN% &7BCoins. &4%NICK%&7s balance: &4%WALLET% &7BCoins");
            msgfc.set("AdminAddYou", "Admin &4%NICK% &7added you &4%BCOIN% &7BCoins. You now have &4%WALLET% &7BCoins");
            msgfc.set("YouRemovePlayer", "You removed &4%NICK% &4%BCOIN%&7 BCoins. &4%NICK%&7s balance: &4%WALLET% &7BCoins");
            msgfc.set("AdminRemoveYou", "Admin &4%NICK% &7removed you &4%BCOIN% &7BCoins. You now have &4%WALLET% &7BCoins");
            msgfc.set("SendYourself", "You cannot send yourself BCoins!");
            msgfc.set("YouSendPlayer", "You have sent &4%NICK% %BCOIN% &7BCoins. You now have &4%WALLET% &7BCoins");
            msgfc.set("PlayerSendYou", "Player &4%NICK% &7has sent you &4%BCOIN% &7BCoins. You now have &4%WALLET% &7BCoins");
            
            try {
                msgfc.save(msg);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
}
