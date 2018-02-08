package dao.factory;

import dao.VocabularyDao;
import dao.impl.VocabularyDaoImpl;

/**
 * @author Andrey Volinskiy on 08.02.2018.
 */
public class DaoFactory {

    public static VocabularyDao getVocabularyDao() {
        return new VocabularyDaoImpl();
    }

}
