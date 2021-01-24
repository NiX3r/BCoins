package cz.nixdevelopment.bcoins.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cz.nixdevelopment.bcoins.BCoins;
import cz.nixdevelopment.bcoins.events.ShopItemEvent;
import cz.nixdevelopment.bcoins.utils.BCoinsUtil;
import cz.nixdevelopment.bcoins.utils.MySQL;

public class BShopCommand implements CommandExecutor {

    @SuppressWarnings("unused")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        
        if(args.length == 0) {
            if(sender.hasPermission("bcoins.admin")) {
                sender.sendMessage(BCoins.GetMessages().BShopUsageAdmin().replaceAll("&", "§"));
            }
            else {
                sender.sendMessage(BCoins.GetMessages().BShopUsageNonAdmin().replaceAll("&", "§"));
            }
        }
        
        // commands: /bshop list
        else if(args.length == 1) {
            
            if(args[0].equalsIgnoreCase("list")) {
                String output = BCoins.GetMessages().ListBShop();
                for(ShopItemEvent sie : BCoins.GetItems()) {
                    output += "§7 ,§c" + sie.GetIdentifier() + "§7[" + sie.GetCost() + "BC]";
                }
                sender.sendMessage(output.replaceFirst(" ,", "").replaceAll("&", "§"));
            }
            else {
                sender.sendMessage(BCoins.GetMessages().UnknownCommandBShop().replaceAll("&", "§"));
            }
            
        }
        
        // commands: /bshop [buy | remove] <identifier>
        else if(args.length == 2) {
            
            if(args[0].equalsIgnoreCase("buy")) {
                
                if(BCoinsUtil.IsItemExist(args[1])) {
                    
                    Player buier = Bukkit.getPlayer(sender.getName());
                    double pocket = MySQL.getTokens(buier.getUniqueId().toString());
                    double cost = 0.0;
                    ShopItemEvent item = null;
                    
                    for(ShopItemEvent sie : BCoins.GetItems()) {
                        if(sie.GetIdentifier().equals(args[1]))
                            item = sie;
                    }
                    
                    if(item != null) {
                        
                        cost = item.GetCost();
                        
                        if(pocket >= cost) {
                            
                            pocket -= cost;
                            
                            MySQL.setTokens(buier.getUniqueId().toString(), pocket);
                            
                            BCoinsUtil.DispatchItemCommands(item, buier.getName());
                            
                            sender.sendMessage(BCoins.GetMessages().PlayerBuySelf().replace("%ITEM%", item.GetIdentifier()).replace("%WALLET%", String.valueOf(pocket)).replaceAll("&", "§"));
                            
                        }
                        else {
                            sender.sendMessage(BCoins.GetMessages().TooPoor().replaceAll("&", "§"));
                        }
                        
                    }
                    else {
                        System.out.println("Some error's here!");
                    }
                    
                }
                else {
                    sender.sendMessage(BCoins.GetMessages().ItemNotExists().replaceAll("&", "§"));
                }
                
            }
            else if(args[0].equalsIgnoreCase("remove")) {
                if(sender.hasPermission("bcoins.admin")) {
                    if(BCoinsUtil.IsItemExist(args[1])) {
                        
                        ShopItemEvent item = null;
                        
                        for(ShopItemEvent sie : BCoins.GetItems()) {
                            if(sie.GetIdentifier().equals(args[1]))
                                item = sie;
                        }
                        
                        if(item != null) {
                            
                            BCoins.GetItems().remove(item);
                            sender.sendMessage(BCoins.GetMessages().RemoveItem().replace("%ITEM%", item.GetIdentifier()).replaceAll("&", "§"));
                            
                        }
                        else {
                            System.out.println("Some error's here!");
                        }
                        
                    }
                    else {
                        sender.sendMessage(BCoins.GetMessages().ItemNotExists().replaceAll("&", "§"));
                    }
                }
                else {
                    sender.sendMessage(BCoins.GetMessages().HaveNotPerm().replace("%PERM%", "bcoins.admin").replaceAll("&", "§"));
                }
            }
            else {
                sender.sendMessage(BCoins.GetMessages().UnknownCommandBShop().replaceAll("&", "§"));
            }
            
        }
        
        // commands: /bshop [buy | give | create | cmd] <identifier> (<cost | nick> | [list])
        else if(args.length == 3) {
            if(args[0].equalsIgnoreCase("buy")) {
                if(Bukkit.getPlayer(args[2]) != null) {
                    if(BCoinsUtil.IsItemExist(args[1])) {
                        
                        Player buier = Bukkit.getPlayer(sender.getName());
                        Player taker = Bukkit.getPlayer(args[2]);
                        double pocket = MySQL.getTokens(buier.getUniqueId().toString());
                        double cost = 0.0;
                        ShopItemEvent item = null;
                        
                        for(ShopItemEvent sie : BCoins.GetItems()) {
                            if(sie.GetIdentifier().equals(args[1]))
                                item = sie;
                        }
                        
                        if(item != null) {
                            
                            cost = item.GetCost();
                            
                            if(pocket >= cost) {
                                
                                pocket -= cost;
                                
                                MySQL.setTokens(buier.getUniqueId().toString(), pocket);
                                
                                BCoinsUtil.DispatchItemCommands(item, taker.getName());
                                
                                sender.sendMessage(BCoins.GetMessages().PlayerBuyPlayer().replace("%WALLET%", String.valueOf(pocket)).replace("%ITEM%", item.GetIdentifier()).replace("%NICK%", args[2]).replaceAll("&", "§"));
                                taker.sendMessage(BCoins.GetMessages().PlayerBuyYou().replace("%ITEM%", item.GetIdentifier()).replace("%NICK%", sender.getName()).replaceAll("&", "§"));
                                
                            }
                            else {
                                sender.sendMessage(BCoins.GetMessages().TooPoor().replaceAll("&", "§"));
                            }
                            
                        }
                        else {
                            System.out.println("Some error's here!");
                        }
                        
                    }
                    else {
                        sender.sendMessage(BCoins.GetMessages().ItemNotExists().replaceAll("&", "§"));
                    }
                }
                else {
                    sender.sendMessage(BCoins.GetMessages().TargetOffline().replaceAll("&", "§"));
                }
            }
            else if(args[0].equalsIgnoreCase("give")) {
                if(sender.hasPermission("bcoins.admin")) {
                    if(Bukkit.getPlayer(args[2]) != null) {
                        if(BCoinsUtil.IsItemExist(args[1])) {
                            
                            Player admin = Bukkit.getPlayer(sender.getName());
                            Player taker = Bukkit.getPlayer(args[2]);
                            ShopItemEvent item = null;
                            
                            for(ShopItemEvent sie : BCoins.GetItems()) {
                                if(sie.GetIdentifier().equals(args[1]))
                                    item = sie;
                            }
                            
                            if(item != null) {
                                
                                BCoinsUtil.DispatchItemCommands(item, taker.getName());
                                
                                sender.sendMessage(BCoins.GetMessages().YouGivePlayer().replace("%NICK%", args[2]).replace("%ITEM%", item.GetIdentifier()).replaceAll("&", "§"));
                                taker.sendMessage(BCoins.GetMessages().AdminGiveYou().replace("%NICK%", sender.getName()).replace("%ITEM%", item.GetIdentifier()).replaceAll("&", "§"));
                                
                            }
                            else {
                                System.out.println("Some error's here!");
                            }
                            
                        }
                        else {
                            sender.sendMessage(BCoins.GetMessages().ItemNotExists().replaceAll("&", "§"));
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
            else if(args[0].equalsIgnoreCase("create")) {
                if(sender.hasPermission("bcoins.admin")) {
                    if(!BCoinsUtil.IsItemExist(args[1])) {
                        if(BCoinsUtil.IsDouble(args[2])) {
                            ShopItemEvent item = new ShopItemEvent(args[1], Double.valueOf(args[2]));
                            BCoins.GetItems().add(item);
                            sender.sendMessage(BCoins.GetMessages().CreateItem().replace("%ITEM%", args[1]).replaceAll("&", "§"));
                        }
                        else {
                            sender.sendMessage(BCoins.GetMessages().UncorrectBCoinFormat().replaceAll("&", "§"));
                        }
                    }
                    else {
                        sender.sendMessage(BCoins.GetMessages().ItemExists().replaceAll("&", "§"));
                    }
                }
                else {
                    sender.sendMessage(BCoins.GetMessages().HaveNotPerm().replace("%PERM%", "bcoins.admin").replaceAll("&", "§"));
                }
            }
            else if(args[0].equalsIgnoreCase("cmd") && args[2].equalsIgnoreCase("list")) {
                if(sender.hasPermission("bcoins.admin")) {
                    if(BCoinsUtil.IsItemExist(args[1])) {
                        String output = BCoins.GetMessages().ListItemCommands();
                        for(ShopItemEvent sie : BCoins.GetItems()) {
                            if(sie.GetIdentifier().equals(args[1])) {
                                if(sie.GetCommands() != null) {
                                    for(String cmda : sie.GetCommands()) {
                                        output += "\n - " + cmda;
                                    }
                                }
                                else {
                                    output += "\n" + BCoins.GetMessages().ListItemCommandsNotSet();
                                }
                            }
                        }
                        sender.sendMessage(output.replaceFirst("\n", "").replaceAll("&", "§"));
                    }
                    else {
                        sender.sendMessage(BCoins.GetMessages().ItemNotExists().replaceAll("&", "§"));
                    }
                }
                else {
                    sender.sendMessage(BCoins.GetMessages().HaveNotPerm().replace("%PERM%", "bcoins.admin").replaceAll("&", "§"));
                }
            }
            else {
                sender.sendMessage(BCoins.GetMessages().UnknownCommandBShop().replaceAll("&", "§"));
            }
        }
        else {
            if(args[0].equalsIgnoreCase("cmd") && args[2].equalsIgnoreCase("add") && args.length > 3) {
                if(sender.hasPermission("bcoins.admin")) {
                    if(BCoinsUtil.IsItemExist(args[1])) {
                        String command = "";
                        ShopItemEvent item = null;
                        for(ShopItemEvent sie : BCoins.GetItems()) {
                            if(sie.GetIdentifier().equals(args[1])) {
                                item = sie;
                            }
                        }
                        if(item != null) {
                            for(int i = 3; i < args.length; i++) {
                                command += " " + args[i];
                            }
                            command = command.replaceFirst(" ", "");
                            
                            for(int i = 0; i <= BCoins.GetItems().size(); i++) {
                                if(BCoins.GetItems().get(i).GetIdentifier().equals(item.GetIdentifier())) {
                                    BCoins.GetItems().get(i).AddCommand(command);
                                    break;
                                }
                            }
                            
                            sender.sendMessage(BCoins.GetMessages().AddCommand().replace("%ITEM%", item.GetIdentifier()).replace("%CMD%", command).replaceAll("&", "§"));
                            
                        }
                        else {
                            System.out.println("Some error's here!");
                        }
                    }
                    else {
                        sender.sendMessage(BCoins.GetMessages().ItemNotExists().replaceAll("&", "§"));
                    }
                }
                else {
                    sender.sendMessage(BCoins.GetMessages().HaveNotPerm().replace("%PERM%", "bcoins.admin").replaceAll("&", "§"));
                }
            }
            else if(args[0].equalsIgnoreCase("cmd") && args[2].equalsIgnoreCase("remove") && args.length > 3) {
                if(sender.hasPermission("bcoins.admin")) {
                    if(BCoinsUtil.IsItemExist(args[1])) {
                        String command = "";
                        ShopItemEvent item = null;
                        for(ShopItemEvent sie : BCoins.GetItems()) {
                            if(sie.GetIdentifier().equals(args[1])) {
                                item = sie;
                            }
                        }
                        if(item != null) {
                            for(int i = 3; i < args.length; i++) {
                                command += " " + args[i];
                            }
                            command = command.replaceFirst(" ", "");
                            
                            for(int i = 0; i <= BCoins.GetItems().size(); i++) {
                                if(BCoins.GetItems().get(i).GetIdentifier().equals(item.GetIdentifier())) {
                                    BCoins.GetItems().get(i).GetCommands().remove(command);
                                    break;
                                }
                            }
                            
                            sender.sendMessage(BCoins.GetMessages().RemoveCommand().replace("%ITEM%", item.GetIdentifier()).replace("%CMD%", command).replaceAll("&", "§"));
                            
                        }
                        else {
                            System.out.println("Some error's here!");
                        }
                    }
                    else {
                        sender.sendMessage(BCoins.GetMessages().ItemNotExists().replaceAll("&", "§"));
                    }
                }
                else {
                    sender.sendMessage(BCoins.GetMessages().HaveNotPerm().replace("%PERM%", "bcoins.admin").replaceAll("&", "§"));
                }
            }
            else {
                sender.sendMessage(BCoins.GetMessages().UnknownCommandBShop().replaceAll("&", "§"));
            }
        }
        
        return false;
    }

}
