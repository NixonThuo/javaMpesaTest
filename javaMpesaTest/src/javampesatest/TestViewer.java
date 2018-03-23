/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javampesatest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import javax.swing.*;

/**
 *
 * @author DEVWK008
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DEVWK008
 */
public class TestViewer extends JFrame implements Constants{

public TestViewer() throws IOException, JSONException{
        initComponents();
        Btn_LnmO.addActionListener((ActionEvent e) -> {
            try {
                FreqMethods tokenR = new FreqMethods();
                String token = tokenR.authTokenGen().getString("access_token");
                String header1 = POSTHEADER1+token;
                
                String xRequest = "{\"BusinessShortCode\":"+BSS_CODE+",\"Password\":\""
                        + tokenR.passKeyEncode()+"\",\"Timestamp\":\""+ tokenR.timestampGen()
                        +"\",\"TransactionType\":\""+"CustomerPayBillOnline\",\"Amount\":"
                        +AMT+",\"PartyA\":"+ TSTPHONE+",\"PartyB\":"+BSS_CODE+",\"PhoneNumber\":"
                        + TSTPHONE+",\"CallBackURL\":\""+ CLBK_URL+"\",\"AccountReference\":\""
                        +ACC_REF+"\",\"TransactionDesc\":\""+TRANS_DESC+"\"}";
                
                HttpReqs postR = new HttpReqs();
                JSONObject requestBody = postR.postResponse(LNMO_INITIATE_URL, header1, POSTHEADER2, xRequest);
                String deres = requestBody.toString();
                jTextArea1.setText(deres);
                System.out.println(deres);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | JSONException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Btn_tokenGen.addActionListener((ActionEvent e) -> {
            try {
                FreqMethods tk = new FreqMethods();
                String tkResponse = tk.authTokenGen().toString();
                jTextArea1.setText(tkResponse);
                System.out.print(tkResponse);
            } catch (IOException | JSONException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Btn_Lnmo_q.addActionListener((ActionEvent e) -> {
            try {
                FreqMethods lnmoqR = new FreqMethods();
                String token = lnmoqR.authTokenGen().getString("access_token");
                String pass = lnmoqR.passKeyEncode();
                String timstmp = lnmoqR.timestampGen();
                String header1 = POSTHEADER1+token;
                
                String b2cReq =  "{\"BusinessShortCode\":\""+BSS_CODE+"\",\"Password\":\""
                        +pass+"\",\"Timestamp\":\""+timstmp+"\",\"CheckoutRequestID\":\""
                        +TRANSACID+"\"}";
                
                HttpReqs b2chtR = new HttpReqs();
                JSONObject requestBody =b2chtR.postResponse(LNMO_STATUREQ_URL, header1, POSTHEADER2, b2cReq);
                String deres = requestBody.toString();
                jTextArea1.setText(deres);
                System.out.println(deres);
            } catch (IOException | JSONException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Btn_reverse.addActionListener((ActionEvent e) -> {
            try {
                FreqMethods revR = new FreqMethods();
                String tk3 = revR.authTokenGen().getString("access_token");
                String header1 = POSTHEADER1+tk3;
                String scCr= FreqMethods.secCredGen(FILEPATH,SEC_CRED_SC1);
                
                String revReq =  "{\"Initiator\":\""+INITIATOR_SC1+"\",\"SecurityCredential\":\""
                        +scCr+"\",\"CommandID\":\""+TREV_ID+"\",\"TransactionID\":\""
                        +TRANSACID+"\",\"Amount\":\""+AMT+"\",\"ReceiverParty\":\""
                        +NON_LNMO_SHORTCODE1+"\",\"RecieverIdentifierType\":\""
                        +"11"+"\",\"ResultURL\":\""+RESULT_URL+"\",\"QueueTimeOutURL\":\""
                        +CLBK_URL+"\",\"Remarks\":\""+RMKS+"\",\"Occasion\":\""
                        +OCCASS+"\"}";
                
                HttpReqs b2chtR = new HttpReqs();
                JSONObject requestBody =b2chtR.postResponse(REVERS_URL, header1, POSTHEADER2, revReq);
                String deres = requestBody.toString();
                jTextArea1.setText(deres);
                System.out.println(deres);
            } catch (IOException | JSONException | NoSuchAlgorithmException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Btn_transtatus.addActionListener((ActionEvent e) -> {
            try {
                FreqMethods transtatR = new FreqMethods();
                String tk2 = transtatR.authTokenGen().getString("access_token");
                String header1 = POSTHEADER1+tk2;
                String scC= FreqMethods.secCredGen(FILEPATH,SEC_CRED_SC1);
                
                String transtatReq =  "{\"Initiator\":\""+INITIATOR_SC1+"\",\"SecurityCredential\":\""
                        +scC+"\",\"CommandID\":\""+TSQ_ID+"\",\"TransactionID\":\""
                        +TRANSACID+"\",\"PartyA\":\""+TSTPHONE+"\",\"IdentifierType\":\""
                        +PHONENO+"\",\"ResultURL\":\""+RESULT_URL+"\",\"QueueTimeOutURL\":\""
                        +CLBK_URL+"\",\"Remarks\":\""+RMKS+"\",\"Occasion\":\""
                        +OCCASS+"\"}";
                HttpReqs b2chtR = new HttpReqs();
                JSONObject requestBody =b2chtR.postResponse(TRANSTATUS_URL, header1, POSTHEADER2, transtatReq);
                String deres = requestBody.toString();
                jTextArea1.setText(deres);
                System.out.println(deres);
            } catch (IOException | JSONException | NoSuchAlgorithmException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Btn_AccBal.addActionListener((ActionEvent e) -> {
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
                JSONObject requestBody =b2chtR.postResponse(ACC_BAL_URL, header1, POSTHEADER2, acbalReq);
                String deres = requestBody.toString();
                jTextArea1.setText(deres);
                System.out.println(deres);
            } catch (IOException | JSONException | NoSuchAlgorithmException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Btn_c2bSim.addActionListener((ActionEvent e) -> {
            try {
                FreqMethods c2bSim = new FreqMethods();
                String tk0 = c2bSim.authTokenGen().getString("access_token");
                String header1 = POSTHEADER1+tk0;
                
                String c2bSimReq =  "{\"ShortCode\":\""+BSS_CODE+"\",\"CommandID\":\""
                        +CPBO_ID+"\",\"Amount\":\""+AMT+"\",\"Msisdn\":\""+TSTPHONE
                        +"\",\"BillRefNumber\":\""+RMKS+"\"}";
                
                HttpReqs b2chtR = new HttpReqs();
                JSONObject requestBody =b2chtR.postResponse(C2B_SIM_URL, header1, POSTHEADER2, c2bSimReq);
                String deres = requestBody.toString();
                jTextArea1.setText(deres);
                System.out.println(deres);
            } catch (IOException | JSONException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Btn_c2bReg.addActionListener((ActionEvent e) -> {
            try {
                FreqMethods c2brR = new FreqMethods();
                String token = c2brR.authTokenGen().getString("access_token");
                String header1 = POSTHEADER1+token;
                
                String c2brReq =  "{\"ShortCode\":\""+NON_LNMO_SHORTCODE1+"\",\"ResponseType\":\""
                        +RMKS+"\",\"ConfirmationURL\":\""+CONFIRM_URL+"\",\"ValidationURL\":\""
                        +VALID_URL+"\"}";
                
                HttpReqs c2brhtR = new HttpReqs();
                JSONObject requestBody =c2brhtR.postResponse(C2B_REG_URL, header1, POSTHEADER2, c2brReq);
                String deres = requestBody.toString();
                jTextArea1.setText(deres);
                System.out.println(deres);
            } catch (IOException | JSONException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Btn_b2bReq.addActionListener((ActionEvent e) -> {
            try {
                FreqMethods b2bR = new FreqMethods();
                String tok1 = b2bR.authTokenGen().getString("access_token");
                String header1 = POSTHEADER1+tok1;
                
                String secCreden = FreqMethods.secCredGen(FILEPATH,SEC_CRED_SC1);
                String b2bReq =  "{\"Initiator\":\""+INITIATOR_SC1+"\",\"SecurityCredential\":\""+secCreden
                        +"\",\"CommandID\":\""+BTB_ID+"\",\"SenderIdentifierType\":\""+SHORTCODE
                        +"\",\"RecieverIdentifierType\":\""+SHORTCODE+"\",\"Amount\":\""+AMT+"\",\"PartyA\":\""
                        +NON_LNMO_SHORTCODE1+"\",\"PartyB\":\""+NON_LNMO_SHORTCODE2+"\",\"AccountReference\":\""
                        +ACC_REF+"\",\"Remarks\":\""+RMKS+"\",\"QueueTimeOutURL\":\""+CLBK_URL+"\",\"ResultURL\":\""+RESULT_URL+"\"}";
                
                HttpReqs b2bhtR = new HttpReqs();
                JSONObject requestBody =b2bhtR.postResponse(B2B_REQ_URL, header1, POSTHEADER2, b2bReq);
                String deres = requestBody.toString();
                jTextArea1.setText(deres);
                System.out.println(deres);
            } catch (IOException | JSONException | NoSuchAlgorithmException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Btn_b2cReq.addActionListener((ActionEvent e) -> {
            try {
                FreqMethods b2cR = new FreqMethods();
                String token = b2cR.authTokenGen().getString("access_token");
                String header1 = POSTHEADER1+token;
                                
                String securityCreden = FreqMethods.secCredGen(FILEPATH,SEC_CRED_SC1);
                
                String b2cReq =  "{\"InitiatorName\":\""+INITIATOR_SC1+"\",\"SecurityCredential\": \""+securityCreden
                        +"\",\"CommandID\": \""+BSPAY_ID+"\",\"Amount\":\""+AMT+"\",\"PartyA\": \""
                        +NON_LNMO_SHORTCODE1+"\",\"PartyB\": \""+TSTPHONE+"\",\"Remarks\": \""+RMKS+"\",\"QueueTimeOutURL\": \""+CLBK_URL
                        +"\",\"ResultURL\":\""+RESULT_URL+"\",\"Occassion\": \""+OCCASS+"\"}";
                
                HttpReqs b2chtR = new HttpReqs();
                JSONObject requestBody =b2chtR.postResponse(B2C_REQ_URL, header1, POSTHEADER2, b2cReq);
                String deres = requestBody.toString();
                jTextArea1.setText(deres);
                System.out.println(deres);
            } catch (IOException | JSONException | NoSuchAlgorithmException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Btn_ClbkTst.addActionListener((ActionEvent e) -> {
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
                
                JSONObject tstResponse = htr.postResponse(CLBK_URL, POSTHEADER1+testHeader1, POSTHEADER2, testReq1);
                String deres = tstResponse.toString();
                jTextArea1.setText(deres);
                System.out.println(deres);
            } catch (JSONException | IOException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
      
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btn_LnmO = new javax.swing.JButton();
        Btn_Lnmo_q = new javax.swing.JButton();
        Btn_tokenGen = new javax.swing.JButton();
        Btn_reverse = new javax.swing.JButton();
        Btn_transtatus = new javax.swing.JButton();
        Btn_AccBal = new javax.swing.JButton();
        Btn_c2bSim = new javax.swing.JButton();
        Btn_c2bReg = new javax.swing.JButton();
        Btn_b2bReq = new javax.swing.JButton();
        Btn_b2cReq = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Btn_ClbkTst = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Btn_LnmO.setText("Lipa Na Mpesa Online");

        Btn_Lnmo_q.setText("Lipa Na Mpesa Query");

        Btn_tokenGen.setText("Generate Access Token");

        Btn_reverse.setText("Reversal");

        Btn_transtatus.setText("Transaction Status");

        Btn_AccBal.setText("Account Balance");

        Btn_c2bSim.setText("C2B Simulate");

        Btn_c2bReg.setText("C2B Register");

        Btn_b2bReq.setText("B2B Request");

        Btn_b2cReq.setText("B2C Request");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        Btn_ClbkTst.setText("CallBack URL Test");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_LnmO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Lnmo_q, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_tokenGen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_reverse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_transtatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_AccBal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_c2bSim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_c2bReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_b2bReq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_b2cReq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_ClbkTst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Btn_LnmO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_Lnmo_q)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_tokenGen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_reverse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_transtatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_AccBal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_c2bSim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_c2bReg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_b2bReq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_b2cReq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_ClbkTst)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
      public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new TestViewer().setVisible(true);
            } catch (IOException | JSONException ex) {
                Logger.getLogger(TestViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_AccBal;
    private javax.swing.JButton Btn_ClbkTst;
    private javax.swing.JButton Btn_LnmO;
    private javax.swing.JButton Btn_Lnmo_q;
    private javax.swing.JButton Btn_b2bReq;
    private javax.swing.JButton Btn_b2cReq;
    private javax.swing.JButton Btn_c2bReg;
    private javax.swing.JButton Btn_c2bSim;
    private javax.swing.JButton Btn_reverse;
    private javax.swing.JButton Btn_tokenGen;
    private javax.swing.JButton Btn_transtatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

