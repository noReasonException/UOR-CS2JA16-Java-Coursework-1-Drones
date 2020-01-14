package math.vector;

import math.vector.etc.LinearlyComplexOps;
import math.vector.etc.Quantrant;

import java.util.List;

import static math.utils.VectorCoreUtils.list2;

public class Vector2 extends Vector implements LinearlyComplexOps<Vector2> {

    public Vector2 zero() { return new Vector2(core.toZero()); }

    public Double magnitude() { return core.length(); }


    public Vector2 add(Vector2 any) {
        return new Vector2(core.addition(any.core));
    }

    public Vector2 scale(Double scalar) {
        return new Vector2(core.scalar(scalar));
    }
    public Vector2(List<Double> elements) {
        super(new VectorCore(elements,2));
    }
    public Vector2(int x,int y) {
        super(new VectorCore(list2(x,y),2));
    }

    public Double dot(Vector2 any){ return core.dot(any.core); }
    public Vector2(VectorCore core) { super(core); }

    public Quantrant getQuantrant(){
        if(core.getElement(0)>0){
            if(core.getElement(1)>0){
                return Quantrant.First;
            }
            else return Quantrant.Fourth;
        }
        else{
            if(core.getElement(1)>0){
                return Quantrant.Second;
            }
            else return Quantrant.Third;
        }
    }
}
