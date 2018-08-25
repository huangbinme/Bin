package com.encryption;

import org.junit.Assert;
import org.junit.Test;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

public class RSATest {

    @Test
    public void createKeys() {
        Map<String,String> map = RSA.createKeys(1024);
        System.out.println(map.get("publicKey"));
        System.out.println(map.get("privateKey"));
    }

    @Test
    public void publicEncrypt() throws Exception{
        Map<String,String> map = RSA.createKeys(1024);
        RSAPublicKey rsaPublicKey = RSA.getPublicKey(map.get("publicKey"));
        System.out.println(RSA.publicEncrypt("HELLO!",rsaPublicKey));
    }

    @Test
    public void privateDecrypt() throws Exception{
        Map<String,String> map = RSA.createKeys(1024);
        RSAPublicKey rsaPublicKey = RSA.getPublicKey(map.get("publicKey"));
        String inputStr = "dfasdfasdfasdfasdasdfsdfsdffffffffffffffffffffffffffffffff!";
        String encryStr = RSA.publicEncrypt(inputStr,rsaPublicKey);
        RSAPrivateKey rsaPrivateKey = RSA.getPrivateKey(map.get("privateKey"));
        String decryStr = RSA.privateDecrypt(encryStr,rsaPrivateKey);
        Assert.assertEquals(decryStr,inputStr);
    }

    @Test
    public void privateEncrypt()  throws Exception{
        Map<String,String> map = RSA.createKeys(1024);
        RSAPrivateKey rSAPrivateKey = RSA.getPrivateKey(map.get("privateKey"));
        System.out.println(RSA.privateEncrypt("HELLO!",rSAPrivateKey));
    }

    @Test
    public void publicDecrypt() throws Exception{
        Map<String,String> map = RSA.createKeys(1024);
        RSAPrivateKey rSAPrivateKey = RSA.getPrivateKey(map.get("privateKey"));
        String inputStr = "dfasdfasdfasdfasdasdfsdfsdffffffffffffffffffffffffffffffff!";
        String encryStr = RSA.privateEncrypt(inputStr,rSAPrivateKey);
        RSAPublicKey rsaPublicKey = RSA.getPublicKey(map.get("publicKey"));
        String decryStr = RSA.publicDecrypt(encryStr,rsaPublicKey);
        Assert.assertEquals(decryStr,inputStr);
    }
}