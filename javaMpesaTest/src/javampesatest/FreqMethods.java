/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javampesatest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author DEVWK008
 */
public class FreqMethods implements Constants{
    public String timestampGen(){
        //format yyyymmddhhiiss
        Date curr_date = new Date();
        curr_date.setTime(curr_date.getTime());
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(curr_date);
        return timeStamp;
    }
    
    public String passKeyEncode() throws UnsupportedEncodingException{
        String ts = this.timestampGen();
        String passkey=BSS_CODE+PASSKEY+ts;
        byte[] testByte = Base64.getEncoder().encode(passkey.getBytes(BASE64_ENC));
        String Passwd = new String(testByte);
        return Passwd;
    }
    
    public String authEncode() throws UnsupportedEncodingException{
        String appkeySecret = CONSKEY+":"+CONSECRET;
        byte[] mpsByte = Base64.getEncoder().encode(appkeySecret.getBytes(BASE64_ENC));
        String Auth = new String(mpsByte);
        return Auth;
    }
    
    public JSONObject authTokenGen() throws IOException, JSONException{
        String auth_encoded = this.authEncode();
        String header1 = GETHEADER1+auth_encoded;
        HttpReqs gr = new HttpReqs();
        JSONObject obj = gr.getResponse(MP_AUTH_GEN_URL, header1, GETHEADER2);
        return obj;
        
    }
    
    public static String secCredGen(String secCert, String iniPass) throws NoSuchAlgorithmException{
        String encryptedPass="";
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            byte[] input = iniPass.getBytes();
            Cipher cypher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
            FileInputStream fin = new FileInputStream(new File(secCert));
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate certificate = (X509Certificate) cf.generateCertificate(fin);
            PublicKey pk = certificate.getPublicKey();
            cypher.init(Cipher.ENCRYPT_MODE, pk);

        byte[] cipherText = cypher.doFinal(input);
        
        encryptedPass = Base64.getEncoder().encodeToString(cipherText);
        
           
        } catch (NoSuchProviderException | NoSuchPaddingException | CertificateException | FileNotFoundException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException ex) {
            Logger.getLogger(FreqMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encryptedPass;
    }
    
}
