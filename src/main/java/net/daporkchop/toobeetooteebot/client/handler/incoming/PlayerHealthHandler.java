/*
 * Adapted from the Wizardry License
 *
 * Copyright (c) 2016-2019 DaPorkchop_
 *
 * Permission is hereby granted to any persons and/or organizations using this software to copy, modify, merge, publish, and distribute it.
 * Said persons and/or organizations are not allowed to use the software or any derivatives of the work for commercial use or any other means to generate income, nor are they allowed to claim this software as their own.
 *
 * The persons and/or organizations are also disallowed from sub-licensing and/or trademarking this software without explicit permission from DaPorkchop_.
 *
 * Any persons and/or organizations using this software must disclose their source code and have it publicly available, include this license, provide sufficient credit to the original authors of the project (IE: DaPorkchop_), as well as provide a link to the original project.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package net.daporkchop.toobeetooteebot.client.handler.incoming;

import com.github.steveice10.mc.protocol.data.game.ClientRequest;
import com.github.steveice10.mc.protocol.packet.ingame.client.ClientRequestPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.player.ServerPlayerHealthPacket;
import lombok.NonNull;
import net.daporkchop.toobeetooteebot.Bot;
import net.daporkchop.toobeetooteebot.client.PorkClientSession;
import net.daporkchop.toobeetooteebot.util.handler.HandlerRegistry;

/**
 * @author DaPorkchop_
 */
public class PlayerHealthHandler implements HandlerRegistry.IncomingHandler<ServerPlayerHealthPacket, PorkClientSession> {
    @Override
    public boolean apply(@NonNull ServerPlayerHealthPacket packet, @NonNull PorkClientSession session) {
        CACHE.getPlayerCache().getThePlayer()
                .setFood(packet.getFood())
                .setSaturation(packet.getSaturation())
                .setHealth(packet.getHealth());
        CACHE_LOG.debug("Player food: %d", packet.getFood())
                .debug("Player saturation: %f", packet.getSaturation())
                .debug("Player health: %f", packet.getHealth());
        if (packet.getHealth() <= 0 && CONFIG.getBoolean("client.extra.autorespawn.enabled"))  {
            new Thread(() -> {
                try {
                    Thread.sleep(CONFIG.getInt("client.extra.autorespawn.delay", 100));
                } catch (InterruptedException e)    {
                    Thread.currentThread().interrupt();
                }
                if (Bot.getInstance().isConnected() && CACHE.getPlayerCache().getThePlayer().getHealth() <= 0)    {
                    CACHE.getChunkCache().reset(true); //i don't think this is needed, but it can't hurt
                    Bot.getInstance().getClient().getSession().send(new ClientRequestPacket(ClientRequest.RESPAWN));
                }
            }).start();
        }
        return true;
    }

    @Override
    public Class<ServerPlayerHealthPacket> getPacketClass() {
        return ServerPlayerHealthPacket.class;
    }
}
