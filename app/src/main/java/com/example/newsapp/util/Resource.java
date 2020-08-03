package com.example.newsapp.util;

import androidx.annotation.Nullable;

public abstract class Resource<T>{
    @Nullable
    private T data = null;

    @Nullable
    private String message = null;

    public class Success<T> extends Resource<T> {
        private T data;

        public Success(T data) {
            this.data = data;
        }
    }

    public class Error<T> extends Resource<T> {
        @Nullable
        private T data = null;
        private String message;

        public Error(@Nullable T data, String message) {
            this.data = data;
            this.message = message;
        }
    }

    public class Loading<T> extends Resource<T> {
        public Loading() {
        }
    }
}
