package xyz.neziw.titleapi.api.event;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BroadcastSubtitleEvent extends Event {

    @Getter
    private static final HandlerList handlers = new HandlerList();
    @Getter
    private String message;
    @Getter
    @Setter
    private boolean cancelled = false;

    public BroadcastSubtitleEvent(String message) {
        this.message = message;
    }
}
