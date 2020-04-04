package com.company.University.Component;

import com.company.University.Model.*;
import com.company.Lib.Component.TaskInterface;
import com.company.Lib.Dao.RepositoryInterface;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniversityTask implements TaskInterface {
    private RepositoryInterface<Student> studentRepository;
    private RepositoryInterface<Teacher> teacherRepository;
    private RepositoryInterface<Cleaner> cleanerRepository;

    public UniversityTask(RepositoryInterface<Student> studentRepository, RepositoryInterface<Teacher> teacherRepository, RepositoryInterface<Cleaner> cleanerRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.cleanerRepository = cleanerRepository;
    }

    @Override
    public void run() {
        List<Student> students = studentRepository.takeList(getRandomInteger());
        List<Teacher> teachers = teacherRepository.takeList(getRandomInteger());
        List<Cleaner> cleaners = cleanerRepository.takeList(getRandomInteger());
        List<Person> people = Stream.of(students, teachers, cleaners).flatMap(Collection::stream).collect(Collectors.toList());
        Collections.shuffle(people);
        people.forEach(Person::print);
        List<Staff> staff = Stream.of(teachers, cleaners).flatMap(Collection::stream).collect(Collectors.toList());
        staff.forEach(Staff::salary);

    }

    private Integer getRandomInteger()
    {
        return new Random().nextInt(2   ) + 1;
    }
}
