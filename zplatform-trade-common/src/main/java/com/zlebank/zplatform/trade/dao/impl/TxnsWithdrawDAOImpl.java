/* 
 * TxnsWithdrawServiceImpl.java  
 * 
 * version TODO
 *
 * 2015年10月22日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.trade.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zlebank.zplatform.commons.dao.impl.HibernateBaseDAOImpl;
import com.zlebank.zplatform.trade.dao.ITxnsWithdrawDAO;
import com.zlebank.zplatform.trade.model.TxnsWithdrawModel;

/**
 * Class Description
 *
 * @author guojia
 * @version
 * @date 2015年10月22日 下午5:43:29
 * @since 
 */
@Repository("txnsWithdrawDAO")
public class TxnsWithdrawDAOImpl extends HibernateBaseDAOImpl<TxnsWithdrawModel> implements ITxnsWithdrawDAO{

    public Session getSession(){
        return super.getSession();
    }
    /**
     *
     * @param seqNo
     * @return
     */
    public TxnsWithdrawModel getWithdrawBySeqNo(String seqNo){
        Criteria cri=getSession().createCriteria(TxnsWithdrawModel.class);
        cri.add(Restrictions.eq("texnseqno", seqNo));
        return (TxnsWithdrawModel) cri.uniqueResult();
    }
}
