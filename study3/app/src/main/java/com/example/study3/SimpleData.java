package com.example.study3;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {
   int code;
   String message;

   public SimpleData(int code, String message){
       this.code=code;
       this.message=message;
   }
   public SimpleData(Parcel src){
       code=src.readInt();
       message=src.readString();
   }

   public static final Parcelable.Creator CREATOR = new Creator() {
       @Override
       public SimpleData createFromParcel(Parcel source) {
           return new SimpleData(source);
       }

       @Override
       public SimpleData[] newArray(int size) {
           return new SimpleData[size];
       }
   };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(message);
    }
}
