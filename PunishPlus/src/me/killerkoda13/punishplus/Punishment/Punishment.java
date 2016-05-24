package me.killerkoda13.punishplus.Punishment;

/**
 * Created by Alex on 5/23/2016.
 */
public class Punishment {

    public String ipAddress;
    public String offender;
    public String UUID;
    public String message;
    public String Banning_Staff;
    public String duration;
    public String timeOfBan;
    public PunishmentType punishment;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBanningStaff() {
        return Banning_Staff;
    }

    public void setBanningStaff(String Staff) {
        this.Banning_Staff = Staff;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getPlayer() {
        return offender;
    }

    public void setPlayer(String offender) {
        this.offender = offender;
    }

    public String getTimeOfBan() {
        return timeOfBan;
    }

    public void setTimeOfBan(String time) {
        this.timeOfBan = time;
    }

    public PunishmentType getPunishment() {
        return punishment;
    }

    public void setPunishment(PunishmentType type) {
        this.punishment = type;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ip) {
        this.ipAddress = ip;
    }

    public void upload() {
    }

    public enum PunishmentType {
        PERMBAN, TEMPBAN, MUTE, KICK
    }
}
