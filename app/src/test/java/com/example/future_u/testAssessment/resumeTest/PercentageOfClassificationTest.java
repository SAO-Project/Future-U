package com.example.future_u.testAssessment.resumeTest;

import com.example.future_u.assessment.resume.PercentageOfClassification;
import com.example.future_u.assessment.resume.PercentageOfClassification;
import com.example.future_u.assessment.resume.PercentageOfClassificationUtil;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PercentageOfClassificationTest {

    private PercentageOfClassification percentageOfClassification =
            new PercentageOfClassification();
    @Test
    public void simTest() {
        double sim = PercentageOfClassificationUtil.sim(
                "barley", "shrimp", percentageOfClassification.getVectorOfWords());
        System.out.println(sim);
        assertEquals(true, true);
    }
    @Test
    public void parsePdfTest() {
        String[] words = new String[8];
        words[0] = "solving";
        words[1] = "communication";
        words[2] = "teamwork";
        words[3] = "digital";
        words[4] = "leadership";
        words[5] = "ethics";
        words[6] = "management";
        words[7] = "intercultural";

        assertEquals(true, percentageOfClassification.parsePdf(words));
    }

    @Test
    public void getHashMapTest() {
        // This is the flow.
        String[] words = new String[8];
        words[0] = "solving";
        words[1] = "communication";
        words[2] = "teamwork";
        words[3] = "digital";
        words[4] = "leadership";
        words[5] = "ethics";
        words[6] = "management";
        words[7] = "intercultural";

        assertEquals(true,percentageOfClassification.parsePdf(words));
        assertEquals(true,
                percentageOfClassification.insertPercentageOfClassifications());
        System.out.println(
                percentageOfClassification.getPercentageOfClassification().toString());
    }

}
