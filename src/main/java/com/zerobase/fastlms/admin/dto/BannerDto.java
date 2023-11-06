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

    String linkUrl;
    String altText;

    Long priority;
    String target;
    boolean front;

    LocalDateTime regDt;
    LocalDateTime udtDt;

    String filename;
    String urlFilename;

    long totalCount;
    long seq;

    public static BannerDto of(Banner banner) {

        return BannerDto.builder()
                .id(banner.getId())

                .linkUrl(banner.getLinkUrl())
                .altText(banner.getAltText())
                .priority(banner.getPriority())
                .target(banner.getTarget())
                .front(banner.isFront())

                .filename(banner.getFilename())
                .urlFilename(banner.getUrlFilename())

                .regDt(banner.getRegDt())
                .udtDt(banner.getUdtDt())

                .build();
    }
}
