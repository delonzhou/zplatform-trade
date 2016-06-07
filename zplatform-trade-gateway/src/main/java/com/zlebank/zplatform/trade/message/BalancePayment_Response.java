/* 
 * BalancePaymentResponse.java  
 * 
 * version TODO
 *
 * 2015年10月9日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.trade.message;

import com.zlebank.zplatform.trade.validator.An;
import com.zlebank.zplatform.trade.validator.N;

/**
 * 余额支付【应答报文】
 *
 * @author yangpeng
 * @version
 * @date 2015年10月9日 下午4:00:47
 * @since
 */
public class BalancePayment_Response  extends BaseMessage {

    /** 受理订单号 **/
    @An
    private String tn;
    /** 交易金额 **/
    @An(max=12,isNull=false)
    private String txnAmt;
    /** 交易币种 **/
    @N(max=3,isNull=false)
    private String currencyCode;
    /** 响应码 **/
    @An(max=15,isNull=false)
    private String respCode;
    /** 应答信息 **/
    @An(max=15,isNull=false)
    private String respMsg;
    /**前台跳转地址**/
    private String frontUrl;
 
    public String getTn() {
        return tn;
    }
    public String getTxnAmt() {
        return txnAmt;
    }
    public String getCurrencyCode() {
        return currencyCode;
    }
    public String getRespCode() {
        return respCode;
    }
    public String getRespMsg() {
        return respMsg;
    }
    public void setTn(String tn) {
        this.tn = tn;
    }
    public void setTxnAmt(String txnAmt) {
        this.txnAmt = txnAmt;
    }
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }
    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }
    public String getFrontUrl() {
        return frontUrl;
    }
    public void setFrontUrl(String frontUrl) {
        this.frontUrl = frontUrl;
    }
}
