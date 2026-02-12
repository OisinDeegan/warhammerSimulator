public class ToSave{
    // true means the wound has gone through;

    public boolean regSave(int z, int rend, int save, int invSave, boolean invuln){
        if(invuln==true){
            if ((save+rend)>=invSave) {
                rend=0;
                save=invSave;
            }
        }
        if (z>=(save+rend)) {
            // z is saving throw, if I have a 3+ save(space marine etc) with rend/ap of 1 it gets worsened to 4+. Then if z is equal to or greater than the target, the save is made and the wound did not go through
            return false;
        }else{
            return true;
        }
    }
    // devestating wounds
    public boolean devWoSave(int z, int rend, int save, int invSave, boolean invuln){
        if (z==6) {
            return true;
        }else{
            return regSave(z, rend, save, invSave, invuln);
        }
    }
}