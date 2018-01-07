package com.padcmyanmar.news.data.vo;

/**
 * Created by aung on 12/17/17.
 */

public class CommentVO {

    private String commentId;
    private String comment;
    private String commentDate;
    private ActedUserVO actedUser;

    public String getCommentId() {
        return commentId;
    }

    public String getComment() {
        return comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }
}
