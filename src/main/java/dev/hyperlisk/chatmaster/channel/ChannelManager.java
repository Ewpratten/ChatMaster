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

        /**
         * TODO: Change to the on join event instead of doing it here
         */
        if(!this.playerChannels.containsKey(uuid)) {
            setChannel(uuid, Channel.GLOBAL);
        }
        return this.playerChannels.get(uuid);
    }


}
