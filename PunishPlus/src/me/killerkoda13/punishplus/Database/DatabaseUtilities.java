package me.killerkoda13.punishplus.Database;

import me.killerkoda13.punishplus.Punishment.Punishment;

import java.sql.*;
import java.util.ArrayList;

/***
 * ---------------------------------
 *
 * @Author Killerkoda13 (Alex Jones)
 * @date Apr 30, 2016
 * ---------------------------------
 */
public class DatabaseUtilities {
    public static Connection connection;
    public static boolean connected;

    public static void putPlayer(String name, Punishment.PunishmentType p, String UUID, String reason, String time, String banningstaff) throws SQLException {
        String url = "censored";
        String username = "<censored>";
        String password = "<censored>";

        ArrayList<String> values = new ArrayList<String>();

        Connection connection = DriverManager.getConnection(url, username, password);
        switch (p) {
            case PERMBAN:
                PreparedStatement statement = connection.prepareStatement("INSERT INTO `punishment_table`(`Name`, `UUID`, `Banning Staff`, `Reason`, `Punishment`, `Duration`) VALUES ('" + name + "','" + UUID + "','" + banningstaff + "','" + reason + "','" + "ban" + "','" + time + "')");
                statement.executeUpdate();
                break;
            case TEMPBAN:
                PreparedStatement statement1 = connection.prepareStatement("INSERT INTO `punishment_table`(`Name`, `UUID`, `Banning Staff`, `Reason`, `Punishment`, `Duration`) VALUES (" + name + "," + UUID + "," + banningstaff + "," + reason + "," + "tempban" + "," + time + ")");
                statement1.executeUpdate();
                break;
            case KICK:
                PreparedStatement statement11 = connection.prepareStatement("INSERT INTO `punishment_table`(`Name`, `UUID`, `Banning Staff`, `Reason`, `Punishment`, `Duration`) VALUES (" + name + "," + UUID + "," + banningstaff + "," + reason + "," + "kick" + "," + time + ")");
                statement11.executeUpdate();
                break;
            case MUTE:
                PreparedStatement statement111 = connection.prepareStatement("INSERT INTO `punishment_table`(`Name`, `UUID`, `Banning Staff`, `Reason`, `Punishment`, `Duration`) VALUES (" + name + "," + UUID + "," + banningstaff + "," + reason + "," + "kick" + "," + time + ")");
                statement111.executeUpdate();
                break;
        }
    }

    public static ArrayList<String> getPlayer(String name) {
        String url = "censored";
        String username = "censored";
        String password = "censored";

        ArrayList<String> values = new ArrayList<String>();

        PreparedStatement statement = null;
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String sqlstatement = "SELECT `Name`, `UUID`, `Banning Staff`, `Punishment`, `Reason`, `Duration`, `CaseID`, `ip address`, `ban_time` FROM `DevTable` WHERE Name=\"" + name + "\"";
            statement = connection.prepareStatement(sqlstatement);
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        ResultSet set = null;
        try {
            set = statement.executeQuery();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            if (set.next() != false) {
                values.add("Name: " + set.getString(1));
                values.add("UUID: " + set.getString(2));
                values.add("Banning Staff: " + set.getString(3));
                values.add("Reason: " + set.getString(4));
                values.add("Punishment: " + set.getString(5));
                values.add("Duration: " + set.getString(6));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return values;

    }

    public static ArrayList<String> getPlayer(String name, int page) {
        String url = "censored";
        String username = "censored";
        String password = "censored";

        ArrayList<String> values = new ArrayList<String>();

        PreparedStatement statement = null;
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String sqlstatement = "SELECT `Name`, `UUID`, `Banning Staff`, `Punishment`, `Reason`, `Duration`, `CaseID`, `ip address`, `ban_time` FROM `DevTable` WHERE Name=\"" + name + "\"";
            statement = connection.prepareStatement(sqlstatement);
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        ResultSet set = null;
        try {
            set = statement.executeQuery();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            for (int i = page; i > 0; i--) {
                set.next();
                System.out.println(set.getString(i));
                values.add("Name: " + set.getString(1));
                values.add("UUID: " + set.getString(2));
                values.add("Banning Staff: " + set.getString(3));
                values.add("Reason: " + set.getString(4));
                values.add("Punishment: " + set.getString(5));
                values.add("Duration: " + set.getString(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return values;

    }
}

