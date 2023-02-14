package com.tasks.SourceCodeChannel.FileIO.backup;

import java.io.*;

public class FIleSerializeDeserialize {

    private static final String PATH = "object.txt";

    // Сериализация обьекта - это способность обьекта сохранять его копию и других обьектов на которые он может ссылатся
    public static void main(String[] args) throws ClassNotFoundException{
        serialize();
        deserialize();
    }

    private static void serialize() {
        SerializableClass serializableClass = new SerializableClass(SerializableClass.class.getName(), 0);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(PATH))) {
            outputStream.writeObject(serializableClass);
        } catch (IOException ex) {
            System.out.println("Output error");
        }
    }

    private static void deserialize() throws ClassNotFoundException {
        try (ObjectInputStream inputSteam = new ObjectInputStream(new FileInputStream(PATH))){
            SerializableClass serializableClass = (SerializableClass) inputSteam.readObject();
            System.out.printf("Title: %s%Size: %d", serializableClass.title, serializableClass.size);
        }catch (IOException ex) {
            System.out.println("Input error");
        }
    }

    private static class SerializableClass implements Serializable {
        private String title;
        private int size;

        SerializableClass(String title, int size) {
            this.title = title;
            this.size = size;
        }

    }
}
