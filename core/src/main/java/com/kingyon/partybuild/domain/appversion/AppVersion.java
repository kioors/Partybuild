package com.kingyon.partybuild.domain.appversion;

import com.kingyon.common.domain.AuditedDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * app版本
 */
@Entity
@Table(name = "S_APP_VERSION")
public class AppVersion extends AuditedDomain {

    /**
     * Default constructor
     */
    public AppVersion() {
    }

    /**
     *
     */
    public String url;

    /**
     *
     */
    @Column(name = "version_code")
    public String versionCode;

    /**
     *
     */
    @Column(name = "version_number")
    public String versionNumber;

    /**
     *
     */
    public String content;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}