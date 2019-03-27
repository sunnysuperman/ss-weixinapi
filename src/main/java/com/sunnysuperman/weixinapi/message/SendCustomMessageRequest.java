package com.sunnysuperman.weixinapi.message;

public class SendCustomMessageRequest {
    public static class VideoMessage {
        private String mediaId;
        private String thumbMediaId;
        private String title;
        private String description;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }

    public static class ArticleMessage {
        private String title;
        private String description;
        private String url;
        private String picurl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

    }

    private String touser;
    private String text;
    private String image;
    private String voice;
    private VideoMessage video;
    private ArticleMessage[] articles;
    private String mpNewsId;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public VideoMessage getVideo() {
        return video;
    }

    public void setVideo(VideoMessage video) {
        this.video = video;
    }

    public ArticleMessage[] getArticles() {
        return articles;
    }

    public void setArticles(ArticleMessage[] articles) {
        this.articles = articles;
    }

    public String getMpNewsId() {
        return mpNewsId;
    }

    public void setMpNewsId(String mpNewsId) {
        this.mpNewsId = mpNewsId;
    }

}
