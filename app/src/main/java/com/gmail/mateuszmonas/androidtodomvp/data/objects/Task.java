package com.gmail.mateuszmonas.androidtodomvp.data.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class Task implements Parcelable {
    private int _id;
    private String _description;
    private boolean _done;

    Task(int _id, String _description, boolean _done) {
        this._id = _id;
        this._description = _description;
        this._done = _done;
    }

    public Task(String _description, boolean _done) {
        this._description = _description;
        this._done=_done;
    }

    Task(String _description) {
        this._description = _description;
        this._done=false;
    }

    private Task(Parcel source){
        _description=source.readString();
        _id=source.readInt();
        _done=source.readByte() != 0;
    }

    Task(){
        _id=0;
        _description="";
        _done=false;
    }

    public int get_id() {
        return _id;
    }

    void set_id(int _id) {
        this._id = _id;
    }

    public String get_description() {
        return _description;
    }

    void set_description(String _description) {
        this._description = _description;
    }

    public boolean is_done() {
        return _done;
    }

    void set_done(boolean _isDone) {
        this._done = _isDone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(_description);
        parcel.writeInt(_id);
        parcel.writeByte((byte) (_done ? 1 : 0));
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }

        @Override
        public Task createFromParcel(Parcel source) {
            return new Task(source);
        }
    };

}
