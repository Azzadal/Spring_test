package com.springapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    Controller sut;

    @BeforeEach
    void setUp() {
        sut = new Controller();
    }

    @Test
    void test1() throws Exception {
        sut.test();
    }
}