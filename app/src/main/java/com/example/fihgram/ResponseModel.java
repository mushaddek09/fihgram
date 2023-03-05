package com.example.fihgram;

public class ResponseModel {


    String id;
    String user_name;
    String post_image;
    String description;
    String image_profile;

    public ResponseModel() {
    }

    public ResponseModel(String id, String user_name, String post_image, String description, String image_profile) {
        this.id = id;
        this.user_name = user_name;
        this.post_image = post_image;
        this.description = description;
        this.image_profile = image_profile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPost_image() {
        return post_image;
    }

    public void setPost_image(String post_image) {
        this.post_image = post_image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_profile() {
        return image_profile;
    }

    public void setImage_profile(String image_profile) {
        this.image_profile = image_profile;
    }


}
