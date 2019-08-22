package com.neverend.blog;

import com.neverend.blog.dao.ArticleDao;
import com.neverend.blog.entity.Article;
import com.neverend.blog.util.email.MailService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


/**
 * ���дʿ��ʼ��
 *
 * @author pipi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SensitiveWordInit {
    @Autowired
    ArticleDao articleDao  ;
    /**
     * ���дʿ�
     */
    @SuppressWarnings("rawtypes")
    public static HashMap sensitiveWordMap;

    /**
     * ��ʼ�����д�
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
    public Map initKeyWord() {
        List<Article> articles = articleDao.getAll();
        try {
            // �����дʼ��϶�����ȡ�����дʲ���װ��Set������
            Set<String> keyWordSet = new HashSet<String>();
            for (Article s : articles) {
                keyWordSet.add(s.getArticleName().trim());
            }
            // �����дʿ���뵽HashMap��
            addSensitiveWordToHashMap(keyWordSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveWordMap;
    }

    /**
     * ��װ���дʿ�
     *
     * @param keyWordSet
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void addSensitiveWordToHashMap(Set<String> keyWordSet) {
        // ��ʼ��HashMap���󲢿��������Ĵ�С
        sensitiveWordMap = new HashMap(keyWordSet.size());
        // ���д�
        String key = null;
        // ����������Ӧ�ĸ�ʽ�������дʿ�����
        Map nowMap = null;
        // ���������������дʿ�
        Map<String, String> newWorMap = null;
        // ʹ��һ����������ѭ�����дʼ���
        Iterator<String> iterator = keyWordSet.iterator();
        while (iterator.hasNext()) {
            key = iterator.next();
            // �������дʿ⣬HashMap�������ڴ���ռ�õ���ͬһ����ַ�����Դ�nowMap����ı仯��sensitiveWordMap����Ҳ����Ÿı�
            nowMap = sensitiveWordMap;
            for (int i = 0; i < key.length(); i++) {
                // ��ȡ���дʵ��е��֣������дʿ�����ΪHashMap�����Key��ֵ
                char keyChar = key.charAt(i);

                // �ж�������Ƿ���������дʿ���
                Object wordMap = nowMap.get(keyChar);
                if (wordMap != null) {
                    nowMap = (Map) wordMap;
                } else {
                    newWorMap = new HashMap<String, String>();
                    newWorMap.put("isEnd", "0");
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }

                // ��������ǵ�ǰ���дʵ����һ���֣����ʶΪ��β��
                if (i == key.length() - 1) {
                    nowMap.put("isEnd", "1");
                }
            }
        }
    }
}

