package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SharePhotoContent extends ShareContent<SharePhotoContent, ShareContent.Builder> {
    public static final Creator<SharePhotoContent> CREATOR = new C04721();
    private final List<SharePhoto> photos;

    /* renamed from: com.facebook.share.model.SharePhotoContent$1 */
    static class C04721 implements Creator<SharePhotoContent> {
        C04721() {
        }

        public SharePhotoContent createFromParcel(Parcel in) {
            return new SharePhotoContent(in);
        }

        public SharePhotoContent[] newArray(int size) {
            return new SharePhotoContent[size];
        }
    }

    public static class Builder extends com.facebook.share.model.ShareContent.Builder<SharePhotoContent, Builder> {
        private final List<SharePhoto> photos = new ArrayList();

        public Builder addPhoto(@Nullable SharePhoto photo) {
            if (photo != null) {
                this.photos.add(new com.facebook.share.model.SharePhoto.Builder().readFrom(photo).build());
            }
            return this;
        }

        public Builder addPhotos(@Nullable List<SharePhoto> photos) {
            if (photos != null) {
                for (SharePhoto photo : photos) {
                    addPhoto(photo);
                }
            }
            return this;
        }

        public SharePhotoContent build() {
            return null;
        }

        public Builder readFrom(SharePhotoContent model) {
            if (model == null) {
                return this;
            }
            return ((Builder) super.readFrom(model)).addPhotos(model.getPhotos());
        }

        public Builder setPhotos(@Nullable List<SharePhoto> photos) {
            this.photos.clear();
            addPhotos(photos);
            return this;
        }
    }

    private SharePhotoContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        this.photos = Collections.unmodifiableList(builder.photos);
    }

    SharePhotoContent(Parcel in) {
        super(in);
        this.photos = Collections.unmodifiableList(com.facebook.share.model.SharePhoto.Builder.readPhotoListFrom(in));
    }

    @Nullable
    public List<SharePhoto> getPhotos() {
        return this.photos;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        com.facebook.share.model.SharePhoto.Builder.writePhotoListTo(out, flags, this.photos);
    }
}
