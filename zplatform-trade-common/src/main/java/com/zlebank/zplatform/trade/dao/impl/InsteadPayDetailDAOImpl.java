/* 
 * InsteadPayDetailDAOImpl.java  
 * 
 * version TODO
 *
 * 2015年11月24日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.trade.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zlebank.zplatform.commons.dao.impl.AbstractPagedQueryDAOImpl;
import com.zlebank.zplatform.commons.utils.StringUtil;
import com.zlebank.zplatform.trade.bean.InsteadPayDetailQuery;
import com.zlebank.zplatform.trade.dao.InsteadPayDetailDAO;
import com.zlebank.zplatform.trade.model.PojoInsteadPayDetail;

/**
 * Class Description
 *
 * @author Luxiaoshuai
 * @version
 * @date 2015年11月24日 下午1:49:02
 * @since
 */
@Repository("insteadPayDetailDAO")
public class InsteadPayDetailDAOImpl
        extends
            AbstractPagedQueryDAOImpl<PojoInsteadPayDetail, InsteadPayDetailQuery>
        implements
            InsteadPayDetailDAO {

    /**
     * 通过批次号得到批次明细
     * 
     * @param batchNo
     * @return
     */
    @Override
    public List<PojoInsteadPayDetail> getByBatchDetail(String batchNo) {
        Criteria crite = this.getSession().createCriteria(
                PojoInsteadPayDetail.class);
        crite.add(Restrictions.eq("batchNo", batchNo));
        return crite.list();
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void updateBatchDetailResult(PojoInsteadPayDetail insteadPayDetail) {
        // TODO Auto-generated method stub
        try {
            String hql = "update PojoInsteadPayDetail set status = ?,channelCode = ?,batchFileNo = ?,respCode = ?,respMsg = ? where merId = ? and orderId = ?";
            Session session = getSession();
            Query query = session.createQuery(hql);
            query.setString(0, insteadPayDetail.getStatus());
            query.setString(1, insteadPayDetail.getChannelCode());
            query.setString(2, insteadPayDetail.getBatchFileNo());
            query.setString(3, insteadPayDetail.getRespCode());
            query.setString(4, insteadPayDetail.getRespMsg());
            query.setString(5, insteadPayDetail.getMerId());
            query.setString(6, insteadPayDetail.getOrderId());
            query.executeUpdate();
        } catch (HibernateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    protected Criteria buildCriteria(InsteadPayDetailQuery e) {
        Criteria crite = this.getSession().createCriteria(
                PojoInsteadPayDetail.class);
        if (e != null) {
            if (StringUtil.isNotEmpty(e.getAccNo())) {
                crite.add(Restrictions.eq("accNo", e.getAccNo()));
            }
            if (StringUtil.isNotEmpty(e.getAccType())) {
                crite.add(Restrictions.eq("accType", e.getAccType()));
            }
            if (StringUtil.isNotEmpty(e.getMerId())) {
                crite.add(Restrictions.eq("merId", e.getMerId()));
            }
            if (StringUtil.isNotEmpty(e.getOrderId())) {
                crite.add(Restrictions.eq("orderId", e.getOrderId()));
            }
            if (StringUtil.isNotEmpty(e.getBatchFileNo())) {
                crite.add(Restrictions.eq("batchId",   Long.valueOf(e.getBatchFileNo())));
            }
            if (StringUtil.isNotEmpty(e.getStatus())) {
                crite.add(Restrictions.eq("status",e.getStatus()));
            }
            
            
        }
        crite.addOrder(Order.desc("intime"));
        return crite;
        }

    /**
     *
     * @param orderId
     * @return
     */
    @Override
    public PojoInsteadPayDetail getDetailByTxnseqno(String txnseqno,String status) {
        Criteria crite = this.getSession().createCriteria(
                PojoInsteadPayDetail.class);
        crite.add(Restrictions.eq("txnseqno", txnseqno));
        crite.add(Restrictions.eq("status", status));
        return (PojoInsteadPayDetail)crite.uniqueResult();
    }
    
    
      }