/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Property;

/**
 *
 * @author thoma
 */
public enum TypeOfProperty {
    APARTMENT,
    HOUSE,
    VILLA,
    CASTLE,
    HUT,
    OTHER;
    
    public static void displayEnumTypeOfProperty(){
        System.out.println("1 : APARTMENT");
        System.out.println("2 : HOUSE");
        System.out.println("3 : VILLA");
        System.out.println("4 : CASTLE");
        System.out.println("5 : HUT");
        System.out.println("6 : OTHER");
    }
}
