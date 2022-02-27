package xyz.neziw.titleapi.api.event;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ActionbarSendEvent extends Event {

    @Getter
    private static final HandlerList handlers = new HandlerList();
    @Getter
    private final Player player;
    @Getter
    private String message;
    @Getter
    @Setter
    private boolean cancelled = false;

    public ActionbarSendEvent(Player player, String message) {
        this.player = player;
        this.message = message;
    }
}
