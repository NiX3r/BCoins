package cz.nixdevelopment.bcoins.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import cz.nixdevelopment.bcoins.BCoins;

public class MessagesUtil {
    
    public static void LoadMessages() {
        
        System.out.println("[BCoins] Loading messages from messages.yml ...");
        
        File msg = new File("plugins/BCoins/messages.yml");
        FileConfiguration msgfc = YamlConfiguration.loadConfiguration(msg);
        FileConfiguration config = YamlConfiguration.loadConfiguration(new File("plugins/BCoins/config.yml"));
        
        BCoins.GetMessages().setBCoinUsageAdmin(config.getString("Menus.BCoinUsage.Admin"));
        BCoins.GetMessages().setBCoinUsageNonAdmin(config.getString("Menus.BCoinUsage.NonAdmin"));
        BCoins.GetMessages().setBShopUsageAdmin(config.getString("Menus.BShopUsage.Admin"));
        BCoins.GetMessages().setBShopUsageNonAdmin(config.getString("Menus.BShopUsage.NonAdmin"));
        BCoins.GetMessages().setListBShop(config.getString("Menus.Lists.BShop"));
        BCoins.GetMessages().setListItemCommands(config.getString("Menus.Lists.ItemCommands"));
        BCoins.GetMessages().setListItemCommandsNotSet(config.getString("Menus.Lists.ItemCommandsNotSet"));
        
        BCoins.GetMessages().setUnknownCommandBCoin(msgfc.getString("UnknownCommandBCoin"));
        BCoins.GetMessages().setUnknownCommandBShop(msgfc.getString("UnknownCommandBShop"));
        BCoins.GetMessages().setReload(msgfc.getString("Reload"));
        BCoins.GetMessages().setItemNotExists(msgfc.getString("ItemNotExists"));
        BCoins.GetMessages().setItemExists(msgfc.getString("ItemExists"));
        BCoins.GetMessages().setCreateItem(msgfc.getString("CreateItem"));
        BCoins.GetMessages().setRemoveItem(msgfc.getString("RemoveItem"));
        BCoins.GetMessages().setHaveNotPerm(msgfc.getString("HaveNotPerm"));
        BCoins.GetMessages().setTooPoor(msgfc.getString("TooPoor"));
        BCoins.GetMessages().setTargetOffline(msgfc.getString("TargetOffline"));
        BCoins.GetMessages().setUncorrectBCoinFormat(msgfc.getString("UncorrectBCoinFormat"));
        BCoins.GetMessages().setAddCommand(msgfc.getString("AddCommand"));
        BCoins.GetMessages().setRemoveCommand(msgfc.getString("RemoveCommand"));
        BCoins.GetMessages().setPlayerWallet(msgfc.getString("PlayerWallet"));
        BCoins.GetMessages().setPlayerBuySelf(msgfc.getString("PlayerBuySelf"));
        BCoins.GetMessages().setPlayerBuyPlayer(msgfc.getString("PlayerBuyPlayer"));
        BCoins.GetMessages().setPlayerBuyYou(msgfc.getString("PlayerBuyYou"));
        BCoins.GetMessages().setAdminGiveYou(msgfc.getString("AdminGiveYou"));
        BCoins.GetMessages().setYouGivePlayer(msgfc.getString("YouGivePlayer"));
        BCoins.GetMessages().setYouSetPlayer(msgfc.getString("YouSetPlayer"));
        BCoins.GetMessages().setAdminSetYou(msgfc.getString("AdminSetYou"));
        BCoins.GetMessages().setYouAddPlayer(msgfc.getString("YouAddPlayer"));
        BCoins.GetMessages().setAdminAddYou(msgfc.getString("AdminAddYou"));
        BCoins.GetMessages().setYouRemovePlayer(msgfc.getString("YouRemovePlayer"));
        BCoins.GetMessages().setAdminRemoveYou(msgfc.getString("AdminRemoveYou"));
        BCoins.GetMessages().setSendYourself(msgfc.getString("SendYourself"));
        BCoins.GetMessages().setYouSendPlayer(msgfc.getString("YouSendPlayer"));
        BCoins.GetMessages().setPlayerSendYou(msgfc.getString("PlayerSendYou"));
        
        System.out.println("[BCoins] Messages loaded!");
    }
    
}
