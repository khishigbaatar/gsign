package biz.gsign.sqlUtil;

import com.miragesql.miragesql.ClasspathSqlResource;
import com.miragesql.miragesql.SqlResource;

import java.util.ArrayList;
import java.util.List;

public class SqlUtil {
    public static SqlResource sql(String sqlName) {
        return new ClasspathSqlResource(sqlName);
    }


    public static String[] stringToArray(String string) {
        if (string == null) {
            return null;
        }
        return string.split("\\\\t");
    }

    public static List<String> getStringList(String values) {
        String[] valueArray = stringToArray(values);

        List<String> stringList = new ArrayList<>();
        if (valueArray == null) {
            return stringList;
        }
        for (int i = 0; i < valueArray.length; i++) {
            stringList.add(valueArray[i]);
        }

        return stringList;
    }

}