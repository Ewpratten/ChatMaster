package dev.hyperlisk.chatmaster.channel;

import java.util.ArrayList;
import java.util.List;

public enum Channel {

    GLOBAL("", "&a[GLOBAL] {NAME}:&8 {MESSAGE}", "global"),
    STAFF("chatmaster.staff", "&1[STAFF] {NAME}:&8 {MESSAGE}", "staff"),
    DEV("chatmaster.dev", "&5[DEV] {NAME}:&8 {MESSAGE}", "dev");

    private String permission, format, channelName;


    Channel(String permission, String format, String channelName) {
        this.permission = permission;
        this.format = format;
        this.channelName = channelName;
    }

    public String getPermission() {
        return permission;
    }

    public String getFormat() {
        return format;
    }

    public String getChannelName(){ return channelName;}

}
