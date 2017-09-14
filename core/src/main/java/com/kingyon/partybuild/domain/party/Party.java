package com.kingyon.partybuild.domain.party;

import com.kingyon.common.domain.AuditedDomain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 支部
 */
@Entity
@Table(name = "S_PART")
public class Party extends AuditedDomain {

    /**
     * Default constructor
     */
    public Party() {
    }

    /**
     *
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}