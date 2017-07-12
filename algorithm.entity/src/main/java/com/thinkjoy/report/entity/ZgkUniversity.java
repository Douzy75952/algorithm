package com.thinkjoy.report.entity;

import java.io.Serializable;

public class ZgkUniversity implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.id
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.name
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.code
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.provinceCode
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private String provincecode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.subjection
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private String subjection;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.areaid
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private String areaid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.type
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.url
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.photo_url
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private String photoUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.property
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private String property;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.xc_rank
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private String xcRank;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.rank
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private Integer rank;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.educationLevel
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private Integer educationlevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.isProportion
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private Boolean isproportion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.isRange
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private Boolean isrange;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.rankTrend
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private String ranktrend;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.createDate
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private Long createdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.creator
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private Long creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.lastModDate
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private Long lastmoddate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.lastModifier
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private Long lastmodifier;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university.is_delete
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private Boolean isDelete;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table zgk_university
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.id
     *
     * @return the value of zgk_university.id
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.id
     *
     * @param id the value for zgk_university.id
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.name
     *
     * @return the value of zgk_university.name
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.name
     *
     * @param name the value for zgk_university.name
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.code
     *
     * @return the value of zgk_university.code
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.code
     *
     * @param code the value for zgk_university.code
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.provinceCode
     *
     * @return the value of zgk_university.provinceCode
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public String getProvincecode() {
        return provincecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.provinceCode
     *
     * @param provincecode the value for zgk_university.provinceCode
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode == null ? null : provincecode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.subjection
     *
     * @return the value of zgk_university.subjection
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public String getSubjection() {
        return subjection;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.subjection
     *
     * @param subjection the value for zgk_university.subjection
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setSubjection(String subjection) {
        this.subjection = subjection == null ? null : subjection.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.areaid
     *
     * @return the value of zgk_university.areaid
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public String getAreaid() {
        return areaid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.areaid
     *
     * @param areaid the value for zgk_university.areaid
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.type
     *
     * @return the value of zgk_university.type
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.type
     *
     * @param type the value for zgk_university.type
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.url
     *
     * @return the value of zgk_university.url
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.url
     *
     * @param url the value for zgk_university.url
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.photo_url
     *
     * @return the value of zgk_university.photo_url
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.photo_url
     *
     * @param photoUrl the value for zgk_university.photo_url
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.property
     *
     * @return the value of zgk_university.property
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public String getProperty() {
        return property;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.property
     *
     * @param property the value for zgk_university.property
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setProperty(String property) {
        this.property = property == null ? null : property.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.xc_rank
     *
     * @return the value of zgk_university.xc_rank
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public String getXcRank() {
        return xcRank;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.xc_rank
     *
     * @param xcRank the value for zgk_university.xc_rank
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setXcRank(String xcRank) {
        this.xcRank = xcRank == null ? null : xcRank.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.rank
     *
     * @return the value of zgk_university.rank
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.rank
     *
     * @param rank the value for zgk_university.rank
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.educationLevel
     *
     * @return the value of zgk_university.educationLevel
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public Integer getEducationlevel() {
        return educationlevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.educationLevel
     *
     * @param educationlevel the value for zgk_university.educationLevel
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setEducationlevel(Integer educationlevel) {
        this.educationlevel = educationlevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.isProportion
     *
     * @return the value of zgk_university.isProportion
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public Boolean getIsproportion() {
        return isproportion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.isProportion
     *
     * @param isproportion the value for zgk_university.isProportion
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setIsproportion(Boolean isproportion) {
        this.isproportion = isproportion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.isRange
     *
     * @return the value of zgk_university.isRange
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public Boolean getIsrange() {
        return isrange;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.isRange
     *
     * @param isrange the value for zgk_university.isRange
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setIsrange(Boolean isrange) {
        this.isrange = isrange;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.rankTrend
     *
     * @return the value of zgk_university.rankTrend
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public String getRanktrend() {
        return ranktrend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.rankTrend
     *
     * @param ranktrend the value for zgk_university.rankTrend
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setRanktrend(String ranktrend) {
        this.ranktrend = ranktrend == null ? null : ranktrend.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.createDate
     *
     * @return the value of zgk_university.createDate
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public Long getCreatedate() {
        return createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.createDate
     *
     * @param createdate the value for zgk_university.createDate
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.creator
     *
     * @return the value of zgk_university.creator
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.creator
     *
     * @param creator the value for zgk_university.creator
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.lastModDate
     *
     * @return the value of zgk_university.lastModDate
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public Long getLastmoddate() {
        return lastmoddate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.lastModDate
     *
     * @param lastmoddate the value for zgk_university.lastModDate
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setLastmoddate(Long lastmoddate) {
        this.lastmoddate = lastmoddate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.lastModifier
     *
     * @return the value of zgk_university.lastModifier
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public Long getLastmodifier() {
        return lastmodifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.lastModifier
     *
     * @param lastmodifier the value for zgk_university.lastModifier
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setLastmodifier(Long lastmodifier) {
        this.lastmodifier = lastmodifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university.is_delete
     *
     * @return the value of zgk_university.is_delete
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university.is_delete
     *
     * @param isDelete the value for zgk_university.is_delete
     *
     * @mbggenerated Wed May 03 14:40:13 CST 2017
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}