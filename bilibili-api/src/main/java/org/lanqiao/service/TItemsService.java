package org.lanqiao.service;

import org.apache.ibatis.annotations.Select;
import org.lanqiao.entity.TItems;

import java.util.List;

public interface TItemsService {

    public List<TItems> queryAll();

    public String queryName(Integer i_no);

    public Float queryMoney(Integer i_no);

    public Float queryIno(Integer i_name);

}
