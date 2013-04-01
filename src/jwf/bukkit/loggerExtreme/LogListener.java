package jwf.bukkit.loggerExtreme;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerCommandEvent;

import static jwf.bukkit.loggerExtreme.Util.*;

/**
 * User: joshuac
 * Date: 30/03/2013
 * Time: 16:07
 */
public class LogListener implements Listener {


    public LogListener() {

    }

    /*=====================================================BLOCK======================================================*/
    @EventHandler(priority = EventPriority.MONITOR)
    @SuppressWarnings("unused")
    public void onBlockPlace(BlockPlaceEvent event) {
        printToBlockLog(getDate() + "|Block " + event.getBlock().getTypeId() + ":" + event.getBlock().getData() + " placed at " + formatLoc(event.getBlock().getLocation()) + " by " + event.getPlayer().getDisplayName());
//        say(getDate() + "|Block " + event.getBlock().getTypeId() + ":" + event.getBlock().getData() + " placed at " + formatLoc(event.getBlock().getLocation()) + " by " + event.getPlayer().getDisplayName());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    @SuppressWarnings("unused")
    public void onBlockDestroy(BlockBreakEvent event) {
        printToBlockLog(getDate() + "|Block " + event.getBlock().getTypeId() + ":" + event.getBlock().getData() + " destroyed at " + formatLoc(event.getBlock().getLocation()) + " by " + event.getPlayer().getDisplayName());
//        say(getDate() + "|Block " + event.getBlock().getTypeId() + ":" + event.getBlock().getData() + "destroyed at " + formatLoc(event.getBlock().getLocation()) + "by " + event.getPlayer().getDisplayName());
    }
    /*==================================================================================================================*/


    /*=====================================================PLAYER=====================================================*/
    @EventHandler(priority = EventPriority.MONITOR)
    @SuppressWarnings("unused")
    public void onPlayChat(AsyncPlayerChatEvent event) {
        printToPlayerLog(getDate() + "|< " + event.getPlayer().getDisplayName() + " > " + event.getMessage());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    @SuppressWarnings("unused")
    public void onPlayerLogin(PlayerLoginEvent event) {
        printToPlayerLog(getDate() + "|" + event.getPlayer().getDisplayName() + " Logged in at " + formatLoc(event.getPlayer().getLocation()));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    @SuppressWarnings("unused")
    public void onPlayerLogOut(PlayerQuitEvent event) {
        printToPlayerLog(getDate() + "|" + event.getPlayer().getDisplayName() + " Exited the game at " + formatLoc(event.getPlayer().getLocation()) + " because " + event.getQuitMessage());
    }

//    @EventHandler(priority = EventPriority.MONITOR)
//    public void onGameModeChange(PlayerGameModeChangeEvent event) {
//    }

    @EventHandler(priority = EventPriority.MONITOR)
    @SuppressWarnings("unused")
    public void onPlayerKick(PlayerKickEvent event) {
        printToPlayerLog(getDate() + "|" + event.getPlayer().getDisplayName() + " Was kicked for " + event.getReason());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    @SuppressWarnings("unused")
    public void onPlayerDeath(PlayerDeathEvent event) {
        printToPlayerLog(getDate() + "|" + event.getEntity().getDisplayName() + " Died at " + formatLoc(event.getEntity().getLocation()) + " because " + event.getDeathMessage());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    @SuppressWarnings("unused")
    public void onPlayerHurtByPlayer(EntityDamageByEntityEvent event) {

        if (event.getDamager().getType() == EntityType.PLAYER && event.getEntityType() == EntityType.PLAYER) {
            printToPlayerLog(getDate() + "|" + ((Player) event.getEntity()).getDisplayName() + " Was damaged by " + ((Player) event.getEntity()).getDisplayName());
        }

    }
    /*==================================================================================================================*/


    /*====================================================GENERAL=====================================================*/
    @EventHandler(priority = EventPriority.MONITOR)
    @SuppressWarnings("unused")
    public void onServerCommand(ServerCommandEvent event) {
        printToGeneralLog(getDate() + "|[SERVER] " + event.getCommand());
    }
}
