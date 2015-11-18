import java.io.*;
import java.util.*;
public class fileio {
public static void main (String [] args) throws IOException{
Scanner scnr = new Scanner (System.in);
System.out.println("Enter the input file name");
int i;
String fileinput;
String fileout;
fileinput = scnr.nextLine();
System.out.println("Enter the output file name");
fileout = scnr.next();
FileInputStream fin;
try {
 fin = new FileInputStream(fileinput);
}
catch (FileNotFoundException e) {
System.out.println("File not found");
return;
}
FileOutputStream fout;
try {
 fout = new FileOutputStream(fileout);
}
catch (FileNotFoundException e) {
System.out.println("File not found");
return;
}
do{
i = fin.read();
if (i != -1) {
fout.write(i);
}
}
while (i != -1);
fin.close();
fout.close();
}
}
