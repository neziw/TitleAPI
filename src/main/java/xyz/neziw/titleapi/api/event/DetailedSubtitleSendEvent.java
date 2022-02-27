package xyz.neziw.titleapi.api.event;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DetailedSubtitleSendEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    @Getter
    private final Player player;
    @Getter
    private String message;
    @Getter
    private int fadein;
    @Getter
    private int stayin;
    @Getter
    private int fadeout;
    @Getter
    @Setter
    private boolean cancelled = false;

    public DetailedSubtitleSendEvent(Player player, String message, int fadein, int stayin, int fadeout) {
        this.player = player;
        this.message = message;
        this.fadein = fadein;
        this.stayin = stayin;
        this.fadeout = fadeout;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
