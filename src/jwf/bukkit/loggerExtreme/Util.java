package jwf.bukkit.loggerExtreme;

import org.apache.commons.io.FileUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: joshuac
 * Date: 31/03/2013
 * Time: 15:51
 */
public class Util {

    //TODO Stop files from re-writing themselves each load.

    static String playerLog = "Log/Player.log";
    static String generalLog = "Log/General.log";
    static String blockLog = "Log/Block.log";
    static String logDir = "Log";

    static PrintWriter playerWriter;
    static PrintWriter generalWriter;
    static PrintWriter blockWriter;

    static File playerLogFile = new File(playerLog);
    static File generalLogFile = new File(generalLog);
    static File blockLogFile = new File(blockLog);
    static File logDirFile = new File(logDir);

    static DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss");

    //TODO Finish
    private static String[] blocks = {"air","stone","grass","dirt","cobblestone","plank","sapling","bedrock","water",
                                      "stat water","lava","stat lava","sand","gravel","ore gold"," ore iron","ore coal",
                                      "log","leaves","sponge","glass","ore lapis","block lapis","dispenser","sandstone",
                                      "note block","bed top","power rail","detector rail","piston sticky","web","shrubbery","dead shrubbery",
                                      "piston","piston head","wool","flower yellow","flower red","mushroom brown","mushroom red","block gold",
                                      "block iron","double slab","single slab","brick","tnt","bookshelf","cobble mossy","obsidian"};

    static void initFiles() {
        try {
            if (!(logDirFile.exists())) logDirFile.mkdir();
            if (!(playerLogFile.exists())) playerLogFile.createNewFile();
            if (!(generalLogFile.exists())) generalLogFile.createNewFile();
            if (!(blockLogFile.exists())) blockLogFile.createNewFile();

            playerWriter = new PrintWriter(new FileWriter(playerLogFile));
            generalWriter = new PrintWriter(new FileWriter(generalLogFile));
            blockWriter = new PrintWriter(new FileWriter(blockLogFile));

            //            printToGeneralLog("Logger Loaded");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("all")
    static void printToPlayerLog(String str) {
        writeToFile(playerLogFile, str);
    }

    @SuppressWarnings("all")
    static void printToBlockLog(String str) {
        writeToFile(blockLogFile, str);
    }

    @SuppressWarnings("all")
    static void printToGeneralLog(String str) {
        writeToFile(generalLogFile, str);
    }

    static String getDate() {
        return dateFormat.format(new Date());
    }

    static String getCustomDate(DateFormat format) {
        return format.format(new Date());
    }

    static public String formatLoc(Location location) {
        return location.getWorld().getName() + "|" + location.getBlockX() + "," + location.getBlockY() + "," + location.getBlockZ();
    }

    //TODO Test!
    static public String getPlayerName(Player player){
        return player.getPlayerListName();
    }

    static public void rotateLogs(){
        blockLogFile.renameTo(new File(blockLog+"|"+getCustomDate(new SimpleDateFormat("ddMMyy"))));
        playerLogFile.renameTo(new File(playerLog+"|"+getCustomDate(new SimpleDateFormat("ddMMyy"))));
        generalLogFile.renameTo(new File(generalLog+"|"+getCustomDate(new SimpleDateFormat("ddMMyy"))));
    }


    private static void writeToFile(File file, String str) {
        try {
            FileUtils.writeStringToFile(file, str +"\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
