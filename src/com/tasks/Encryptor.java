package com.tasks;

/**
 * Created by sir.viters on 20.09.2016.
 */
class Encryptor {

    private byte[] key;

    Encryptor(String key) {
        if (key.length() == 0)
            throw new IllegalArgumentException("Please provide a security key.");
        this.key = key.getBytes();
    }

    String Crypt(String data) {
        final byte[] output = new byte[data.length()];

        for (int inPos = 0, keyPos = 0; inPos < data.length(); inPos++) {
            output[inPos] = (byte) (data.charAt(inPos) ^ this.key[keyPos]);
            keyPos = ++keyPos % this.key.length;
        }

        return new String(output);
    }
}
