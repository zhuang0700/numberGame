package com.telan.numbergame.mapper;

import com.telan.numbergame.domain.UserDO;

import java.util.List;

public interface UserDOMapper {
    int insert(UserDO record);

    UserDO selectByPrimaryKey(long id);

    List<UserDO> batchSelectByIds(List<Long> list);

    UserDO selectByUnionId(String unionId);

    UserDO selectByOpenId(String openId);

    int updateByPrimaryKeySelective(UserDO record);

}