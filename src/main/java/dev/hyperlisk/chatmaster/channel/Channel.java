package dev.hyperlisk.chatmaster.channel;

public enum Channel {

    GLOBAL("", "&a[GLOBAL] {NAME}:&8 {MESSAGE}"),
    STAFF("chatmaster.staff", "&1[STAFF] {NAME}:&8 {MESSAGE}"),
    DEV("chatmaster.dev", "&5[DEV] {NAME}:&8 {MESSAGE} ");

    private String permission, format;


    Channel(String permission, String format) {
        this.permission = permission;
        this.format = format;
    }

    public String getPermission() {
        return permission;
    }

    public String getFormat() {
        return format;
    }
}
