package com.ksrs.service;

import com.ksrs.entity.ClueminingApiExpand;
import com.ksrs.entity.Cluemining_api;

import java.util.List;

public interface Cluemining_apiService {
     List<Cluemining_api> getData(String starDate, String endDate, String operation_explain,String operation_type,int page, int pageSize);
     int getTotal(String starDate, String endDate, String operation_explain,String operation_type);
     List<ClueminingApiExpand> getPage(int page,int limit,String ip);
     Integer getExpandTotal(String ip);
}
