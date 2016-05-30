package me.killerkoda13.punishplus.Punishment;

import org.bukkit.entity.Player;

/**
 * Created by Alex on 5/23/2016.
 */
public class Kick extends Punishment {

    public Kick(Player player, String message, String Banning_Staff, String timeOfBan) {
        this.ipAddress = player.getAddress().getHostName();
        this.offender = player.getDisplayName();
        this.UUID = player.getUniqueId().toString();
        this.message = message;
        this.Banning_Staff = Banning_Staff;
        this.timeOfBan = timeOfBan;
        this.punishment = PunishmentType.KICK;
    }
}
