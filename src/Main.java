import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static StringBuilder log = new StringBuilder();

    public static void main(String args[]) {
//StringBuilder log = new StringBuilder();

        createDir("D://Games//src");
        createDir("D://Games//res");
        createDir("D://Games//temp");
        createDir("D://Games//savegames");

        createDir("D://Games//src//main");
        createDir("D://Games//src//test");

        createFile("D://Games//src//main//Main.java");
        createFile("D://Games//src//main//Utils.java");

        createDir("D://Games//res//drawables");
        createDir("D://Games//res//vectors");
        createDir("D://Games//res//icons");

        createFile("D://Games//temp//temp.txt");

        System.out.println(log.toString());

        writeToFile(log, "D://Games//temp//temp.txt");
    }

    public static void writeToFile(StringBuilder log, String nameOfFile) {
        String text = log.toString();
        try (FileWriter writer = new FileWriter(nameOfFile, false)) {
            writer.write(text);
            writer.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void createDir(String nameDir) {
        File dir = new File(nameDir);
        if (dir.mkdir()) {
            System.out.println("Каталог создан");
            log.append("Создан каталог " + nameDir + "\n ");
        } else System.out.println("Не получилось создать каталог");

    }

    public static void createFile(String nameFile) {
        File myFile = new File(nameFile);
        try {
            if (myFile.createNewFile())
                System.out.println("Файл был создан");
            log.append("Создан файл " + nameFile + "\n ");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
