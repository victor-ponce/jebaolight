package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;

public final class ShareVideoContent extends ShareContent<ShareVideoContent, ShareContent.Builder> implements ShareModel {
    public static final Creator<ShareVideoContent> CREATOR = new C04741();
    private final String contentDescription;
    private final String contentTitle;
    private final SharePhoto previewPhoto;
    private final ShareVideo video;

    /* renamed from: com.facebook.share.model.ShareVideoContent$1 */
    static class C04741 implements Creator<ShareVideoContent> {
        C04741() {
        }

        public ShareVideoContent createFromParcel(Parcel in) {
            return new ShareVideoContent(in);
        }

        public ShareVideoContent[] newArray(int size) {
            return new ShareVideoContent[size];
        }
    }

    public static final class Builder extends com.facebook.share.model.ShareContent.Builder<ShareVideoContent, Builder> {
        private String contentDescription;
        private String contentTitle;
        private SharePhoto previewPhoto;
        private ShareVideo video;

        public Builder setContentDescription(@Nullable String contentDescription) {
            this.contentDescription = contentDescription;
            return this;
        }

        public Builder setContentTitle(@Nullable String contentTitle) {
            this.contentTitle = contentTitle;
            return this;
        }

        public Builder setPreviewPhoto(@Nullable SharePhoto previewPhoto) {
            SharePhoto sharePhoto;
            if (previewPhoto == null) {
                sharePhoto = null;
            } else {
                sharePhoto = new com.facebook.share.model.SharePhoto.Builder().readFrom(previewPhoto).build();
            }
            this.previewPhoto = sharePhoto;
            return this;
        }

        public Builder setVideo(@Nullable ShareVideo video) {
            if (video != null) {
                this.video = new com.facebook.share.model.ShareVideo.Builder().readFrom(video).build();
            }
            return this;
        }

        public ShareVideoContent build() {
            return null;
        }

        public Builder readFrom(ShareVideoContent model) {
            if (model == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareVideoContent) model)).setContentDescription(model.getContentDescription()).setContentTitle(model.getContentTitle()).setPreviewPhoto(model.getPreviewPhoto()).setVideo(model.getVideo());
        }
    }

    private ShareVideoContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        this.contentDescription = builder.contentDescription;
        this.contentTitle = builder.contentTitle;
        this.previewPhoto = builder.previewPhoto;
        this.video = builder.video;
    }

    ShareVideoContent(Parcel in) {
        super(in);
        this.contentDescription = in.readString();
        this.contentTitle = in.readString();
        com.facebook.share.model.SharePhoto.Builder previewPhotoBuilder = new com.facebook.share.model.SharePhoto.Builder().readFrom(in);
        if (previewPhotoBuilder.getImageUrl() == null && previewPhotoBuilder.getBitmap() == null) {
            this.previewPhoto = null;
        } else {
            this.previewPhoto = previewPhotoBuilder.build();
        }
        this.video = new com.facebook.share.model.ShareVideo.Builder().readFrom(in).build();
    }

    @Nullable
    public String getContentDescription() {
        return this.contentDescription;
    }

    @Nullable
    public String getContentTitle() {
        return this.contentTitle;
    }

    @Nullable
    public SharePhoto getPreviewPhoto() {
        return this.previewPhoto;
    }

    @Nullable
    public ShareVideo getVideo() {
        return this.video;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeString(this.contentDescription);
        out.writeString(this.contentTitle);
        out.writeParcelable(this.previewPhoto, 0);
        out.writeParcelable(this.video, 0);
    }
}
