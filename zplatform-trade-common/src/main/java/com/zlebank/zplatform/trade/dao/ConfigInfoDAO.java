/* 
 * InsteadPayBatchDAO.java  
 * 
 * version TODO
 *
 * 2015年11月24日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.trade.dao;

import com.zlebank.zplatform.commons.dao.BaseDAO;
import com.zlebank.zplatform.trade.model.ConfigInfoModel;

/**
 * 配置DAO
 *
 * @author Luxiaoshuai
 * @version
 * @date 2015年11月24日 下午12:29:35
 * @since 
 */
public interface ConfigInfoDAO  extends BaseDAO<ConfigInfoModel>{
    /**
     * 根据参数名称得到配置信息
     * @param paraName
     * @return
     */
    public ConfigInfoModel getConfigByParaName(String paraName) ;
}