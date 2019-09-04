package com.kumararaja.Model;

public class NumericModelData {

    String arithmatic,logic,reason,mathematical, wordproblem, blood_relations;

    public NumericModelData(String arithmatic, String logic, String reason, String mathematical,String wordproblem, String blood_relations){
        this.arithmatic=arithmatic;
        this.logic=logic;
        this.reason=reason;
        this.mathematical=mathematical;
        this.wordproblem=wordproblem;
        this.blood_relations=blood_relations;
    }

    public String getArithmatic() {
        return arithmatic;
    }

    public void setArithmatic(String arithmatic) {
        this.arithmatic = arithmatic;
    }

    public String getLogic() {
        return logic;
    }

    public void setLogic(String logic) {
        this.logic = logic;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMathematical() {
        return mathematical;
    }

    public void setMathematical(String mathematical) {
        this.mathematical = mathematical;
    }
    public String getWordproblem() {
        return wordproblem;
    }

    public void setWordproblem(String wordproblem) {
        this.wordproblem = wordproblem;
    }
    public String getBlood_relations() {
        return blood_relations;
    }

    public void setBlood_relations(String blood_relations) {
        this.blood_relations = blood_relations;
    }

    public static class Verbal{
        String spotting_errors,idoms_phrases,anonyms,synonyms, vocabulary;

        public Verbal(String spotting_errors, String idoms_phrases, String anonyms, String synonyms, String vocabulary) {
            this.spotting_errors = spotting_errors;
            this.idoms_phrases = idoms_phrases;
            this.anonyms = anonyms;
            this.synonyms = synonyms;
            this.vocabulary = vocabulary;
        }

        public String getSpotting_errors() {
            return spotting_errors;
        }

        public void setSpotting_errors(String spotting_errors) {
            this.spotting_errors = spotting_errors;
        }

        public String getIdoms_phrases() {
            return idoms_phrases;
        }

        public void setIdoms_phrases(String idoms_phrases) {
            this.idoms_phrases = idoms_phrases;
        }

        public String getAnonyms() {
            return anonyms;
        }

        public void setAnonyms(String anonyms) {
            this.anonyms = anonyms;
        }

        public String getSynonyms() {
            return synonyms;
        }

        public void setSynonyms(String synonyms) {
            this.synonyms = synonyms;
        }

        public String getVocabulary() {
            return vocabulary;
        }

        public void setVocabulary(String vocabulary) {
            this.vocabulary = vocabulary;
        }
    }

}



