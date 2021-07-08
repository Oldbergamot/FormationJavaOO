package be.digitalcity.files;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {
    public static void main(String[] args) {
//        compareSpeedReading("C:\\Users\\local_user\\IdeaProjects\\FormationJavaOO\\src\\be\\digitalcity\\files\\fichier.txt");
//        writeFiles("C:\\Users\\local_user\\IdeaProjects\\FormationJavaOO\\src\\be\\digitalcity\\files\\fichier.txt");
//        readFilesWithInputStream("C:\\Users\\local_user\\IdeaProjects\\FormationJavaOO\\src\\be\\digitalcity\\files\\fichier.txt");
//        copyFiles("C:\\Users\\local_user\\IdeaProjects\\FormationJavaOO\\src\\be\\digitalcity\\files\\fichier.txt");
        demoObjectIO("C:\\Users\\local_user\\IdeaProjects\\FormationJavaOO\\src\\be\\digitalcity\\files\\fichier.txt");
    }

    public static void readFilesWithInputStream(String path) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            byte [] buffer = new  byte[8];

            int i = 0;
            while((i = fis.read()) != -1) {
                System.out.print((char)i);
            }
        } catch ( IOException e){
            System.out.println(e.getMessage());
        } finally {
            {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void readFilesWithBufferReader(String path) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));

            String line;
            while ((line = in.readLine()) != null) {
                // System.out.println(line);
            }
            in.close();  // on fini toujours par la fermeture du flux
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFilesWith(String path) {
        BufferedInputStream bis;
        FileInputStream fis;

        try {
            fis = new FileInputStream(path);
            bis = new BufferedInputStream(fis);

            int i = 0;
            while((i = bis.read()) != -1) {
                //System.out.print((char) i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFilesWithNIO(String path) {
        BufferedInputStream bis = null;
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(path);
            FileChannel fc = fis.getChannel();
            ByteBuffer bBuff = ByteBuffer.allocate((int) fc.size());

            fc.read(bBuff);
            bBuff.flip();  // permet de

            byte [] resultat = bBuff.array();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null)fis.close();
                if(bis != null) bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void compareSpeedReading(String path) {
        long time = System.currentTimeMillis();
        for (int i = 0 ; i < 10000 ; i++) {
            readFilesWith(path);
        }
        System.out.println("\nTemps d'execution IO : "+(System.currentTimeMillis()-time));
        time = System.currentTimeMillis();
        for (int i = 0 ; i < 10000 ; i++) {
            readFilesWithInputStream(path);
        }
        System.out.println("\nTemps d'execution InputStream : "+(System.currentTimeMillis()-time));
        time = System.currentTimeMillis();
        for (int i = 0 ; i < 10000 ; i++) {
            readFilesWithBufferReader(path);
        }
        System.out.println("\nTemps d'execution Buffered : "+(System.currentTimeMillis()-time));
        time = System.currentTimeMillis();
        for (int i = 0 ; i < 10000 ; i++) {
            readFilesWithNIO(path);
        }
        System.out.println("\nTemps d'execution nouveau package : "+(System.currentTimeMillis()-time));
    }

    public static void writeFiles(String path) {
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            for (int i = 0; i < 10; i++) {
                out.println("Bonjour " + i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFiles(String path) {

        try(FileInputStream fis = new FileInputStream(path)) {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\local_user\\IdeaProjects\\FormationJavaOO\\src\\be\\digitalcity\\files\\fichierCopie.txt");
            byte [] buffer = new byte[1];
            while(fis.read(buffer) != -1) fos.write(buffer);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void demoObjectIO(String path) {
        ObjectInputStream ois;
        ObjectOutputStream oos;

        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(path)
                    )
            );
            oos.writeObject(new Car("Audi", 1995));
            oos.writeObject(new Car("Renault", 1500));
            oos.close();

            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(path)
                    )
            );
            System.out.println("Listing voiture :");
            System.out.println(((Car)ois.readObject()).toString());
            System.out.println(((Car)ois.readObject()).toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
