package com.boleks.spg5BootSecurity.security;

public enum ApplicationUserPermission {

    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permision;

    ApplicationUserPermission(String permision) {
        this.permision = permision;
    }

    public String getPermision() {
        return permision;
    }
}
