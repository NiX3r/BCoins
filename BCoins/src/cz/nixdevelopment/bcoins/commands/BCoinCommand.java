package cz.nixdevelopment.bcoins.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cz.nixdevelopment.bcoins.BCoins;
import cz.nixdevelopment.bcoins.utils.BCoinsUtil;

public class BCoinCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        // commands: /bcoin check
        if(args.length == 1) {
            
            if(args[0].equalsIgnoreCase("check")) {
                double bc = BCoins.GetPlayers().GetPlayer(sender.getName()).GetBC();
                sender.sendMessage(BCoins.GetMessages().PlayerWallet().replace("%BCOIN%", String.valueOf(bc)).replace("%NICK%", sender.getName()).replaceAll("&", "§"));
            }
            else if(args[0].equalsIgnoreCase("reload")) {
                
                if(sender.hasPermission("bcoins.admin")) {
                    
                    BCoins.ReloadFile();
                    sender.sendMessage(BCoins.GetMessages().Reload());
                    
                }
                else {
                    sender.sendMessage(BCoins.GetMessages().HaveNotPerm().replace("%PERM%", "bcoins.admin").replaceAll("&", "§"));
                }
                
            }
            else {
                sender.sendMessage(BCoins.GetMessages().UnknownCommandBCoin());
            }
            
        }
        
        // commands: /bcoin check <nick>
        else if(args.length == 2) {
            
            if(args[0].equalsIgnoreCase("check")) {
                
                if(Bukkit.getPlayer(args[1]) != null) {
                    double bc = BCoins.GetPlayers().GetPlayer(args[1]).GetBC();
                    sender.sendMessage(BCoins.GetMessages().PlayerWallet().replace("%BCOIN%", String.valueOf(bc)).replace("%NICK%", args[1]).replaceAll("&", "§"));
                }
                else {
                    sender.sendMessage(BCoins.GetMessages().TargetOffline());
                }
                
            }
            else {
                sender.sendMessage(BCoins.GetMessages().UnknownCommandBCoin());
            }
            
        }
        
        // commands: /bcoin [send | add | remove | set] <nick> <value>
        else if(args.length == 3) {
            
            if(args[0].equalsIgnoreCase("send")) {
                
                if(!args[1].equals(sender.getName())) {
                    
                }
                else {
                    
                }
                
                if(Bukkit.getPlayer(args[1]) != null) {
                    
                    Player pTaker = Bukkit.getPlayer(args[1]);
                    Player pSender = Bukkit.getPlayer(sender.getName());
                    
                    if(BCoinsUtil.IsDouble(args[2])) {

                        double bcFrom = BCoins.GetPlayers().GetPlayer(pSender.getUniqueId()).GetBC();
                        double bcTo = BCoins.GetPlayers().GetPlayer(pTaker.getUniqueId()).GetBC();
                        double bcSend = Double.parseDouble(args[2]);
                        
                        if(bcSend <= bcFrom) {
                            
                            bcFrom -= bcSend;
                            bcTo += bcSend;
                            
                            BCoins.GetPlayers().GetPlayer(pSender.getUniqueId()).SetBC(bcFrom);
                            BCoins.GetPlayers().GetPlayer(pTaker.getUniqueId()).SetBC(bcTo);
                            
                            sender.sendMessage(BCoins.GetMessages().YouSendPlayer().replace("%NICK%", args[1]).replace("%BCOIN%", String.valueOf(bcSend)).replace("%WALLET%", String.valueOf(bcFrom)).replaceAll("&", "§"));
                            pTaker.sendMessage(BCoins.GetMessages().PlayerSendYou().replace("%NICK%", sender.getName()).replace("%BCOIN%", String.valueOf(bcSend)).replace("%WALLET%", String.valueOf(bcTo)).replaceAll("&", "§"));
                            
                            pTaker.playSound(pTaker.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 20, 20);
                            
                        }
                        else {
                            sender.sendMessage(BCoins.GetMessages().TooPoor().replaceAll("&", "§"));
                        }
                        
                    }
                    else {
                        sender.sendMessage(BCoins.GetMessages().UncorrectBCoinFormat().replaceAll("&", "§"));
                    }
                    
                }
                else {
                    sender.sendMessage(BCoins.GetMessages().TargetOffline().replaceAll("&", "§"));
                }
                
            }
            else if(args[0].equalsIgnoreCase("add")) {
                
                if(sender.hasPermission("bcoins.admin")) {
                    
                    if(Bukkit.getPlayer(args[1]) != null) {
                        
                        Player pTaker = Bukkit.getPlayer(args[1]);
                        Player pSender = Bukkit.getPlayer(sender.getName());
                        
                        if(BCoinsUtil.IsDouble(args[2])) {

                            double bcFrom = BCoins.GetPlayers().GetPlayer(pTaker.getUniqueId()).GetBC();
                            double bcAdd = Double.parseDouble(args[2]);
                            
                            bcFrom += bcAdd;

                            BCoins.GetPlayers().GetPlayer(pTaker.getUniqueId()).SetBC(bcFrom);
                            
                            sender.sendMessage(BCoins.GetMessages().YouAddPlayer().replaceAll("%NICK%", args[1]).replace("%BCOIN%", String.valueOf(bcAdd)).replaceAll("%WALLET", String.valueOf(bcFrom)).replaceAll("&", "§"));
                            pTaker.sendMessage(BCoins.GetMessages().AdminAddYou().replaceAll("%NICK%", sender.getName()).replace("%BCOIN%", String.valueOf(bcAdd)).replaceAll("%WALLET", String.valueOf(bcFrom)).replaceAll("&", "§"));

                            pTaker.playSound(pTaker.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 20, 20);
                        }
                        else {
                            sender.sendMessage(BCoins.GetMessages().UncorrectBCoinFormat().replaceAll("&", "§"));
                        }
                        
                    }
                    else {
                        sender.sendMessage(BCoins.GetMessages().TargetOffline().replaceAll("&", "§"));
                    }
                    
                }
                else {
                    sender.sendMessage(BCoins.GetMessages().HaveNotPerm().replace("%PERM%", "bcoins.admin").replaceAll("&", "§"));
                }
                
            }
            else if(args[0].equalsIgnoreCase("remove")) {
                
                if(sender.hasPermission("bcoins.admin")) {
                    
                    if(Bukkit.getPlayer(args[1]) != null) {
                        
                        Player pTaker = Bukkit.getPlayer(args[1]);
                        Player pSender = Bukkit.getPlayer(sender.getName());
                        
                        if(BCoinsUtil.IsDouble(args[2])) {

                            double bcFrom = BCoins.GetPlayers().GetPlayer(pTaker.getUniqueId()).GetBC();
                            double bcRemove = Double.parseDouble(args[2]);
                            
                            bcFrom -= bcRemove;
                            
                            if(bcFrom < 0.0)
                                bcFrom = 0.0;
                            
                            BCoins.GetPlayers().GetPlayer(pTaker.getUniqueId()).SetBC(bcFrom);
                            
                            sender.sendMessage(BCoins.GetMessages().YouRemovePlayer().replace("%NICK%", args[1]).replace("%BCOIN%", String.valueOf(bcRemove)).replace("%WALLET%", String.valueOf(bcFrom)).replaceAll("&", "§"));
                            pTaker.sendMessage(BCoins.GetMessages().AdminRemoveYou().replace("%NICK%", sender.getName()).replace("%BCOIN%", String.valueOf(bcRemove)).replace("%WALLET%", String.valueOf(bcFrom)).replaceAll("&", "§"));

                            pTaker.playSound(pTaker.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 20, 20);
                        }
                        else {
                            sender.sendMessage(BCoins.GetMessages().UncorrectBCoinFormat().replaceAll("&", "§"));
                        }
                        
                    }
                    else {
                        sender.sendMessage(BCoins.GetMessages().TargetOffline().replaceAll("&", "§"));
                    }
                    
                }
                else {
                    sender.sendMessage(BCoins.GetMessages().HaveNotPerm().replace("%PERM%", "bcoins.admin").replaceAll("&", "§"));
                }
                
            }
            else if(args[0].equalsIgnoreCase("set")) {
                
                if(sender.hasPermission("bcoins.admin")) {
                    
                    if(Bukkit.getPlayer(args[1]) != null) {
                        
                        Player pTaker = Bukkit.getPlayer(args[1]);
                        Player pSender = Bukkit.getPlayer(sender.getName());
                        
                        if(BCoinsUtil.IsDouble(args[2])) {

                            double bcSet = Double.parseDouble(args[2]);
                            
                            BCoins.GetPlayers().GetPlayer(pTaker.getUniqueId()).SetBC(bcSet);
                            
                            sender.sendMessage(BCoins.GetMessages().YouSetPlayer().replace("%NICK%", args[1]).replace("%BCOIN%", String.valueOf(bcSet)).replaceAll("&", "§"));
                            pTaker.sendMessage(BCoins.GetMessages().AdminSetYou().replace("%NICK%", sender.getName()).replace("%BCOIN%", String.valueOf(bcSet)).replaceAll("&", "§"));

                            pTaker.playSound(pTaker.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 20, 20);
                        }
                        else {
                            sender.sendMessage(BCoins.GetMessages().UncorrectBCoinFormat().replaceAll("&", "§"));
                        }
                        
                    }
                    else {
                        sender.sendMessage(BCoins.GetMessages().TargetOffline().replaceAll("&", "§"));
                    }
                    
                }
                else {
                    sender.sendMessage(BCoins.GetMessages().HaveNotPerm().replace("%PERM%", "bcoins.admin").replaceAll("&", "§"));
                }
                
            }
            else {
                sender.sendMessage(BCoins.GetMessages().UnknownCommandBCoin());
            }
            
        }
        else {
            if(sender.hasPermission("bcoins.admin")) {
                sender.sendMessage(BCoins.GetMessages().BCoinUsageAdmin().replaceAll("&", "§"));
            }
            else {
                sender.sendMessage(BCoins.GetMessages().BCoinUsageNonAdmin().replaceAll("&", "§"));
            }
        }
        
        return false;
    }

}