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

package nl.pvdberg.pnet.packet

import nl.pvdberg.pnet.KPacketBuilder
import nl.pvdberg.pnet.KPacketReader
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

class KPacketTest : PacketBuilderReaderTest()
{
    @Test
    override fun buildAndRead()
    {
        val packet = KPacketBuilder.build(TYPE)
        {
            withID(ID)
            withBoolean(BOOLEAN)
            withByte(BYTE)
            withBytes(BYTES)
            withDouble(DOUBLE)
            withFloat(FLOAT)
            withInt(INT)
            withLong(LONG)
            withShort(SHORT)
            withString(STRING)
        }

        KPacketReader.read(packet)
        {
            assertEquals(ID, packetID)
            assertEquals(BOOLEAN, readBoolean())
            assertEquals(BYTE, readByte())
            assertArrayEquals(BYTES, readBytes())
            assertEquals(DOUBLE, readDouble(), 0.0001)
            assertEquals(FLOAT, readFloat(), 0.0001f)
            assertEquals(INT, readInt())
            assertEquals(LONG, readLong())
            assertEquals(SHORT, readShort())
            assertEquals(STRING, readString())
        }
    }
}