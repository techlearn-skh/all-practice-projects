package com.skh.files;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ListOfFilesInDir {
    static Set<String> duplicateSongs = new HashSet<>();
    static Set<String> duplicateSongsSorted = new TreeSet<>();
    static Set<String> songsWithAbsolutePath = new TreeSet<>();
    static List<String> duplicateSongsList = new ArrayList<>();

    public static void main(String[] args) {
//        listFiles("F:\\Songs");
        listFiles("D:\\kamal documents\\Personal\\Songs");
//        System.out.println("duplicateSongs: " + duplicateSongsList.size());
//        System.out.println("duplicateSongsSorted: " + duplicateSongsSorted);
        duplicateSongsSorted.stream().forEach(System.out::println);
        //deleteFileFromDir(duplicateSongsList);
//        listOnlyJpgFilesAndDelete(songsWithAbsolutePath);
    }

    private static void listFiles(String path) {
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isFile()) {
//                System.out.println(file.getName());
                if (!duplicateSongs.add(file.getName())) {
                    // System.out.println("songs is Duplicated: " + file.getName() + " --> " + file.getAbsolutePath());
                    duplicateSongsList.add(file.getAbsolutePath());
                } else {
                    duplicateSongsSorted.add(file.getName());
                    songsWithAbsolutePath.add(file.getAbsolutePath());
                }
            } else if (file.isDirectory()) {
                listFiles(file.getAbsolutePath());
            }
        }
    }


    public static void deleteFileFromDir(List<String> duplicateSongsList) {

        for (String fileNameAndPath : duplicateSongsList) {
            try {
                Path path = Paths.get(fileNameAndPath);
                boolean deleted = Files.deleteIfExists(path);
                if (deleted) {
                    System.out.println("File deleted successfully");
                } else {
                    System.out.println("File not found");
                }
            } catch (Exception e) {
                System.out.println("Error deleting file: " + e.getMessage());
            }
        }
    }

    public static void listOnlyJpgFilesAndDelete(Set<String> sortedList) {
        List<String> duplicateJPGFiles = new ArrayList<>();
        for (String fileName : sortedList) {
            if (fileName.toLowerCase().contains(".jpg")) {
               // System.out.println(fileName);
                duplicateJPGFiles.add(fileName);
            }
        }
        duplicateJPGFiles.forEach(System.out::println);
        deleteFileFromDir(duplicateJPGFiles);
    }
}


