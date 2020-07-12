package com.example.radyapp.StaffSide.ModelsS;


public class NoteModel  {
    private String note;
    private boolean done;

    public NoteModel() {
    }

    public NoteModel(String note, boolean done) {
        this.note = note;
        this.done = done;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
