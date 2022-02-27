package xyz.neziw.titleapi.api.event;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TimedActionbarSendEvent extends Event {

    @Getter
    private static final HandlerList handlers = new HandlerList();
    @Getter
    private final Player player;
    @Getter
    private String message;
    @Getter
    private int duration;
    @Getter
    @Setter
    private boolean cancelled = false;

    public TimedActionbarSendEvent(Player player, String message, int duration) {
        this.player = player;
        this.message = message;
        this.duration = duration;
    }
}
