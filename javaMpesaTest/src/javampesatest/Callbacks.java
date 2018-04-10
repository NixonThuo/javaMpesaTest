/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javampesatest;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author DEVWK008
 */
public class Callbacks {
    
    public JSONObject confirm(){
        JSONObject response = new JSONObject();
        try {            
            String resultdesc = "Success", resultcode="0";
            response.put("ResultCode",resultcode);
            response.put("ResultDesc",resultdesc);
            
        } catch (JSONException ex) {
            Logger.getLogger(Callbacks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }
    public JSONObject validate(){
        JSONObject response = new JSONObject();
        try {            
            String resultdesc = "Success", resultcode="0";
            response.put("ResultCode",resultcode);
            response.put("ResultDesc",resultdesc);
            
        } catch (JSONException ex) {
            Logger.getLogger(Callbacks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }
    
    public JSONObject b2cResult(JSONObject result){
    JSONObject response = new JSONObject();
    try {            
            String resultdesc = "Success", resultcode="0";
            response.put("ResultCode",resultcode);
            response.put("ResultDesc",resultdesc);
            
        } catch (JSONException ex) {
            Logger.getLogger(Callbacks.class.getName()).log(Level.SEVERE, null, ex);
        }
    return response;
    }
    
     /*
    //b2c response on callback
    {
    "Result":{
    "ResultType":0,
    "ResultCode":0,
    "ResultDesc":"The service request has been accepted successfully.",
    "OriginatorConversationID":"19455-424535-1",
    "ConversationID":"AG_20170717_00006be9c8b5cc46abb6",
    "TransactionID":"LGH3197RIB",
    "ResultParameters":{
      "ResultParameter":[
        {
          "Key":"TransactionReceipt",
          "Value":"LGH3197RIB"
        },
        {
          "Key":"TransactionAmount",
          "Value":8000
        },
        {
          "Key":"B2CWorkingAccountAvailableFunds",
          "Value":150000
        },
        {
          "Key":"B2CUtilityAccountAvailableFunds",
          "Value":133568
        },
        {
          "Key":"TransactionCompletedDateTime",
          "Value":"17.07.2017 10:54:57"
        },
        {
          "Key":"ReceiverPartyPublicName",
          "Value":"254708374149 - John Doe"
        },
        {
          "Key":"B2CChargesPaidAccountAvailableFunds",
          "Value":0
        },
        {
          "Key":"B2CRecipientIsRegisteredCustomer",
          "Value":"Y"
        }
      ]
    },
    "ReferenceData":{
      "ReferenceItem":{
        "Key":"QueueTimeoutURL",
        "Value":"https://internalsandbox.safaricom.co.ke/mpesa/b2cresults/v1/submit"
      }
    }
  }
}
    
    //b2b response on callback
    {
  "Result":{
    "ResultType":0,
    "ResultCode":0,
    "ResultDesc":"The service request has been accepted successfully.",
    "OriginatorConversationID":"8551-61996-3",
    "ConversationID":"AG_20170727_00006baee344f4ce0796",
    "TransactionID":"LGR519G2QV",
    "ResultParameters":{
      "ResultParameter":[
        {
          "Key":"InitiatorAccountCurrentBalance",
          "Value":"{ Amount={BasicAmount=46713.00, MinimumAmount=4671300, CurrencyCode=KES}}"
        },
        {
          "Key":"DebitAccountCurrentBalance",
          "Value":"{Amount={BasicAmount=46713.00, MinimumAmount=4671300, CurrencyCode=KES}}"
        },
        {
          "Key":"Amount",
          "Value":10
        },
        {
          "Key":"DebitPartyAffectedAccountBalance",
          "Value":"Working Account|KES|46713.00|46713.00|0.00|0.00"
        },
        {
          "Key":"TransCompletedTime",
          "Value":20170727102524
        },
        {
          "Key":"DebitPartyCharges",
          "Value":"Business Pay Bill Charge|KES|77.00"
        },
        {
          "Key":"ReceiverPartyPublicName",
          "Value":"603094 - Safaricom3117"
        },
        {
          "Key":"Currency",
          "Value":"KES"
        }
      ]
    },
    "ReferenceData":{
      "ReferenceItem":[
        {
          "Key":"BillReferenceNumber",
          "Value":"aaa"
        },
        {
          "Key":"QueueTimeoutURL",
          "Value":"https://internalsandbox.safaricom.co.ke/mpesa/b2bresults/v1/submit"
        },
        {
          "Key":"Occasion"
        }
      ]
    }
  }
}
    
    // Validation Response
{
  "TransactionType":"",
  "TransID":"LGR219G3EY",
  "TransTime":"20170727104247",
  "TransAmount":"10.00",
  "BusinessShortCode":"600134",
  "BillRefNumber":"xyz",
  "InvoiceNumber":"",
  "OrgAccountBalance":"",
  "ThirdPartyTransID":"",
  "MSISDN":"254708374149",
  "FirstName":"John",
  "MiddleName":"Doe",
  "LastName":""
}

//Confirmation Respose
{
  "TransactionType":"",
  "TransID":"LGR219G3EY",
  "TransTime":"20170727104247",
  "TransAmount":"10.00",
  "BusinessShortCode":"600134",
  "BillRefNumber":"xyz",
  "InvoiceNumber":"",
  "OrgAccountBalance":"49197.00",
  "ThirdPartyTransID":"1234567890",
  "MSISDN":"254708374149",
  "FirstName":"John",
  "MiddleName":"",
  "LastName":""
}


//accbal
{
  "Result":{
    "ResultType":0,
    "ResultCode":0,
    "ResultDesc":"The service request has b een accepted successfully.",
    "OriginatorConversationID":"19464-802673-1",
    "ConversationID":"AG_20170728_0000589b6252f7f25488",
    "TransactionID":"LGS0000000",
    "ResultParameters":{
      "ResultParameter":[
        {
          "Key":"AccountBalance",
          "Value":"Working Account|KES|46713.00|46713.00|0.00|0.00&Float Account|KES|0.00|0.00|0.00|0.00&Utility Account|KES|49217.00|49217.00|0.00|0.00&Charges Paid Account|KES|-220.00|-220.00|0.00|0.00&Organization Settlement Account|KES|0.00|0.00|0.00|0.00"
        },
        {
          "Key":"BOCompletedTime",
          "Value":20170728095642
        }
      ]
    },
    "ReferenceData":{
      "ReferenceItem":{
        "Key":"QueueTimeoutURL",
        "Value":"https://internalsandbox.safaricom.co.ke/mpesa/abresults/v1/submit"
      }
    }
  }
}


//transtatus
{
  "Result":{
    "ResultType":0,
    "ResultCode":0,
    "ResultDesc":"The service request has been accepted successfully.",
    "OriginatorConversationID":"10816-694520-2",
    "ConversationID":"AG_20170727_000059c52529a8e080bd",
    "TransactionID":"LGR0000000",
    "ResultParameters":{
      "ResultParameter":[
        {
          "Key":"ReceiptNo",
          "Value":"LGR919G2AV"
        },
        {
          "Key":"Conversation ID",
          "Value":"AG_20170727_00004492b1b6d0078fbe"
        },
        {
          "Key":"FinalisedTime",
          "Value":20170727101415
        },
        {
          "Key":"Amount",
          "Value":10
        },
        {
          "Key":"TransactionStatus",
          "Value":"Completed"
        },
        {
          "Key":"ReasonType",
          "Value":"Salary Payment via API"
        },
        {
          "Key":"TransactionReason"
        },
        {
          "Key":"DebitPartyCharges",
          "Value":"Fee For B2C Payment|KES|33.00"
        },
        {
          "Key":"DebitAccountType",
          "Value":"Utility Account"
        },
        {
          "Key":"InitiatedTime",
          "Value":20170727101415
        },
        {
          "Key":"Originator Conversation ID",
          "Value":"19455-773836-1"
        },
        {
          "Key":"CreditPartyName",
          "Value":"254708374149 - John Doe"
        },
        {
          "Key":"DebitPartyName",
          "Value":"600134 - Safaricom157"
        }
      ]
    },
    "ReferenceData":{
      "ReferenceItem":{
        "Key":"Occasion",
        "Value":"aaaa"
      }
    }
  }
}


//reversal
{
  "Result":{
    "ResultType":0,
    "ResultCode":0,
    "ResultDesc":"The service request has been accepted successfully.",
    "OriginatorConversationID":"10819-695089-1",
    "ConversationID":"AG_20170727_00004efadacd98a01d15",
    "TransactionID":"LGR019G3J2",
    "ReferenceData":{
      "ReferenceItem":{
        "Key":"QueueTimeoutURL",
        "Value":"https://internalsandbox.safaricom.co.ke/mpesa/reversalresults/v1/submit"
      }
    }
  }
}

//LNMOPayment
// A cancelled request
{
  "Body":{
    "stkCallback":{
      "MerchantRequestID":"8555-67195-1",
      "CheckoutRequestID":"ws_CO_27072017151044001",
      "ResultCode":1032,
      "ResultDesc":"[STK_CB - ]Request cancelled by user"
    }
  }
}

// An accepted request
    */
    public JSONObject LNMOCallback(JSONObject STKResponse) throws JSONException{
    JSONObject response = new JSONObject();
    JSONObject stkCallback = STKResponse.getJSONObject("stkCallback");
    JSONObject callbackMetadata = stkCallback.getJSONObject("CallbackMetadata");
    JSONArray Item =  callbackMetadata.getJSONArray("Item");
    String MerchantRequestID, CheckoutRequestID, ResultCode, ResultDesc, Amount,
            MpesaReceiptNumber, Balance, TransactionDate, PhoneNo;
    
    MerchantRequestID = stkCallback.getString("MerchantRequestID");
    CheckoutRequestID = stkCallback.getString("CheckoutRequestID"); 
    ResultCode = stkCallback.getString("ResultCode"); 
    ResultDesc = stkCallback.getString("ResultDesc");
    for(int i = 0; i<Item.length();i++){
        JSONObject obji = Item.getJSONObject(i);
        switch(i){
            case 0:
                if(obji.getString("Name").equals("Amount")){
                Amount = obji.getString("Value");
                }
                break;
            case 1:
                if(obji.getString("Name").equals("MpesaReceiptNumber")){
                MpesaReceiptNumber = obji.getString("Value");
                }
                break;
            case 2:
                if(obji.getString("Name").equals("Balance")){
                Balance = obji.getString("Value");
                }
                break;
            case 3:
                if(obji.getString("Name").equals("TransactionDate")){
                TransactionDate = obji.getString("Value");
                }
                break;
            case 4:
                if(obji.getString("Name").equals("PhoneNumber")){
                PhoneNo = obji.getString("Value");
                }
                break;
                
        }
    }
    
    String resultdesc = "Success", resultcode="0";
            response.put("ResultCode",resultcode);
            response.put("ResultDesc",resultdesc);
    /*int i = 0;
    if(i<Item.length()){
    switch(i){
        case 0:
            
    }
    }
    i++;*/
    return response;
}
    /*
{
  "Body":{
    "stkCallback":{
      "MerchantRequestID":"19465-780693-1",
      "CheckoutRequestID":"ws_CO_27072017154747416",
      "ResultCode":0,
      "ResultDesc":"The service request is processed successfully.",
      "CallbackMetadata":{
        "Item":[
          {
            "Name":"Amount",
            "Value":1
          },
          {
            "Name":"MpesaReceiptNumber",
            "Value":"LGR7OWQX0R"
          },
          {
            "Name":"Balance"
          },
          {
            "Name":"TransactionDate",
            "Value":20170727154800
          },
          {
            "Name":"PhoneNumber",
            "Value":254721566839
          }
        ]
      }
    }
  }
}

//LNMOQuery
{
  "ResponseCode":"0",
  "ResponseDescription":"The service request has been accepted successfully",
  "MerchantRequestID":"8555-67195-1",
  "CheckoutRequestID":"ws_CO_27072017151044001",
  "ResultCode":"1032",
  "ResultDesc":"[STK_CB - ]Request cancelled by user"
}

*/
    
}
