package com.sliusar.projectzone.exeptions;

public enum ErrorType {
        USR_NOT_FOUND("The user was not found. Check request details"),
        TASK_NOT_FOUND("The task was not found. Check request details"),
        PROJECT_NOT_FOUND("The project was not found. Check request details");
        private final String message;

        ErrorType(final String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
}
