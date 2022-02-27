package xyz.neziw.titleapi.api.event;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BroadcastActionbarEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    @Getter
    private String message;
    @Getter
    @Setter
    private boolean cancelled = false;

    public BroadcastActionbarEvent(String message) {
        this.message = message;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
