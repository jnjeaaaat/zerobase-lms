package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.admin.entity.Banner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BannerDto {

    Long id;

    String filePath;
    String linkUrl;
    String altText;

    Long priority;
    boolean target;
    boolean front;

    LocalDateTime regDt;
    LocalDateTime udtDt;

    long totalCount;
    long seq;

    public static BannerDto of(Banner banner) {

        return BannerDto.builder()
                .id(banner.getId())
                .filePath(banner.getFilePath())
                .linkUrl(banner.getLinkUrl())
                .altText(banner.getAltText())
                .priority(banner.getPriority())
                .target(banner.isTarget())
                .front(banner.isFront())

                .regDt(banner.getRegDt())
                .udtDt(banner.getUdtDt())

                .build();
    }
}
