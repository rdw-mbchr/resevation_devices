package com.example.backend;

import com.example.backend.util.DummyUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DummyUtilTest {

    @Test
    void should_return_true_for_positive_number() {
        assertTrue(DummyUtil.isPositive(5));
    }

    @Test
    void should_return_false_for_negative_number() {
        assertFalse(DummyUtil.isPositive(-1));
    }
}


