package vn.edu.iuh.fit.enums;

public enum Roles {
    ADMINISTRATION(1), STAFF(2), MANAGER(3), EXECUTIVE(4);
    private final int role;

    private Roles(int role) {
        this.role = role;
    }
    public int getRole() {
        return role;
    }
    public static Roles fromValue(int value) {
        for (Roles role : Roles.values()) {
            if (role.role == value) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role value: " + value);
    }
}
