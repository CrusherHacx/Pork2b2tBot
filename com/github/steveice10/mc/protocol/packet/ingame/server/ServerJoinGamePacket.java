/*
 * Decompiled with CFR 0_132.
 */
package com.github.steveice10.mc.protocol.packet.ingame.server;

import com.github.steveice10.mc.protocol.data.MagicValues;
import com.github.steveice10.mc.protocol.data.game.entity.player.GameMode;
import com.github.steveice10.mc.protocol.data.game.setting.Difficulty;
import com.github.steveice10.mc.protocol.data.game.world.WorldType;
import com.github.steveice10.mc.protocol.packet.MinecraftPacket;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import java.io.IOException;

public class ServerJoinGamePacket
extends MinecraftPacket {
    public int entityId;
    public boolean hardcore;
    public GameMode gamemode;
    public int dimension;
    public Difficulty difficulty;
    public int maxPlayers;
    public WorldType worldType;
    public boolean reducedDebugInfo;

    public ServerJoinGamePacket() {
    }

    public ServerJoinGamePacket(int entityId, boolean hardcore, GameMode gamemode, int dimension, Difficulty difficulty, int maxPlayers, WorldType worldType, boolean reducedDebugInfo) {
        this.entityId = entityId;
        this.hardcore = hardcore;
        this.gamemode = gamemode;
        this.dimension = dimension;
        this.difficulty = difficulty;
        this.maxPlayers = maxPlayers;
        this.worldType = worldType;
        this.reducedDebugInfo = reducedDebugInfo;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public boolean getHardcore() {
        return this.hardcore;
    }

    public GameMode getGameMode() {
        return this.gamemode;
    }

    public int getDimension() {
        return this.dimension;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    public WorldType getWorldType() {
        return this.worldType;
    }

    public boolean getReducedDebugInfo() {
        return this.reducedDebugInfo;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.entityId = in.readInt();
        int gamemode = in.readUnsignedByte();
        this.hardcore = (gamemode & 8) == 8;
        this.gamemode = MagicValues.key(GameMode.class, gamemode &= -9);
        this.dimension = in.readInt();
        this.difficulty = MagicValues.key(Difficulty.class, in.readUnsignedByte());
        this.maxPlayers = in.readUnsignedByte();
        this.worldType = MagicValues.key(WorldType.class, in.readString().toLowerCase());
        this.reducedDebugInfo = in.readBoolean();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeInt(this.entityId);
        int gamemode = MagicValues.value(Integer.class, this.gamemode);
        if (this.hardcore) {
            gamemode |= 8;
        }
        out.writeByte(gamemode);
        out.writeInt(this.dimension);
        out.writeByte(MagicValues.value(Integer.class, (Object)this.difficulty));
        out.writeByte(this.maxPlayers);
        out.writeString(MagicValues.value(String.class, (Object)this.worldType));
        out.writeBoolean(this.reducedDebugInfo);
    }
}

