package com.example.proiectcolectiv.model;

public class Eroare {
    private String error;
    public Eroare(){
        this.error="Unexpected error!";
    }

    @Override
    public String toString() {
        return "Eroare{" +
                "error='" + error + '\'' +
                '}';
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
