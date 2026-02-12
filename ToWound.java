public class ToWound{

    public boolean woundCheck(int str, int t, int y){
        if (str==t) {
            System.out.println("You wound on 4s");
            if (y>=4) {
                System.out.println("You wound them!");
                return true;
            } else {
                System.out.println("You do not wound them");
                return false;
            }
        }else if ((str/2)>=t) {
            System.out.println("You wound on 2s");
            if (y>=2) {
                System.out.println("You wound them!");
                return true;
            } else {
                System.out.println("You do not wound them");
                return false;
            }
        }else if (str>t) {
            System.out.println("You wound on 3s");
            if (y>=3) {
                System.out.println("You wound them!");
                return true;
            } else {
                System.out.println("You do not wound them");
                return false;
            }
        }else if ((t/2)>=str) {
            System.out.println("You wound on 6s");
            if (y>=6) {
                System.out.println("You wound them!");
                return true;
            } else {
                System.out.println("You do not wound them");
                return false;
            }
        }else if (t>str) {
            System.out.println("You wound on 5s");
            if (y>=5) {
                System.out.println("You wound them!");
                return true;
            } else {
                System.out.println("You do not wound them");
                return false;
            }
        }else{
            return false;
        }
    }
}