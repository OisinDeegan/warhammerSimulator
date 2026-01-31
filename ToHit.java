public class ToHit {

    public boolean hitCheck(int bs, int x){
        if(bs<=x){
            return true;
        }else{
        return false;
        }
    }

    public boolean critCheck(boolean Sus, boolean Lethal, int x){
        if(Sus == true|| Lethal == true){
            if(x==6){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

}