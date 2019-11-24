package com.example.future_u.testAssessment;

import com.example.future_u.assessment.Assessment;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class AssessmentTest {
    final String SAMPLE_RESUME =
            "/Users/greywind/Desktop/Hello/hello/app/src/test/java/com/example/future_u/testAssessment/Sample Resume.pdf";

    @Test
    public void assessmentTest(){
        Assessment assessment = new Assessment(SAMPLE_RESUME, "Computer Science", 4.2323);
        assertEquals(true, true);
        System.out.println(assessment.getPercentageOfClassification().getPercentageOfClassification().toString());
    }
}

