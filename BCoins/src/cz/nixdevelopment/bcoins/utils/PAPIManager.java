package cz.nixdevelopment.bcoins.utils;

import org.bukkit.entity.Player;

import cz.nixdevelopment.bcoins.BCoins;
import cz.nixdevelopment.bcoins.instances.BCoinPlayerInstance;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class PAPIManager extends PlaceholderExpansion{

	@Override
    public String getAuthor() {
        return "NiX3r";
    }
 
    @Override
    public String getIdentifier() {
        return "bcoins";
    }
 
    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String getPlugin() {
        // TODO Auto-generated method stub
        return "BCoins";
    }

    @Override
    public String onPlaceholderRequest(Player p, String identifier) {
        
        String output = "ERR#404";
        
        if(identifier.equalsIgnoreCase("bc")){
            return BCoins.GetPlayers().GetPlayer(p.getUniqueId()).GetBC() + "BC";
        }
        else if(identifier.equalsIgnoreCase("nobc")){
            return BCoins.GetPlayers().GetPlayer(p.getUniqueId()).GetBC() + "";
        }
        else
            output = "WrongIdentifier";
        
        return output;
    }
	
}
