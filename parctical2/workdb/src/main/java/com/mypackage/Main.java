package com.mypackage; // изменено имя пакета

import com.mypackage.ChemicalSample.ChemicalSample;
import com.mypackage.ChemicalSampleRepository.ChemicalSampleRepository;
import com.mypackage.User.User; // исправлены импорты
import com.mypackage.UserRepository.UserRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        List<User> users = userRepository.getAllUsers();

        for (User user : users) {
            System.out.println(user.getName());
            System.out.println("Стаж: "+ user.getAge());
            System.out.println("Количество: " +user.getMembers()+" человек");
        }
        userRepository.closeEntityManager();

        ChemicalSampleRepository sampleRepository = new ChemicalSampleRepository();
        List<ChemicalSample> samples = sampleRepository.getAllSamples();

        for (ChemicalSample sample: samples) {
            System.out.println(sample.getName() + " Попытка "+sample.getQuantity() );
            System.out.println();
        }
        sampleRepository.closeEntityManager();
    }
}
