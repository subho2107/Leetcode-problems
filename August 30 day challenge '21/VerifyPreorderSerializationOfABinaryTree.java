import java.io.*;
import java.util.*;

public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        String [] arr = preorder.split(",");
        int slots = 1;
        for(String node : arr){
            if(slots <= 0)
                return false;
            if(node.charAt(0) == '#')
                slots--;
            else
                slots++;
        }
        return slots == 0;
    }
}
