package com.example.helloworld;

import javacard.framework.*;

public class HelloWorldApplet extends Applet {

    private static final byte[] HELLO_WORLD = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'};
    private static final byte INS_HELLO = (byte) 0x01;

    protected HelloWorldApplet() {
        register();
    }

    public static void install(byte[] bArray, short bOffset, byte bLength) {
        new HelloWorldApplet();
    }

    public void process(APDU apdu) {
        byte[] buffer = apdu.getBuffer();
        if (selectingApplet()) {
            return;
        }

        if (buffer[ISO7816.OFFSET_INS] == INS_HELLO) {
            Util.arrayCopyNonAtomic(HELLO_WORLD, (short) 0, buffer, (short) 0, (short) HELLO_WORLD.length);
            apdu.setOutgoingAndSend((short) 0, (short) HELLO_WORLD.length);
        } else {
            ISOException.throwIt(ISO7816.SW_INS_NOT_SUPPORTED);
        }
    }
}
