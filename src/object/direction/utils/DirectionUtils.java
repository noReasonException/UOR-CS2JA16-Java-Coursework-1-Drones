package object.direction.utils;

import math.vector.Vector2;
import math.vector.Vector3;

import java.util.Map;


public class DirectionUtils {
    public static double directionToRadians(Vector2 direction){
        Vector2 norm = direction.norm();

        Vector2 i_hat = new Vector2(1,0);


        System.out.println(norm.toString());

        switch (direction.getQuantrant()){
            case First:
            case Second:return norm.angle(i_hat);
            case Third:
            case Fourth:return (2*Math.PI -norm.angle(i_hat));
            default:return 0;//unreachable , but java sucks
        }


    }
}
