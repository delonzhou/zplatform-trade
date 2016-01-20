/* 
 * TxnsOrderinfoDAOImpl.java  
 * 
 * version TODO
 *
 * 2015年8月29日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.trade.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zlebank.zplatform.commons.dao.impl.HibernateBaseDAOImpl;
import com.zlebank.zplatform.trade.dao.ITxnsOrderinfoDAO;
import com.zlebank.zplatform.trade.model.TxnsOrderinfoModel;

/**
 * Class Description
 *
 * @author guojia
 * @version
 * @date 2015年8月29日 下午3:40:27
 * @since 
 */
@Repository("txnsOrderinfo")
public class TxnsOrderinfoDAOImpl extends HibernateBaseDAOImpl<TxnsOrderinfoModel> implements ITxnsOrderinfoDAO{
    public Session getSession() {
        // TODO Auto-generated method stub
        return super.getSession();
    }
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void updateOrderToFail(String orderNo,String merchId) {
        TxnsOrderinfoModel orderinfo = getOrderinfoByOrderNo(orderNo,merchId);
        if("02".equals(orderinfo.getStatus())){
            String hql = "update TxnsOrderinfoModel set status = ? where orderno=? and firmemberno = ? ";
            Session session = getSession();
            Query query = session.createQuery(hql);
            query.setString(0, "03");
            query.setString(1, orderNo);
            query.setString(2, merchId);
            int rows =  query.executeUpdate();
        }
    }
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public TxnsOrderinfoModel getOrderinfoByOrderNo(String orderNo,String merchId) {
        String hql = "from TxnsOrderinfoModel where orderno = ? and firmemberno = ? ";
        Session session = getSession();
        Query query = session.createQuery(hql);
        query.setString(0, orderNo);
        query.setString(1, merchId);
        return (TxnsOrderinfoModel) query.list().get(0);
    }
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void updateOrderinfo(TxnsOrderinfoModel orderinfo){
        getSession().update(orderinfo);
    }
}