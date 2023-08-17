package io.jira.history.common.models;

import org.bson.types.ObjectId;

import java.util.Date;

public class BaseEntity {
    public static final String ID_FIELD = "_id";
    public static final String CREATED_AT_FIELD = "createdAt";
    public static final String UPDATED_AT_FIELD = "updatedAt";

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
