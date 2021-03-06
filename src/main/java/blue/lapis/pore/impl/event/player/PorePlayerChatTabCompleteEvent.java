/*
 * PoreRT - A Bukkit to Sponge Bridge
 *
 * Copyright (c) 2016-2017, Maxqia <https://github.com/Maxqia> AGPLv3
 * Copyright (c) 2014-2016, Lapis <https://github.com/LapisBlue> MIT
 * Copyright (c) Contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * An exception applies to this license, see the LICENSE file in the main directory for more information.
 */

package blue.lapis.pore.impl.event.player;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.event.PoreEvent;
import blue.lapis.pore.event.RegisterEvent;
import blue.lapis.pore.event.Source;
import blue.lapis.pore.impl.entity.PorePlayer;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.command.TabCompleteEvent;

import java.util.Collection;
import java.util.Collections;

@RegisterEvent
public final class PorePlayerChatTabCompleteEvent extends PlayerChatTabCompleteEvent
        implements PoreEvent<TabCompleteEvent.Chat> {

    private final TabCompleteEvent.Chat handle;
    private final Player source;

    public PorePlayerChatTabCompleteEvent(TabCompleteEvent.Chat handle, @Source Player source) {
        super(null, "", Collections.<String>emptyList());
        this.handle = checkNotNull(handle, "handle");
        this.source = checkNotNull(source, "source");
    }

    @Override
    public TabCompleteEvent.Chat getHandle() {
        return handle;
    }

    @Override
    public org.bukkit.entity.Player getPlayer() {
        return PorePlayer.of(source);
    }

    @Override
    public String getChatMessage() {
        return getHandle().getRawMessage();
    }

    @Override
    public String getLastToken() {
        return StringUtils.substringAfterLast(getChatMessage(), " ");
    }

    @Override
    public Collection<String> getTabCompletions() {
        return getHandle().getTabCompletions();
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }

}
