package test;

import java.io.File;

/**
 * Created by test on 08.11.15.
 */
public class PathHelper {

    public static String findCurrentLocation(){
        return new File(".").getAbsolutePath();
    }


}
