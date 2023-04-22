package com.tomlavalord.pokemon;

public enum Elements {
    WATER("💧"),FIRE("🔥"),GRASS("🍃"),POISON("☠"),FIGHTING("✊"),
    PSYCHIC("👁"),DRAGON("🐉"),GHOST("👻"),GROUND("⛰"),ROCK("💎"),
    ICE("❄"),NORMAL("✶"),BUG("🐛"),ELECTRIC("⚡"),FLYING("☁");

    private final String icon;
    Elements(String icon){
        this.icon = icon;
    }
    public String toString(){
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
    public String iconToString(){
        return icon;
    }
}
