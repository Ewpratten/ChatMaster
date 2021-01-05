package dev.hyperlisk.chatmaster.util;

public enum Colours {

    RED("&4"), BLUE("&1"), PURPLE("&5");

    private String spigotCode;

    Colours(String spigotCode) {
        this.spigotCode = spigotCode;
    }

    public String getSpigotCode() {
        return spigotCode;
    }
}
