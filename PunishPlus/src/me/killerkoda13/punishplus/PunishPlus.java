package me.killerkoda13.punishplus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;






import me.killerkoda13.punishplus.dbutils.DatabaseUtilities;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PunishPlus extends JavaPlugin{

	@Override
	public void onEnable()
	{

	}

	@Override
	public void onDisable()
	{

	}

	HashMap<Player, String> map = new HashMap<Player, String>();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{

		if(cmd.getName().equalsIgnoreCase("grab"))
		{


			if(map.containsKey((Player)sender))
			{
				ArrayList<String> info = DatabaseUtilities.getPlayer(map.get((Player)sender), Integer.parseInt(args[0]));
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
					DatabaseUtilities.putPlayer(args[0], DatabaseUtilities.punishment.Ban, Bukkit.getPlayer(args[0]).getUniqueId().toString(), args[2], args[3], sender.getName());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "tempban":
				try {
					DatabaseUtilities.putPlayer(args[0], DatabaseUtilities.punishment.Tempban, Bukkit.getPlayer(args[0]).getUniqueId().toString(), args[2], args[3], sender.getName());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;	
			case "kick":
				try {
					DatabaseUtilities.putPlayer(args[0], DatabaseUtilities.punishment.kick, Bukkit.getPlayer(args[0]).getUniqueId().toString(), args[2], args[3], sender.getName());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				break;
			case "mute":
				try {
					DatabaseUtilities.putPlayer(args[0], DatabaseUtilities.punishment.mute, Bukkit.getPlayer(args[0]).getUniqueId().toString(), args[2], args[3], sender.getName());
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
