package org.jboss.netty.handler.codec.socks;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.handler.codec.socks.SocksMessage.AddressType;
import org.jboss.netty.handler.codec.socks.SocksMessage.CmdStatus;
import org.jboss.netty.handler.codec.socks.SocksResponse.SocksResponseType;

public final class SocksCmdResponse extends SocksResponse {
    private static final byte[] IPv4_HOSTNAME_ZEROED = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0};
    private static final byte[] IPv6_HOSTNAME_ZEROED = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
    private final AddressType addressType;
    private final CmdStatus cmdStatus;

    public SocksCmdResponse(CmdStatus cmdStatus, AddressType addressType) {
        super(SocksResponseType.CMD);
        if (cmdStatus == null) {
            throw new NullPointerException("cmdStatus");
        } else if (addressType == null) {
            throw new NullPointerException("addressType");
        } else {
            this.cmdStatus = cmdStatus;
            this.addressType = addressType;
        }
    }

    public CmdStatus getCmdStatus() {
        return this.cmdStatus;
    }

    public AddressType getAddressType() {
        return this.addressType;
    }

    public void encodeAsByteBuf(ChannelBuffer channelBuffer) {
        channelBuffer.writeByte(getProtocolVersion().getByteValue());
        channelBuffer.writeByte(this.cmdStatus.getByteValue());
        channelBuffer.writeByte(0);
        channelBuffer.writeByte(this.addressType.getByteValue());
        switch (this.addressType) {
            case IPv4:
                channelBuffer.writeBytes(IPv4_HOSTNAME_ZEROED);
                channelBuffer.writeShort(0);
                return;
            case DOMAIN:
                channelBuffer.writeByte(1);
                channelBuffer.writeByte(0);
                channelBuffer.writeShort(0);
                return;
            case IPv6:
                channelBuffer.writeBytes(IPv6_HOSTNAME_ZEROED);
                channelBuffer.writeShort(0);
                return;
            default:
                return;
        }
    }
}
