package test;

import com.qf.mapper.HouseInfoMapper;
import com.qf.pojo.HouseInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestMapper {
    @Resource
    private HouseInfoMapper houseInfoMapper;
    @Test
    public void test(){
        HouseInfo info=new HouseInfo();
        info.setAddress("北京");
        info.setPrice(22222);
        info.setTitle("好房出租");
        info.setImages("");
        int i=houseInfoMapper.saveHouseInfo(info);
        System.err.println(i>0?"success":"false");
    }
}
