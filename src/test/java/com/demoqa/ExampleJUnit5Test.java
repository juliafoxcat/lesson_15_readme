package com.demoqa;

import org.junit.jupiter.api.*;

import java.lang.module.Configuration;

public class ExampleJUnit5Test {

    @BeforeAll
    static void configure() {
        System.out.println("this is @before all");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("this is @after all");
    }

    @BeforeEach
    void beforeTest() {
        System.out.println("this is @before each");
    }

    @AfterEach
    void afterTest() {
        System.out.println("this is @after each");
    }

    @Test
    void fisrtTest0() {
        System.out.println("    this is @test0");
    }

    @Test
    void fisrtTest1() {
        System.out.println("    this is @test1");
    }
}
