/*
 * MIT License
 *
 * Copyright (c) 2017 Pim van den Berg
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package nl.pvdberg.pnet.event;

import nl.pvdberg.pnet.client.Client;
import nl.pvdberg.pnet.packet.Packet;

import java.io.IOException;

public interface PNetListener
{
    /**
     * Called when a connection is made
     * @param c Connected Client
     */
    void onConnect(final Client c);

    /**
     * Called when a connection is lost
     * @param c Lost Client
     */
    void onDisconnect(final Client c);

    /**
     * Called when a new Packet has been received. May throw a caught and silenced IOException
     * @param p New Packet
     * @param c Sender
     * @throws IOException when anything goes wrong during data extraction. This exception is caught because invalid Packets should not crash the Client or Server
     */
    void onReceive(final Packet p, final Client c) throws IOException;
}