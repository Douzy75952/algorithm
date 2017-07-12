package com.thinkjoy.report.entity;

import java.io.Serializable;

public class ZgkUniversityMajorEnrolling implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university_enrolling.id
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university_enrolling.universityId
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    private Long universityid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university_enrolling.areaId
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    private String areaid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university_enrolling.year
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    private Integer year;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university_enrolling.batch
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    private String batch;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university_enrolling.majorType
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    private String majortype;

    private String universityname;
    private String majorname;

    public String getUniversityname() {
        return universityname;
    }

    public void setUniversityname(String universityname) {
        this.universityname = universityname;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university_enrolling.realEnrollingNumber
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    private String realenrollingnumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university_enrolling.highestScore
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    private String highestscore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university_enrolling.lowestScore
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    private String lowestscore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university_enrolling.averageScore
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    private String averagescore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university_enrolling.planEnrollingNumber
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    private Integer planenrollingnumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university_enrolling.highestPrecedence
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    private Integer highestprecedence;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university_enrolling.lowestPrecedence
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    private Integer lowestprecedence;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zgk_university_enrolling.averagePrecedence
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    private Integer averageprecedence;


    //优志愿对应的学校id
    private Integer yzyuniversityid;
    //学校在该地区的分数信息
    private String dataareaname;

    public Integer getYzyuniversityid() {
        return yzyuniversityid;
    }

    public void setYzyuniversityid(Integer yzyuniversityid) {
        this.yzyuniversityid = yzyuniversityid;
    }

    public String getDataareaname() {
        return dataareaname;
    }

    public void setDataareaname(String dataareaname) {
        this.dataareaname = dataareaname;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table zgk_university_enrolling
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university_enrolling.id
     *
     * @return the value of zgk_university_enrolling.id
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university_enrolling.id
     *
     * @param id the value for zgk_university_enrolling.id
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university_enrolling.universityId
     *
     * @return the value of zgk_university_enrolling.universityId
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public Long getUniversityid() {
        return universityid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university_enrolling.universityId
     *
     * @param universityid the value for zgk_university_enrolling.universityId
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public void setUniversityid(Long universityid) {
        this.universityid = universityid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university_enrolling.areaId
     *
     * @return the value of zgk_university_enrolling.areaId
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public String getAreaid() {
        return areaid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university_enrolling.areaId
     *
     * @param areaid the value for zgk_university_enrolling.areaId
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university_enrolling.year
     *
     * @return the value of zgk_university_enrolling.year
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public Integer getYear() {
        return year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university_enrolling.year
     *
     * @param year the value for zgk_university_enrolling.year
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university_enrolling.batch
     *
     * @return the value of zgk_university_enrolling.batch
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public String getBatch() {
        return batch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university_enrolling.batch
     *
     * @param batch the value for zgk_university_enrolling.batch
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public void setBatch(String batch) {
        this.batch = batch == null ? null : batch.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university_enrolling.majorType
     *
     * @return the value of zgk_university_enrolling.majorType
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public String getMajortype() {
        return majortype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university_enrolling.majorType
     *
     * @param majortype the value for zgk_university_enrolling.majorType
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public void setMajortype(String majortype) {
        this.majortype = majortype == null ? null : majortype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university_enrolling.realEnrollingNumber
     *
     * @return the value of zgk_university_enrolling.realEnrollingNumber
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public String getRealenrollingnumber() {
        return realenrollingnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university_enrolling.realEnrollingNumber
     *
     * @param realenrollingnumber the value for zgk_university_enrolling.realEnrollingNumber
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public void setRealenrollingnumber(String realenrollingnumber) {
        this.realenrollingnumber = realenrollingnumber == null ? null : realenrollingnumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university_enrolling.highestScore
     *
     * @return the value of zgk_university_enrolling.highestScore
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public String getHighestscore() {
        return highestscore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university_enrolling.highestScore
     *
     * @param highestscore the value for zgk_university_enrolling.highestScore
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public void setHighestscore(String highestscore) {
        this.highestscore = highestscore == null ? null : highestscore.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university_enrolling.lowestScore
     *
     * @return the value of zgk_university_enrolling.lowestScore
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public String getLowestscore() {
        return lowestscore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university_enrolling.lowestScore
     *
     * @param lowestscore the value for zgk_university_enrolling.lowestScore
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public void setLowestscore(String lowestscore) {
        this.lowestscore = lowestscore == null ? null : lowestscore.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university_enrolling.averageScore
     *
     * @return the value of zgk_university_enrolling.averageScore
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public String getAveragescore() {
        return averagescore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university_enrolling.averageScore
     *
     * @param averagescore the value for zgk_university_enrolling.averageScore
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public void setAveragescore(String averagescore) {
        this.averagescore = averagescore == null ? null : averagescore.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university_enrolling.planEnrollingNumber
     *
     * @return the value of zgk_university_enrolling.planEnrollingNumber
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public Integer getPlanenrollingnumber() {
        return planenrollingnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university_enrolling.planEnrollingNumber
     *
     * @param planenrollingnumber the value for zgk_university_enrolling.planEnrollingNumber
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public void setPlanenrollingnumber(Integer planenrollingnumber) {
        this.planenrollingnumber = planenrollingnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university_enrolling.highestPrecedence
     *
     * @return the value of zgk_university_enrolling.highestPrecedence
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public Integer getHighestprecedence() {
        return highestprecedence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university_enrolling.highestPrecedence
     *
     * @param highestprecedence the value for zgk_university_enrolling.highestPrecedence
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public void setHighestprecedence(Integer highestprecedence) {
        this.highestprecedence = highestprecedence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university_enrolling.lowestPrecedence
     *
     * @return the value of zgk_university_enrolling.lowestPrecedence
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public Integer getLowestprecedence() {
        return lowestprecedence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university_enrolling.lowestPrecedence
     *
     * @param lowestprecedence the value for zgk_university_enrolling.lowestPrecedence
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public void setLowestprecedence(Integer lowestprecedence) {
        this.lowestprecedence = lowestprecedence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zgk_university_enrolling.averagePrecedence
     *
     * @return the value of zgk_university_enrolling.averagePrecedence
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public Integer getAverageprecedence() {
        return averageprecedence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zgk_university_enrolling.averagePrecedence
     *
     * @param averageprecedence the value for zgk_university_enrolling.averagePrecedence
     *
     * @mbggenerated Wed May 03 15:10:16 CST 2017
     */
    public void setAverageprecedence(Integer averageprecedence) {
        this.averageprecedence = averageprecedence;
    }
}