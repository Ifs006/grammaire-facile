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
        addNewMateri(Constants.Materi.TYPE_VERB, "LE VERBE RÉGULIER", new int[]{R.drawable.verb1_content1});
        addNewMateri(Constants.Materi.TYPE_VERB, "LE VERBE IRRÉGULIER", new int[]{R.drawable.verb2_content1, R.drawable.verb2_content2});
        addNewMateri(Constants.Materi.TYPE_VERB, "LE CONDITIONNEL DE POLITESSE", new int[]{R.drawable.verb3_content1});
        addNewMateri(Constants.Materi.TYPE_VERB, "LA NÉGATION", new int[]{R.drawable.verb4_content1, R.drawable.verb4_content2});
        addNewMateri(Constants.Materi.TYPE_VERB, "LA FORME IMPERSONNELLE SIMPLE", new int[]{R.drawable.verb5_content1, R.drawable.verb5_content2});
        addNewMateri(Constants.Materi.TYPE_VERB, "L’IMPÉRATIF", new int[]{R.drawable.verb6_content1, R.drawable.verb6_content2});
        addNewMateri(Constants.Materi.TYPE_VERB, "LA PRÉSENT DE L’INDICATIF", new int[]{R.drawable.verb7_content1, R.drawable.verb7_content2, R.drawable.verb7_content3, R.drawable.verb7_content4});

        // GENERATE MATERI PRONOM
        addNewMateri(Constants.Materi.TYPE_PRONOM, "LES PRONOMS PERSONNELS SUJETS", new int[]{R.drawable.pronom1_content1});
        addNewMateri(Constants.Materi.TYPE_PRONOM, "LES PRONOMS TONIQUES", new int[]{R.drawable.pronom2_content1, R.drawable.pronom2_content2});
        addNewMateri(Constants.Materi.TYPE_PRONOM, "LES INTÉROGATIFS SIMPLES", new int[]{R.drawable.pronom3_content1});

        // GENERATE MATERI ARTICLES
        addNewMateri(Constants.Materi.TYPE_ARTICLES, "LES PRONOMS PERSONNELS SUJETS", new int[]{R.drawable.articles1_content1});
        addNewMateri(Constants.Materi.TYPE_ARTICLES, "LES PRONOMS TONIQUES", new int[]{R.drawable.articles2_content1});
        addNewMateri(Constants.Materi.TYPE_ARTICLES, "LES INTÉROGATIFS SIMPLES", new int[]{R.drawable.articles3_content1});

        // GENERATE MATERI ADJECTIF
        addNewMateri(Constants.Materi.TYPE_ADJECTIF, "LES PRONOMS PERSONNELS SUJETS", new int[]{R.drawable.adjectif1_content1, R.drawable.adjectif1_content2});
        addNewMateri(Constants.Materi.TYPE_ADJECTIF, "LES PRONOMS TONIQUES", new int[]{R.drawable.adjectif2_content1});
        addNewMateri(Constants.Materi.TYPE_ADJECTIF, "LES INTÉROGATIFS SIMPLES", new int[]{R.drawable.adjectif3_content1, R.drawable.adjectif3_content2});

        // GENERATE MATERI CONJONCTION
        addNewMateri(Constants.Materi.TYPE_CONJONCTION, "LES PRONOMS PERSONNELS SUJETS", new int[]{R.drawable.conjonction1_content1, R.drawable.conjonction1_content2});

        // GENERATE MATERI INTERROGATION
        addNewMateri(Constants.Materi.TYPE_INTERROGATIF, "LES PRONOMS PERSONNELS SUJETS", new int[]{R.drawable.interrogation1_content1, R.drawable.interrogation1_content2});


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
        question.setChoices(new String[]{"a.\tparle", "b.\tparles", "c.\tparlons", "d.\tparlez"});
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
        question.setChoices(new String[]{"a.\tdanse", "b.\tdanses", "c.\tdansons", "d.\tdansez"});
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

        addNewQuiz(1, "Pilihlah konjugasi yang tepat dari kata kerja berakhiran -er di dalam kurung !", questions);

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
        // Reset question to new class
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

        addNewQuiz(2, "Pilihlah konjugasi yang tepat dari kata kerja irrégulier di dalam kurung !", questions);

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
        question.setCorrectIndexofChoices(1);
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

        addNewQuiz(3, "Pilihlah konjugasi yang tepat dari kata kerja irrégulier di dalam kurung !", questions);

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
        question.setChoices(new String[]{"a.\tje n’habite pas à Paris", "b.\tje n’habite pas à Nièce", "c.\tje n’habite pas à Nièce ", "d.\tje n’habite pas à Bordeaux"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Est-ce que vous achetez des légumes ? \n B : Non, …………");
        question.setChoices(new String[]{"a.\tje n’achète pas de légumes", "b.\tje n’ai pas de légumes", "c.\tpourriez", "d.\tpourrions"});
        question.setCorrectIndexofChoices(1);
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
        question.setChoices(new String[]{"a.\tce n’est pas de chat.", "b.\tce n’est pas un chat.", "c.\tce n’est pas le chat.", "d.\tce n’est pas le chat."});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Vous voulez du pain ?\n B : Non,…………….");
        question.setChoices(new String[]{"a.\tnous ne voulons pas des pains", "b.\tnous ne voulons pas des pains", "c.\tnous ne voulons pas un pain", "d.\tnous ne voulons pas de pain"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Tu connais la sœur de Gisèle ? \n B : Non, …………………………");
        question.setChoices(new String[]{"a.\tje ne connais pas de sœur de Gisèle.", "b.\tje ne connais pas une sœur de Gisèle.", "c.\tje ne connais pas la sœur de Gisèle.", "d.\tje ne connais pas des sœurs de Gisèle."});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("A : Tu regardes la télévision? \n B : Non, ……………………….");
        question.setChoices(new String[]{"a.\tje ne regarde pas de télévision.", "b.\tje ne regarde pas la télévision.", "c.\tje ne regarde pas la nouvelle.", "d.\tje ne regarde pas la nouvelle."});
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
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        addNewQuiz(5, "Pilihlah kata kerja impersonnelle yang sesuai pada kalimat berikut!", questions);

        /*******************************************************************************************
         *  ADD QUIZ 6
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("Vous achetez un billet -> ….. un billet !");
        question.setChoices(new String[]{"a.\tAchète", "b.\tAchetez", "c.\tAchetons", ""});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Tu passes l’aspirateur ->…. l’aspirateur !");
        question.setChoices(new String[]{"a.\tpasse", "b.\tpassez", "c.\t.passons", ""});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Tu jettes les papiers -> …. les papiers !");
        question.setChoices(new String[]{"a.\tjette", "b.\tjetez", "c.\tjetons", ""});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Nous coupons le poulet en morceaux -> …. le poulet en morceaux !");
        question.setChoices(new String[]{"a.\tCoupe", "b.\tCoupez", "c.\tCoupons", ""});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Nous montons les escaliers -> …. les escaliers !");
        question.setChoices(new String[]{"a.\tMonte", "b.\tMontez", "c.\tMontons", ""});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous demandez au professeur -> …. au professeur !");
        question.setChoices(new String[]{"a.\tDemande", "b.\tDemandez", "c.\tDemandons", ""});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous allez au bâtiment 4! -> …. au bâtiment 4 !");
        question.setChoices(new String[]{"a.\tVa", "b.\tAllez", "c.\tAllons", ""});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Tu n’as pas peur -> …. pas peur !");
        question.setChoices(new String[]{"a.\tN’aie", "b.\tN’ayons", "c.\tN’ayez", ""});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous ne fumez pas -> …. !");
        question.setChoices(new String[]{"a.\tNe fume pas", "b.\tNe fumez pas", "c.\tNe fumons pas", ""});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous n’êtes pas nerveux -> ….. nerveux !");
        question.setChoices(new String[]{"a.\tNe sois pas", "b.\tNe soyons pas", "c.\tNe soyez pas", ""});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        addNewQuiz(6, "Pilihlah konjugasi l’impératif yang tepat!", questions);

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

        addNewQuiz(7, "Pilihlah konjugasi indicatif présent yang tepat dari kata kerja di dalam kurung ", questions);

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
            type = Constants.Materi.TYPE_ARTICLES;
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
            }
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
