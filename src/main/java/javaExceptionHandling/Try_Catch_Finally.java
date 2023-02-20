package javaExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Try_Catch_Finally
{

    public static void main(String[] args) {

        //txt file okuma yapiyoruz

        try_catch_finally_kullanimi_structuralProgramming();

        try_catch_finally_kullanimi_functionalProgramming();

    }


    private static void try_catch_finally_kullanimi_structuralProgramming()
    {
        FileReader fileReader=null;
        BufferedReader bufferedReader=null;

        try {
            fileReader = new FileReader("src/test/java/DB_Testing/javaExceptionHandling/data.txt");
            bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e)
        {
            System.out.println("Boyle bir dosya bulunamadi!!!");
        }
        finally
        {
            try
            {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e)
            {
                System.out.println("Boyle bir dosya bulunamadi!!!");
            }
        }

    }


    private static void try_catch_finally_kullanimi_functionalProgramming()
    {

        try {
            Files.lines(Paths.get("src/test/java/DB_Testing/javaExceptionHandling/data.txt")).forEach(x -> System.out.println(x));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
