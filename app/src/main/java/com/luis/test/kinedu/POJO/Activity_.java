package com.luis.test.kinedu.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Activity_ {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("age_group")
    @Expose
    private String ageGroup;
    @SerializedName("activity_type")
    @Expose
    private String activityType;
    @SerializedName("is_holiday")
    @Expose
    private Boolean isHoliday;
    @SerializedName("domain_id")
    @Expose
    private Integer domainId;
    @SerializedName("area_id")
    @Expose
    private Integer areaId;
    @SerializedName("purpose")
    @Expose
    private String purpose;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("active_milestones")
    @Expose
    private Integer activeMilestones;
    @SerializedName("completed_milestones")
    @Expose
    private Integer completedMilestones;

    @SerializedName("video_provider_thumbnails")
    @Expose
    private VideoProviderThumbnails videoProviderThumbnails;
    @SerializedName("video_id")
    @Expose
    private String videoId;

    @SerializedName("shareable_video_url")
    @Expose
    private String shareableVideoUrl;
    @SerializedName("shareable_thumbnail_url")
    @Expose
    private String shareableThumbnailUrl;
    @SerializedName("locked")
    @Expose
    private Boolean locked;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("faved")
    @Expose
    private Boolean faved;



    public Activity_(Integer id, String name, Integer age, String ageGroup, String activityType, Boolean isHoliday, Integer domainId, Integer areaId, String purpose, String thumbnail, Integer activeMilestones, Integer completedMilestones) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ageGroup = ageGroup;
        this.activityType = activityType;
        this.isHoliday = isHoliday;
        this.domainId = domainId;
        this.areaId = areaId;
        this.purpose = purpose;
        this.thumbnail = thumbnail;
        this.activeMilestones = activeMilestones;
        this.completedMilestones = completedMilestones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Boolean getIsHoliday() {
        return isHoliday;
    }

    public void setIsHoliday(Boolean isHoliday) {
        this.isHoliday = isHoliday;
    }

    public Integer getDomainId() {
        return domainId;
    }

    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getActiveMilestones() {
        return activeMilestones;
    }

    public void setActiveMilestones(Integer activeMilestones) {
        this.activeMilestones = activeMilestones;
    }

    public Integer getCompletedMilestones() {
        return completedMilestones;
    }

    public void setCompletedMilestones(Integer completedMilestones) {
        this.completedMilestones = completedMilestones;
    }

    public Boolean getHoliday() {
        return isHoliday;
    }

    public void setHoliday(Boolean holiday) {
        isHoliday = holiday;
    }

    public VideoProviderThumbnails getVideoProviderThumbnails() {
        return videoProviderThumbnails;
    }

    public void setVideoProviderThumbnails(VideoProviderThumbnails videoProviderThumbnails) {
        this.videoProviderThumbnails = videoProviderThumbnails;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getShareableVideoUrl() {
        return shareableVideoUrl;
    }

    public void setShareableVideoUrl(String shareableVideoUrl) {
        this.shareableVideoUrl = shareableVideoUrl;
    }

    public String getShareableThumbnailUrl() {
        return shareableThumbnailUrl;
    }

    public void setShareableThumbnailUrl(String shareableThumbnailUrl) {
        this.shareableThumbnailUrl = shareableThumbnailUrl;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Boolean getFaved() {
        return faved;
    }

    public void setFaved(Boolean faved) {
        this.faved = faved;
    }
}
