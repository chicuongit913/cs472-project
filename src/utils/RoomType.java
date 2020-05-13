package utils;

public enum RoomType {
    SINGLE_ROOM(1,"Single Room"),

    DOUBLE_ROOM(2, "Double Room"),

    TRIPLE_ROOM(3, "Triple Room"),

    QUAD_ROOM(4, "Quad Room"),

    QUEEN_ROOM(5, "Queen Room"),

    KING_ROOM(6, "King Room"),

    TWIN_ROOM(7, "Twin Room"),

    HOLLYWOOD_TWIN_ROOM(8, "Hollywood Twin Room");

    private String name;
    private int code;

    RoomType(int code, String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCode(){
        return code;
    }
}
