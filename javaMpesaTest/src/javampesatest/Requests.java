/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javampesatest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author DEVWK008
 */
public class Requests implements Constants{
    
        public JSONObject LNMORequest(String phoneNumber){
            JSONObject requestBody = new JSONObject();
            try {
                FreqMethods tokenR = new FreqMethods();
                String token = tokenR.authTokenGen().getString("access_token");
                String header1 = POSTHEADER1+token;
                
                String xRequest = "{\"BusinessShortCode\":"+BSS_CODE+",\"Password\":\""
                        + tokenR.passKeyEncode()+"\",\"Timestamp\":\""+ tokenR.timestampGen()
                        +"\",\"TransactionType\":\""+"CustomerPayBillOnline\",\"Amount\":"
                        +AMT+",\"PartyA\":"+ phoneNumber+",\"PartyB\":"+BSS_CODE+",\"PhoneNumber\":"
                        + phoneNumber+",\"CallBackURL\":\""+ LNMOCALLBACK_URL+"\",\"AccountReference\":\""
                        +ACC_REF+"\",\"TransactionDesc\":\""+TRANS_DESC+"\"}";
                
                HttpReqs postR = new HttpReqs();
                requestBody = postR.postResponse(LNMO_INITIATE_URL, header1, POSTHEADER2, xRequest);
                String deres = requestBody.toString();
                System.out.println(deres);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | JSONException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
            return requestBody;
        }
        
        public JSONObject tokenGen(){
            JSONObject tkResponse = new JSONObject();
            try {
                FreqMethods tk = new FreqMethods();
                tkResponse = tk.authTokenGen();
                System.out.print(tkResponse);
            } catch (IOException | JSONException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tkResponse;
        }
        
        public JSONObject LNMOQuery(String transAcid){
            JSONObject lnmoqObject = new JSONObject();
            try {
                FreqMethods lnmoqR = new FreqMethods();
                String token = lnmoqR.authTokenGen().getString("access_token");
                String pass = lnmoqR.passKeyEncode();
                String timstmp = lnmoqR.timestampGen();
                String header1 = POSTHEADER1+token;
                
                String b2cReq =  "{\"BusinessShortCode\":\""+BSS_CODE+"\",\"Password\":\""
                        +pass+"\",\"Timestamp\":\""+timstmp+"\",\"CheckoutRequestID\":\""
                        +transAcid+"\"}";
                
                HttpReqs b2chtR = new HttpReqs();
                lnmoqObject =b2chtR.postResponse(LNMO_STATUREQ_URL, header1, POSTHEADER2, b2cReq);
                String deres = lnmoqObject.toString();
                System.out.println(deres);
            } catch (IOException | JSONException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lnmoqObject;
        }
        
        public JSONObject reverseRequest(String transACID){
            JSONObject reverseObj = new JSONObject();
            try {
                FreqMethods revR = new FreqMethods();
                String tk3 = revR.authTokenGen().getString("access_token");
                String header1 = POSTHEADER1+tk3;
                String scCr= FreqMethods.secCredGen(FILEPATH,SEC_CRED_SC1);
                
                String revReq =  "{\"Initiator\":\""+INITIATOR_SC1+"\",\"SecurityCredential\":\""
                        +scCr+"\",\"CommandID\":\""+TREV_ID+"\",\"TransactionID\":\""
                        +transACID+"\",\"Amount\":\""+AMT+"\",\"ReceiverParty\":\""
                        +NON_LNMO_SHORTCODE1+"\",\"RecieverIdentifierType\":\""
                        +"11"+"\",\"ResultURL\":\""+RESULT_URL+"\",\"QueueTimeOutURL\":\""
                        +CLBK_URL+"\",\"Remarks\":\""+RMKS+"\",\"Occasion\":\""
                        +OCCASS+"\"}";
                
                HttpReqs b2chtR = new HttpReqs();
                reverseObj =b2chtR.postResponse(REVERS_URL, header1, POSTHEADER2, revReq);
                String deres = reverseObj.toString();
                System.out.println(deres);
            } catch (IOException | JSONException | NoSuchAlgorithmException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
            return reverseObj;
        }
        
        public JSONObject transactionStatus(String transACID, String phoneNumber){
            JSONObject statusObj = new JSONObject();
            try {
                FreqMethods transtatR = new FreqMethods();
                String tk2 = transtatR.authTokenGen().getString("access_token");
                String header1 = POSTHEADER1+tk2;
                String scC= FreqMethods.secCredGen(FILEPATH,SEC_CRED_SC1);
                
                String transtatReq =  "{\"Initiator\":\""+INITIATOR_SC1+"\",\"SecurityCredential\":\""
                        +scC+"\",\"CommandID\":\""+TSQ_ID+"\",\"TransactionID\":\""
                        +transACID+"\",\"PartyA\":\""+phoneNumber+"\",\"IdentifierType\":\""
                        +PHONENO+"\",\"ResultURL\":\""+RESULT_URL+"\",\"QueueTimeOutURL\":\""
                        +CLBK_URL+"\",\"Remarks\":\""+RMKS+"\",\"Occasion\":\""
                        +OCCASS+"\"}";
                HttpReqs b2chtR = new HttpReqs();
                statusObj =b2chtR.postResponse(TRANSTATUS_URL, header1, POSTHEADER2, transtatReq);
                String deres = statusObj.toString();
                System.out.println(deres);
            } catch (IOException | JSONException | NoSuchAlgorithmException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
            return statusObj;
        }
        
        public JSONObject accbalRequest(){
            JSONObject balObj = new JSONObject();
            try {
                FreqMethods acbalR = new FreqMethods();
                String tk1 = acbalR.authTokenGen().getString("access_token");
                String header1 = POSTHEADER1+tk1;
                
                String sc = FreqMethods.secCredGen(FILEPATH,SEC_CRED_SC1);
                
                String acbalReq =  "{\"Initiator\":\""+INITIATOR_SC1+"\",\"SecurityCredential\":\""
                        +sc+"\",\"CommandID\":\""+ACCBAL_ID+"\",\"PartyA\":\""+NON_LNMO_SHORTCODE1
                        +"\",\"IdentifierType\":\""+SHORTCODE+"\",\"Remarks\":\""
                        +RMKS+"\",\"QueueTimeOutURL\":\""+CLBK_URL+"\",\"ResultURL\":\""
                        +RESULT_URL+"\"}";
                
                HttpReqs b2chtR = new HttpReqs();
                balObj =b2chtR.postResponse(ACC_BAL_URL, header1, POSTHEADER2, acbalReq);
                String deres = balObj.toString();
                System.out.println(deres);
            } catch (IOException | JSONException | NoSuchAlgorithmException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
            return balObj;
        }
        
        public JSONObject c2bSimulate(String phoneNumber){
            JSONObject simObj = new JSONObject();
            try {
                FreqMethods c2bSim = new FreqMethods();
                String tk0 = c2bSim.authTokenGen().getString("access_token");
                String header1 = POSTHEADER1+tk0;
                
                String c2bSimReq =  "{\"ShortCode\":\""+BSS_CODE+"\",\"CommandID\":\""
                        +CPBO_ID+"\",\"Amount\":\""+AMT+"\",\"Msisdn\":\""+phoneNumber
                        +"\",\"BillRefNumber\":\""+RMKS+"\"}";
                
                HttpReqs b2chtR = new HttpReqs();
                simObj =b2chtR.postResponse(C2B_SIM_URL, header1, POSTHEADER2, c2bSimReq);
                String deres = simObj.toString();
                System.out.println(deres);
            } catch (IOException | JSONException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
            return simObj;
        }
        
        public JSONObject c2bRegistration(){
            JSONObject c2bregObj = new JSONObject();
            try {
                FreqMethods c2brR = new FreqMethods();
                String token = c2brR.authTokenGen().getString("access_token");
                String header1 = POSTHEADER1+token;
                
                String c2brReq =  "{\"ShortCode\":\""+NON_LNMO_SHORTCODE1+"\",\"ResponseType\":\"Cancelled\",\"ConfirmationURL\":\""+CONFIRM_URL+"\",\"ValidationURL\":\""
                        +VALID_URL+"\"}";
                
                HttpReqs c2brhtR = new HttpReqs();
                c2bregObj =c2brhtR.postResponse(C2B_REG_URL, header1, POSTHEADER2, c2brReq);
                String deres = c2bregObj.toString();
                System.out.println(deres);
            } catch (IOException | JSONException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
            return c2bregObj;
        }
        
        public JSONObject b2bRequest(String shortCode){
            JSONObject b2bObj = new JSONObject();
            try {
                FreqMethods b2bR = new FreqMethods();
                String tok1 = b2bR.authTokenGen().getString("access_token");
                String header1 = POSTHEADER1+tok1;
                
                String secCreden = FreqMethods.secCredGen(FILEPATH,SEC_CRED_SC1);
                String b2bReq =  "{\"Initiator\":\""+INITIATOR_SC1+"\",\"SecurityCredential\":\""+secCreden
                        +"\",\"CommandID\":\""+BTB_ID+"\",\"SenderIdentifierType\":\""+SHORTCODE
                        +"\",\"RecieverIdentifierType\":\""+SHORTCODE+"\",\"Amount\":\""+AMT+"\",\"PartyA\":\""
                        +NON_LNMO_SHORTCODE1+"\",\"PartyB\":\""+shortCode+"\",\"AccountReference\":\""
                        +ACC_REF+"\",\"Remarks\":\""+RMKS+"\",\"QueueTimeOutURL\":\""+CLBK_URL+"\",\"ResultURL\":\""+RESULT_URL+"\"}";
                
                HttpReqs b2bhtR = new HttpReqs();
                b2bObj =b2bhtR.postResponse(B2B_REQ_URL, header1, POSTHEADER2, b2bReq);
                String deres = b2bObj.toString();
                System.out.println(deres);
            } catch (IOException | JSONException | NoSuchAlgorithmException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
            return b2bObj;
        }
                
        public JSONObject b2cRequest(String phoneNumber){
            JSONObject b2cObj = new JSONObject();
            try {
                FreqMethods b2cR = new FreqMethods();
                String token = b2cR.authTokenGen().getString("access_token");
                String header1 = POSTHEADER1+token;
                                
                String securityCreden = FreqMethods.secCredGen(FILEPATH,SEC_CRED_SC1);
                
                String b2cReq =  "{\"InitiatorName\":\""+INITIATOR_SC1+"\",\"SecurityCredential\": \""+securityCreden
                        +"\",\"CommandID\": \""+BSPAY_ID+"\",\"Amount\":\""+AMT+"\",\"PartyA\": \""
                        +NON_LNMO_SHORTCODE1+"\",\"PartyB\": \""+phoneNumber+"\",\"Remarks\": \""+RMKS+"\",\"QueueTimeOutURL\": \""+B2CRESULT_URL
                        +"\",\"ResultURL\":\""+B2CRESULT_URL+"\",\"Occassion\": \""+OCCASS+"\"}";
                
                HttpReqs b2chtR = new HttpReqs();
                b2cObj =b2chtR.postResponse(B2C_REQ_URL, header1, POSTHEADER2, b2cReq);
                String deres = b2cObj.toString();
                System.out.println(deres);
            } catch (IOException | JSONException | NoSuchAlgorithmException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
            return b2cObj;
        }
        
        public JSONObject callbackTest(){
            JSONObject tstResponse = new JSONObject();
            try {
                String testHeader1 = "TestHeader1", testHeader2 = "TestHeader2";
                HttpReqs htr = new HttpReqs();
                //String testReq = "{\"Item1\", \"TestItem Orange\"\"Item2\", \"TestItem Banana\"\"Item3\", \"TestItem Mango\"\"Item4\", \"TestItem Ruby\"\"Item5\", \"TestItem Jet\"}";
                JSONObject tstObj = new JSONObject();
                tstObj.put("Item1", "TestItem Orange");
                tstObj.put("Item2", "TestItem Banana");
                tstObj.put("Item3", "TestItem Mango");
                tstObj.put("Item4", "TestItem Ruby");
                tstObj.put("Item5", "TestItem Jet");
                String testReq1 = tstObj.toString();
                
                tstResponse = htr.postResponse(CLBK_URL, POSTHEADER1+testHeader1, POSTHEADER2, testReq1);
                String deres = tstResponse.toString();
                System.out.println(deres);
            } catch (JSONException | IOException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tstResponse;
        }
}
