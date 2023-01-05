import java.io.*;
public class File02
{
public static void main(String args[]) throws IOException
{
FileReader fr=new FileReader("Sample.txt");
BufferedReader br=new BufferedReader(fr);
FileWriter fw=new FileWriter("text.txt");
String line;
int n=0;
while((line=br.readLine())!=null)
{
fw.write(n+" "+line+"\n");
fw.flush();
n++;
}
System.out.println("File copied succesfully");
fr.close();
fw.close();
br.close();
}}
