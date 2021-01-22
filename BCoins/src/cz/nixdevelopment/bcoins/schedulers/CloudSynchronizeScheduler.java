package cz.nixdevelopment.bcoins.schedulers;

import org.bukkit.Bukkit;

import cz.nixdevelopment.bcoins.BCoins;

public class CloudSynchronizeScheduler {

    public static void Scheduler() {
        
        Bukkit.getScheduler().scheduleSyncRepeatingTask(BCoins.GetInst(), new Runnable() {

            @Override
            public void run() {
                
                BCoins.GetPlayers().cloudSync();
                
            }
        
        },1L, 20L * 300);
        
    }
    
}
