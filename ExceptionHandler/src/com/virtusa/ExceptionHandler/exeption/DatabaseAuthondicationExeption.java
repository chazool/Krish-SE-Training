package com.virtusa.ExceptionHandler.exeption;

public class DatabaseAuthondicationExeption  extends RuntimeException {

    static final long serialVersionUID = -1;
   public  DatabaseAuthondicationExeption(String message,Throwable cause){
       super(message,cause);
   }


}
