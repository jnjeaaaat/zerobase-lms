package com.zerobase.fastlms.admin.mapper;


import com.zerobase.fastlms.admin.dto.LoginHistoryDto;
import com.zerobase.fastlms.admin.model.LoginHistoryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginHistoryMapper {

    long selectHistoryListCount(LoginHistoryParam parameter);
    List<LoginHistoryDto> selectHistoryList(LoginHistoryParam parameter);

}
