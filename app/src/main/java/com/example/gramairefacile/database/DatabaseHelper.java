package com.example.gramairefacile.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.gramairefacile.R;
import com.example.gramairefacile.database.entity.Materi;
import com.example.gramairefacile.database.entity.Question;
import com.example.gramairefacile.database.entity.Quiz;
import com.example.gramairefacile.database.model.Conjonction;
import com.example.gramairefacile.database.model.Interrogatif;
import com.example.gramairefacile.database.model.LesAdjectif;
import com.example.gramairefacile.database.model.LesArticles;
import com.example.gramairefacile.database.model.LesPronom;
import com.example.gramairefacile.database.model.LesVerbes;
import com.example.gramairefacile.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "grammairefacile_db";

    // Pretty print
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Convert JSON to Array
    public static final <T> T toArray(String json, Class<T> type) {
        return gson.fromJson(json, type);
    }

    public static List<Question> toQuestionList(String json) {
        Type listType = new TypeToken<List<Question>>() {
        }.getType();
        return gson.fromJson(json, listType);
    }


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        // create materi table
        db.execSQL(Materi.CREATE_TABLE);
        // create quiz table
        db.execSQL(Quiz.CREATE_TABLE);

        generateMateri();
        generateQuiz();
    }


    private void generateMateri() {
        // GENERATE MATERI VERB
        addNewMateri(Constants.Materi.TYPE_VERB, "Verbe regulier", new int[]{R.drawable.verbes1_content1});
        addNewMateri(Constants.Materi.TYPE_VERB, "Verbe irregulier", new int[]{R.drawable.verbes2_content1, R.drawable.verbes2_content2, R.drawable.verbes2_content3, R.drawable.verbes2_content4});
        addNewMateri(Constants.Materi.TYPE_VERB, "Conditionnel\nde politese", new int[]{R.drawable.verbes3_content1});
        addNewMateri(Constants.Materi.TYPE_VERB, "Negation", new int[]{R.drawable.verbes4_content1, R.drawable.verbes4_content2});
        addNewMateri(Constants.Materi.TYPE_VERB, "La forme\nimpersonnelle simple", new int[]{R.drawable.verbes5_content1, R.drawable.verbes5_content2, R.drawable.verbes5_content3});
        addNewMateri(Constants.Materi.TYPE_VERB, "L’Imperatif", new int[]{R.drawable.verbes6_content1, R.drawable.verbes6_content2, R.drawable.verbes6_content3});
        addNewMateri(Constants.Materi.TYPE_VERB, "La present de l'indicatifs", new int[]{R.drawable.verbes7_content1, R.drawable.verbes7_content2, R.drawable.verbes7_content3, R.drawable.verbes7_content4, R.drawable.verbes7_content5});

        // GENERATE MATERI PRONOM
        addNewMateri(Constants.Materi.TYPE_PRONOM, "Les pronoms\npersonnels sujets", new int[]{R.drawable.pronom1_content1, R.drawable.pronom1_content2});
        addNewMateri(Constants.Materi.TYPE_PRONOM, "Les pronoms tonique", new int[]{R.drawable.pronom2_content1, R.drawable.pronom2_content2});
        addNewMateri(Constants.Materi.TYPE_PRONOM, "Les interrogatif simple", new int[]{R.drawable.pronom3_content1, R.drawable.pronom3_content2});

        // GENERATE MATERI ARTICLES
        addNewMateri(Constants.Materi.TYPE_ARTICLE, "L’Article defini", new int[]{R.drawable.article1_content1});
        addNewMateri(Constants.Materi.TYPE_ARTICLE, "L’Article indefini", new int[]{R.drawable.article2_content1});
        addNewMateri(Constants.Materi.TYPE_ARTICLE, "L’Article partitif", new int[]{R.drawable.article3_content1});

        // GENERATE MATERI ADJECTIF
        addNewMateri(Constants.Materi.TYPE_ADJECTIF, "L’Adjectif posesif", new int[]{R.drawable.adjectif1_content1});
        addNewMateri(Constants.Materi.TYPE_ADJECTIF, "L’Adjectif demonstratif", new int[]{R.drawable.adjectif2_content1});
        addNewMateri(Constants.Materi.TYPE_ADJECTIF, "L’Adjectif qualificatif", new int[]{R.drawable.adjectif3_content1, R.drawable.adjectif3_content2});

        // GENERATE MATERI CONJONCTION
        addNewMateri(Constants.Materi.TYPE_CONJONCTION, "LES CONJONCTION", new int[]{R.drawable.conjonction1_content1, R.drawable.conjonction1_content2, R.drawable.conjonction1_content3});

        // GENERATE MATERI INTERROGATIF
        addNewMateri(Constants.Materi.TYPE_INTERROGATIF, "LES INTERROGATIF", new int[]{R.drawable.interrogation1_content1, R.drawable.interrogation1_content2, R.drawable.interrogation1_content3, R.drawable.interrogation1_content4, R.drawable.interrogation1_content5});


    }

    private void generateQuiz() {
        List<Question> questions;
        Question question;

        /*******************************************************************************************
         *  ADD QUIZ 1
         *******************************************************************************************/
        // Create new list question
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("J’ …. (habiter) à Paris.");
        question.setChoices(new String[]{"a.\thabite", "b.\thabites", "c.\thabitez", "d.\thabitent"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);
        // Reset question to new class
        question = new Question();
        question.setQuestion("Nous …. (parler) de son travail.");
        question.setChoices(new String[]{"a.\tportons", "b.\tpermettons", "c.\tparlons", "d.\tparlez"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Tu …. (jouer) le football.");
        question.setChoices(new String[]{"a.\tjoue", "b.\tjoues", "c.\tjouons", "d.\tjouez"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Il …. (crier) tous les nuits.");
        question.setChoices(new String[]{"a.\tcrie", "b.\tcries", "c.\tcrions", "d.\tcriez"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous …. (danser) avec Marie.");
        question.setChoices(new String[]{"a.\tdanse", "b.\tdanses", "c.\tdacisez", "d.\tdansez"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Ma mère …. (travailler) à l’université.");
        question.setChoices(new String[]{"a.\ttravaillent", "b.\ttravailles", "c.\ttravaillez", "d.\ttravaille"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Jacques …. (acheter) des œufs.");
        question.setChoices(new String[]{"a.\tachète", "b.\tachètes", "c.\tachetez", "d.\tachetons"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Erick et moi …. (regarder) la télé.");
        question.setChoices(new String[]{"a.\tregardez", "b.\tregarde", "c.\tregardons", "d.\tregardes"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Julien et Paul …. (parler) français avec Monsieur Dupont.");
        question.setChoices(new String[]{"a.\tparle", "b.\tparlez", "c.\tparlent", "d.\tparlons"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous …. (fermer) la porte.");
        question.setChoices(new String[]{"a.\tfermes", "b.\tfermez", "c.\tferment", "d.\tfermons"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        addNewQuiz(1, "Pilihlah konjugasi yang tepat dari kata kerja berakhiran <i>-er</i> di dalam kurung !", questions);

        /*******************************************************************************************
         *  ADD QUIZ 2
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class

        question = new Question();
        question.setQuestion("Je …. (être) japonais.");
        question.setChoices(new String[]{"a.\tsuis", "b.\test", "c.\tsommes", "d.\tavez"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Nous …. (avoir) des stylos.");
        question.setChoices(new String[]{"a.\tsommes", "b.\ta", "c.\tavons", "d.\tai"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Elle …. (faire) de la cuisine.");
        question.setChoices(new String[]{"a.\tfais", "b.\tfait", "c.\tfaisons", "d.\tfont"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous .… (aller) à l’anniversaire de Paul.");
        question.setChoices(new String[]{"a.\tva", "b.\tvais", "c.\tallons", "d.\tallez"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Ils …. (être) professeurs de grammaire.");
        question.setChoices(new String[]{"a.\tsuis", "b.\tont", "c.\tsommes", "d.\tsont"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("J’…. (avoir) un portable.");
        question.setChoices(new String[]{"a.\tai", "b.\tavons", "c.\tas", "d.\ta"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Tu … (être) belle, Amanda.");
        question.setChoices(new String[]{"a.\tsuis", "b.\tont", "c.\tes", "d.\tas"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Michelle et moi …. (aller) à Paris aujourd’hui.");
        question.setChoices(new String[]{"a.\tallons", "b.\tva", "c.\tvais", "d.\tvont"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Mon père et ma mère …. (faire) de la cuisine.");
        question.setChoices(new String[]{"a.\tfais", "b.\tfait", "c.\tfaisons", "d.\tfont"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Suzane …. (avoir) deux enfants.");
        question.setChoices(new String[]{"a.\tas", "b.\ta", "c.\tont", "d.\tavons"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        addNewQuiz(2, "Pilihlah konjugasi yang tepat dari kata kerja <i>irrégulier</i> di dalam kurung !", questions);

        /*******************************************************************************************
         *  ADD QUIZ 3
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("Je …. (vouloir) acheter un poulet.");
        question.setChoices(new String[]{"a.\tvoudrions", "b.\tvoudrais", "c.\tvoudraient", "d.\tvoudrait"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Nous …. (aimer) un café, s’il vous plaît.");
        question.setChoices(new String[]{"a.\taimeriez", "b.\taimerait", "c.\taimerions", "d.\taimeraient"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Elle …. (pouvoir) rester ici.");
        question.setChoices(new String[]{"a.\tpourrais", "b.\tpourrait", "c.\tpourriez", "d.\tpourrions"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous .… (préférer) du café ou du thé ?");
        question.setChoices(new String[]{"a.\tpréférerais", "b.\tpréférerions", "c.\tpréféreriez", "d.\tpréféreraient"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Je …. (souhaiter) aller en France.");
        question.setChoices(new String[]{"a.\tsouhaiterais", "b.\tsouhaiterait", "c.\tsouhaiteriez", "d.\tsouhaiterions"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Je ….  (vouloir) aller aux toilettes");
        question.setChoices(new String[]{"a.\tvoudriez", "b.\tvoudrais", "c.\tvoudrait", "d.\tvoudrions"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Nous …. (pouvoir) avoir une carafe d’eau s’il vous plaît?");
        question.setChoices(new String[]{"a.\tpourrais", "b.\tpourrait", "c.\tpourriez", "d.\tpourrions"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Nous ….. (vouloir) vous parler, c’est très urgent.");
        question.setChoices(new String[]{"a.\tvoudriez", "b.\tvoudrais", "c.\tvoudrait", "d.\tvoudrions"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Qu’est-ce que vous …. (souhaiter) manger pour ce soir ?");
        question.setChoices(new String[]{"a.\tsouhaiterais", "b.\tsouhaiterait", "c.\tsouhaiteriez", "d.\tsouhaiterions"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous …. (devoir) parle à Mme Dupont.");
        question.setChoices(new String[]{"a.\tdevrais", "b.\tdevrions", "c.\tdevrait", "d.\tdevriez"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        addNewQuiz(3, "Pilihlah konjugasi <i>conditionnel présent</i> yang tepat dari kata kerja di dalam kurung !", questions);

        /*******************************************************************************************
         *  ADD QUIZ 4
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("A : Vous avez un stylo ? \n B : Non, …………..");
        question.setChoices(new String[]{"a.\tje n’ai pas de stylo", "b.\tje n’ai pas un stylo", "c.\tje n’ai pas le stylo", "d.\tje n’ai pas des stylos"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Tu habites à Paris ? \n B : Non, …………..");
        question.setChoices(new String[]{"a.\tje n’habite pas à Paris", "b.\tje n’habite pas à Nièce", "c.\tje n’habite pas à Marseille ", "d.\tje n’habite pas à Bordeaux"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Est-ce que vous achetez des légumes ? \n B : Non, …………");
        question.setChoices(new String[]{"a.\tje n’achète pas de légumes", "b.\tje n’ai pas de légumes", "c.\tje ne suis pas de légumes", "d.\tje ne donne pas de légumes"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Est-ce qu’il parle à son père ? \n B : Non, ……………..");
        question.setChoices(new String[]{"a.\til ne parle pas à sa mère", "b.\til ne parle pas à son frère", "c.\til ne parle pas à son père", "d.\til ne parle pas  à ses parents"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Est-ce que Sarah a un frère ? \n B : Non, ………….. ");
        question.setChoices(new String[]{"a.\telle n’a pas un frère", "b.\telle n’a pas de frère", "c.\telle n’a pas le frère", "d.\telle n’a pas des frères"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Tu veux aller au cinéma ? \n B : Non, ……………");
        question.setChoices(new String[]{"a.\tje ne veux pas aller au cinéma", "b.\tje ne veux pas aller à la poste", "c.\tje ne veux pas aller au restaurant", "d.\tje ne veux pas aller au campus"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : C’est un chat? \n B : Non, …………...");
        question.setChoices(new String[]{"a.\tce n’est pas de chat.", "b.\tce n’est pas un chat.", "c.\tce n’est pas le chat.", "d.\tce n’est pas des chat."});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Vous voulez du pain ?\n B : Non,…………….");
        question.setChoices(new String[]{"a.\tnous ne voulons pas des pains", "b.\tnous ne voulons pas du pains", "c.\tnous ne voulons pas un pain", "d.\tnous ne voulons pas de pain"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Tu connais la sœur de Gisèle ? \n B : Non, …………………………");
        question.setChoices(new String[]{"a.\tje ne connais pas de sœur de Gisèle.", "b.\tje ne connais pas une sœur de Gisèle.", "c.\tje ne connais pas la sœur de Gisèle.", "d.\tje ne connais pas des sœurs de Gisèle."});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Tu regardes la télévision? \n B : Non, ……………………….");
        question.setChoices(new String[]{"a.\tje ne regarde pas de télévision.", "b.\tje ne regarde pas la télévision.", "c.\tje ne regarde pas la nouvelle.", "d.\tje ne regarde pas de nouvelle."});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        addNewQuiz(4, "Pilihlah jawaban dalam bentuk negatif yang tepat !", questions);

        /*******************************************************************************************
         *  ADD QUIZ 5
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("….. 5 degrés dans le frigo.");
        question.setChoices(new String[]{"a.\tIl est", "b.\tIl fait", "c.\tIl y a", "d.\tIl faut"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Les chaussures des enfants sont trop vieilles. ….. des chaussures neuves.");
        question.setChoices(new String[]{"a.\tIl est", "b.\tIl fait", "c.\tIl y a", "d.\tIl faut"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("….. 8h 05.");
        question.setChoices(new String[]{"a.\tIl est", "b.\tIl fait", "c.\tIl y a", "d.\tIl faut"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("…. arrêter de fumer.");
        question.setChoices(new String[]{"a.\tIl est", "b.\tIl fait", "c.\tIl y a", "d.\tIl faut"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("….. des chocolats dans le frigo.");
        question.setChoices(new String[]{"a.\tIl est", "b.\tIl fait", "c.\tIl y a", "d.\tIl faut"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Il est arrivé …. 15 minutes.");
        question.setChoices(new String[]{"a.\tIl est", "b.\tIl fait", "c.\tIl y a", "d.\tIl faut"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("…. 18 heures");
        question.setChoices(new String[]{"a.\tIl est", "b.\tIl fait", "c.\tIl y a", "d.\tIl faut"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("En été, …. beau.");
        question.setChoices(new String[]{"a.\tIl est", "b.\tIl fait", "c.\tIl y a", "d.\tIl faut"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("…. beaucoup des gens ici.");
        question.setChoices(new String[]{"a.\tIl est", "b.\tIl fait", "c.\tIl y a", "d.\tIl faut"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("…. de l’argent pour voyager à Bali.");
        question.setChoices(new String[]{"a.\tIl est", "b.\tIl fait", "c.\tIl y a", "d.\tIl faut"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        addNewQuiz(5, "Pilihlah kata kerja <i>impersonnelle</i> yang sesuai pada kalimat berikut!", questions);

        /*******************************************************************************************
         *  ADD QUIZ 6
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("Vous achetez un billet -> ….. un billet !");
        question.setChoices(new String[]{"a.\tAchète", "b.\tAchetez", "c.\tAchetons"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Tu passes l’aspirateur ->…. l’aspirateur !");
        question.setChoices(new String[]{"a.\tpasse", "b.\tpassez", "c.\tpassons"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Tu jettes les papiers -> …. les papiers !");
        question.setChoices(new String[]{"a.\tjette", "b.\tjetez", "c.\tjetons"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Nous coupons le poulet en morceaux -> …. le poulet en morceaux !");
        question.setChoices(new String[]{"a.\tCoupe", "b.\tCoupez", "c.\tCoupons"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Nous montons les escaliers -> …. les escaliers !");
        question.setChoices(new String[]{"a.\tMonte", "b.\tMontez", "c.\tMontons"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous demandez au professeur -> …. au professeur !");
        question.setChoices(new String[]{"a.\tDemande", "b.\tDemandez", "c.\tDemandons"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous allez au bâtiment 4! -> …. au bâtiment 4 !");
        question.setChoices(new String[]{"a.\tVa", "b.\tAllez", "c.\tAllons"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Tu n’as pas peur -> …. pas peur !");
        question.setChoices(new String[]{"a.\tN’aie", "b.\tN’ayons", "c.\tN’ayez"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous ne fumez pas -> …. !");
        question.setChoices(new String[]{"a.\tNe fume pas", "b.\tNe fumez pas", "c.\tNe fumons pas"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous n’êtes pas nerveux -> ….. nerveux !");
        question.setChoices(new String[]{"a.\tNe sois pas", "b.\tNe soyons pas", "c.\tNe soyez pas"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        addNewQuiz(6, "Pilihlah konjugasi <i>l’impératif</i> yang tepat!", questions);

        /*******************************************************************************************
         *  ADD QUIZ 7
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("Nous (parler) …. avec Madame Valerie.");
        question.setChoices(new String[]{"a.\tparle", "b.\tparlons", "c.\tparlez", "d.\tparles"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Je (faire) …. un promenade.");
        question.setChoices(new String[]{"a.\tfais", "b.\tfait", "c.\tfaisons", "d.\tfaites"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Nous (prendre) …. le petit déjeuner ensemble. ");
        question.setChoices(new String[]{"a.\tprends", "b.\tprend", "c.\tprenez", "d.\tprenons"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Paul (fermer) …. la porte.");
        question.setChoices(new String[]{"a.\tferme", "b.\tfermes", "c.\tfermons", "d.\tfermez"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Moi et ma mère (écouter) …. de la musique");
        question.setChoices(new String[]{"a.\técoute", "b.\técoutes", "c.\técoutes", "d.\técoutons"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Je …. (aller) au campus");
        question.setChoices(new String[]{"a.\tva", "b.\tvais", "c.\tvas", "d.\tallez"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Il …. (aimer) le chocolat.");
        question.setChoices(new String[]{"a.\taime", "b.\taimes", "c.\taimes", "d.\taimons"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Madame Valérie ….. (chanter) bien");
        question.setChoices(new String[]{"a.\tchante", "b.\tchantez", "c.\tchantes", "d.\tchantons"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous …. (regarder) la télévision.");
        question.setChoices(new String[]{"a.\tregarde", "b.\tregardent", "c.\tregardons", "d.\tregardez"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Elles …. (porter) un parapluie.");
        question.setChoices(new String[]{"a.\tporte", "b.\tportes", "c.\tportez", "d.\tportent"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        addNewQuiz(7, "Pilihlah konjugasi <i>indicatif présent</i> yang tepat dari kata kerja di dalam kurung ", questions);

        /*******************************************************************************************
         *  ADD QUIZ 8
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("Amanda … toujours avec son costume officiel.");
        question.setChoices(new String[]{"a.\tm’habille", "b.\tt’habille", "c.\ts’habille", "d.\tvous habillez"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Cette étudiante est très sympa. … s’appelle Marie.");
        question.setChoices(new String[]{"a.\tNous", "b.\tTu", "c.\tElle", "d.\tIl"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Antoine et moi sommes français. …. parlons français et anglais.");
        question.setChoices(new String[]{"a.\tNous", "b.\tTu", "c.\tElle", "d.\tIl"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("…. aime le thé.");
        question.setChoices(new String[]{"a.\tJe", "b.\tTu", "c.\tNous", "d.\tJ’"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Anne et Lucie sont amies. …. aiment le chocolat.");
        question.setChoices(new String[]{"a.\tIls", "b.\tIl", "c.\tElles", "d.\tElle"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Jacques et moi sommes en vacances. ….. visitons le musée de Louvre.");
        question.setChoices(new String[]{"a.\tJe", "b.\tTu", "c.\tNous", "d.\tJ’"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Quand mon frère va au cinéma, ….. achète toujours du pop-corn.");
        question.setChoices(new String[]{"a.\tIls", "b.\tIl", "c.\tElles", "d.\tElle"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Salut, Natalie. ….vas bien?");
        question.setChoices(new String[]{"a.\tNous", "b.\tTu", "c.\tElle", "d.\tIl"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Tu connais Laura ?\nB : Bien sûr, … est dans ma classe. ?");
        question.setChoices(new String[]{"a.\tje", "b.\ttu", "c.\telle", "d.\til"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Vous ….. comment ?\nB : Je m’appelle Sara.");
        question.setChoices(new String[]{"a.\tt’appelle", "b.\tvous appelez", "c.\tnous appelons", "d.\tm’appelle"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        addNewQuiz(8, "Pilihlah <i>pronom personnel</i> yang sesuai untuk melengkapi kalimat-kalimat berikut !", questions);

        /*******************************************************************************************
         *  ADD QUIZ 9
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("J’ai rendez-vous avec Nathalie -> J’ai rendez-vous avec….");
        question.setChoices(new String[]{"a.\tmoi", "b.\tlui", "c.\teux", "d.\telle"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Ce soir, je vais au cinéma avec mes sœur -> Ce soir, je vais au cinéma avec ….");
        question.setChoices(new String[]{"a.\telle", "b.\telles", "c.\teux", "d.\tmoi"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Ce stylo est à Marie?\nB : Oui, C’est à …. ");
        question.setChoices(new String[]{"a.\telle", "b.\teux", "c.\tlui", "d.\ttoi"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : On se retrouve chez moi samedi ?\nB : Non, je ne peux pas venir chez ….., je travaille.");
        question.setChoices(new String[]{"a.\telle", "b.\ttoi", "c.\tlui", "d.\tvous"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Il part en vacances avec son ami -> Il part en vacances avec …..");
        question.setChoices(new String[]{"a.\tmoi", "b.\teux", "c.\tlui", "d.\ttoi"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Monsieur et Madame Dupont vont au cinéma avec ses enfants -> Ils vont au cinéma avec ….");
        question.setChoices(new String[]{"a.\telle", "b.\teux", "c.\tlui", "d.\tvous"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Salut ! Tu vas bien ?\nB : Pas mal ! Et …. ?");
        question.setChoices(new String[]{"a.\ttoi", "b.	elles", "c.\teux", "d.\tmoi"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Il vient avec ses parents -> Il vient avec ….");
        question.setChoices(new String[]{"a.\ttoi", "b.\telles", "c.\teux", "d.\tmoi"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : C’est pour moi?\nB : Oui, c’est pour …..");
        question.setChoices(new String[]{"a.\ttoi", "b.\telles", "c.\teux", "d.\tmoi"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Tu sors avec ce garçon?\nB : Oui, je sors avec ….");
        question.setChoices(new String[]{"a.\ttoi", "b.\tlui", "c.\teux", "d.\tmoi"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        addNewQuiz(9, "Pilihlah <i>pronom tonique</i> yang sesuai untuk melengkapi kalimat-kalimat berikut ini !", questions);

        /*******************************************************************************************
         *  ADD QUIZ 10
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("A : …. habitez-vous ? \n B : Avec ma famille");
        question.setChoices(new String[]{"a.\tAvec quoi", "b.\tAvec qui", "c.\tDe quoi", "d.\tQui"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : …. tu parles ? \n B : De mon travail");
        question.setChoices(new String[]{"a.\tAvec quoi", "b.\tAvec qui", "c.\tDe quoi", "d.\tQui"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : …. lisez-vous ? \n B : le livre de petit prince");
        question.setChoices(new String[]{"a.\tAvec quoi", "b.\tQue", "c.\tDe quoi", "d.\tQui"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Vous parlez …. avec Madame Directrice? \n B : Nous parlons de Jeanne");
        question.setChoices(new String[]{"a.\tAvec quoi", "b.\tAvec qui", "c.\tDe quoi", "d.\tQui"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : …. a mangé mon gâteau ? \n B : Moi");
        question.setChoices(new String[]{"a.\tAvec quoi", "b.\tAvec qui", "c.\tDe quoi", "d.\tQui"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : ……. avez-vous parlé?  \n B : Au médecin.");
        question.setChoices(new String[]{"a.\tAvec quoi", "b.\tAvec qui", "c.\tDe quoi", "d.\tQui"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : …… êtes-vous ? ? \n B : Je suis le père de Léa.");
        question.setChoices(new String[]{"a.\tQui", "b.\tAvec qui", "c.\tDe quoi", "d.\tÀ qui"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : …… tu vas au restaurant ce soir ? \n B : Avec ma mère");
        question.setChoices(new String[]{"a.\tQui", "b.\tAvec qui", "c.\tDe quoi", "d.\tÀ Qui"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : …… tu as parlé ?  \n B : Au boulanger.");
        question.setChoices(new String[]{"a.\tQui", "b.\tAvec qui", "c.\tDe quoi", "d.\tÀ Qui"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : …… avez-vous vu? \n B : Les concours de français.");
        question.setChoices(new String[]{"a.\tQu'", "b.\tQue", "c.\tDe quoi", "d.\tÀ qui"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        addNewQuiz(10, "Pilihlah <i>pronom interrogatif</i> yang tepat untuk melengkapi dialog-dialog berikut !", questions);

        /*******************************************************************************************
         *  ADD QUIZ 11
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("Je connais …. maison d’Andrew.");
        question.setChoices(new String[]{"a.\tle", "b.\tla", "c.\tles", "d.\tl'"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Donnez-moi … livre de Paul.");
        question.setChoices(new String[]{"a.\tle", "b.\tla", "c.\tles", "d.\tl'"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Passe-moi …. papiers qui sont sur la table.");
        question.setChoices(new String[]{"a.\tle", "b.\tla", "c.\tles", "d.\tl'"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Mon école est près de …. hôtel de Paris.");
        question.setChoices(new String[]{"a.\tle", "b.\tla", "c.\tles", "d.\tl'"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("…. chats sont très mignons, les couleurs sont gris.");
        question.setChoices(new String[]{"a.\tLe", "b.\tLa", "c.\tLes", "d.\tL'"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Jane cherche ….. clé de son copain.");
        question.setChoices(new String[]{"a.\tle", "b.\tla", "c.\tles", "d.\tl'"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("…… maison de Sophie est très grande.");
        question.setChoices(new String[]{"a.\tLe", "b.\tLa", "c.\tLes", "d.\tL'"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("……. téléphone portable de Xavier est cassé.");
        question.setChoices(new String[]{"a.\tLe", "b.\tLa", "c.\tLes", "d.\tL'"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("…… chaleur est très forte.");
        question.setChoices(new String[]{"a.\tLe", "b.\tLa", "c.\tLes", "d.\tL'"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("…… nuages arrivent.");
        question.setChoices(new String[]{"a.\tLe", "b.\tLa", "c.\tLes", "d.\tL'"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        addNewQuiz(11, "Pilihlah <i>article défini</i> yang sesuai untuk melengkapi kalimat-kalimat berikut !", questions);

        /*******************************************************************************************
         *  ADD QUIZ 12
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("Pierre accroché …. tableaux sur le mur.");
        question.setChoices(new String[]{"a.\tdu", "b.\tdes", "c.\tune", "d.\tun"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Je vais à la plage avec … ami.");
        question.setChoices(new String[]{"a.\tune", "b.\tun", "c.\tdes", "d.\tdu"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Ma mère a …. voiture");
        question.setChoices(new String[]{"a.\tune", "b.\tun", "c.\tdes", "d.\tdu"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Alice achète …. stylos");
        question.setChoices(new String[]{"a.\tune", "b.\tun", "c.\tdes", "d.\tdu"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Pierre regarde …. film");
        question.setChoices(new String[]{"a.\tune", "b.\tun", "c.\tdes", "d.\tdu"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Les touristes prennent ….. photos.");
        question.setChoices(new String[]{"a.\tune", "b.\tun", "c.\tdes", "d.\tdu"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("….. jeune femme lit un livre");
        question.setChoices(new String[]{"a.\tUne", "b.\tUn", "c.\tDes", "d.\tDu"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("….. fillettes mangent une glace.");
        question.setChoices(new String[]{"a.\tUne", "b.\tUn", "c.\tDes", "d.\tDu"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("…… musicien joue du violon.");
        question.setChoices(new String[]{"a.\tUne", "b.\tUn", "c.\tDes", "d.\tDu"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("le serveur parle avec ….. cliente.");
        question.setChoices(new String[]{"a.\tune", "b.\tun", "c.\tdes", "d.\tdu"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        addNewQuiz(12, "Pilihlah <i>article indéfini</i> yang sesuai untuk melengkapi kalimat-kalimat berikut !", questions);

        /*******************************************************************************************
         *  ADD QUIZ 13
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("Hélène et Marie mangent du pain avec …. beurre.");
        question.setChoices(new String[]{"a.\tdu", "b.\tde la", "c.\tde", "d.\tde l'"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("En général, les Français boivent …. vin aux repas.");
        question.setChoices(new String[]{"a.\tdu", "b.\tde la", "c.\tde", "d.\tde l'"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Cette centrale nucléaire fournit …. énergie à toute la région.");
        question.setChoices(new String[]{"a.\tdu", "b.\tde la", "c.\tde", "d.\tde l'"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Il faut avoir …. patience pour faire un puzzle.");
        question.setChoices(new String[]{"a.\tdu", "b.\tde la", "c.\tde", "d.\tde l'"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Elle achete …. farine.");
        question.setChoices(new String[]{"a.\tde la", "b.\tde l'", "c.\tde", "d.\tdu"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Il y a ….. jambon.");
        question.setChoices(new String[]{"a.\tde la", "b.\tde l'", "c.\tde", "d.\tdu"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Je veux ….. vin.");
        question.setChoices(new String[]{"a.\tde la", "b.\tde l'", "c.\tde", "d.\tdu"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Je prends …. gâteau.");
        question.setChoices(new String[]{"a.\tde la", "b.\tde l'", "c.\tde", "d.\tdu"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Il y a ….. confiture mais il n’y a du pain.");
        question.setChoices(new String[]{"a.\tde la", "b.\tde l'", "c.\tde", "d.\tdu"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Il boit ….. café.");
        question.setChoices(new String[]{"a.\tde la", "b.\tde l'", "c.\tde", "d.\tdu"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        addNewQuiz(13, "Pilihlah <i>article partitif</i> yang sesuai untuk melengkapi kalimat-kalimat berikut !", questions);

        /*******************************************************************************************
         *  ADD QUIZ 14
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("…. yeux sont d’un bleu profond");
        question.setChoices(new String[]{"a.\tSa", "b.\tSon", "c.\tSes", "d.\tMon"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("…. école est loin d’ici");
        question.setChoices(new String[]{"a.\tMa", "b.\tMes", "c.\tSes", "d.\tMon"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("…. maison est très belle");
        question.setChoices(new String[]{"a.\tTa", "b.\tTon", "c.\tTes", "d.\tSes"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("C’est …. petit frère. Il s’appelle Erick.");
        question.setChoices(new String[]{"a.\tma", "b.\tmon", "c.\tmes", "d.\ttes"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Est-ce que …. mère est allée en vacances ? \n B : Bien sûr.");
        question.setChoices(new String[]{"a.\tvotre", "b.\tton", "c.\tmon", "d.\tson"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("J’ai perdu …. veste bleue.");
        question.setChoices(new String[]{"a.\tvotre", "b.\tma", "c.\tmon", "d.\tson"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Je dois passer chez Catherine mais je n’ai pas …. adresse.");
        question.setChoices(new String[]{"a.\tvotre", "b.\tsa", "c.\tmon", "d.\tson"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Posez …. affaires sur la table, s’il vous plaît.");
        question.setChoices(new String[]{"a.\tvotre", "b.\tton", "c.\tvos", "d.\tson"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous avez …. permis de conduire, madame ?");
        question.setChoices(new String[]{"a.\tvotre", "b.\tton", "c.\tvos", "d.\tses"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Je ne retrouve plus …. lunettes.");
        question.setChoices(new String[]{"a.\tsa", "b.\tmes", "c.\tmon", "d.\tma"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        addNewQuiz(14, "Pilihlah <i>adjectif possesif</i> yang sesuai untuk melengkapi kalimat-kalimat berikut!", questions);

        /*******************************************************************************************
         *  ADD QUIZ 15
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("Je n’aime pas …. stylos : Ils m’échappent tous des mains.");
        question.setChoices(new String[]{"a.\tca", "b.\tces", "c.\tcet", "d.\tcette"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("…. endroit est désertique : c’est un désert humain");
        question.setChoices(new String[]{"a.\tCes", "b.\tCe", "c.\tCette", "d.\tCet"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("…. station de sports d’hiver est très grande");
        question.setChoices(new String[]{"a.\tCes", "b.\tCe", "c.\tCette", "d.\tCet"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("…. porte-avions était le plus grand de la seconde Guerre Mondiale");
        question.setChoices(new String[]{"a.\tCette", "b.\tCe", "c.\tCet", "d.\tCes"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Passez-moi …. livre.");
        question.setChoices(new String[]{"a.\tcette", "b.\tce", "c.\tcet", "d.\tces"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous préférez ce bonnet ou ….. casquette ?");
        question.setChoices(new String[]{"a.\tcette", "b.\tce", "c.\tcet", "d.\tces"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("…. homme a l’air très sympathique, tu ne trouves pas ?");
        question.setChoices(new String[]{"a.\tCette", "b.\tCe", "c.\tCet", "d.\tCes"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("J’hésite entre …. chemisier et cette tunique.");
        question.setChoices(new String[]{"a.\tcette", "b.\tce", "c.\tcet", "d.\tces"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Je voudrais essayer …. jupe, s’il vous plaît.");
        question.setChoices(new String[]{"a.\tcette", "b.\tce", "c.\tcet", "d.\tces"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("….. billets ne sont plus valables, je regrette mademoiselle.");
        question.setChoices(new String[]{"a.\tCette", "b.\tCe", "c.\tCet", "d.\tCes"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        addNewQuiz(15, "Pilihlah <i>adjectif démonstratif</i> yang sesuai untuk melengkapi kalimat-kalimat berikut!", questions);

        /*******************************************************************************************
         *  ADD QUIZ 16
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("Madame Soirée aime aider n’importe qui. Elle est une personne …..");
        question.setChoices(new String[]{"a.\tbelle", "b.\tbeau", "c.\tgentille", "d.\triche"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Erick jamais fait son devoir. Il est une personne …..");
        question.setChoices(new String[]{"a.\tbelle", "b.\tbeau", "c.\tgentile", "d.\tpareusseux"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Il s’appelle Hulk. Maintenant Il a 57 ans, donc il est……….");
        question.setChoices(new String[]{"a.\tvieux", "b.\tgentil", "c.\tgentile", "d.\triche"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("J’aime bien cette …. robe.");
        question.setChoices(new String[]{"a.\tbelle", "b.\tbeau", "c.\tlaid", "d.\tlaide"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("C’est une …. femme.");
        question.setChoices(new String[]{"a.\tbelle", "b.\tbeau", "c.\tlaid", "d.\tnouveau"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Je dois acheter un ….. stylo.");
        question.setChoices(new String[]{"a.\tbelle", "b.\tnouveau", "c.\tbonne", "d.\tdouce"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("La température est vraiment ….");
        question.setChoices(new String[]{"a.\tgros", "b.\tbeau", "c.\tbon", "d.\tfraiche"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Elle a de bonnes notes. Elle est très ….");
        question.setChoices(new String[]{"a.\tintelligente", "b.\tintelligent", "c.\tgentil", "d.\tgentile"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous avez un ….. chapeau");
        question.setChoices(new String[]{"a.\tbelle", "b.\tgentille", "c.\tnouvelle", "d.\tnouveau"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Son mari est vraiment ….");
        question.setChoices(new String[]{"a.\tbelle", "b.\tdouce", "a.\tjaloux", "d.\tgentille"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        addNewQuiz(16, "Pilihlah <i>adjectif qualificatif</i> yang sesuai untuk melengkapi kalimat-kalimat berikut!", questions);

        /*******************************************************************************************
         *  ADD QUIZ 17
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("Ma cousine est venue pour les fêtes de Nöel, …. elle est arrivée en retard.");
        question.setChoices(new String[]{"a.\tet", "b.\tou", "c.\tmais", "d.\talors"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Il y a six paquets : trois pour moi … trois pour elle.");
        question.setChoices(new String[]{"a.\tet", "b.\tou", "c.\tmais", "d.\talors"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Paul … Alexandra sont partis à la piscine.");
        question.setChoices(new String[]{"a.\tet", "b.\tou", "c.\tmais", "d.\talors"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Il fait beau temps, …. on n’a pas fait grand-chose finalement.");
        question.setChoices(new String[]{"a.\tet", "b.\tou", "c.\tmais", "d.\talors"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Les animaux sauvages …. les animaux domestiques n’ont rien à voir entre eux.");
        question.setChoices(new String[]{"a.\tet", "b.\tou", "c.\tmais", "d.\talors"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Il est jeune … malgré les apparences il est mature");
        question.setChoices(new String[]{"a.\tet", "b.\tou", "c.\tmais", "d.\talors"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Veut-elle manger une tarte aux framboises … aux myrtilles ?");
        question.setChoices(new String[]{"a.\tet", "b.\tou", "c.\tmais", "d.\talors"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("J’ai fini de manger … j’ai encore faim.");
        question.setChoices(new String[]{"a.\tet", "b.\tou", "c.\tmais", "d.\talors"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("L’anniversaire de Phillipe est aujourd’hui … demain ?");
        question.setChoices(new String[]{"a.\tet", "b.\tou", "c.\tmais", "d.\talors"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Ma mère …. mon père se marient en 1996.");
        question.setChoices(new String[]{"a.\tet", "b.\tou", "c.\tmais", "d.\talors"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        addNewQuiz(17, "Pilihlah <i>conjonction</i> yang tepat untuk melengkapi kalimat-kalimat berikut! ", questions);

        /*******************************************************************************************
         *  ADD QUIZ 17
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("A : …. est-ce que la conférence a lieu ? \n B : Dans le grand amphithéâtre. ");
        question.setChoices(new String[]{"a.\tCombien", "b.\tOù", "c.\tQue", "d.\tQuand"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : …. Arthur ne vient pas ? \n B : Il n’est pas libre.");
        question.setChoices(new String[]{"a.\tPourquoi", "b.\tQuand", "c.\tQui", "d.\tQuoi"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : …. de touristes séjournent dans votre hôtel? \n B : Trente personnes.");
        question.setChoices(new String[]{"a.\tCombien", "b.\tComment", "c.\tQui", "d.\tQuoi"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : …. a oublié de fermer la fenêtre ? \n B : Moi");
        question.setChoices(new String[]{"a.\tOù", "b.\tCombien", "c.\tQui", "d.\tPourquoi"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Tu vas …. en France \n B : En janvier");
        question.setChoices(new String[]{"a.\tquand", "b.\tcombien", "c.\tqui", "d.\tpourquoi"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Ils habitent …. ? \n B : Ils habitents à Nice");
        question.setChoices(new String[]{"a.\toù", "b.\tcombien", "c.\tqui", "d.\tpourquoi"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : …. elles ne mangent pas de chocolat ? \n B : parce qu’elles n’aiment pas ça. ");
        question.setChoices(new String[]{"a.\tOù", "b.\tCombien", "c.\tQui", "d.\tPourquoi"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : …. est-ce que ça finit ? \n B : vers 5 heures");
        question.setChoices(new String[]{"a.\tOù", "b.\tComment", "c.\tQuand", "d.\tPourquoi"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : …. on y va ? \n B : En voiture, si tu veux.");
        question.setChoices(new String[]{"a.\tOù", "b.\tComment", "c.\tQui", "d.\tPourquoi"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : …… est-ce que ça commence à 18h seuleument ? \nB : Parce que la salle n’est pas libre avant.");
        question.setChoices(new String[]{"a.\tOù", "b.\tComment", "c.\tCombien de", "d.\tPourquoi"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        addNewQuiz(18, "Pilihlah <i>mot interrogation</i> yang sesuai untuk melengkapi kalimat-kalimat berikut!", questions);
    }


    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Materi.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Quiz.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long addNewMateri(int type, String title, int[] contents) {
        ContentValues values = new ContentValues();
        // `id` will be inserted automatically.
        // no need to add them
        values.put(Materi.COLUMN_TYPE, type);
        values.put(Materi.COLUMN_TITLE, title);
        values.put(Materi.COLUMN_CONTENTS, gson.toJson(contents));

        Log.i("@@@", gson.toJson(contents));

        // insert row
        long id = db.insert(Materi.TABLE_NAME, null, values);
        // return newly inserted row id
        return id;
    }

    public long addNewQuiz(int idMateri, String title, List<Question> questions) {
        ContentValues values = new ContentValues();
        // `id` will be inserted automatically.
        // no need to add them
        values.put(Quiz.COLUMN_ID_MATERI, idMateri);
        values.put(Quiz.COLUMN_TITLE, title);
        values.put(Quiz.COLUMN_QUESTIONS, gson.toJson(questions));

        Log.i("@QUIZ", gson.toJson(questions));

        // insert row
        long id = db.insert(Quiz.TABLE_NAME, null, values);
        // return newly inserted row id
        return id;
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getMateriByType(Class<T> dataClass) {
        List<T> materies = new ArrayList<>();
        int type = 0;

        if (dataClass == LesAdjectif.class)
            type = Constants.Materi.TYPE_ADJECTIF;
        else if (dataClass == LesArticles.class)
            type = Constants.Materi.TYPE_ARTICLE;
        else if (dataClass == LesPronom.class)
            type = Constants.Materi.TYPE_PRONOM;
        else if (dataClass == LesVerbes.class)
            type = Constants.Materi.TYPE_VERB;
        else if (dataClass == Conjonction.class)
            type = Constants.Materi.TYPE_CONJONCTION;
        else if (dataClass == Interrogatif.class)
            type = Constants.Materi.TYPE_INTERROGATIF;


        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(Materi.TABLE_NAME,
                new String[]{Materi.COLUMN_ID, Materi.COLUMN_TYPE, Materi.COLUMN_TITLE, Materi.COLUMN_CONTENTS},
                Materi.COLUMN_TYPE + "=?",
                new String[]{String.valueOf(type)}, null, null, Materi.COLUMN_ID + " ASC", null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            if (dataClass == LesAdjectif.class) {
                do {
                    LesAdjectif adjectif = new LesAdjectif();
                    adjectif.setIcon(R.drawable.icon_lesadjectif);
                    adjectif.setId(cursor.getInt(cursor.getColumnIndex(Materi.COLUMN_ID)));
                    adjectif.setTitle(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_TITLE)));
                    adjectif.setContents(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_CONTENTS)));
                    materies.add((T) adjectif);
                } while (cursor.moveToNext());
            } else if (dataClass == LesArticles.class) {
                do {
                    LesArticles articles = new LesArticles();
                    articles.setIcon(R.drawable.icon_lesarticles);
                    articles.setId(cursor.getInt(cursor.getColumnIndex(Materi.COLUMN_ID)));
                    articles.setTitle(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_TITLE)));
                    articles.setContents(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_CONTENTS)));
                    materies.add((T) articles);
                } while (cursor.moveToNext());
            } else if (dataClass == LesVerbes.class) {
                do {
                    LesVerbes verbes = new LesVerbes();
                    verbes.setIcon(R.drawable.icon_lesverbes);
                    verbes.setId(cursor.getInt(cursor.getColumnIndex(Materi.COLUMN_ID)));
                    verbes.setTitle(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_TITLE)));
                    verbes.setContents(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_CONTENTS)));
                    materies.add((T) verbes);
                } while (cursor.moveToNext());
            } else if (dataClass == LesPronom.class) {
                do {
                    LesPronom pronom = new LesPronom();
                    pronom.setIcon(R.drawable.icon_lespronom);
                    pronom.setId(cursor.getInt(cursor.getColumnIndex(Materi.COLUMN_ID)));
                    pronom.setTitle(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_TITLE)));
                    pronom.setContents(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_CONTENTS)));
                    materies.add((T) pronom);
                } while (cursor.moveToNext());
            } else if (dataClass == Conjonction.class) {
                do {
                    Conjonction conjonction = new Conjonction();
                    conjonction.setIcon(R.drawable.icon_conjonction);
                    conjonction.setId(cursor.getInt(cursor.getColumnIndex(Materi.COLUMN_ID)));
                    conjonction.setTitle(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_TITLE)));
                    conjonction.setContents(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_CONTENTS)));
                    materies.add((T) conjonction);
                } while (cursor.moveToNext());
            } else if (dataClass == Interrogatif.class) {
                do {
                    Interrogatif interrogatif = new Interrogatif();
                    interrogatif.setIcon(R.drawable.icon_interrogatif);
                    interrogatif.setId(cursor.getInt(cursor.getColumnIndex(Materi.COLUMN_ID)));
                    interrogatif.setTitle(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_TITLE)));
                    interrogatif.setContents(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_CONTENTS)));
                    materies.add((T) interrogatif);
                } while (cursor.moveToNext());
            }
        }

        // close db connection
        db.close();

        // return list
        return materies;
    }

    public Quiz getQuizByMateri(int idMateri) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getWritableDatabase();

        String QUERY = "SELECT tbl_quiz.id, tbl_quiz.title_quiz, tbl_quiz.questions FROM tbl_quiz INNER JOIN tbl_materi ON tbl_quiz.id_materi= tbl_materi.id WHERE tbl_quiz.id_materi=?";

        Cursor cursor = db.rawQuery(QUERY, new String[]{String.valueOf(idMateri)});

        if (cursor != null)
            cursor.moveToFirst();

        // prepare quiz object
        Quiz quiz = new Quiz();
        quiz.setId(cursor.getInt(cursor.getColumnIndex(Quiz.COLUMN_ID)));
        quiz.setTitleQuiz(cursor.getString(cursor.getColumnIndex(Quiz.COLUMN_TITLE)));
        quiz.setQuestions(cursor.getString(cursor.getColumnIndex(Quiz.COLUMN_QUESTIONS)));

        // close the db connection
        cursor.close();

        return quiz;
    }
}
