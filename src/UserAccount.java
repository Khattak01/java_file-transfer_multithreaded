package servermain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Khattak01
 */
class UserAccount 
{
    private String username;
    private String password;
    //private String[][] accounts = {{"12345", "12345"},{"rida", "rida"},{"sir", "ahmed"},{"khattak01", "01"}};
    private ArrayList<String> listOfLines = new ArrayList<>();
    public UserAccount(String username, String password) throws IOException 
    {
        BufferedReader bufReader = new BufferedReader(new FileReader("E:\\file.txt"));
        //ArrayList<String> listOfLines = new ArrayList<>();
        String line = bufReader.readLine();
        while (line != null) {
            listOfLines.add(line);
            //System.out.println(line);
            line = bufReader.readLine();
        }
        bufReader.close();
        this.username = username;
        this.password = password;
    }

    public boolean checkPassword()
    {
        boolean result = true;
        /*for(int i=0;i<accounts.length;i++)
        {
            if((this.username.equals(accounts[i][0])) && (this.password.equals(accounts[i][1])))
                result = true;
            else
                result =  false;
        }
        return result;*/
        for(int i=0;i<listOfLines.size();i++){
            //System.out.println("SIZE : "+listOfLines.size()+"  I : "+i);
            String ele = listOfLines.get(i);
            //System.out.println(ele);
            String[] elements = ele.split(",",2);
            //System.out.println(elements[0]);
            if(elements[0].equals(this.username) && elements[1].equals(this.password)){
                System.out.println("Good");
                result = true;
                break;
            }
            else
                result = false;
            //System.out.println(listOfLines.get(i));
        }
        System.out.println(result);
        return result;
    }
    public static void register(Scanner var)
    {
        String user,pass,rePass;
        System.out.println("USERNAME");
        user = var.nextLine();
        System.out.println("PASSWORD");
        pass = var.nextLine();
        System.out.println("re-enter PASSWORD");
        rePass = var.nextLine();
        if(!pass.equals(rePass)){
            System.out.println("Invalid");
            return;
        }
        try
        {    
            FileWriter fw=new FileWriter("E:\\file.txt",true);    
            fw.write(user+","+pass+"\n");    
            fw.close();    
        }
        catch(Exception e)
        {
            System.out.println(e);
        }    
        System.out.println("Success...");    
    } 

    /*public static void makeList() throws IOException{
        BufferedReader bufReader = new BufferedReader(new FileReader("E:\\file.txt"));
        ArrayList<String> listOfLines = new ArrayList<>();
        String line = bufReader.readLine();
        while (line != null) {
            listOfLines.add(line);
            //System.out.println(line);
            line = bufReader.readLine();
        }
        bufReader.close();
        for(int i=0;i<listOfLines.size();i++){
            String ele = listOfLines.get(i);
            String[] elements = ele.split(",",2);
            //System.out.println(elements[0]);
            if(elements[0].equals("khattak01") && elements[1].equals("01"))
                System.out.println("Good");
            //System.out.println(listOfLines.get(i));
        }
    }*/
}


