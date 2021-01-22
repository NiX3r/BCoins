package cz.nixdevelopment.bcoins.instances;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import cz.nixdevelopment.bcoins.BCoins;
import cz.nixdevelopment.bcoins.utils.MySQL;

public class ListBCoinPlayersInstance {

    private ArrayList<BCoinPlayerInstance> players;
    
    public ListBCoinPlayersInstance() {
        this.players = new ArrayList<BCoinPlayerInstance>();
    }
    
    public void cloudSync() {
        
        if(BCoins.GetUseSQL()) {
            for(BCoinPlayerInstance p : players) {
                
                MySQL.setTokens(p.GetUUID().toString(), p.GetBC());
                
            }
        }
        else {
            File cloud = new File("plugins/BCoins/cloud.yml");
            FileConfiguration cloudfc = YamlConfiguration.loadConfiguration(cloud);
            for(BCoinPlayerInstance p : players) {
                
                cloudfc.set("List." + p.GetUUID().toString() + ".Wallet", p.GetBC());
                
            }
            try {
                cloudfc.save(cloud);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
    public void checkPlayerCloudExists(String uuid, String nick) {
        if(BCoins.GetUseSQL()) {
            MySQL.checkPlayerExists(uuid, nick);
        }
        else {
            File cloud = new File("plugins/BCoins/cloud.yml");
            FileConfiguration cloudfc = YamlConfiguration.loadConfiguration(cloud);
            
            if(cloudfc.getString("List." + uuid + ".Nick") == null || cloudfc.getString("List." + uuid + ".Nick") == "") {
                cloudfc.set("List." + uuid + ".Nick", nick);
                cloudfc.set("List." + uuid + ".Wallet", 0.0);
                try {
                    cloudfc.save(cloud);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
        }
    }
    
    public void add(UUID uuid, String nick) {
        if(BCoins.GetUseSQL()) {
            players.add(new BCoinPlayerInstance(uuid, nick, MySQL.getTokens(uuid.toString())));
        }
        else {
            File cloud = new File("plugins/BCoins/cloud.yml");
            FileConfiguration cloudfc = YamlConfiguration.loadConfiguration(cloud);
            players.add(new BCoinPlayerInstance(uuid, nick, cloudfc.getDouble("List." + uuid.toString() + ".Wallet")));
            Bukkit.broadcastMessage("adding player");
        }
    }
    
    public void remove(UUID uuid) {
        
        if(players.size() == 1) {
            if(BCoins.GetUseSQL()) {
                MySQL.setTokens(players.get(0).GetUUID().toString(), players.get(0).GetBC());
            }
            else {
                File cloud = new File("plugins/BCoins/cloud.yml");
                FileConfiguration cloudfc = YamlConfiguration.loadConfiguration(cloud);
                cloudfc.set("List." + players.get(0).GetUUID().toString() + ".Wallet", players.get(0).GetBC());
                try {
                    cloudfc.save(cloud);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            players.clear();
            return;
        }
        
        BCoinPlayerInstance toRemove = GetPlayer(uuid);
        if(BCoins.GetUseSQL()) {
            MySQL.setTokens(toRemove.GetUUID().toString(), toRemove.GetBC());
        }
        else {
            File cloud = new File("plugins/BCoins/cloud.yml");
            FileConfiguration cloudfc = YamlConfiguration.loadConfiguration(cloud);
            cloudfc.set("List." + toRemove.GetUUID().toString() + ".Wallet", toRemove.GetBC());
            try {
                cloudfc.save(cloud);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        players.remove(toRemove);
        
    }
    
    public BCoinPlayerInstance GetPlayer(UUID uuid) {
        if(players.size() > 0) {
            for(BCoinPlayerInstance bpi : players) {
                if(bpi.GetUUID().equals(uuid)) {
                    return bpi;
                }
            }
        }
        return null;
    }
    
    public BCoinPlayerInstance GetPlayer(String nick) {
        if(players.size() > 0) {
            for(BCoinPlayerInstance bpi : players) {
                if(bpi.GetNick().equals(nick)) {
                    return bpi;
                }
            }
        }
        return null;
    }
    
}
