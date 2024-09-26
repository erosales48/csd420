package org.example.csd420.Examples;

import java.util.Scanner;

public class ImageUploaderApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter MySQL username: ");
        String user = scanner.nextLine();

        System.out.print("Enter MySQL password: ");
        String password = scanner.nextLine();

        System.out.print("Enter database name: ");
        String dbName = scanner.nextLine();

        System.out.print("Enter table name: ");
        String tableName = scanner.nextLine();

        System.out.print("Enter column name: ");
        String columnName = scanner.nextLine();

        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();

        ImageUploader uploader = new ImageUploader();
        uploader.insertImage(dbName, tableName, columnName, filePath, user, password);
    }
}