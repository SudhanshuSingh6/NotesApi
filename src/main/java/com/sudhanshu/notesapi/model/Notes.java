package com.sudhanshu.notesapi.model;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Notes {
    @Id
    private String id;
    private String username;
    private String note;

    public Notes() {

    }

    public Notes(String username, String note) {
        this.note = note;
        this.username=username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername() {
        return username;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}