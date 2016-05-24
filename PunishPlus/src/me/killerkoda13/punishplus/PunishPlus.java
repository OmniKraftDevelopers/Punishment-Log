package me.killerkoda13.punishplus;

import me.killerkoda13.punishplus.Database.DatabaseUtilities;
import me.killerkoda13.punishplus.Punishment.Punishment;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

public class PunishPlus extends JavaPlugin{

	public static Plugin plugin;
	private static File usernamefile = new File(PunishPlus.getPlugin().getDataFolder() + "/credentials/" + "username.cred");
	private static File passwordfile = new File(PunishPlus.getPlugin().getDataFolder() + "/credentials/" + "password.cred");
	private static File serverurlfile = new File(PunishPlus.getPlugin().getDataFolder() + "/credentials/" + "serverurl.cred");
	HashMap<Player, String> map = new HashMap<Player, String>();

	public static Plugin getPlugin() {
		return plugin;
	}

	@Override
	public void onEnable() {
		plugin = this;

		if (this.getDataFolder().exists() != true) {
			this.getDataFolder().mkdirs();
			if (new File(this.getDataFolder() + "/credentials/").exists() != true) {
				Bukkit.getLogger().log(Level.INFO, "Credentials folder was not found. Generating one now.");
				new File(this.getDataFolder() + "/credentials/").mkdirs();
				if (usernamefile.exists() != true) {
					try {
						usernamefile.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (passwordfile.exists() != true) {
					try {
						passwordfile.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (serverurlfile.exists() != true) {
					try {
						serverurlfile.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public void onDisable()
	{

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(cmd.getName().equalsIgnoreCase("grab"))
		{
			if (map.containsKey(sender))
			{
				ArrayList<String> info = DatabaseUtilities.getPlayer(map.get(sender), Integer.parseInt(args[0]));
				int index = 0;
				for(String item : info)
				{
					if(index == 5)
					{
						sender.sendMessage("---------------");
						index = 0;
					}else
					{
						index++;
						sender.sendMessage(item);
					}
				}
			}else
			{
				ArrayList<String> info = DatabaseUtilities.getPlayer(args[0]);
				sender.sendMessage("---------------");
				int index = 0;
				for(String item : info)
				{
					if(index == 5)
					{
						sender.sendMessage("---------------");
						index = 0;
					}else
					{
						index++;
						sender.sendMessage(item);
					}
				}
			}
			map.put((Player) sender, args[0]);

		}else if(cmd.getName().equalsIgnoreCase("gput"))
		{
			switch(args[1])
			{
			case "ban":
				try {
					DatabaseUtilities.putPlayer(args[0], Punishment.PunishmentType.PERMBAN, Bukkit.getPlayer(args[0]).getUniqueId().toString(), args[2], args[3], sender.getName());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "tempban":
				try {
					DatabaseUtilities.putPlayer(args[0], Punishment.PunishmentType.TEMPBAN, Bukkit.getPlayer(args[0]).getUniqueId().toString(), args[2], args[3], sender.getName());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;	
			case "kick":
				try {
					DatabaseUtilities.putPlayer(args[0], Punishment.PunishmentType.KICK, Bukkit.getPlayer(args[0]).getUniqueId().toString(), args[2], args[3], sender.getName());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				break;
			case "mute":
				try {
					DatabaseUtilities.putPlayer(args[0], Punishment.PunishmentType.MUTE, Bukkit.getPlayer(args[0]).getUniqueId().toString(), args[2], args[3], sender.getName());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
		return true;
	}



}
