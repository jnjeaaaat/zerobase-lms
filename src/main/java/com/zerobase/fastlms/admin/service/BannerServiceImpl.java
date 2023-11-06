package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.admin.mapper.BannerMapper;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;
import com.zerobase.fastlms.admin.repository.BannerRepository;
import com.zerobase.fastlms.course.entity.Course;
import com.zerobase.fastlms.course.model.CourseInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService {

    private final BannerMapper bannerMapper;

    private final BannerRepository bannerRepository;

    @Override
    public List<BannerDto> list(BannerParam parameter) {
        long totalCount = bannerMapper.selectBannerListCount(parameter);

        List<BannerDto> list = bannerMapper.selectListOrderByPriority(parameter);

        if (!CollectionUtils.isEmpty(list)) {
            int i = 0;
            for (BannerDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }

        return list;
    }

    @Override
    public BannerDto getById(long id) {
        return bannerRepository.findById(id).map(BannerDto::of).orElse(null);
    }


    @Override
    public boolean add(BannerInput parameter) {
        System.out.println("target : " + parameter.getTarget());

        Banner banner = Banner.builder()
                .altText(parameter.getAltText())
                .linkUrl(parameter.getLinkUrl())
                .priority(parameter.getPriority())
                .front(parameter.isFront())
                .target(parameter.getTarget())
                .regDt(LocalDateTime.now())
                .filename(parameter.getFilename())
                .urlFilename(parameter.getUrlFilename())
                .build();
        bannerRepository.save(banner);

        return true;
    }


    @Override
    public boolean set(BannerInput parameter) {

        Optional<Banner> optionalBanner = bannerRepository.findById(parameter.getId());
        if (!optionalBanner.isPresent()) {
            //수정할 데이터가 없음
            return false;
        }

        Banner banner = optionalBanner.get();
        banner.setAltText(parameter.getAltText());
        banner.setFront(parameter.isFront());
        banner.setPriority(parameter.getPriority());
        banner.setUdtDt(LocalDateTime.now());
        banner.setTarget(parameter.getTarget());
        banner.setLinkUrl(parameter.getLinkUrl());
        banner.setFilename(parameter.getFilename());
        banner.setUrlFilename(parameter.getUrlFilename());

        bannerRepository.save(banner);

        return true;
    }
}
