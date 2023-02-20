package javaExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources_Catch
{

    public static void main(String[] args) {

       // try_catch_finally_kullanimi_structuralProgramming();
        try_catch_finally_kullanimi_functionalProgramming();

    }


    private static void try_catch_finally_kullanimi_structuralProgramming()
    {
        try( BufferedReader reader = new BufferedReader(new FileReader("src/test/java/DB_Testing/javaExceptionHandling/data.txt")))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /*NOT:
    Yukarıdaki kodda, dosya adı "data.txt" olan bir FileReader nesnesi ile sarılmış olan bir BufferedReader nesnesi oluşturuyoruz.
    Her döngüde (readLine () null değerini döndürür) dosyadan her satırı okumak için bir while döngüsü kullanıyoruz.
    Döngünün içinde, her satırı System.out.println() kullanarak konsola yazdırıyoruz.

    Dosyayı kapatmak için try-with-resources ifadesini kullanarak BufferedReader ve FileReader nesnelerini otomatik olarak kapatıyoruz.
    Bu, bir istisna fırlatılsa bile dosyanın düzgün şekilde kapatılmasını sağlar.
    Eğer Java 6 veya daha önceki bir sürüm kullanıyorsanız, finally bloğunu kullanarak BufferedReader ve FileReader nesnelerini kapatmanız gerekiyor.
     */


    private static void try_catch_finally_kullanimi_functionalProgramming() {

        try( BufferedReader reader = new BufferedReader(new FileReader("src/test/java/DB_Testing/javaExceptionHandling/data.txt")))  {

            reader.lines().forEach(line-> System.out.println(line));
        }



        catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*NOT
    Yukarıdaki kodda, "example.txt" dosyasından okuma yapmak için bir FileReader nesnesi ile sarılmış bir BufferedReader nesnesi oluşturuyoruz.
    BufferedReader nesnesinin lines() metodu, dosyadan okunan her satır için bir Stream<String> nesnesi döndürür.
    Bu Stream<String> nesnesini kullanarak forEach() yöntemini çağırarak her satırı konsola yazdırıyoruz.

    Dosyayı otomatik olarak kapatmak için try-with-resources ifadesini kullanıyoruz.
    Bu sayede, BufferedReader ve FileReader nesneleri otomatik olarak kapatılır ve dosya kapatılmazsa oluşabilecek sorunların önüne geçilmiş olur.
    Eğer bir hata oluşursa, istisna yakalanır ve konsola yazdırılır.
     */
}
