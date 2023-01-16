/*
package com.APISurvey.Application.generique.denquete.util;

import java.util.List;

public class sondagemulti {



    // MultiValueOption class{
        private List<String> values;

        public void MultiValueOption(List<String> values) {
            this.values = values;
        }

        public List<String> getValues() {
            return values;
        }

        public void setValues(List<String> values) {
            this.values = values;
        }
    }

    // Question class
    public class Question {
        private List<MultiValueOption> options;

        public Question() {
            options = new ArrayList<MultiValueOption>();
        }

        public List<MultiValueOption> getOptions() {
            return options;
        }

        public void setOptions(List<MultiValueOption> options) {
            this.options = options;
        }

        public void addOption(MultiValueOption option) {
            options.add(option);
        }
    }

    // SondageService interface
    public interface SondageService {
        Sondage CreerSondage(Sondage sondage);

        Sondage AfficherSondage(Integer id);
        List<Sondage> AfficherAllSondage();
        Sondage ModifierSondage(Integer id, Sondage sondage);
        Sondage SupprimerSondage(Integer id);
        Sondage LancerSondage();
        void addOption(Integer questionId, MultiValueOption option);
    }

    // Sondage class
    public class Sondage {
        private Map<Integer, Question> questions;

        public Sondage() {
            questions = new HashMap<Integer, Question>();
        }

        public Map<Integer, Question> getQuestions() {
            return questions;
        }

        public void setQuestions(Map<Integer, Question> questions) {
            this.questions = questions;
        }

        public void addQuestion(Question question) {
            questions.put(question.getId(), question);
        }
    }


*/
