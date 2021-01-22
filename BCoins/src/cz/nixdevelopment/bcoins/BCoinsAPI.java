package cz.nixdevelopment.bcoins;

import java.util.UUID;

public class BCoinsAPI {

    // Return players BCoins by UUID
    public static double GetBCoinsByUUID(UUID uuid) {
        return BCoins.GetPlayers().GetPlayer(uuid).GetBC();
    }

    // Return players BCoins by Nick
    public static double GetBCoinsByNick(String nick) {
        return BCoins.GetPlayers().GetPlayer(nick).GetBC();
    }

    // Set players BCoins by UUID to value
    public static void SetBCoinsByUUID(UUID uuid, double value) {
        BCoins.GetPlayers().GetPlayer(uuid).SetBC(value);
    }

    // Set players BCoins by Nick to value
    public static void SetBCoinsByNick(String nick, double value) {
        BCoins.GetPlayers().GetPlayer(nick).SetBC(value);
    }
    
}
