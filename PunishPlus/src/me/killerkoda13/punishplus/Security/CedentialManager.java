package me.killerkoda13.punishplus.Security;

import me.killerkoda13.punishplus.PunishPlus;

import java.io.*;

/**
 * Created by Alex on 5/23/2016.
 */
public class CedentialManager {

    private static BufferedReader filereader;
    private static File usernamefile = new File(PunishPlus.getPlugin().getDataFolder() + "/credentials/" + "username.cred");
    private static File passwordfile = new File(PunishPlus.getPlugin().getDataFolder() + "/credentials/" + "password.cred");
    private static File serverurlfile = new File(PunishPlus.getPlugin().getDataFolder() + "/credentials/" + "serverurl.cred");

    public static String getUserName() {
        try {
            filereader = new BufferedReader(new FileReader(usernamefile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String usr = filereader.readLine();
            filereader.close();
            return usr;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPassword() {
        try {
            filereader = new BufferedReader(new FileReader(passwordfile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String pass = filereader.readLine();
            filereader.close();
            return pass;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getServer() {
        try {
            filereader = new BufferedReader(new FileReader(serverurlfile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String serverurl = filereader.readLine();
            filereader.close();
            return "jdbc:mysql://" + serverurl;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
