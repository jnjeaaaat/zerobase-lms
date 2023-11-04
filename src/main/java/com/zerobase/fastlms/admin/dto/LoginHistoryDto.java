package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.member.entity.LoginHistory;
import com.zerobase.fastlms.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginHistoryDto {

    String username;
    String ipAddress;
    String userAgent;

    LocalDateTime loginDt;

    long totalCount;
    long seq;
    
    
    public static LoginHistoryDto of(LoginHistory loginHistory) {
        
        return LoginHistoryDto.builder()
                .userAgent(loginHistory.getUserAgent())
                .ipAddress(loginHistory.getIpAddress())
                .username(loginHistory.getUsername())

                .loginDt(loginHistory.getLoginDt())
                
                .build();
    }

    
}
