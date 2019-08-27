package com.neverend.blog.util.email;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.ArrayList;
import java.util.List;

public class FenCIUtil {
    /**
     * 返回字符串进行分词之后的集合数据
     * @param str
     * @return
     */
    public static List<String> getFneciLists(String str) {
        String s = removeFuHao(str);
        List<Term> parses = ToAnalysis.parse(s).getTerms();
        List<String> strings = new ArrayList<>();
        for (Term pars : parses) {
            strings.add(pars.getName());
        }
        return strings;
    }

    /**
     * 去除标点符号
     * @param s
     * @return
     */
    private static String removeFuHao(String s) {
        String str =  s.replaceAll( "[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]" , "");
        return str;
    }





}
