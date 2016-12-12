/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stuff;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONValue;

/**
 *
 * @author Miikka
 */
public abstract class JSONstring {
    public static String getJSONresult(ResultSet result, String key){
        Map json = new HashMap(); 
        List list = new ArrayList();
        if(result!=null)
    {
        try {
            ResultSetMetaData meta = result.getMetaData();
            while(result.next())
            {
                Map<String,Object> columnMap = new HashMap<String, Object>();
                for(int columnIndex=1;columnIndex<=meta.getColumnCount();columnIndex++)
                {
                    if(result.getString(meta.getColumnName(columnIndex))== null){
                        columnMap.put(meta.getColumnLabel(columnIndex), "");
                    }
                    else if (result.getString(meta.getColumnName(columnIndex)).chars().allMatch(Character::isDigit)){
                         columnMap.put(meta.getColumnLabel(columnIndex),Integer.parseInt(result.getString(meta.getColumnName(columnIndex))));
                    }
                    else{
                        columnMap.put(meta.getColumnLabel(columnIndex),result.getString(meta.getColumnName(columnIndex)));
                    }
                }
                list.add(columnMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        json.put(key, list);
     }
     return JSONValue.toJSONString(json);
    }
    
}
