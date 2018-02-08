package execute;

import service.factory.ServiceFactory;

/**
 * @author Andrey Volinskiy on 07.02.2018.
 */
public class Main {

    public static void main(String[] args) {

//        ServiceFactory.getVocabularyService().add("Стілець", "Chair");
        System.out.println(ServiceFactory.getVocabularyService().translate("Молоко"));
//        ServiceFactory.getVocabularyService().delete("Стілець");
    }
}
