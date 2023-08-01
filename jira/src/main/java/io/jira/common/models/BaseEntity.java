package io.jira.common.models;

import org.bson.types.ObjectId;

import java.util.Date;

public class BaseEntity {

    public String id;
    public Date createdAt;
    public Date updatedAt;


    public void setCreatedAndUpdatedAt() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }

    public void setObjectId() {
        this.id = new ObjectId().toString();
    }


    public String getId() {
        return id;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
