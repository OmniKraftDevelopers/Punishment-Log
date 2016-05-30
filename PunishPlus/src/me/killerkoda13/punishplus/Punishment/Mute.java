package me.killerkoda13.punishplus.Punishment;

import org.bukkit.entity.Player;

/**
 * Created by Alex on 5/23/2016.
 */
public class Mute extends Punishment {

    public Mute(Player player, String message, String Banning_Staff, String timeOfBan, String duration) {
        this.ipAddress = player.getAddress().getHostName();
        this.offender = player.getDisplayName();
        this.UUID = player.getUniqueId().toString();
        this.message = message;
        this.Banning_Staff = Banning_Staff;
        this.timeOfBan = timeOfBan;
        this.duration = duration;
        this.punishment = PunishmentType.MUTE;
    }
}
