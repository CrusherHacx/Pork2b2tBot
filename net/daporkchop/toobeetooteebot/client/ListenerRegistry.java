/*
 * Decompiled with CFR 0_132.
 */
package net.daporkchop.toobeetooteebot.client;

import com.github.steveice10.mc.protocol.packet.MinecraftPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerBossBarPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerChatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerDisconnectPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerJoinGamePacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerPlayerListDataPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerPlayerListEntryPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerRespawnPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityAttachPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityCollectItemPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityDestroyPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityEffectPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityEquipmentPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityHeadLookPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityMetadataPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityMovementPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityPropertiesPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityRemoveEffectPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntitySetPassengersPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityTeleportPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityVelocityPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerVehicleMovePacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.player.ServerPlayerHealthPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.player.ServerPlayerPositionRotationPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.spawn.ServerSpawnMobPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.spawn.ServerSpawnObjectPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.spawn.ServerSpawnPaintingPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.spawn.ServerSpawnPlayerPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerBlockChangePacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerChunkDataPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerMultiBlockChangePacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerNotifyClientPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerUnloadChunkPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerUpdateTimePacket;
import com.github.steveice10.mc.protocol.packet.login.server.LoginSuccessPacket;
import com.github.steveice10.packetlib.Session;
import java.util.Hashtable;
import java.util.Map;
import net.daporkchop.toobeetooteebot.client.IPacketListener;
import net.daporkchop.toobeetooteebot.client.impl.ListenerBlockChangePacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerBossBarPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerChatPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerChunkDataPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerDisconnectPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerEntityAttachPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerEntityCollectItemPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerEntityDestroyPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerEntityEffectPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerEntityEquipmentPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerEntityHeadLookPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerEntityMetadataPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerEntityMovementPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerEntityPropertiesPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerEntityRemoveEffectPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerEntitySetPassengersPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerEntityTeleportPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerJoinGamePacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerLoginSuccessPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerMultiBlockChangePacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerNotifyClientPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerPlayerHealthPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerPlayerListDataPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerPlayerListEntryPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerPlayerPositionRotationPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerRespawnPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerSpawnMobPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerSpawnObjectPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerSpawnPaintingPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerSpawnPlayerPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerUnloadChunkPacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerUpdateTimePacket;
import net.daporkchop.toobeetooteebot.client.impl.ListenerVehicleMovePacket;

public class ListenerRegistry {
    private static final Map<Class<? extends MinecraftPacket>, IPacketListener> listeners = new Hashtable<Class<? extends MinecraftPacket>, IPacketListener>();

    public static void handlePacket(Session session, MinecraftPacket pck) {
        IPacketListener listener = listeners.get(pck.getClass());
        if (listener != null) {
            listener.handlePacket(session, pck);
        }
    }

    static {
        listeners.put(ServerChatPacket.class, new ListenerChatPacket());
        listeners.put(ServerPlayerHealthPacket.class, new ListenerPlayerHealthPacket());
        listeners.put(ServerPlayerListEntryPacket.class, new ListenerPlayerListEntryPacket());
        listeners.put(ServerPlayerListDataPacket.class, new ListenerPlayerListDataPacket());
        listeners.put(ServerPlayerPositionRotationPacket.class, new ListenerPlayerPositionRotationPacket());
        listeners.put(ServerChunkDataPacket.class, new ListenerChunkDataPacket());
        listeners.put(ServerUnloadChunkPacket.class, new ListenerUnloadChunkPacket());
        listeners.put(ServerUpdateTimePacket.class, new ListenerUpdateTimePacket());
        listeners.put(ServerBlockChangePacket.class, new ListenerBlockChangePacket());
        listeners.put(ServerMultiBlockChangePacket.class, new ListenerMultiBlockChangePacket());
        listeners.put(ServerJoinGamePacket.class, new ListenerJoinGamePacket());
        listeners.put(LoginSuccessPacket.class, new ListenerLoginSuccessPacket());
        listeners.put(ServerNotifyClientPacket.class, new ListenerNotifyClientPacket());
        listeners.put(ServerRespawnPacket.class, new ListenerRespawnPacket());
        listeners.put(ServerDisconnectPacket.class, new ListenerDisconnectPacket());
        listeners.put(ServerSpawnMobPacket.class, new ListenerSpawnMobPacket());
        listeners.put(ServerSpawnObjectPacket.class, new ListenerSpawnObjectPacket());
        listeners.put(ServerSpawnPaintingPacket.class, new ListenerSpawnPaintingPacket());
        listeners.put(ServerSpawnPlayerPacket.class, new ListenerSpawnPlayerPacket());
        listeners.put(ServerEntityDestroyPacket.class, new ListenerEntityDestroyPacket());
        listeners.put(ServerEntityAttachPacket.class, new ListenerEntityAttachPacket());
        listeners.put(ServerEntityCollectItemPacket.class, new ListenerEntityCollectItemPacket());
        listeners.put(ServerEntityEffectPacket.class, new ListenerEntityEffectPacket());
        listeners.put(ServerEntityEquipmentPacket.class, new ListenerEntityEquipmentPacket());
        listeners.put(ServerEntityHeadLookPacket.class, new ListenerEntityHeadLookPacket());
        listeners.put(ServerEntityMetadataPacket.class, new ListenerEntityMetadataPacket());
        listeners.put(ServerEntityMovementPacket.class, new ListenerEntityMovementPacket());
        listeners.put(ServerEntityMovementPacket.ServerEntityPositionPacket.class, new ListenerEntityMovementPacket());
        listeners.put(ServerEntityMovementPacket.ServerEntityRotationPacket.class, new ListenerEntityMovementPacket());
        listeners.put(ServerEntityMovementPacket.ServerEntityPositionRotationPacket.class, new ListenerEntityMovementPacket());
        listeners.put(ServerEntityPropertiesPacket.class, new ListenerEntityPropertiesPacket());
        listeners.put(ServerEntityRemoveEffectPacket.class, new ListenerEntityRemoveEffectPacket());
        listeners.put(ServerEntitySetPassengersPacket.class, new ListenerEntitySetPassengersPacket());
        listeners.put(ServerEntityTeleportPacket.class, new ListenerEntityTeleportPacket());
        listeners.put(ServerVehicleMovePacket.class, new ListenerVehicleMovePacket());
        listeners.put(ServerBossBarPacket.class, new ListenerBossBarPacket());
        listeners.put(ServerEntityVelocityPacket.class, new IPacketListener.IgnoreListener());
    }
}

