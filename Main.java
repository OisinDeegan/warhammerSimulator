import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random ranNum = new Random();
        Scanner input= new Scanner(System.in);
        /* Setting up variables */
        int x, y, z=0;
        int bs =0;
        int str =0;
        int t=0;
        int attack=0;
        int models=0;
        int susModTotal =0;
        int susMod =0;
        int susModCounter=0;
        int save=0;
        int invSave=10;
        int rend=0;
        int whileControl1 =1;
        int whileControl2=1;
        String fancy = "";
        boolean Lethal=false;
        boolean DevWo=false;
        boolean Sus =false;
        boolean invuln=false;
        ToHit hit = new ToHit();
        ToWound ouch = new ToWound();
        ToSave armor = new ToSave();

        System.out.print("Enter the amount of models in the attacking unit: ");
        models=input.nextInt();
        System.out.print("Enter the amount of attacks: ");
        attack=input.nextInt();
        System.out.print("Enter the ballistics/weapons skill: ");
        bs=input.nextInt();
        System.out.print("Enter the strength: ");
        str=input.nextInt();
        System.out.print("Enter the toughness of your opponent: ");
        t=input.nextInt();
        System.out.print("Enter the AP value: ");
        rend=input.nextInt();
        System.out.print("Does the attack have any special effects? (y/n to open selection): ");
        fancy=input.next();
        if (fancy.equalsIgnoreCase("y")) {
            System.out.print("Does the attack have Lethal Hits? (y/n): ");
            fancy=input.next();
            if (fancy.equalsIgnoreCase("y")) {
                Lethal=true;
            }
            System.out.print("Does the attack have Devestating Wounds? (y/n): ");
            fancy=input.next();
            if (fancy.equalsIgnoreCase("y")) {
                DevWo=true;
            }
            System.out.print("Does the attack have Sustained hits? (y/n): ");
            fancy=input.next();
            if (fancy.equalsIgnoreCase("y")) {
                Sus=true;
            }
        }
        if (Sus==true) {
            System.out.print("what is the modifier? (e.g. Sustained Hits 1): ");
            susMod=input.nextInt();
        }
        System.out.print("Enter the target unit Save value: ");
        save=input.nextInt();
        System.out.print("Does the target unit have an Invulnerable Save? (y/n): ");
        fancy=input.next();
        if (fancy.equalsIgnoreCase("y")) {
            invuln=true;
            System.out.print("Enter the target unit Invul. save value: ");
            invSave=input.nextInt();
        }
        // loop in case there are multiple models in a unit (each one gets to attack)
        while (whileControl2<=models) {
            System.out.println();
            if (models==1) {
                System.out.print("Only model ");
            }else{
                System.out.print("Model "+whileControl2+" ");
            }
            // attack calulations
            whileControl1=1;
            while (whileControl1<=attack) {
                System.out.println();
                System.out.println("Attack number "+whileControl1);
                x=ranNum.nextInt(6) + 1;
                y=ranNum.nextInt(6) + 1;
                z=ranNum.nextInt(6) + 1;
                if (hit.hitCheck(bs, x)) {
                    System.out.println("Your attack hit! WAAAAGH!!");
                    if (hit.critCheck(Sus, Lethal, x)) {
                        if(Lethal==true){
                            System.out.println("You automatically wound with a critical hit");
                            armor.regSave(z, rend, save, invSave, invuln);
                        }
                        if(Sus==true){
                            System.out.println("Regular attack: ");
                            if (ouch.woundCheck(str, t, y)){
                                if (DevWo) {
                                    armor.devWoSave(z, rend, save, invSave, invuln);
                                } else {
                                    armor.regSave(z, rend, save, invSave, invuln);
                                }
                                
                            }
                            System.out.println("Sustained attack(s): ");
                            for(int i=1;i<=susMod;i++){
                                int ySus=ranNum.nextInt(6) + 1;
                                int zSus=ranNum.nextInt(6) + 1;
                                System.out.println("Sustained wound roll "+i);
                                if (ouch.woundCheck(str, t, ySus)){
                                    System.out.println("Sustained save roll "+i);
                                    if (DevWo) {
                                        armor.devWoSave(zSus, rend, save, invSave, invuln);
                                    } else {
                                        armor.regSave(zSus, rend, save, invSave, invuln);
                                    }
                                    
                                }
                                System.out.println();
                            }
                        }
                    }else if (ouch.woundCheck(str, t, y)){
                        if (DevWo) {
                            armor.devWoSave(z, rend, save, invSave, invuln);
                        } else {
                            armor.regSave(z, rend, save, invSave, invuln);
                        }
                        
                    }
                            
                }else{
                    System.out.println("Your attack misses :(");
                }
                whileControl1++;
            }    
            whileControl2++;
        }
        input.close();       
    }
}
