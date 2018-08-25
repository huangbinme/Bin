package com.encryption;

import org.junit.Test;

public class DESTest {

    @Test
    public void encrypt() {
        String str = "cryptology";
        //This password is private key
        String password = "95880288";
        byte[] result = DES.encrypt(str.getBytes(),password);
        System.out.println("加密后："+new String(result));
    }

    @Test
    public void decrypt() throws Exception{
        String str = "cryptology";
        //This password is private key same as the password when process encrypt.
        String password = "95880288";
        byte[] decryResult = DES.decrypt(DES.encrypt(str.getBytes(),password), password);
        System.out.println("解密后："+new String(decryResult));

    }
}