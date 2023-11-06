package com.zerobase.fastlms.admin.model;

import lombok.Data;

@Data
public class BannerInput {

    long id;

    String linkUrl;
    String altText;

    long priority;
    String target;
    boolean front;

    String filename;
    String urlFilename;

}
