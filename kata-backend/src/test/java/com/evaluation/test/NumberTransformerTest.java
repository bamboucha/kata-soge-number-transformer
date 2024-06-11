package com.evaluation.test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.evaluation.service.NumberTransformer;
import com.evaluation.service.rule.ContainsDigitRule;
import com.evaluation.service.rule.DivisibleByRule;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTransformerTest {

    private NumberTransformer transformer;

    @BeforeEach
    public void setUp() {
        transformer = new NumberTransformer(Arrays.asList(
            new DivisibleByRule(3, "FOO"),
            new DivisibleByRule(5, "BAR"),
            new ContainsDigitRule('5', "BAR"),
            new ContainsDigitRule('3', "FOO"),
            new ContainsDigitRule('7', "QUIX")
        ));
    }

    @Test
    public void testTransform1() {
        assertEquals("1", transformer.transform(1));
    }

    @Test
    public void testTransform3() {
        assertEquals("FOOFOO", transformer.transform(3));
    }

    @Test
    public void testTransform5() {
        assertEquals("BARBAR", transformer.transform(5));
    }

    @Test
    public void testTransform7() {
        assertEquals("QUIX", transformer.transform(7));
    }

    @Test
    public void testTransform9() {
        assertEquals("FOO", transformer.transform(9));
    }

    @Test
    public void testTransform51() {
        assertEquals("FOOBAR", transformer.transform(51));
    }

    @Test
    public void testTransform53() {
        assertEquals("BARFOO", transformer.transform(53));
    }

    @Test
    public void testTransform33() {
        assertEquals("FOOFOOFOO", transformer.transform(33));
    }

    @Test
    public void testTransform15() {
        assertEquals("FOOBARBAR", transformer.transform(15));
    }
}

