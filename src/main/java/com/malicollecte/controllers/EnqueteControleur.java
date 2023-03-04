package com.malicollecte.controllers;

import com.malicollecte.Image.SaveImage;
import com.malicollecte.Services.EnqueteService;
import com.malicollecte.Services.QuestionnaireService;
import com.malicollecte.models.*;
import com.malicollecte.payload.request.Repondant;
import com.malicollecte.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/enquete")
@CrossOrigin(origins = "http://localhost:8100", maxAge = 3600, allowCredentials="true")
public class EnqueteControleur {

    @Autowired
    private EnqueteService enqueteService;
    @Autowired
    private EnqueteRepositorie enqueteRepositorie;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    QuestionnaireService questionnaireService;

    @Autowired
    QuestionnaireRepositorie questionnaireRepositorie;

    @Autowired
    User_questionnaireRepository user_questionnaireRepository;

    @Autowired
    QuestionRepositorie  questionRepositorie;


    //@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    @PostMapping("/creer")
    public Object createEnquete(@Param("type") String  type,
                                @Param("libelle") String  libelle,
                                @Param("description") String  description,
                             //   @Param("images") String images ,
                                @Param("file") MultipartFile file,

                                @Param("datedebut") String datedebut,
                                @Param("datefin") String datefin) throws IOException
    // @Param("questionnaire")Questionnaire questionnaire,
    //   @Param("idUser") Long idUser)
    {
        String image2= file.getOriginalFilename();
        Enquete enquete1 = new Enquete();

        enquete1.setType(type);
        enquete1.setLibelle(libelle);
        enquete1.setDescription(description);
        enquete1.setDatedebut(datedebut);
        enquete1.setDatefin(datefin);
        enquete1.setImages(SaveImage.save(file, image2));

       // enquete1.setImages(enquete1.getImages());
        //enquete1.setQuestionnaire(questionnaire);
        //Optional<User> user1 = userRepository.findById(idUser);
        // User savedUser = userRepository.save(utilisateur);
        // enquete1.setUtilisateur(user1.get());

        if (enqueteRepositorie.findByLibelle(libelle) == null) {
            //enquete1.setEtat(etat);

            ResponseEntity.ok(enqueteService.Creer(enquete1));
            return "Enquête " + enquete1.getLibelle() + " créer  avec succès";
        }
        return "Cette enquête " + enquete1.getLibelle() + " existe dêjà !";
    }

        //@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
        @PutMapping("/modifier/{id}")
        public ResponseEntity<Enquete> updateEnquete(@PathVariable Long id, @Valid @RequestBody Enquete enquete) {
            return ResponseEntity.ok(enqueteService.Modifier(id, enquete));
        }

        //@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
        @DeleteMapping("/supprimer/{id}")
        public ResponseEntity<String> deleteEnquete(@PathVariable Long id) {
            enqueteService.Supprimer(id);
             ResponseEntity.noContent().build();
             return ResponseEntity.ok("Enquête  " + id + " supprimer avec succés") ;
        }

        @GetMapping("/afficher/{id}")
        //@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
        public ResponseEntity<Enquete> getEnquete(@PathVariable Long id) {
        if (id == null){
            return null;
        }else {
            return ResponseEntity.ok(enqueteService.AfficherUn(id));
        }
    }



        @GetMapping("/toutafficher")
       // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
        public ResponseEntity<List<Enquete>> getEnquetes() {
            return ResponseEntity.ok(enqueteService.ToutAfficher());
        }


//        @GetMapping("/afficherparorganisation/{organisation}")
//        @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
//        public ResponseEntity<List<Enquete>> getEnquetesByOrganisation(@PathVariable String organisation) {
//            return ResponseEntity.ok(enqueteService.AfficherparOrganisation(organisation));
//        }

   /*     @GetMapping("/createur/{createur}")
        @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
        public ResponseEntity<List<User>> getEnquetesByCreateur(@PathVariable String createur) {
            return ResponseEntity.ok(enqueteService.AfficherparCreateur(createur));
        }*/

        @GetMapping("/statut/{statut}")
        @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
        public ResponseEntity<List<Enquete>> getEnquetesByStatut(@PathVariable String statut) {
            return ResponseEntity.ok(enqueteService.AfficherparStatut(statut));
        }

//        @PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
//        @GetMapping("/afficherpar/{statut}/{organisation}")
//        public ResponseEntity<List<Enquete>> getEnquetesByStatutAndOrganisation(@PathVariable String statut, @PathVariable String organisation){
//            return ResponseEntity.ok(enqueteService.AfficherparStatutEtOrga(statut, organisation));
//            }


        @GetMapping("/afficherparstatut/{statut}")
      //  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
        public ResponseEntity<List<Enquete>> getEnquetesStatut(@PathVariable String statut){
            return ResponseEntity.ok(enqueteService.AfficherparStatut(statut));
            }

    @GetMapping("/afficherpartype/{type}")
   // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public ResponseEntity<List<Enquete>> getEnquetesType(@PathVariable String stype){
        return ResponseEntity.ok(enqueteService.AfficherparType(stype));
    }
    @PatchMapping("/assignerquestionadesusers/{questionnaire}")
    public ResponseEntity<?> assignerQuestionADesUers(@PathVariable Questionnaire questionnaire, @RequestBody Repondant repondant){

            List<User> users = userRepository.findByLocaliteInAndGenre(repondant.getLocalite(), repondant.getGenre());
            List<User> usersRepondant = new ArrayList<>();
            LocalDate currentDate = LocalDate.now();

            if(repondant.getTranche().equals("0-5")){
                for(User user : users){
                    int age = Period.between(user.getDatedenaissance(), currentDate).getYears();
                    if(age >= 0 && age < 5){
                        usersRepondant.add(user);
                    }
                }
            } else if (repondant.getTranche().equals("5-15")) {
                for(User user : users){
                    int age = Period.between(user.getDatedenaissance(), currentDate).getYears();
                    if(age >= 5 && age < 15){
                        usersRepondant.add(user);
                    }
                }
            } else if (repondant.getTranche().equals("15-25")) {
                for(User user : users){
                    int age = Period.between(user.getDatedenaissance(), currentDate).getYears();
                    if(age >= 15 && age < 25){
                        usersRepondant.add(user);
                    }
                }
            } else if (repondant.getTranche().equals("25-35")) {
                for(User user : users){
                    int age = Period.between(user.getDatedenaissance(), currentDate).getYears();
                    if(age >= 25 && age < 35){
                        usersRepondant.add(user);
                    }
                }

            } else if (repondant.getTranche().equals("35-50")) {
                for(User user : users){
                    int age = Period.between(user.getDatedenaissance(), currentDate).getYears();
                    if(age >= 35 && age < 50){
                        usersRepondant.add(user);
                    }
                }

            } else if (repondant.getTranche().equals("50-65")) {
                for(User user : users){
                    int age = Period.between(user.getDatedenaissance(), currentDate).getYears();
                    if(age >= 50 && age < 65){
                        usersRepondant.add(user);
                    }
                }

            }else {
                for(User user : users){
                    int age = Period.between(user.getDatedenaissance(), currentDate).getYears();
                    if(age >= 65){
                        usersRepondant.add(user);
                    }
                }
            }

           //questionnaire.setUtilisateur_id(usersRepondant);
            Questionnaire quest = new Questionnaire();
            quest.setUtilisateur_id(usersRepondant);

        List<User_questionnaire> userQuestionnaire = new ArrayList<>();
       int i = 0;
       System.out.println(usersRepondant);
        for (User user: usersRepondant){
            User_questionnaire userQuest = new User_questionnaire();
            userQuest.setUserid(user);
            userQuest.setQuestionnaireid(questionnaire);
            userQuest.setStatus(EStatusEnquete.ENCOURS);
            userQuestionnaire.add(userQuest);
//            userQuestionnaire.add(userQuest);
//            userQuestionnaire.get(i).setUser_id(user);
//            userQuestionnaire.get(i).setQuestionnaire_id(questionnaire);
//            userQuestionnaire.get(i).setStatus(EStatusEnquete.ENCOURS);
//            i++;
        }
          // return ResponseEntity.ok(questionnaireService.Modifier(questionnaire.getId(), quest));
        return ResponseEntity.ok(user_questionnaireRepository.saveAll(userQuestionnaire));
    }


    @GetMapping("/recuperlesenquentesdunutilisateur/{user}")
    public ResponseEntity<?> recuperLesEnquentesDunUtilisateur(@PathVariable User user){
        List<User_questionnaire> userQuestionnaireList = user_questionnaireRepository.findByUseridAndStatus(user, EStatusEnquete.ENCOURS);

        List<Enquete> enquetes = new ArrayList<>();

        for (User_questionnaire uq : userQuestionnaireList){
            enquetes.add(uq.getQuestionnaireid().getEnquete());
        }

        return ResponseEntity.ok(enquetes);
    }

    @GetMapping("/recuprerLesQuestionsParEnquete/{enquete}")
    public ResponseEntity<?> recuprerLesQuestionsParEnquete(@PathVariable Enquete enquete){
            Questionnaire questionnaire1= questionnaireRepositorie.recupererQuestionnaire(enquete.getId());

        return ResponseEntity.ok(questionRepositorie.getQuestionsByQuestionnaireId(questionnaire1.getId()));
    }

//    @GetMapping("/recuprerLesQuestionsParEnquete/{enqueteId}")
//    public ResponseEntity<?> recuprerLesQuestionsParEnquete(@PathVariable Long enqueteId){
//
//        Enquete enquete = enqueteRepositorie.findById(enqueteId).get();
//        if (enquete == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        Questionnaire questionnaire = enquete.getQuestionnaire();
//        if (questionnaire == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        List<Question> questions = questionnaire.getQuestions();
//        return ResponseEntity.ok(questions);
//    }


}



