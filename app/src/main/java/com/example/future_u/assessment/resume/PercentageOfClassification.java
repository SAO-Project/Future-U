package main.java.com.example.future_u.assessment.resume;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Should only be initiated once.
 */
public class PercentageOfClassification {
    final static private HashMap<String, ArrayList<Double>> VectorOfWords =
            PercentageOfClassificationUtil.getAllWordsMap();
    private HashMap<String, Double> percentageOfClassification;
    private Double[] skills;
    String[] pdf;

    public PercentageOfClassification() {
        this.percentageOfClassification = new HashMap<>();
        this.skills = new Double[8];
    }

    public PercentageOfClassification(String[] pdf) {
        this.percentageOfClassification = new HashMap<>();
        this.skills = new Double[8];
        this.pdf = pdf;
    }

    public Boolean parsePdf(String[] newPdf) {
        this.pdf = newPdf;
        return parsePdf();
    }

    /**
     * This step goes through every word in the given string array and compares the value and the
     * corresponding word.
     * @return True if successful, false if an error occurred.
     */
    public Boolean parsePdf() {
        // Words are subject are to change.
        for (String s : this.pdf) {
            try {
                this.skills[0] += PercentageOfClassificationUtil.sim(
                        s, "solving", VectorOfWords);

                this.skills[1] += PercentageOfClassificationUtil.sim(
                        s, "communication", VectorOfWords);

                this.skills[2] += PercentageOfClassificationUtil.sim(
                        s, "teamwork", VectorOfWords);

                this.skills[3] += PercentageOfClassificationUtil.sim(
                        s, "digital", VectorOfWords);

                this.skills[4] += PercentageOfClassificationUtil.sim(
                        s, "leadership", VectorOfWords);

                this.skills[5] += PercentageOfClassificationUtil.sim(
                        s, "ethics", VectorOfWords);

                this.skills[6] += PercentageOfClassificationUtil.sim(
                        s, "management", VectorOfWords);

                this.skills[7] += PercentageOfClassificationUtil.sim(
                        s, "intercultural", VectorOfWords);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * Returns True if operation was successful. Places all percentages by classification.
     * @return True if successful, False if error occurred.
     */
    public Boolean insertPercentageOfClassifications() {
        try {
            Double total = 0.0;
            for (Double value : this.skills) {
                total += value;
            }
            this.percentageOfClassification.put("solving", this.skills[0] / total);
            this.percentageOfClassification.put(
                    "communication", this.skills[1] / total);
            this.percentageOfClassification.put("teamwork", this.skills[2] / total);
            this.percentageOfClassification.put("digital", this.skills[3] / total);
            this.percentageOfClassification.put("leadership", this.skills[4] / total);
            this.percentageOfClassification.put("ethics", this.skills[5] / total);
            this.percentageOfClassification.put("management", this.skills[6] / total);
            this.percentageOfClassification.put(
                    "intercultural", this.skills[7] / this.skills.length);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public HashMap<String, Double> getPercentageOfClassification() {
        return this.percentageOfClassification;
    }
}
