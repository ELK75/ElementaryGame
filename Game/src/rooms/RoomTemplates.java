package rooms;

import walls.*;

public class RoomTemplates {

    public static final int ROOM_TYPES = 1;

    public static final char[][] BASIC_ROOM_TEMPLATE = new char[][]{
        {'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n'},
        {'n', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'n'},
        {'n', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'n'},
        {'n', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'n'},
        {'n', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'n'},
        {'n', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'n'},
        {'n', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'n'},
        {'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n'}
    };

    public static final char[][][] ROOM_TEMPLATES = new char[][][]{BASIC_ROOM_TEMPLATE};
}
