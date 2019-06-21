package com.qiang.mapper;

import com.qiang.model.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: qiang
 * @ProjectName: adminsystem
 * @Package: com.qiang.mapper
 * @Description:
 * @Date: 2019/6/20 0020 21:30
 **/
@Repository
public interface UseMapper {

    User selByName(String username);
}
