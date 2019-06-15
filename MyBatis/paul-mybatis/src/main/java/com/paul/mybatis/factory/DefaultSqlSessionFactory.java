package com.paul.mybatis.factory;

import com.paul.mybatis.confiuration.Configuration;
import com.paul.mybatis.confiuration.MappedStatement;
import com.paul.mybatis.sqlsession.DefaultSqlSession;
import com.paul.mybatis.sqlsession.SqlSession;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * 1.初始化时就完成了 configuration 的实例化
 * 2.工厂类，生成 sqlSession
 *
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory{

    //希望Configuration 是单例子并且唯一的
    private final Configuration configuration = new Configuration();

    // xml 文件存放的位置
    private static final String MAPPER_CONFIG_LOCATION = "mappers";

    // 数据库信息存放的位置
    private static final String DB_CONFIG_FILE = "db.properties";


    public DefaultSqlSessionFactory() {
        loadDBInfo();
        loadMapperInfo();
    }

    private void loadDBInfo() {
        InputStream db = this.getClass().getClassLoader().getResourceAsStream(DB_CONFIG_FILE);
        Properties p = new Properties();

        try {
            p.load(db);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将配置信息写入Configuration 对象
        configuration.setJdbcDriver(p.get("jdbc.driver").toString());
        configuration.setJdbcUrl(p.get("jdbc.url").toString());
        configuration.setJdbcUsername(p.get("jdbc.username").toString());
        configuration.setJdbcPassword(p.get("jdbc.password").toString());

    }

    //解析并加载xml文件
    private void loadMapperInfo(){
        URL resources = null;
        resources = this.getClass().getClassLoader().getResource(MAPPER_CONFIG_LOCATION);
        File mappers = new File(resources.getFile());
        //读取文件夹下面的文件信息
        if(mappers.isDirectory()){
            File[] files = mappers.listFiles();
            for(File file:files){
                loadMapperInfo(file);
            }
        }
    }

    private void loadMapperInfo(File file){
        SAXReader reader = new SAXReader();
        //通过read方法读取一个文件转换成Document 对象
        Document document = null;
        try {
            document = reader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        //获取根结点元素对象<mapper>
        Element e = document.getRootElement();
        //获取命名空间namespace
        String namespace = e.attribute("namespace").getData().toString();
        //获取select,insert,update,delete子节点列表
        List<Element> selects = e.elements("select");
        List<Element> inserts = e.elements("select");
        List<Element> updates = e.elements("select");
        List<Element> deletes = e.elements("select");

        List<Element> all = new ArrayList<>();
        all.addAll(selects);
        all.addAll(inserts);
        all.addAll(updates);
        all.addAll(deletes);

        //遍历节点，组装成 MappedStatement 然后放入到configuration 对象中
        for(Element ele:all){
            MappedStatement mappedStatement = new MappedStatement();
            String id = ele.attribute("id").getData().toString();
            String resultType = ele.attribute("resultType").getData().toString();
            String sql = ele.getData().toString();

            mappedStatement.setId(namespace+"."+id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setNamespace(namespace);
            mappedStatement.setSql(sql);

            configuration.getMappedStatement().put(namespace+"."+id,mappedStatement);
        }
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
