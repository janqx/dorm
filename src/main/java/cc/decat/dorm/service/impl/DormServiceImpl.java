package cc.decat.dorm.service.impl;

import cc.decat.dorm.mapper.DormMapper;
import cc.decat.dorm.model.Dorm;
import cc.decat.dorm.service.DormService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class DormServiceImpl extends ServiceImpl<DormMapper, Dorm> implements DormService {

    @Resource
    private DormMapper dormMapper;


    @Override
    public Dorm findDormByDormNumber(String flatsName, Integer buildingNumber, Integer dormNumber) {
        return dormMapper.selectOne(
                new QueryWrapper<Dorm>().
                        eq("flatsName", flatsName).
                        eq("buildingNumber", buildingNumber).
                        eq("dormNumber", dormNumber));
    }

    @Override
    public List<Dorm> findDormByBuildingNumber(String flatsName, Integer buildingNumber) {
        return dormMapper.selectList(
                new QueryWrapper<Dorm>().
                        eq("flatsName", flatsName).
                        eq("buildingNumber", buildingNumber));
    }

    @Override
    public List<Dorm> findDormByFlats(String flatsName) {

        return dormMapper.selectList(
                new QueryWrapper<Dorm>().
                        eq("flatsName", flatsName));
    }

//    @Override
//    public Dorm findDormByStudentInfo(String studentNumber, String username, String phoneNumber) {
//        return dormDao.selectOne(
//                new QueryWrapper<Dorm>().
//                        eq(!StringUtils.isEmpty(studentNumber), "studentNumber", studentNumber).
//                        eq(!StringUtils.isEmpty(username), "username", username).
//                        eq(!StringUtils.isEmpty(phoneNumber), "phoneNumber", phoneNumber));
//    }

}
