/*
 * Decompiled with CFR 0_132.
 */
package net.daporkchop.toobeetooteebot.server;

import com.github.steveice10.packetlib.Session;

public class PorkClient {
    public Session session;
    public boolean loggedIn = false;
    public boolean sentChunks = false;
    public boolean setInitialPosition = false;
    public int arrayIndex;
    public String username;

    public PorkClient(Session session, int arrayIndex) {
        this.session = session;
        this.arrayIndex = arrayIndex;
    }
}

