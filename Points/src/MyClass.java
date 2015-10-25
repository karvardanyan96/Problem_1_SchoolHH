import java.util.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileNotFoundException;

public class MyClass {

	public static void main(String[] args) throws IOException  
	{
		Ñoordinate coor; 
        String[] array = new String[0]; 
        List<Ñoordinate> spisok = new ArrayList<Ñoordinate>(); 
        String[] ob = new String[2]; 
        
        Charset charset = Charset.forName("ISO-8859-1");
        String baseDir = new File(".").getCanonicalPath() + "\\3.txt";
        Path file_path = Paths.get(baseDir);
        
        if (file_path != null) {
        	try {
		        int size = Files.readAllLines(file_path, charset).size();
		        array = new String[size];
		        Files.readAllLines(file_path, charset).toArray(array);
        	}
        	catch(FileNotFoundException e) {
        		System.out.println(e);
        	}
        }
        
        for (int i = 0; i < array.length; i++)
        {
            ob = array[i].split(" ");
            int[] numbers = Arrays.stream(ob).mapToInt(Integer::parseInt).toArray();
            coor = new Ñoordinate(numbers[0], numbers[1]);
            spisok.add(coor);
        }
        
        for (int i = 0; i < spisok.size(); i++)
        {
            System.out.println("Òî÷êà" + (i+1) + "(" + spisok.get(i).getX() + "," + spisok.get(i).getY() + ")");
        }
        
        //double[] distance  = new double[spisok.size() * (spisok.size() - 1) / 2];
        //int f= 0;
        
        
        double min_distance = Distance.fun(spisok.get(0).getX(), spisok.get(0).getY(), spisok.get(1).getX(), spisok.get(1).getY());
        for (int i = 0; i < spisok.size(); i++)
        {
            //int g = i + 1;
            for (int j = i + 1; j<spisok.size(); j++)
            {
            	//distance[f] = Distance.fun(spisok.get(i).getX(), spisok.get(i).getY(), spisok.get(g).getX(), spisok.get(g).getY());
                //f++;
            	double buffer = Distance.fun(spisok.get(i).getX(), spisok.get(i).getY(), spisok.get(j).getX(), spisok.get(j).getY());
            	if (buffer < min_distance)
            	min_distance = buffer;
            }
        }
        
        //qyasa jogar?) ha 
        //tenc obshi aveli chishta lishni pamyat' ches optagorcum
        //de qyasa es commentnere jnjumem
        // mekel stex karoxa try catch petq ga?
        //filice read petqa anes zadaniyayov?
        //mek@ faylic em arel mek@ klavyaturayic
        // ha de eti tesa myusum dra hamar harcrim eli
        //de qyasa kareliya file raead aneluc arach
        
        //for (int i = 0; i < distance.length; i++)
        //{
          //  System.out.println(distance[i]);
        //}
        //double min = 0;

        //min =  distance[0];
        //for (int i = 0; i < distance.length; ++i) {
         //   min = Math.min(min, distance[i]);
        //}
        System.out.println();
        System.out.println("Ìèíèìàëüíîå ðàñòîÿíèå " + min_distance);
	}
}
