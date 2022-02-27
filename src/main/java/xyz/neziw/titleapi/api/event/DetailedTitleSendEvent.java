package xyz.neziw.titleapi.api.event;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class DetailedTitleSendEvent {

    @Getter
    private static final HandlerList handlers = new HandlerList();
    @Getter
    private final Player player;
    @Getter
    private String title;
    @Getter
    private String subtitle;
    @Getter
    private int fadein;
    @Getter
    private int stayin;
    @Getter
    private int fadeout;
    @Getter
    @Setter
    private boolean cancelled = false;

    public DetailedTitleSendEvent(Player player, String title, String subtitle, int fadein, int stayin, int fadeout) {
        this.player = player;
        this.title = title;
        this.subtitle = title;
        this.fadein = fadein;
        this.stayin = stayin;
        this.fadeout = fadeout;
    }
}
