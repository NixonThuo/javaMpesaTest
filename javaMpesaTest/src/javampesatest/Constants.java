/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javampesatest;

/**
 *
 * @author DEVWK008
 */
public interface Constants {
    //Keys
    public static final String CONSECRET = "tn9bM1H1zsziCmMR",
        CONSKEY = "AEG7MzUoSVZURxOUekai4AbWeXzlQOma",
            //URLs
        MP_AUTH_GEN_URL = "https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials",
        LNMO_INITIATE_URL = "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest",
        LNMO_STATUREQ_URL = "https://sandbox.safaricom.co.ke/mpesa/stkpushquery/v1/query",
        C2B_SIM_URL ="https://sandbox.safaricom.co.ke/mpesa/c2b/v1/simulate" ,
        C2B_REG_URL ="https://sandbox.safaricom.co.ke/mpesa/c2b/v1/registerurl" ,
        B2B_REQ_URL ="https://sandbox.safaricom.co.ke/mpesa/b2b/v1/paymentrequest" ,
        B2C_REQ_URL ="https://sandbox.safaricom.co.ke/mpesa/b2c/v1/paymentrequest", 
        ACC_BAL_URL="https://sandbox.safaricom.co.ke/mpesa/accountbalance/v1/query",
        TRANSTATUS_URL="https://sandbox.safaricom.co.ke/mpesa/transactionstatus/v1/query",
        REVERS_URL="https://sandbox.safaricom.co.ke/mpesa/reversal/v1/request",
            //CommandIDs
        BG_ID="BusinessBuyGoods",
        PB_ID="BusinessPayBill",
        MMF_TO_UTIL_ID = "BusinessTransferFromMMFToUtility",
        BTB_ID="BusinessToBusinessTransfer",
        FTB_ID="DisburseFundsToBusiness",
        CHK_IDEN_ID="CheckIdentity",
        TSQ_ID="TransactionStatusQuery",
        CPBO_ID="CustomerPayBillOnline",
        ACCBAL_ID="AccountBalance",
        PROMO_PAY_ID="PromotionPayment",
        BSPAY_ID="BusinessPayment",
        SALPAY_ID="SalaryPayment",
        TREV_ID="TransactionReversal",
            TRANSACID="MCK2D9XSVI",
            //Identifier Types
            /*
                1 - MSISDN
                2 - Till Number
                4 - Shortcode
            */
        PHONENO = "1",
        TILLNO="2",
        SHORTCODE="4",
            //Encoding
        BASE64_ENC = "ISO-8859-1",
            //Headers
        GETHEADER1 = "Basic ", 
        GETHEADER2 = "no-cache",
        POSTHEADER1 = "Bearer ",
        POSTHEADER2 = "application/json",
            //ShortCodes
        BSS_CODE="174379",
        NON_LNMO_SHORTCODE2="600000",
        NON_LNMO_SHORTCODE1 = "601451",
            //Other Params
        INITIATOR_SC1 = "apitest451",
        SEC_CRED_SC1 = "451reset",RMKS="Testing Transaction",
        TSTPHONE = "254729838302",//can change 
        AMT="1", //can change
        CLBK_URL="http://dmstst.munshiram.com:56518/callback.jsp",
        VALID_URL="",
        PASSKEY = "bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919",
        CONFIRM_URL="",
        FILEPATH="C:\\Users\\DEVWK008\\Documents\\NetBeansProjects\\Timestamp\\Files\\cert.cer",
        ACC_REF="TestAccount", //can change
        OCCASS = "TestOccassion",
        TRANS_DESC = "TestTransaction"; //can change
}
