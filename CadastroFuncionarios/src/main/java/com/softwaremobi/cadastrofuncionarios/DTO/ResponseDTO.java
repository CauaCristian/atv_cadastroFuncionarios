package com.softwaremobi.cadastrofuncionarios.DTO;

// ResponseDTO.java
public class ResponseDTO<T> {
    public boolean error;
    public String message;
    public T data;
    public String token;

    public ResponseDTO(boolean error, String message, T data, String token) {
        this.error = error;
        this.message = message;
        this.data = data;
        this.token = token;
    }
}
