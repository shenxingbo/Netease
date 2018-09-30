package com.code.pojo;

/**
 * @Author shen
 * @Date 2018/9/30
 * @Function:
 **/
public class Comment {
    private String against;
    private String anonymous;
    private String buildLevel;
    private String commentId;
    private String content;
    private String createTime;
    private String favCount;
    private String ip;
    private String isDel;
    private String postId;
    private String productKey;
    private String shareCount;
    private String siteName;
    private String source;
    private String unionState;
    private String vote;
    private User user;

    public String getAgainst() {
        return against;
    }

    public void setAgainst(String against) {
        this.against = against;
    }

    public String getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(String anonymous) {
        this.anonymous = anonymous;
    }

    public String getBuildLevel() {
        return buildLevel;
    }

    public void setBuildLevel(String buildLevel) {
        this.buildLevel = buildLevel;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFavCount() {
        return favCount;
    }

    public void setFavCount(String favCount) {
        this.favCount = favCount;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getShareCount() {
        return shareCount;
    }

    public void setShareCount(String shareCount) {
        this.shareCount = shareCount;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUnionState() {
        return unionState;
    }

    public void setUnionState(String unionState) {
        this.unionState = unionState;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "against='" + against + '\'' +
                ", anonymous='" + anonymous + '\'' +
                ", buildLevel='" + buildLevel + '\'' +
                ", commentId='" + commentId + '\'' +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", favCount='" + favCount + '\'' +
                ", ip='" + ip + '\'' +
                ", isDel='" + isDel + '\'' +
                ", postId='" + postId + '\'' +
                ", productKey='" + productKey + '\'' +
                ", shareCount='" + shareCount + '\'' +
                ", siteName='" + siteName + '\'' +
                ", source='" + source + '\'' +
                ", unionState='" + unionState + '\'' +
                ", vote='" + vote + '\'' +
                ", user=" + user +
                '}';
    }
}
