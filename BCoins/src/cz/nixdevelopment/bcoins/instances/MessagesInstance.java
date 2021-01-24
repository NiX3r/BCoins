package cz.nixdevelopment.bcoins.instances;

import cz.nixdevelopment.bcoins.BCoins;

public class MessagesInstance {

    private String unknownCommandBCoin = "&4Error#404 - Message not found! UnknownCommandBCoin";
    private String unknownCommandBShop = "&4Error#404 - Message not found! UnknownCommandBShop";
    private String reload = "&4Error#404 - Message not found! UnknownCommandBShop"; 
    private String itemNotExists = "&4Error#404 - Message not found! ItemNotExists";
    private String itemExists = "&4Error#404 - Message not found! ItemExists";
    private String removeItem = "&4Error#404 - Message not found! RemoveItem";
    private String createItem = "&4Error#404 - Message not found! CreateItem";
    private String haveNotPerm = "&4Error#404 - Message not found! HaveNotPerm";
    private String tooPoor = "&4Error#404 - Message not found! TooPoor";
    private String targetOffline = "&4Error#404 - Message not found! TargetOffline";
    private String uncorrectBCoinFormat = "&4Error#404 - Message not found! UncorrectBCoinFormat";
    private String addCommand = "&4Error#404 - Message not found! AddCommand";
    private String removeCommand = "&4Error#404 - Message not found! RemoveCommand";
    private String playerWallet = "&4Error#404 - Message not found! PlayerWallet";
    private String playerBuySelf = "&4Error#404 - Message not found! PlayerBuySelf";
    private String playerBuyPlayer = "&4Error#404 - Message not found! PlayerBuyPlayer";
    private String playerBuyYou = "&4Error#404 - Message not found! PlayerBuyYou";
    private String adminGiveYou = "&4Error#404 - Message not found! AdminGiveYou";
    private String youGivePlayer = "&4Error#404 - Message not found! YouGivePlayer";
    private String youSetPlayer = "&4Error#404 - Message not found! YouSetPlayer";
    private String adminSetYou = "&4Error#404 - Message not found! AdminSetYou";
    private String youAddPlayer = "&4Error#404 - Message not found! YouAddPlayer";
    private String adminAddYou = "&4Error#404 - Message not found! AdminAddYou";
    private String youRemovePlayer = "&4Error#404 - Message not found! YouRemovePlayer";
    private String adminRemoveYou = "&4Error#404 - Message not found! AdminRemoveYou";
    private String sendYourself = "&4Error#404 - Message not found! SendYourself";
    private String youSendPlayer = "&4Error#404 - Message not found! YouSendPlayer";
    private String playerSendYou = "&4Error#404 - Message not found! PlayerSendYou";
    private String BCoinUsageAdmin = "&4Error#404 - Message not found! Config.Menus.Admin";
    private String BCoinUsageNonAdmin = "&4Error#404 - Message not found! Config.Menus.NonAdmin";
    private String BShopUsageAdmin = "&4Error#404 - Message not found! Config.Menus.Admin";
    private String BShopUsageNonAdmin = "&4Error#404 - Message not found! Config.Menus.NonAdmin";
    private String ListBShop = "&4Error#404 - Message not found! Config.Menus.Lists.BShop";
    private String ListItemCommands = "&4Error#404 - Message not found! Config.Menus.Lists.ItemCommands";
    private String ListItemCommandsNotSet = "&4Error#404 - Message not found! Config.Menus.Lists.ItemCommandsNotSet";
    
    public MessagesInstance() {
        
    }

    public String UnknownCommandBCoin() {
        return BCoins.GetPrefix() + unknownCommandBCoin;
    }

    public void setUnknownCommandBCoin(String unknownCommandBCoin) {
        this.unknownCommandBCoin = unknownCommandBCoin;
    }

    public String UnknownCommandBShop() {
        return BCoins.GetPrefix() + unknownCommandBShop;
    }

    public void setUnknownCommandBShop(String unknownCommandBShop) {
        this.unknownCommandBShop = unknownCommandBShop;
    }

    public String ItemExists() {
        return BCoins.GetPrefix() + itemExists;
    }

    public void setItemExists(String itemExists) {
        this.itemExists = itemExists;
    }

    public String ItemNotExists() {
        return BCoins.GetPrefix() + itemNotExists;
    }

    public void setItemNotExists(String itemNotExists) {
        this.itemNotExists = itemNotExists;
    }

    public String RemoveItem() {
        return BCoins.GetPrefix() + removeItem;
    }

    public void setRemoveItem(String removeItem) {
        this.removeItem = removeItem;
    }

    public String TooPoor() {
        return BCoins.GetPrefix() + tooPoor;
    }

    public void setTooPoor(String tooPoor) {
        this.tooPoor = tooPoor;
    }

    public String HaveNotPerm() {
        return BCoins.GetPrefix() + haveNotPerm;
    }

    public void setHaveNotPerm(String haveNotPerm) {
        this.haveNotPerm = haveNotPerm;
    }

    public String AddCommand() {
        return BCoins.GetPrefix() + addCommand;
    }

    public void setAddCommand(String addCommand) {
        this.addCommand = addCommand;
    }

    public String RemoveCommand() {
        return BCoins.GetPrefix() + removeCommand;
    }

    public void setRemoveCommand(String removeCommand) {
        this.removeCommand = removeCommand;
    }

    public String TargetOffline() {
        return BCoins.GetPrefix() + targetOffline;
    }

    public void setTargetOffline(String targetOffline) {
        this.targetOffline = targetOffline;
    }

    public String UncorrectBCoinFormat() {
        return BCoins.GetPrefix() + uncorrectBCoinFormat;
    }

    public void setUncorrectBCoinFormat(String uncorrectBCoinFormat) {
        this.uncorrectBCoinFormat = uncorrectBCoinFormat;
    }

    public String PlayerBuyPlayer() {
        return BCoins.GetPrefix() + playerBuyPlayer;
    }

    public void setPlayerBuyPlayer(String playerBuyPlayer) {
        this.playerBuyPlayer = playerBuyPlayer;
    }

    public String PlayerWallet() {
        return BCoins.GetPrefix() + playerWallet;
    }

    public void setPlayerWallet(String playerWallet) {
        this.playerWallet = playerWallet;
    }

    public String PlayerBuySelf() {
        return BCoins.GetPrefix() + playerBuySelf;
    }

    public void setPlayerBuySelf(String playerBuySelf) {
        this.playerBuySelf = playerBuySelf;
    }

    public String YouGivePlayer() {
        return BCoins.GetPrefix() + youGivePlayer;
    }

    public void setYouGivePlayer(String youGivePlayer) {
        this.youGivePlayer = youGivePlayer;
    }

    public String PlayerBuyYou() {
        return BCoins.GetPrefix() + playerBuyYou;
    }

    public void setPlayerBuyYou(String playerBuyYou) {
        this.playerBuyYou = playerBuyYou;
    }

    public String YouSetPlayer() {
        return BCoins.GetPrefix() + youSetPlayer;
    }

    public void setYouSetPlayer(String youSetPlayer) {
        this.youSetPlayer = youSetPlayer;
    }

    public String YouAddPlayer() {
        return BCoins.GetPrefix() + youAddPlayer;
    }

    public void setYouAddPlayer(String youAddPlayer) {
        this.youAddPlayer = youAddPlayer;
    }

    public String YouSendPlayer() {
        return BCoins.GetPrefix() + youSendPlayer;
    }

    public void setYouSendPlayer(String youSendPlayer) {
        this.youSendPlayer = youSendPlayer;
    }

    public String AdminGiveYou() {
        return BCoins.GetPrefix() + adminGiveYou;
    }

    public void setAdminGiveYou(String adminGiveYou) {
        this.adminGiveYou = adminGiveYou;
    }

    public String AdminSetYou() {
        return BCoins.GetPrefix() + adminSetYou;
    }

    public void setAdminSetYou(String adminSetYou) {
        this.adminSetYou = adminSetYou;
    }

    public String AdminAddYou() {
        return BCoins.GetPrefix() + adminAddYou;
    }

    public void setAdminAddYou(String adminAddYou) {
        this.adminAddYou = adminAddYou;
    }

    public String AdminRemoveYou() {
        return BCoins.GetPrefix() + adminRemoveYou;
    }

    public void setAdminRemoveYou(String adminRemoveYou) {
        this.adminRemoveYou = adminRemoveYou;
    }

    public String YouRemovePlayer() {
        return BCoins.GetPrefix() + youRemovePlayer;
    }

    public void setYouRemovePlayer(String youRemovePlayer) {
        this.youRemovePlayer = youRemovePlayer;
    }

    public String PlayerSendYou() {
        return BCoins.GetPrefix() + playerSendYou;
    }

    public void setPlayerSendYou(String playerSendYou) {
        this.playerSendYou = playerSendYou;
    }

    public String CreateItem() {
        return BCoins.GetPrefix() + createItem;
    }

    public void setCreateItem(String createItem) {
        this.createItem = createItem;
    }

    public String BCoinUsageAdmin() {
        return BCoinUsageAdmin;
    }

    public void setBCoinUsageAdmin(String bCoinUsageAdmin) {
        BCoinUsageAdmin = bCoinUsageAdmin;
    }

    public String ListBShop() {
        return BCoins.GetPrefix() + ListBShop;
    }

    public void setListBShop(String listBShop) {
        ListBShop = listBShop;
    }

    public String BShopUsageNonAdmin() {
        return BShopUsageNonAdmin;
    }

    public void setBShopUsageNonAdmin(String bShopUsageNonAdmin) {
        BShopUsageNonAdmin = bShopUsageNonAdmin;
    }

    public String BShopUsageAdmin() {
        return BShopUsageAdmin;
    }

    public void setBShopUsageAdmin(String bShopUsageAdmin) {
        BShopUsageAdmin = bShopUsageAdmin;
    }

    public String BCoinUsageNonAdmin() {
        return BCoinUsageNonAdmin;
    }

    public void setBCoinUsageNonAdmin(String bCoinUsageNonAdmin) {
        BCoinUsageNonAdmin = bCoinUsageNonAdmin;
    }

    public String ListItemCommands() {
        return ListItemCommands;
    }

    public void setListItemCommands(String listItemCommands) {
        ListItemCommands = listItemCommands;
    }

    public String ListItemCommandsNotSet() {
        return ListItemCommandsNotSet;
    }

    public void setListItemCommandsNotSet(String listItemCommandsNotSet) {
        ListItemCommandsNotSet = listItemCommandsNotSet;
    }

    public String Reload() {
        return BCoins.GetPrefix() + reload;
    }

    public void setReload(String reload) {
        this.reload = reload;
    }

    public String SendYourself() {
        return sendYourself;
    }

    public void setSendYourself(String sendYourself) {
        this.sendYourself = sendYourself;
    }
    
}
