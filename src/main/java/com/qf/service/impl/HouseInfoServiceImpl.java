package com.qf.service.impl;

import com.qf.mapper.HouseInfoMapper;
import com.qf.pojo.HouseInfo;
import com.qf.service.HouseInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class HouseInfoServiceImpl implements HouseInfoService {
    @Resource
    HouseInfoMapper houseInfoMapper;
    @Override
    public int saveHouseInfo(HouseInfo houseInfo) {
        return houseInfoMapper.saveHouseInfo(houseInfo);
    }

    @Override
    public List findall() {
        return houseInfoMapper.findall();
    }
}
