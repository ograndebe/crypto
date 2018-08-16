package com.github.ograndebe.crypto;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Criptografador {
    public static void main (String[] args) {
        if (args.length != 2) {
            System.out.println("Numero invalido de argumentos, 1:O QUE SERA CRIPTOGRAFADO 2:CHAVE");
            System.exit(-1);
        }
        final String resultado = new Criptografador().criptografar(args[0], args[1]);
        System.out.println(resultado);
    }

    public String criptografar(String string, String key) {
        return hmacsha256(string, key);
    }

    public String hmacsha256(String stringToSign , String key ){
        try {
            byte[] bytes = encode256 ( key .getBytes( "UTF-8" ), stringToSign .getBytes( "UTF-8" ));
            return Base64.encodeBase64String( bytes );
        } catch (Exception  e ){
            throw new RuntimeException( e );
        }
    }
    private static byte[] encode256(byte[]keyBytes, byte[] text ) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac hmacSha1 ;
        try {
            hmacSha1 = Mac.getInstance ( "HmacSHA256" );
        } catch (NoSuchAlgorithmException  nsae ){
            hmacSha1 = Mac.getInstance ( "HMAC-SHA-256" );
        }
        SecretKeySpec macKey = new SecretKeySpec( keyBytes, "RAW" );
        hmacSha1.init( macKey );
        return hmacSha1 .doFinal( text );
    }

}
