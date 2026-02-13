public class ToSave{
    // true means the wound has gone through;

    public boolean regSave(int z, int rend, int save, int invSave, boolean invuln){
        if(invuln==true){
            if ((save+rend)>=invSave) {
                rend=0;
                save=invSave;
                System.out.println("The invulnerable save of "+invSave+" is better against this attack, and is used");
            }else{
                System.out.println("Even though there is an invulnerable save, the regular save is better against this attack and is used");
            }
        }
        if (z>=(save+rend)) {
            // z is saving throw, if I have a 3+ save(space marine etc) with rend/ap of 1 it gets worsened to 4+. Then if z is equal to or greater than the target, the save is made and the wound did not go through
            System.out.println("The armor succeeded the save with a roll of "+z+" against a target of "+(save+rend));
            return false;
        }else{
            System.out.println("The armor failed the save with a roll of "+z+" against a target of "+(save+rend));
            return true;
        }
    }
    // devestating wounds
    public boolean devWoSave(int z, int rend, int save, int invSave, boolean invuln){
        if (z==6) {
            System.out.println("With a Devestating Wound, no armor save can be made");
            return true;
        }else{
            return regSave(z, rend, save, invSave, invuln);
        }
    }
}