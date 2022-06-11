package unit1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author parthverma
 */
public class CharException extends Exception{
    public CharException(String message){
        super(message);
    }
    public String getMessage(){
        return super.getMessage();
    }
}
