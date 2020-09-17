import java.util.HashMap;

public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        String direction = "north";
        HashMap<String, String> left = new HashMap<>();
        left.put("north", "west");
        left.put("west", "south");
        left.put("south", "east");
        left.put("east", "north");
        HashMap<String, String> right = new HashMap<>();
        right.put("north", "east");
        right.put("west", "north");
        right.put("south", "west");
        right.put("east", "south");
        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                if (direction.equals("west"))
                    x--;
                else if (direction.equals("east"))
                    x++;
                else if (direction.equals("north"))
                    y++;
                else
                    y--;
            } else if (ch == 'L') {
                direction = left.get(direction);
            } else {
                direction = right.get(direction);
            }
        }
        if ((x == 0 && y == 0) || !direction.equals("north"))
            return true;
        return false;

    }
}
