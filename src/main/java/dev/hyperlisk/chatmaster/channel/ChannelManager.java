package dev.hyperlisk.chatmaster.channel;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ChannelManager {

    private Map<UUID, Channel> playerChannels = new HashMap<UUID, Channel>();

    public void setChannel(UUID uuid, Channel channel) {
        this.playerChannels.put(uuid, channel);
    }

    public Channel getChannel(UUID uuid) {
        return this.playerChannels.get(uuid);
    }

    public Channel returnChannel(String channelName) {
        Channel channel = Channel.GLOBAL;
        for (Channel c : Channel.values()) {
            if(c.getChannelName() == channelName) {
                channel = c;
            }
        }
        return channel;

    }

}
