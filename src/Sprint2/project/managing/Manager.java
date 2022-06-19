package Sprint2.project.managing;

import Sprint2.project.models.Language;
import Sprint2.project.models.News;
import Sprint2.project.models.Publication;

import java.nio.channels.Pipe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Manager {

    private static Connection connection;

    static {
            try{
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(""+
                        "jdbc:postgresql://localhost:5432/sprint2","postgres", "postgres");
            }catch (Exception e){
                e.printStackTrace();
            }
    }

    public static ArrayList<News> getAllNews(String req, String req2){
        ArrayList<News> allNews = new ArrayList<>();
        try{

            PreparedStatement statement = connection.prepareStatement("");

            if(req2.equals("ALL")){

                statement = connection.prepareStatement(""+
                        "SELECT n.id, n.title, n.short_content ,n.content, n.post_date, n.picture, " +
                        "l.name AS lang, l.id AS lang_id, l.code, " +
                        "p.name AS publication, p.id AS pub_id, p.rating, p.description " +
                        "FROM news n " +
                        "INNER JOIN languages l ON l.id = n.language_id " +
                        "INNER JOIN publications p ON p.id = n.publication_id WHERE l.code=?");

                statement.setString(1,req);

            }
            else{

                statement = connection.prepareStatement(""+
                        "SELECT n.id, n.title, n.short_content ,n.content, n.post_date, n.picture, " +
                        "l.name AS lang, l.id AS lang_id, l.code, " +
                        "p.name AS publication, p.id AS pub_id, p.rating, p.description " +
                        "FROM news n " +
                        "INNER JOIN languages l ON l.id = n.language_id " +
                        "INNER JOIN publications p ON p.id = n.publication_id WHERE l.code=? AND p.name = ?");

                statement.setString(1, req);
                statement.setString(2, req2);

            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                News theNew = new News();

                theNew.setId(resultSet.getLong("id"));
                theNew.setTitle(resultSet.getString("title"));
                theNew.setShort_content(resultSet.getString("short_content"));
                theNew.setContent(resultSet.getString("content"));
                theNew.setDate(resultSet.getString("post_date"));
                theNew.setPicture(resultSet.getString("picture"));

                Language theLanguage = new Language();

                theLanguage.setId(resultSet.getLong("lang_id"));
                theLanguage.setName(resultSet.getString("lang"));
                theLanguage.setCode(resultSet.getString("code"));

                theNew.setLanguage(theLanguage);


                Publication p = new Publication();

                p.setId(resultSet.getLong("pub_id"));
                p.setName(resultSet.getString("publication"));
                p.setDescription(resultSet.getString("description"));
                p.setRating(resultSet.getDouble("rating"));

                theNew.setPublication(p);

                allNews.add(theNew);

                }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return allNews;
    }


    public static ArrayList<News> getNews(){
        ArrayList<News> allNews = new ArrayList<>();
        try{

            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT n.id, n.title, n.short_content ,n.content, n.post_date, n.picture, " +
                    "l.name AS lang, l.id AS lang_id, l.code, " +
                    "p.name AS publication, p.id AS pub_id, p.rating, p.description " +
                    "FROM news n " +
                    "INNER JOIN languages l ON l.id = n.language_id " +
                    "INNER JOIN publications p ON p.id = n.publication_id");


            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                News theNew = new News();

                theNew.setId(resultSet.getLong("id"));
                theNew.setTitle(resultSet.getString("title"));
                theNew.setShort_content(resultSet.getString("short_content"));
                theNew.setContent(resultSet.getString("content"));
                theNew.setDate(resultSet.getString("post_date"));
                theNew.setPicture(resultSet.getString("picture"));

                Language theLanguage = new Language();

                theLanguage.setId(resultSet.getLong("lang_id"));
                theLanguage.setName(resultSet.getString("lang"));
                theLanguage.setCode(resultSet.getString("code"));

                theNew.setLanguage(theLanguage);


                Publication p = new Publication();

                p.setId(resultSet.getLong("pub_id"));
                p.setName(resultSet.getString("publication"));
                p.setDescription(resultSet.getString("description"));
                p.setRating(resultSet.getDouble("rating"));

                theNew.setPublication(p);

                allNews.add(theNew);
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return allNews;
    }

    public static News getTheNew(Long id){

        News theNew = new News();

        try{
            PreparedStatement statement = connection.prepareStatement("");

            statement = connection.prepareStatement(""+
                    "SELECT n.id, n.title, n.short_content, n.content, n.post_date, n.picture, "+
                    "l.name AS lang, l.id AS lang_id, l.code, "+
                    "p.name AS publication, p.id AS pub_id, p.rating, p.description "+
                    "FROM news n "+
                    "INNER JOIN languages l ON l.id = n.language_id "+
                    "INNER JOIN publications p ON p.id = n.publication_id WHERE n.id = ? ");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                theNew.setId(id);
                theNew.setTitle(resultSet.getString("title"));
                theNew.setShort_content(resultSet.getString("short_content"));
                theNew.setContent(resultSet.getString("content"));
                theNew.setDate(resultSet.getString("post_date"));
                theNew.setPicture(resultSet.getString("picture"));

                Language lang = new Language();
                lang.setId(resultSet.getLong("lang_id"));
                lang.setName(resultSet.getString("lang"));
                lang.setCode(resultSet.getString("code"));

                theNew.setLanguage(lang);


                Publication pub = new Publication();
                pub.setId(resultSet.getLong("pub_id"));
                pub.setName(resultSet.getString("publication"));
                pub.setRating(resultSet.getDouble("rating"));
                pub.setDescription(resultSet.getString("description"));
                theNew.setPublication(pub);

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return theNew;
    }


    public static ArrayList<Language> getAllLanguages(){

        ArrayList<Language> languages = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT * FROM languages");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                Language language = new Language();

                language.setId(resultSet.getLong("id"));
                language.setName(resultSet.getString("name"));
                language.setCode(resultSet.getString("code"));

                languages.add(language);
            }
            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }

        return languages;
    }

    public static ArrayList<Publication> getAllPublications(){

        ArrayList<Publication> pubs = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT * FROM publications");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Publication p = new Publication();

                p.setId(resultSet.getLong("id"));
                p.setName(resultSet.getString("name"));
                p.setDescription(resultSet.getString("description"));
                p.setRating(resultSet.getDouble("rating"));

                pubs.add(p);

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }


        return pubs;
    }

    public static void deleteNews(Long i){

        try{

            PreparedStatement statement = connection.prepareStatement(""+
                    "DELETE FROM news WHERE id = ?");
            statement.setLong(1, i);

            statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void AddNews(News n){

        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "INSERT INTO news ( title, short_content, content, post_date, picture, language_id, publication_id ) "+
                    "values ( ? , ? , ? , NOW() , ? , ? , ? ) ");

            statement.setString(1, n.getTitle());
            statement.setString(2, n.getShort_content());
            statement.setString(3, n.getContent());
            statement.setString(4, n.getPicture());
            statement.setLong(5, n.getLanguage().getId());
            statement.setLong(6, n.getPublication().getId());

            statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void addPublication(Publication p){

        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "INSERT INTO publications ( name , description , rating ) values ( ? , ? , ? )");
            statement.setString(1,p.getName());
            statement.setString(2,p.getDescription());
            statement.setDouble(3,p.getRating());

            statement.executeUpdate();

        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public static void deletePublication(Long id){

        try{

            PreparedStatement statement = connection.prepareStatement(""+
                    "DELETE FROM publications WHERE id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteLanguage(Long id){

        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "DELETE FROM languages WHERE id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addLanguage(Language lang){

        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO "+
                    "languages (name, code) values( ? , ? )");
            statement.setString(1, lang.getName());
            statement.setString(2, lang.getCode());
            statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Language getLanguage(Long id){

        Language theLanguage = new Language();

        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT * FROM languages WHERE id = ?");
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                theLanguage.setId(id);
                theLanguage.setName(resultSet.getString("name"));
                theLanguage.setCode(resultSet.getString("code"));
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }


        return theLanguage;


    }

    public static Publication getPublication(Long id){

        Publication thePublication = new Publication();

        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT * FROM publications WHERE id = ?");
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                thePublication.setId(id);
                thePublication.setName(resultSet.getString("name"));
                thePublication.setDescription(resultSet.getString("description"));
                thePublication.setRating(resultSet.getDouble("rating"));
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }


        return thePublication;

    }

    public static Language getLanguageByCode(String code) {

        Language theLanguage = new Language();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM languages WHERE code = ?");
            statement.setString(1, code);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                theLanguage.setId(resultSet.getLong("id"));
                theLanguage.setName(resultSet.getString("name"));
                theLanguage.setCode(code);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return theLanguage;
    }

}












//SELECT n.id, n.title, n.short_content, l.name, p.name
//FROM news n
//INNER JOIN publications p ON n.publication_id = p.id
//INNER JOIN languages l ON n.language_id = l.id