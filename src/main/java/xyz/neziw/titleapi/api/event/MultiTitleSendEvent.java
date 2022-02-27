package xyz.neziw.titleapi.api.event;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MultiTitleSendEvent extends Event {

    @Getter
    private static final HandlerList handlers = new HandlerList();
    @Getter
    private final Player player;
    @Getter
    private String title;
    @Getter
    private String subtitle;
    @Getter
    @Setter
    private boolean cancelled = false;

    public MultiTitleSendEvent(Player player, String title, String subtitle) {
        this.player = player;
        this.title = title;
        this.subtitle = title;
    }
}
